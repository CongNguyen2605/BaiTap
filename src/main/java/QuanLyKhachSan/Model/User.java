package QuanLyKhachSan.Model;

public class User {
    private long id;
    private Customer customer;
    private String nameRole;

    public User() {
    }

    public User(long id, Customer customer, String nameRole) {
        this.id = id;
        this.customer = customer;
        this.nameRole = nameRole;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", customer=" + customer +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }
}
