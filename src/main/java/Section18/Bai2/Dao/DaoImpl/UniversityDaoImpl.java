package Section18.Bai2.Dao.DaoImpl;

import Section18.Bai2.Dao.JDBCConnect;
import Section18.Bai2.Dao.UniversityDao;
import Section18.Bai2.Model.Student;
import Section18.Bai2.Model.University;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDaoImpl implements UniversityDao {
    private Connection connection = JDBCConnect.getConnection();


    @Override
    public void addUniversity(University university) {
    String sql = "Insert into university (id,name,address) values (?,?,?)";
    try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        preparedStatement.setInt(1,university.getId());
        preparedStatement.setString(2,university.getName());
        preparedStatement.setString(3,university.getAddress());
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Override
    public List<University> findAllUniversity() {
        String sql = "Select * from university";
        List<University> universities = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                universities.add(new University(rs.getInt("id"),rs.getString("name"),rs.getString("address")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return universities;
    }
}
