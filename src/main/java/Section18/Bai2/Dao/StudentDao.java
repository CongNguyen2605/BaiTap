package Section18.Bai2.Dao;

import Section18.Bai2.Model.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
    List<Student> findStudentByName(String name);
    List<Student> findStudentByAge(int age);
    List<Student> findStudentByUniversity(int university_id);
    List<Student> findAllStudent();
}
