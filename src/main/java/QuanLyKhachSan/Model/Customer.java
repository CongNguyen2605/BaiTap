package QuanLyKhachSan.Model;

import java.util.Objects;

public class Customer {
    private long idCustomer;
    private String nameCustomer;
    private String phoneCustomer;

    public Customer(long idCustomer, String nameCustomer, String phoneCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.phoneCustomer = phoneCustomer;
    }

    public Customer() {
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getIdCustomer() == customer.getIdCustomer() && Objects.equals(getNameCustomer(), customer.getNameCustomer()) && Objects.equals(getPhoneCustomer(), customer.getPhoneCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCustomer(), getNameCustomer(), getPhoneCustomer());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", phoneCustomer=" + phoneCustomer +
                '}';
    }

}
