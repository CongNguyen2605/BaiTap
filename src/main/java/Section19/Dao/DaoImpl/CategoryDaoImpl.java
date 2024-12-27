package Section19.Dao.DaoImpl;

import Section19.Dao.CategoryDao;
import Section19.Dao.JDBCConnect;
import Section19.Model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private Connection connect = JDBCConnect.getConnection();
    @Override
    public void addCategory(Category category) {
        String sql = "Insert into category(idcategory,name) values (?,?)";
        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)){
            preparedStatement.setInt(1,category.getIdCategory());
            preparedStatement.setString(2, category.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Category category) {
        String sql = "Update category set name = ? where idcategory = ?";
        try(PreparedStatement preparedStatement = connect.prepareStatement(sql)){

            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2,category.getIdCategory());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int idcategory) {
    String sql = "Delete from category where idcategory = ?";
    try(PreparedStatement preparedStatement = connect.prepareStatement(sql)){
        preparedStatement.setInt(1,idcategory);
        preparedStatement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Override
    public List<Category> allCategory() {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from category";
        try (Statement statement = connect.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                categories.add(new Category(rs.getInt("idcategory"), rs.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
