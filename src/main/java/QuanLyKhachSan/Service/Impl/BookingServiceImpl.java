package QuanLyKhachSan.Service.Impl;

import QuanLyKhachSan.Model.*;
import QuanLyKhachSan.Repository.*;
import QuanLyKhachSan.Service.BookingService;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository = new BookingRepository();
    private RoomRepository roomRepository = new RoomRepository();
    private CustomerRepository customerRepository = new CustomerRepository();
    private BillRepository billRepository = new BillRepository();

    @Override
    public void bookingRoom(String nameCus, String phoneCus, Long idRoom) {
        Room room = roomRepository.getIsBooked(idRoom);
        if (room == null) {
            System.out.println("Không còn phòng nào!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập thời gian thuê (1 giờ, 3 giờ, 12 giờ, hoặc 1 ngày): ");
        int duration = scanner.nextInt();
        float totalPrice;
        switch (duration) {
            case 1 -> totalPrice = room.getPrice();
            case 3 -> totalPrice = (float) (room.getPrice() * 3 * 0.9);
            case 12 -> totalPrice = (float) (room.getPrice() * 12 * 0.75);
            case 24 -> totalPrice = (float) (room.getPrice() * 24 * 0.6);
            default -> {
                System.out.println("Thời gian không hợp lệ!");
                return;
            }
        }
        Customer customer = customerRepository.addCustomer(nameCus, phoneCus);
        LocalDateTime rentDay = LocalDateTime.now();
        LocalDateTime rentEnd = rentDay.plusHours(duration);
        bookingRepository.addBooking(room, customer, duration, rentEnd.toString());
        billRepository.addBill(customer, room, totalPrice);
        room.setBooked(false);
        System.out.println("Phòng của bạn là: " + room.getIdRoom());
        System.out.println("Thời gian thuê bắt đầu: " + rentDay);
        System.out.println("Thời gian thuê kết thúc: " + rentEnd);


        new Thread(() -> {
            try {
                long delay = java.time.Duration.between(LocalDateTime.now(), rentEnd).toMillis();
                Thread.sleep(delay);
                room.setBooked(true);
                System.out.println("Phòng " + room.getIdRoom() + " đã sẵn sàng để đặt lại.");
            } catch (InterruptedException e) {
                System.out.println("Lỗi trong việc cập nhật trạng thái phòng.");
            }
        }).start();
    }

    @Override
    public List<Room> showAllRooms() {
        List<Room> rooms = roomRepository.getAllRooms();
        return rooms;
    }

    @Override
    public List<Booking> findAllRoomsBooking(String nameCus, String phoneCus) {
        List<Booking> bookings = bookingRepository.findBooking();

        if (bookings == null || bookings.isEmpty()) {
            System.out.println("Khong tim thay ten khach hang");
            return null;
        }
        for (Booking booking : bookings) {
            if (booking == null) {
                continue;
            }
            if (booking.getCustomer().getNameCustomer().equals(nameCus) && booking.getCustomer().getPhoneCustomer().equals(phoneCus)) {

                return bookings;
            }

        }
        return null;
    }
    @Override
    public void payMent(String nameCus, String phone, float totalMoney) {
        List<Booking> bookings = bookingRepository.findBooking();
        Bill bill = billRepository.findBill(nameCus, phone);

        float tong = 0;
        if (bookings == null || bookings.isEmpty()) {
            System.out.println("Khong tim thay ten khach hang");
            return;
        }
        for (Booking booking : bookings) {
            if (booking == null) {
                continue;
            }
            tong += booking.getRoom().getPrice();
        }
        if (totalMoney == bill.getTotal()) {
            System.out.println("Thanh toan thanh cong");

            Iterator<Booking> iterator = bookings.iterator();
            while (iterator.hasNext()) {
                Booking booking = iterator.next();
                if (booking != null && booking.getCustomer().getNameCustomer().equals(nameCus)
                        && booking.getCustomer().getPhoneCustomer().equals(phone)) {
                    booking.getRoom().setBooked(true);
                    iterator.remove();
                }
            }

            bill.setPaid(true);
            bill.setPaymentTime(LocalDateTime.now().toString());
        } else {
            System.out.println("Khong du tien de thanh toan");
        }
    }

    @Override
    public void cancelRoom(String nameCus, String phone, long idPhong) {
        List<Booking> bookings = bookingRepository.findBooking();
        List<Bill> bills = billRepository.getAllBills();

        if (bookings == null || bookings.isEmpty()) {
            System.out.println("Khong tim thay ten khach hang hoac danh sach dat phong trong");
            return;
        }
        Iterator<Booking> bookingsIterator = bookings.iterator();
        while (bookingsIterator.hasNext()) {
            Booking booking = bookingsIterator.next();
            if (booking.getRoom().getIdRoom() == idPhong &&
                    booking.getCustomer().getNameCustomer().equals(nameCus) &&
                    booking.getCustomer().getPhoneCustomer().equals(phone)) {
                bookingsIterator.remove();
                System.out.println("Đã hủy phòng với ID " + idPhong + " khỏi danh sách đặt.");
                break;
            }
        }
        System.out.println("Khong tim thay phong voi ID " + idPhong + " trong danh sach dat.");
        for (Bill bill : bills) {
            if (bill.getCustomer().getNameCustomer().equals(nameCus) && bill.getCustomer().getPhoneCustomer().equals(phone)) {

                Iterator<Room> roomIterator = bill.getRooms().iterator();
                while (roomIterator.hasNext()) {
                    Room room = roomIterator.next();
                    if (room.getIdRoom() == idPhong) {
                        roomIterator.remove();
                        bill.setTotal(bill.getTotal() - room.getPrice());
                        System.out.println("Đã xóa phòng với ID " + idPhong + " khỏi hóa đơn.");
                        return;
                    }
                }
            }
        }
        System.out.println("Khong tim thay phong voi ID " + idPhong + " trong hóa don.");
    }


}
