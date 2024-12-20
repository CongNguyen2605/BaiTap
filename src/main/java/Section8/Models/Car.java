package Section8.Models;

import java.util.Scanner;
import java.util.Set;

public class Car {
    private long id;
    private String tenHang;
    private String gia;
    private Set<Person> personSet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        tenHang = scanner.next();
        gia = scanner.next();
    }
    public void infor(){
        System.out.println(getId());
        System.out.println(getTenHang());
        System.out.println(getGia());
    }

}
