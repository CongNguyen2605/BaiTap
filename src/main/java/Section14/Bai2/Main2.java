package Section14.Bai2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String filePath2 = "C:\\Users\\admin\\IdeaProjects\\baitapcty\\src\\main\\java\\Section14\\Bai2\\text2.txt";
        try {

            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            Product [] product = new Product[a];
            for (int i = 0; i < product.length; i++) {
                product[i] = new Product() ;
                product[i].input();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath2));
            objectOutputStream.writeObject(product);
            objectOutputStream.close();



            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath2));
            Product [] readProduct = (Product[]) objectInputStream.readObject();
            objectInputStream.close();
            for(Product product1 : readProduct){
            System.out.println(product1);}

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
