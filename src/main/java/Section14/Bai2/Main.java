package Section14.Bai2;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "C:\\Users\\admin\\IdeaProjects\\baitapcty\\src\\main\\java\\Section14\\Bai2\\text.txt";
        String filePath2 = "C:\\Users\\admin\\IdeaProjects\\baitapcty\\src\\main\\java\\Section14\\Bai2\\text2.txt";
        try {

            Product product = new Product();
            product.input();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(product);
            objectOutputStream.close();



            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            Product readProduct = (Product) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(readProduct);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
