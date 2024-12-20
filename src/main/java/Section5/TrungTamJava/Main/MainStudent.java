package Section5.TrungTamJava.Main;

import Section5.TrungTamJava.Model.PerSon;
import Section5.TrungTamJava.Model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Student [] students = new Student[n];
        for (int i = 0 ; i< n ;i++){
            students[i] = new Student();
            students[i].input();
        }
        for (Student student : students){
            student.infor();
        }

    }
}
