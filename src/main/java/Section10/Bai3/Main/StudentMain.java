package Section10.Bai3.Main;

import Section10.Bai3.Model.Student;
import Section10.Bai3.Service.Impl.StudentServiceImpl;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        Student [] students = new Student[a];
        StudentServiceImpl studentServices = new StudentServiceImpl();
        for (int i = 0; i < students.length; i++) {
           students[i] = new Student();
           studentServices.input(students[i]);
        }


        for (Student student1 : students){
            studentServices.infor(student1);
        }
        Student studentold = students[0];
        for (int i = 1; i <students.length; i++) {
            if (students[i].getAge() > studentold.getAge()){
                studentold = students[i];
            }


        }
        studentServices.infor(studentold);
    }
}
