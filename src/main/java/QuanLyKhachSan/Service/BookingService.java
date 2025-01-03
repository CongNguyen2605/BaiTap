package QuanLyKhachSan.Service;

import QuanLyKhachSan.Model.Booking;
import QuanLyKhachSan.Model.Room;

import java.util.List;

public interface BookingService {
    void bookingRoom(String nameCus,String phoneCus,Long idRoom);
    List<Room> showAllRooms();
    List<Booking> findAllRoomsBooking(String nameCus, String phoneCus);
    void payMent(String nameCus, String phone , float totalMoney);
    void cancelRoom(String nameCus , String phone , long idPhong);
}
