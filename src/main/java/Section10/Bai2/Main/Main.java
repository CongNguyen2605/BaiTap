package Section10.Bai2.Main;

import Section10.Bai2.Model.Laptop;
import Section10.Bai2.Service.LaptopService;
import Section10.Bai2.Service.ServiceImpl.LaptopServiceImpl;

public class Main {

    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        LaptopServiceImpl laptopService = new LaptopServiceImpl();
        laptopService.input(laptop);
        laptopService.infor(laptop);



    }
}
