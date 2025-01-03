package QuanLyKhachSan.Service.Impl;

import QuanLyKhachSan.Model.Bill;
import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Repository.BillRepository;
import QuanLyKhachSan.Repository.CustomerRepository;
import QuanLyKhachSan.Repository.RoomRepository;
import QuanLyKhachSan.Service.BillService;

import java.util.List;

public class BillServiceImpl implements BillService {
    private BillRepository billRepository = new BillRepository();


    @Override
    public void findBill(String nameCus, String phone) {
        Bill bill = billRepository.findBill(nameCus, phone);

        if (bill == null) {
            System.out.println("Không tìm thấy hóa đơn nào cho khách hàng: " + nameCus + " với số điện thoại: " + phone);
            return;
        }
        System.out.println("Hóa đơn tìm thấy:");
        System.out.println(bill);
    }



    @Override
    public List<Bill> findAllBill(String nameCus , String phone) {
        List<Bill> bills = billRepository.getAllBills();
        if (bills.isEmpty()) {
            System.out.println("Chưa có hóa đơn nào.");
            return null;
        }

        System.out.println("Danh sách tất cả hóa đơn:");
        for (Bill bill : bills) {
            if(bill.getCustomer().getNameCustomer().equals(nameCus) && bill.getCustomer().getPhoneCustomer().equals(phone)){
           return bills;
        }
        }
        return null;
    }


}
