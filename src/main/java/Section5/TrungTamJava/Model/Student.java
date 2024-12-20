package Section5.TrungTamJava.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends PerSon{
    private Long id;
    private String name;
    private String address;
    private String major;

    public Student(Long id, String name, String address, String major) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.major = major;
    }

    public Student() {

    }

    public long getId() {
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }



    @Override
    public void input() {
       Scanner scanner = new Scanner(System.in);
       id = scanner.nextLong();
       name = scanner.next();
       address = scanner.next();
       major = scanner.next();

    }

    @Override
    public void infor() {
        System.out.println(getId());
        System.out.println(getName());
        System.out.println(getAddress());
        System.out.println(getMajor());
    }
}
