package Section8.Models;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class House {
    private long id;
    private String address;
    private Set<Person> personSet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        address = scanner.next();
    }
    public void infor(){
        System.out.println(getId());
        System.out.println(getAddress());
    }
}
