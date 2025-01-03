package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Model.Customer;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {
    private Map<Long, Customer> customerMap = new HashMap<>();
    private long nextId = 4L;

    public CustomerRepository() {
        customerMap.put(1L, new Customer(1L, "c", "1"));
        customerMap.put(2L, new Customer(2L, "Cong1", "088888889"));
        customerMap.put(3L, new Customer(3L, "Cong2", "088888890"));
    }


    public Customer addCustomer(String name, String phone) {
        Customer customer = new Customer(nextId++, name, phone);
        customerMap.put(customer.getIdCustomer(), customer);
        return customer;
    }


    public Customer getCustomerId(long id) {
        return customerMap.get(id);
    }


    public Map<Long, Customer> getAllCustomers() {
        return customerMap;
    }
}
