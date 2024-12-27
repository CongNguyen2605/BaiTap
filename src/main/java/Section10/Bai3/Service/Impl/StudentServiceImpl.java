package Section10.Bai3.Service.Impl;

import Section10.Bai3.Model.Student;
import Section10.Bai3.Service.StudentService;

import java.util.Scanner;

public class StudentServiceImpl implements StudentService {

    @Override
    public void input(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id");
        student.setId(scanner.nextLong());
        System.out.println("nhap name");
        student.setName(scanner.next());
        System.out.println("nhap age");
        student.setAge(scanner.nextInt());
    }

    @Override
    public void infor(Student student) {
        System.out.println(student.getId() + "-" + student.getName() + "-" + student.getAge());
    }
}
