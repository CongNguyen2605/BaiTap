package Section10.Bai2.Service.ServiceImpl;

import Section10.Bai2.Model.Laptop;
import Section10.Bai2.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class LaptopServiceImpl implements LaptopService {

    private Laptop laptop;
    @Override
    public void input(Laptop lt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id");
        lt.setId(scanner.nextLong());
        System.out.println("nhap cpu");
        lt.setCpu(scanner.next());
        System.out.println("nhap ram");
        lt.setRam(scanner.next());
        System.out.println("nhap vga");
        lt.setVga(scanner.next());
    }

    @Override
    public void infor(Laptop lt) {
        System.out.println(lt.getId() + "-"  + lt.getCpu() + "-" + lt.getRam() + "- "  + lt.getVga());
    }

}
