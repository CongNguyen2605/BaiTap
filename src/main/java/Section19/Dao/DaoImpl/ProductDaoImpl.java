package Section19.Dao.DaoImpl;

import Section19.Dao.JDBCConnect;
import Section19.Dao.ProductDao;
import Section19.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private Connection connect = JDBCConnect.getConnection();
    @Override
    public void addProduct(Product product) {
    String sql = "Insert into product(idproduct,name,quantity,price,idcategory) values (?,?,?,?,?)";
    try (PreparedStatement preparedStatement = connect.prepareStatement(sql)){
        preparedStatement.setInt(1,product.getIdProduct());
        preparedStatement.setString(2,product.getName());

        preparedStatement.setInt(3,product.getQuantity());
        preparedStatement.setInt(4,product.getPrice());
        preparedStatement.setInt(5,product.getIdCategory());
        preparedStatement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "update product set name = ? , quantity = ? , price = ? , idcategory = ? where idproduct = ?";
        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)){

            preparedStatement.setString(1,product.getName());

            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.setInt(3,product.getPrice());
            preparedStatement.setInt(4,product.getIdCategory());
            preparedStatement.setInt(5,product.getIdProduct());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {
        String sql = "delete from product where idproduct = ?";
        try(PreparedStatement preparedStatement = connect.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product findById(int id) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE idproduct = ?";
        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery(); // Execute the query

            if (rs.next()) {
                product = new Product();
                product.setIdProduct(rs.getInt("idproduct"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getInt("price"));
                product.setIdCategory(rs.getInt("idcategory"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }


    @Override
    public List<Product> allProduct() {
        List<Product> products = new ArrayList<>();
        String sql = "Select * from product";
        try(Statement statement = connect.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                products.add(new Product(rs.getInt("idproduct"),rs.getString("name"),rs.getInt("quantity"), rs.getInt("price"),rs.getInt("idcategory")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public List<Product> findAllProductByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "Select * from product where name = ?";
        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)){
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                products.add(new Product(rs.getInt("idproduct"),rs.getString("name"),rs.getInt("quantity"), rs.getInt("price"),rs.getInt("idcategory")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findAllProductByPrice(int priceMin, int priceMax) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE price BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)){
            preparedStatement.setInt(1 , priceMin);
            preparedStatement.setInt(2,priceMax);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                products.add(new Product(rs.getInt("idproduct"),rs.getString("name"),rs.getInt("quantity"), rs.getInt("price"),rs.getInt("idcategory")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
