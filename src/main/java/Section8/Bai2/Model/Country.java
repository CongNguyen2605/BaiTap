package Section8.Bai2.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Country {
    private long id;
    private String ten;
    private List<Person> personList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ID quoc gia:");
        id = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.println("Nhap ten quoc gia:");
        ten = scanner.nextLine();
    }

    public void infor() {
        System.out.println("ID Quoc gia: " + id);
        System.out.println("Ten Quoc gia: " + ten);
        System.out.println("Danh sach nguoi:");
        for (Person person : personList) {
            person.infor();
        }
    }

    public void addPerson(Person person) {
        personList.add(person);
        person.setCountry(this);
    }
}