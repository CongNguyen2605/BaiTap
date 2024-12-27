package Section18.Bai2.Model;

import java.util.List;

public class University {
    private int id;
    private String name;
    private String address;

    public University(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public University() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +

                '}';
    }
}
