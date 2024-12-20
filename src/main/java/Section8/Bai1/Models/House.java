package Section8.Bai1.Models;

import java.util.Scanner;

public class House {
    private long id;
    private String address;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void input(){
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        address = scanner.next();
    }
    public void infor(){
        System.out.println(getId());
        System.out.println(getAddress());

    }
}
