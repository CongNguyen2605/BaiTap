package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Model.Booking;
import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Model.Room;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    private List<Booking> bookings = new ArrayList<>();
    private long nextId = 1;

    public Booking addBooking(Room room , Customer customer , int duration , String rentEnd){
        Booking booking = new Booking(nextId++,customer,room, LocalDateTime.now().toString() , duration , rentEnd);
        bookings.add(booking);
        return booking;
    }
    public List<Booking> findBooking(){

                return bookings;
            }
    public List<Booking> findBooking(String phone , String nameCus){
        for (Booking booking : bookings){
            if (booking.getCustomer().getPhoneCustomer().equals(phone)  && booking.getCustomer().getNameCustomer().equals(nameCus)){
                return bookings;

            }
        }
        return null;
    }




}
