package QuanLyKhachSan.Service.Impl;

import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Model.User;
import QuanLyKhachSan.Repository.CustomerRepository;
import QuanLyKhachSan.Repository.UserRepository;
import QuanLyKhachSan.Service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepository();
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap name");
        String name = scanner.next();
        System.out.println("nhap phonenumber");
        String phone = scanner.next();
        Customer customer = customerRepository.addCustomer(name,phone);
        userRepository.addUser(customer);
    }

    @Override
    public User findUser(String name, String phone) {
        User user = userRepository.findUser(name,phone);
        return user;
    }
    public boolean login(String name, String phone) {
        User user = userRepository.findUser(name,phone);
        if (user != null) {
            return true;
        } else {
            System.out.println("Invalid login details.");
            return false;
        }
    }

    @Override
    public void getAllUser() {
         userRepository.userList().forEach(System.out::println);
    }



}
