package Section5.TrungTamJava.Model;

import java.util.List;
import java.util.Scanner;

public class PerSon {
    private long CCCD;
    private String hoTen;
    private String ngaySinh;
    private String diaChi;

    public PerSon() {
        this.CCCD = CCCD;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public long getCCCD() {
        return CCCD;
    }

    public void setCCCD(long CCCD) {
        this.CCCD = CCCD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

//    @Override
//    public String toString() {
//        return "PerSon{" +
//                "CCCD=" + CCCD +
//                ", hoTen='" + hoTen + '\'' +
//                ", ngaySinh='" + ngaySinh + '\'' +
//                ", diaChi='" + diaChi + '\'' +
//                '}';
//    }
    public  void input(){
        Scanner scanner = new Scanner(System.in);
        CCCD = scanner.nextLong();
        hoTen = scanner.next();
        ngaySinh = scanner.next();
        diaChi = scanner.next();
    }
    public void infor(){
        System.out.println(getCCCD());
        System.out.println(getHoTen());
        System.out.println(getNgaySinh());
        System.out.println(getDiaChi());
    }
}
