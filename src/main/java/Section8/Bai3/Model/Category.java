package Section8.Bai3.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Category {
    private long id;

    private List<Product> productList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id");
        id = scanner.nextLong();
    }
    public void addProduct(Product product){
        productList.add(product);
    }
    public void infor(){
        System.out.println("id : " +id );
        for (Product product : productList){
            product.infor();
        }
    }
}
