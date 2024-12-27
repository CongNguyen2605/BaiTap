package Section10.Bai3.Service.Impl;

import Section10.Bai3.Model.Address;
import Section10.Bai3.Service.AddressService;

import java.util.Scanner;

public class AddressServiceImpl implements AddressService {
    @Override
    public void input(Address address) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id");
        address.setId(scanner.nextLong());
        System.out.println("nhap Street");
        address.setStreet(scanner.next());
        System.out.println("nhap city");
        address.setCity(scanner.next());
    }

    @Override
    public void infor(Address address) {
        System.out.println(address.getId() +    "-" + address.getStreet()  +"-" + address.getCity());
    }
}
