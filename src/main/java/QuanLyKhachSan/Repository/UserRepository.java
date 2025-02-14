package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Model.User;
import QuanLyKhachSan.Connect.JDBCConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final Connection connection;

    public UserRepository() {
        try {
            this.connection = JDBCConnect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database: " + e.getMessage(), e);
        }


    }

    public User addUser(Customer customer) {
        try {

            connection.setAutoCommit(false);


            String checkCustomerQuery = """
            SELECT "idCustomer", "nameCus", "phoneCus" 
            FROM "KhachSan"."Customer" 
            WHERE "nameCus" = ? AND "phoneCus" = ?
        """;
            PreparedStatement checkCustomerStmt = connection.prepareStatement(checkCustomerQuery);
            checkCustomerStmt.setString(1, customer.getNameCustomer());
            checkCustomerStmt.setString(2, customer.getPhoneCustomer());

            ResultSet customerRs = checkCustomerStmt.executeQuery();

            if (customerRs.next()) {
                // Customer exists, retrieve the customer ID and details
                long customerId = customerRs.getLong("idCustomer");
                String customerName = customerRs.getString("nameCus");
                String customerPhone = customerRs.getString("phoneCus");


                String insertUserQuery = """
                INSERT INTO "KhachSan"."User" ("customer", "role") 
                VALUES (?, ?)
            """;
                PreparedStatement insertUserStmt = connection.prepareStatement(insertUserQuery, Statement.RETURN_GENERATED_KEYS);
                insertUserStmt.setLong(1, customerId);
                insertUserStmt.setString(2, "User");
                insertUserStmt.executeUpdate();

                ResultSet userRs = insertUserStmt.getGeneratedKeys();
                if (userRs.next()) {
                    long userId = userRs.getLong(1);
                    connection.commit();
                    return new User(userId, new Customer(customerId, customerName, customerPhone), "User");
                }
            }
            connection.rollback();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public User findUser(String name, String phone) {
        try {
            String query = "SELECT u.\"idUser\", u.\"role\", c.\"idCustomer\", c.\"nameCus\", c.\"phoneCus\" " +
                    "FROM \"KhachSan\".\"User\" u " +
                    "JOIN \"KhachSan\".\"Customer\" c ON u.\"customer\" = c.\"idCustomer\" " +
                    "WHERE c.\"nameCus\" = ? AND c.\"phoneCus\" = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, phone);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                long userId = resultSet.getLong("idUser");
                long customerId = resultSet.getLong("idCustomer");
                String customerName = resultSet.getString("nameCus");
                String customerPhone = resultSet.getString("phoneCus");
                Customer customer = new Customer(customerId, customerName, customerPhone);
                String role = resultSet.getString("role");
                return new User(userId, customer, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public List<User> userList() {
        List<User> users = new ArrayList<>();
        try {
            String query = "SELECT u.\"idUser\", u.\"role\", c.\"idCustomer\", c.\"nameCus\", c.\"phoneCus\" " +
                    "FROM \"KhachSan\".\"User\" u " +
                    "JOIN \"KhachSan\".\"Customer\" c ON u.\"customer\" = c.\"idCustomer\"";
            PreparedStatement stmt = connection.prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                long userId = resultSet.getLong("idUser");
                long customerId = resultSet.getLong("idCustomer");
                String customerName = resultSet.getString("nameCus");
                String customerPhone = resultSet.getString("phoneCus");
                Customer customer = new Customer(customerId, customerName, customerPhone);
                String role = resultSet.getString("role");
                users.add(new User(userId, customer, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public boolean isPhoneNumberExists(String phoneNumber) {
        try {
            String query = "SELECT COUNT(*) FROM \"KhachSan\".\"Customer\" WHERE \"phoneCus\" = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, phoneNumber);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
