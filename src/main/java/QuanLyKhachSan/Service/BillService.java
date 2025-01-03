package QuanLyKhachSan.Service;

import QuanLyKhachSan.Model.Bill;

import java.util.List;

public interface BillService {
    void findBill(String nameCus , String phone);
    List<Bill> findAllBill(String nameCus , String phone);

}
