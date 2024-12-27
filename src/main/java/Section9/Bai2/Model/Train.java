package Section9.Bai2.Model;

import java.util.Scanner;

public class Train extends Traffic{
    private String tenXe;
    private int soToa;

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public int getSoToa() {
        return soToa;
    }

    public void setSoToa(int soToa) {
        this.soToa = soToa;
    }

    @Override
    public void input() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap ten xe");
        tenXe = scanner.next();
        System.out.println("nhap so toa");
        soToa = scanner.nextInt();
        super.input();
    }

    @Override
    public void infor() {

        System.out.println(tenXe + "-" + soToa );
        super.infor();
    }
}
