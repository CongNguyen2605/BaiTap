package QuanLyKhachSan.Service.Impl;

import QuanLyKhachSan.Model.*;
import QuanLyKhachSan.Repository.*;
import QuanLyKhachSan.Service.BookingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        // Get the room and check if it is available
        Room room = roomRepository.getIsBooked(idRoom);
        if (room == null) {
            System.out.println("Không còn phòng nào!");
            return;
        }

        // Input for rental duration
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập thời gian thuê (1 giờ, 3 giờ, 12 giờ, hoặc 1 ngày): ");
        int duration = scanner.nextInt();
        float totalPrice;

        // Calculate the total price based on duration
        switch (duration) {
            case 1:
                totalPrice = room.getPrice();
                break;
            case 3:
                totalPrice = room.getPrice() * 3 * 0.9f;
                break;
            case 12:
                totalPrice = room.getPrice() * 12 * 0.75f;
                break;
            case 24:
                totalPrice = room.getPrice() * 24 * 0.6f;
                break;
            default:
                System.out.println("Thời gian không hợp lệ!");
                return;
        }

        // Find the customer in the database
        Customer customer = customerRepository.findCustomer(nameCus, phoneCus);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại. Vui lòng kiểm tra lại thông tin!");
            return;
        }

        LocalDateTime rentDay = LocalDateTime.now();
        LocalDateTime rentEnd = rentDay.plusHours(duration);

        bookingRepository.addBooking(room, customer, duration, rentEnd.toString());
        billRepository.addBill(customer, room, totalPrice);

        room.setBooked(false);
        roomRepository.updateRoomStatus(room);

        System.out.println("Phòng của bạn là: " + room.getIdRoom());
        System.out.println("Thời gian thuê bắt đầu: " + rentDay);
        System.out.println("Thời gian thuê kết thúc: " + rentEnd);

        new Thread(() -> {
            try {
                long delay = java.time.Duration.between(LocalDateTime.now(), rentEnd).toMillis();
                Thread.sleep(delay);

                // Update room status after the rental period ends
                room.setBooked(true); // Set the room back to available
                roomRepository.updateRoomStatus(room); // Make sure to update in the database

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
        List<Booking> customerBookings = new ArrayList<>();

        if (bookings == null || bookings.isEmpty()) {
            System.out.println("Không tìm thấy bất kỳ đặt phòng nào.");
            return null;
        }
        for (Booking booking : bookings) {
            if (booking == null) {
                continue;
            }

            Customer customer = booking.getCustomer();
            if (customer.getNameCustomer().equals(nameCus) && customer.getPhoneCustomer().equals(phoneCus)) {
                customerBookings.add(booking);
            }
        }

        if (customerBookings.isEmpty()) {
            System.out.println("Không tìm thấy đặt phòng cho khách hàng: " + nameCus);
            return null;
        }

        return customerBookings;
    }

    @Override
    public void payMent(String nameCus, String phone, float totalMoney) {
        boolean paymentSuccess = billRepository.payBill(nameCus, phone, totalMoney);

        if (!paymentSuccess) {
            System.out.println("Thanh toán không thành công.");
            return;
        }


        List<Booking> bookings = bookingRepository.findBooking();
        if (bookings == null || bookings.isEmpty()) {
            System.out.println("Không tìm thấy thông tin đặt phòng liên quan đến khách hàng.");
            return;
        }

        for (Booking booking : bookings) {
            if (booking != null && booking.getCustomer().getNameCustomer().equals(nameCus)
                    && booking.getCustomer().getPhoneCustomer().equals(phone)) {

                booking.getRoom().setBooked(true);
            }
        }

        bookingRepository.deleteBookingByCustomer(nameCus, phone);

        System.out.println("Thanh toán thành công. Các phòng đã được cập nhật trạng thái và đặt phòng đã được xóa.");
    }





}
