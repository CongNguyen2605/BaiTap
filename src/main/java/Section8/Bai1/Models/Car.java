package Section8.Bai1.Models;

import java.util.Scanner;

public class Car {
    private long id;
    private String tenHang;
    private String gia;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }


    public void input(){
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        tenHang = scanner.next();
        gia = scanner.next();
    }
    public void infor(){
        System.out.println(getId());
        System.out.println(getTenHang());
        System.out.println(getGia());

    }

}
