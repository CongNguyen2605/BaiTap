package Section5.TrungTamJava.Main;

import Section5.TrungTamJava.Model.Student;
import Section5.TrungTamJava.Model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTeacher {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Teacher[] teachers = new Teacher[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n teacher : " + (i + 1) + ":");
            teachers[i] = new Teacher();
            teachers[i].input();
        }
        for (Teacher teacher : teachers) {
            teacher.infor();
            System.out.println();
        }

}}
