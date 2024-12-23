package Section8.Bai3.Main;

import Section8.Bai3.Model.Category;
import Section8.Bai3.Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Category> categories = new ArrayList<>();
        List<Product> productList = new ArrayList<>();


        int a;
        System.out.println("1.them san pham \n" +
                "2.mua hang \n" +
                "3. in san pham \n" +
                "4. in gio hang \n");
        do {
            System.out.println("nhap lua chon");
            a = scanner.nextInt();
            if(a==1){
                Product product = new Product();
                product.input();
                productList.add(product);
            }
            if(a==2){
                for (Product product1 : productList){
                    product1.infor();
                }
                System.out.println("chon san pham");
                int b = scanner.nextInt() -1 ;
                Product product1 = productList.get(b);
                System.out.println("chon gio hang");
                int c = scanner.nextInt()-1;
                Category category1 = categories.get(c);
                category1.addProduct(product1);
            }
            if (a==3){
                for (Product product1 : productList){
                    product1.infor();}
            }
            if (a==4){
                for (Category category1 : categories){
                    category1.infor();
                }
            }
            if(a==5){
                Category category = new Category();
                category.input();
                categories.add(category);
            }
        }
        while (a!=0);
    }
}
