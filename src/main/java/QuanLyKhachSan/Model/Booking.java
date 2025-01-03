package QuanLyKhachSan.Model;

public class Booking {
    private long idBooking;
    private Customer customer;
    private Room room;
    private String rentDay;
    private int duration;
    private String rentEnd;


    public Booking(long idBooking, Customer customer, Room room, String rentDay, int duration, String rentEnd) {
        this.idBooking = idBooking;
        this.customer = customer;
        this.room = room;
        this.rentDay = rentDay;
        this.duration = duration;
        this.rentEnd = rentEnd;
    }

    public Booking() {
    }

    public long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(long idBooking) {
        this.idBooking = idBooking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getRentDay() {
        return rentDay;
    }

    public void setRentDay(String rentDay) {
        this.rentDay = rentDay;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(String rentEnd) {
        this.rentEnd = rentEnd;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", customer=" + customer +
                ", room=" + room +
                ", rentDay='" + rentDay + '\'' +
                '}';
    }
}
