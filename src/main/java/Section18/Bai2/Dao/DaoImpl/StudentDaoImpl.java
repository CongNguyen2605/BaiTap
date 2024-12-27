package Section18.Bai2.Dao.DaoImpl;

import Section18.Bai2.Dao.JDBCConnect;
import Section18.Bai2.Dao.StudentDao;
import Section18.Bai2.Model.Student;
import Section18.Bai2.Model.University;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private Connection connection = JDBCConnect.getConnection();


    @Override
    public void addStudent(Student student) {
        String sql = "Insert into student(id,name,age,university_id) values(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setInt(4,student.getIdUniversity());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "Update student Set name = ? ,age = ? , university_id = ? where id =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){


                preparedStatement.setString(1,student.getName());
                preparedStatement.setInt(2,student.getAge());
                preparedStatement.setInt(3,student.getIdUniversity());
                preparedStatement.setInt(4,student.getId());
                preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteStudent(int id) {
        String sql = " Delete From student Where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            Student student = new Student();
            if(student.getId() == id){
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
            }
            else {
                System.out.println("khong tim thay student nay");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> findStudentByName(String name) {
        String sql = "Select * from student where name LIKE ? ";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,"%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                students.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getInt("university_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> findStudentByAge(int age) {
        String sql = "Select * from student where age LIKE ? ";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,age);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                students.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getInt("university_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> findStudentByUniversity(int university_id) {
        String sql = "Select * from student where university_id LIKE ? ";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,university_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                students.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getInt("university_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> findAllStudent() {
        String sql = " Select * from student";
        List<Student> students = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                students.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getInt("university_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
