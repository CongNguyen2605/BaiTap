package QuanLyKhachSan.Model;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private long idBill;
    private Customer customer;
    private List<Room> rooms;
    private float total;
    private boolean paid;
    private String paymentTime;

    public Bill(long idBill, Customer customer, List<Room> rooms, float total, boolean paid, String paymentTime) {
        this.idBill = idBill;
        this.customer = customer;
        this.rooms = rooms;
        this.total = total;
        this.paid = paid;
        this.paymentTime = paymentTime;
    }

    public Bill() {
        this.rooms = new ArrayList<>();
    }

    // Các getter, setter và toString tương tự
    public long getIdBill() {
        return idBill;
    }

    public void setIdBill(long idBill) {
        this.idBill = idBill;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", customer=" + customer +
                ", rooms=" + rooms +
                ", total=" + total +
                ", paid=" + paid +
                ", paymentTime='" + paymentTime + '\'' +
                '}';
    }
}
