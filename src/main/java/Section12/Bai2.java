package Section12;

import java.util.Scanner;

class ZeroException extends Exception {
    public ZeroException(String message) {
        super(message);
    }
}

public class Bai2 {

    public static int divide(int a, int b) throws ZeroException {
        if (b == 0) {
            throw new ZeroException("Lỗi: Không thể chia cho 0!");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Nhập số a: ");
                int a = scanner.nextInt();
                System.out.print("Nhập số b: ");
                int b = scanner.nextInt();

                int result = divide(a, b);
                System.out.println("Kết quả: " + result);
                break;
            } catch (ZeroException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập định dạng hợp lệ!");
                scanner.nextLine();
            }
        }


    }
}