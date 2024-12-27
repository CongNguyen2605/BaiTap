package Section9.Bai2.Model;

import java.util.Scanner;

public class Car extends Traffic{
    private String tenXe;
    private String loaiXe;

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    @Override
    public void input() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap ten xe");
        tenXe = scanner.next();
        System.out.println("nhap loai xe");
        loaiXe = scanner.next();
        super.input();
    }

    @Override
    public void infor() {
        System.out.println(tenXe + "-" + loaiXe );
        super.infor();
    }
}
