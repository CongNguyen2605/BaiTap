package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    private long idNext = 1L;
    private CustomerRepository customerRepository = new CustomerRepository();

    public UserRepository() {
        users.add(new User(idNext++, customerRepository.getCustomerId(1L), "Admin"));
        users.add(new User(idNext++, customerRepository.getCustomerId(2L), "Admin"));
        users.add(new User(idNext++, customerRepository.getCustomerId(3L), "Admin"));
    }




    public User addUser(Customer customer) {
        User user = new User(idNext++, customer, "User");
        users.add(user);
        return user;
    }

    public User findUser(String name, String phone) {
        for (User user : users) {
            if (user.getCustomer().getNameCustomer().equals(name) && user.getCustomer().getPhoneCustomer().equals(phone)) {
                return user;
            }
        }
        return null;
    }

    public List<User> userList() {
        return users;
    }

    public boolean isPhoneNumberExists(String phoneNumber) {
        for (User user : users) {
            if ( user.getCustomer().getPhoneCustomer().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
