package Section9.Bai2.Model;

import java.util.Scanner;

public class Traffic {
    private Double giaVe;
    private int soGhe;

    public Double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(Double giaVe) {
        this.giaVe = giaVe;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap gia ve");
        giaVe = scanner.nextDouble();
        System.out.println("Nhap so ghe");
        soGhe = scanner.nextInt();
    }
    public void infor(){
        System.out.println(giaVe + "-" + soGhe);
    }
}
