package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Model.Bill;
import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Model.Room;

import java.util.ArrayList;
import java.util.List;

public class BillRepository {
    private  List<Bill> bills = new ArrayList<>();
    private  long idNext = 1;

//    public void BillRepository() {
//        // Thêm hóa đơn mặc định
//
//    }
//
//    public BillRepository() {
//        Customer customer1 = new Customer(1L, "Nguyen Van A", "0909123456");
//        Customer customer2 = new Customer(2L, "Tran Thi B", "0912233445");
//        Customer customer3 = new Customer(3L, "Le Van C", "0987654321");
//        List<Room> rooms = new ArrayList<>();
//
//        Room room1 = new Room(1L, "Standard", true, 500);
//        Room room2 = new Room(2L, "Deluxe", true, 500);
//        Room room3 = new Room(3L, "Suite", true, 500);
//        rooms.add(room1);
//        rooms.add(room2);
//        rooms.add(room3)
//        bills.add(new Bill(1, customer1, rooms, 1500));
//        bills.add(new Bill(2, customer2, rooms, 3000));
//        bills.add(new Bill(3L, customer3, rooms, 4500));
//    }

    public Bill addBill(Customer customer, Room room, float roomPrice) {
        if (customer == null || room == null) {
            System.out.println("Customer or Room is null!");
            throw new IllegalArgumentException("Customer and Room cannot be null");
        }


        for (Bill bill : bills) {
            if ( bill.getCustomer().getNameCustomer().equals(customer.getNameCustomer()) && bill.getCustomer().getPhoneCustomer().equals(customer.getPhoneCustomer())  &&  !bill.isPaid()) {
                bill.getRooms().add(room);
                bill.setTotal(bill.getTotal() + roomPrice);
                System.out.println("Added room to an unpaid bill. Updated total.");
                return bill;
            }
        }

        List<Room> roomList = new ArrayList<>();
        roomList.add(room);
        Bill newBill = new Bill(idNext++, customer, roomList, roomPrice, false, "");
        bills.add(newBill);
        System.out.println("Created a new bill.");
        return newBill;
    }

    public Bill findBill(String nameCus, String phone) {
        for (Bill bill : bills) {
            if (bill.getCustomer().getNameCustomer().equalsIgnoreCase(nameCus)
                    && bill.getCustomer().getPhoneCustomer().equals(phone)) {
                return bill;
            }
        }
        return null;
    }

    public List<Bill> getAllBills() {
        return bills;
    }
}
