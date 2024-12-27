package Section10.Bai3.Main;

import Section10.Bai3.Model.Student;
import Section10.Bai3.Service.Impl.StudentServiceImpl;
import Section10.Bai3.Service.StudentService;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.input(student);
        studentService.infor(student);
    }
}
