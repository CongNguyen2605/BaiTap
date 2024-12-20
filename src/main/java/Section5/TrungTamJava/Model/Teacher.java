package Section5.TrungTamJava.Model;

import java.util.List;
import java.util.Scanner;

public class Teacher extends PerSon {
    private Long id;
    private String name;
    private String address;
    private String facility;

    public Teacher() {
    }

    public Teacher(Long id, String name, String address, String facility) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.facility = facility;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        name = scanner.next();
        address = scanner.next();
        facility = scanner.next();
    }

    @Override
    public void infor() {
        System.out.println(getId());
        System.out.println(getName());
        System.out.println(getAddress());
        System.out.println(getFacility());
    }
}

