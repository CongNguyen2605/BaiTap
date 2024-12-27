package Section10.Bai3.Service.Impl;

import Section10.Bai3.Model.School;
import Section10.Bai3.Service.SchoolService;

import java.util.Scanner;

public class SchoolServiceImpl implements SchoolService {

    @Override
    public void input(School school) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id");
        school.setId (scanner.nextLong());
        System.out.println("nhap ten");
        school.setName( scanner.next()) ;

    }

    @Override
    public void infor(School school) {
        System.out.println(school.getId() + "-" + school.getName());
    }
}
