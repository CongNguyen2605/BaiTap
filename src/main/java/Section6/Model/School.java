package Section6.Model;

import java.util.List;
import java.util.Scanner;

public class School {
    private Long id;
    private String schoolName;
    private String address;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        schoolName = scanner.next();
        address = scanner.next();
    }
    public  void infor(){

            System.out.println(getId() + "-"+ getSchoolName() + "-" + getAddress());

    }
}
