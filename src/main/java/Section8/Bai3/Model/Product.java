package Section8.Bai3.Model;

import java.util.Scanner;

public class Product {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id");
        id = scanner.nextLong();
        System.out.println("nhap ten");
        name = scanner.next();
    }
    public void infor(){
        System.out.println("id : " +id);
        System.out.println("name : " +name);
    }
}
