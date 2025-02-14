package Multi_Threads.VD2;

import java.util.LinkedList;

class Producer {
    private final LinkedList<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 3;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (queue.size() == CAPACITY) {
                    wait(); // Đợi nếu queue đầy
                }
                System.out.println("Producer sản xuất: " + value);
                queue.add(value++);
                notify(); // Báo cho Consumer
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait(); // Đợi nếu queue rỗng
                }
                int value = queue.removeFirst();
                System.out.println("Consumer tiêu thụ: " + value);
                notify(); // Báo cho Producer
                Thread.sleep(2000);
            }
        }
    }
}

public class ProducerConsumerWaitNotify {
    public static void main(String[] args) {
        Producer producer = new Producer();

        Thread producerThread = new Thread(() -> {
            try {
                producer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                producer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
