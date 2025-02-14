package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Connect.JDBCConnect;
import QuanLyKhachSan.Model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private final Connection connection;

    public CustomerRepository() {
        try {
            this.connection = JDBCConnect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database: " + e.getMessage(), e);
        }
    }

    public Customer addCustomer(String name, String phone) {
        try {
            String query = "INSERT INTO \"KhachSan\".\"Customer\" (\"nameCus\", \"phoneCus\") VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, phone);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }


            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                long newCustomerId = generatedKeys.getLong(1);
                return new Customer(newCustomerId, name, phone);
            } else {
                throw new SQLException("Creating customer failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error processing customer: " + e.getMessage(), e);
        }
    }

    public Customer getCustomerId(long id) {
        try {
            String query = "SELECT \"idCustomer\", \"nameCus\", \"phoneCus\" FROM \"KhachSan\".\"Customer\" WHERE \"idCustomer\" = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return new Customer(
                        resultSet.getLong("idCustomer"),
                        resultSet.getString("nameCus"),
                        resultSet.getString("phoneCus")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error finding customer: " + e.getMessage());
        }
        return null;
    }


    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            String query = "SELECT \"idCustomer\", \"nameCus\", \"phoneCus\" FROM \"KhachSan\".\"Customer\"";
            PreparedStatement stmt = connection.prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getLong("idCustomer"),
                        resultSet.getString("nameCus"),
                        resultSet.getString("phoneCus")
                );
                customerList.add(customer);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all customers: " + e.getMessage());
        }
        return customerList;
    }
    public Customer findCustomer(String name, String phone) {
        String query = "SELECT \"idCustomer\", \"nameCus\", \"phoneCus\" " +
                "FROM \"KhachSan\".\"Customer\" " +
                "WHERE \"nameCus\" = ? AND \"phoneCus\" = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    long idCustomer = resultSet.getLong("idCustomer");
                    String nameCustomer = resultSet.getString("nameCus");
                    String phoneCustomer = resultSet.getString("phoneCus");

                    return new Customer(idCustomer, nameCustomer, phoneCustomer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
