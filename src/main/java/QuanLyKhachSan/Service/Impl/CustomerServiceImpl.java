package QuanLyKhachSan.Service.Impl;

import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Repository.CustomerRepository;
import QuanLyKhachSan.Service.CustomerService;

import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();



    @Override
    public void getCustomerId(long id) {
        customerRepository.getCustomerId(id);
    }
}
