package Section18.Bai2.Main;

import Section18.Bai2.Dao.DaoImpl.StudentDaoImpl;
import Section18.Bai2.Dao.DaoImpl.UniversityDaoImpl;
import Section18.Bai2.Dao.StudentDao;
import Section18.Bai2.Dao.UniversityDao;
import Section18.Bai2.Model.Student;
import Section18.Bai2.Model.University;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        UniversityDao universityDao = new UniversityDaoImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Find Student by Name");
            System.out.println("5. Find Student by Age");
            System.out.println("6. Find Student by University Name");
            System.out.println("7. List All Students");
            System.out.println("8. Add University");
            System.out.println("9. List All Universities");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student id: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    System.out.print("Enter student age: ");
                    int studentAge = scanner.nextInt();
                    System.out.print("Enter university ID: ");
                    int universityId = scanner.nextInt();
                    studentDao.addStudent(new Student(id, studentName, studentAge, universityId));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter student ID to update: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter new student name: ");
                    studentName = scanner.nextLine();
                    System.out.print("Enter new student age: ");
                    studentAge = scanner.nextInt();
                    System.out.print("Enter new university ID: ");
                    universityId = scanner.nextInt();
                    studentDao.updateStudent(new Student(studentId, studentName, studentAge, universityId));
                    System.out.println("Student updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter student ID to delete: ");
                    studentId = scanner.nextInt();
                    studentDao.deleteStudent(studentId);
                    System.out.println("Student deleted successfully!");
                    break;

                case 4:
                    System.out.print("Enter student name to search: ");
                    studentName = scanner.nextLine();
                    studentDao.findStudentByName(studentName).forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter student age to search: ");
                    studentAge = scanner.nextInt();
                    studentDao.findStudentByAge(studentAge).forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Enter university name to search: ");
                    int idUniversity = scanner.nextInt();
                    studentDao.findStudentByUniversity(idUniversity).forEach(System.out::println);
                    break;

                case 7:
                    studentDao.findAllStudent().forEach(System.out::println);
                    break;

                case 8:
                    System.out.print("Enter university id: ");
                    int id_University = scanner.nextInt();
                    System.out.print("Enter university name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter university address: ");
                    String address = scanner.nextLine();
                    universityDao.addUniversity(new University(id_University, name, address));
                    System.out.println("University added successfully!");
                    break;

                case 9:
                    universityDao.findAllUniversity().forEach(System.out::println);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 10);

        scanner.close();
    }
}
