package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Connect.JDBCConnect;
import QuanLyKhachSan.Model.Bill;
import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BillRepository {
    private final Connection connection;

    public BillRepository() {
        try {
            this.connection = JDBCConnect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database: " + e.getMessage(), e);
        }
    }


    public Bill addBill(Customer customer, Room room, float roomPrice) {
        if (customer == null || room == null) {
            throw new IllegalArgumentException("Customer and Room cannot be null");
        }

        try {

            String checkQuery = """
            SELECT b."idBill", b."total", b."paid", b."rooms"
            FROM "KhachSan"."Bill" b
            JOIN "KhachSan"."Customer" c ON b."customer" = c."idCustomer"
            WHERE c."nameCus" = ? AND c."phoneCus" = ? AND b."paid" = false
        """;
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setString(1, customer.getNameCustomer());
            checkStmt.setString(2, customer.getPhoneCustomer());

            ResultSet resultSet = checkStmt.executeQuery();
            if (resultSet.next()) {
                // Cập nhật hóa đơn chưa thanh toán
                long billId = resultSet.getLong("idBill");
                float newTotal = resultSet.getFloat("total") + roomPrice;

                String updateQuery = "UPDATE \"KhachSan\".\"Bill\" SET \"total\" = ?, \"rooms\" = array_append(\"rooms\", ?) WHERE \"idBill\" = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                updateStmt.setFloat(1, newTotal);
                updateStmt.setLong(2, room.getIdRoom());
                updateStmt.setLong(3, billId);
                updateStmt.executeUpdate();

                return new Bill(billId, customer, Collections.singletonList(room), newTotal, false, null);
            }

            String insertQuery = """
            INSERT INTO "KhachSan"."Bill" ("customer", "total", "paid", "rooms", "paymentTime")
            VALUES (?, ?, ?, ?, ?)
        """;
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setLong(1, customer.getIdCustomer());
            insertStmt.setFloat(2, roomPrice);
            insertStmt.setBoolean(3, false);
            insertStmt.setArray(4, connection.createArrayOf("bigint", new Long[]{room.getIdRoom()}));
            insertStmt.setTimestamp(5, null);

            int affectedRows = insertStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating bill failed, no rows affected.");
            }


            ResultSet generatedKeys = insertStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                long newBillId = generatedKeys.getLong(1);
                return new Bill(newBillId, customer, Collections.singletonList(room), roomPrice, false, null);
            } else {
                throw new SQLException("Creating bill failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error processing bill: " + e.getMessage(), e);
        }
    }


    public Bill findBill(String nameCus, String phone) {
        try {
            String query = "SELECT b.\"idBill\", b.\"total\", b.\"paid\", c.\"idCustomer\", c.\"nameCus\", c.\"phoneCus\" " +
                    "FROM \"KhachSan\".\"Bill\" b " +
                    "JOIN \"KhachSan\".\"Customer\" c ON b.\"customer\" = c.\"idCustomer\" " +
                    "WHERE c.\"nameCus\" = ? AND c.\"phoneCus\" = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, nameCus);
            stmt.setString(2, phone);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("idCustomer"),
                        resultSet.getString("nameCus"),
                        resultSet.getString("phoneCus")
                );

                return new Bill(
                        resultSet.getLong("idBill"),
                        customer,
                        new ArrayList<>(),
                        resultSet.getFloat("total"),
                        resultSet.getBoolean("paid"),
                        ""
                );
            }
        } catch (SQLException e) {
            System.err.println("Error finding the bill: " + e.getMessage());
        }
        return null;
    }


    public List<Bill> getAllBills() {
        List<Bill> billList = new ArrayList<>();

        try {
            String query = "SELECT b.\"idBill\", b.\"total\",b.\"paymentTime\", b.\"paid\", " +
                    "c.\"idCustomer\", c.\"nameCus\", c.\"phoneCus\" " +
                    "FROM \"KhachSan\".\"Bill\" b " +
                    "JOIN \"KhachSan\".\"Customer\" c ON b.\"customer\" = c.\"idCustomer\"";

            PreparedStatement stmt = connection.prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("idCustomer"),
                        resultSet.getString("nameCus"),
                        resultSet.getString("phoneCus")
                );

                Bill bill = new Bill(
                        resultSet.getLong("idBill"),
                        customer,
                        new ArrayList<>(),
                        resultSet.getFloat("total"),
                        resultSet.getBoolean("paid"),
                        resultSet.getString("paymentTime")
                );

                billList.add(bill);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all bills: " + e.getMessage());
        }

        return billList;
    }
    public boolean payBill(String nameCus, String phone, float totalMoney) {
        try {

            connection.setAutoCommit(false);

            String findBillQuery = "SELECT b.\"idBill\", b.\"total\", b.\"paid\" " +
                    "FROM \"KhachSan\".\"Bill\" b " +
                    "JOIN \"KhachSan\".\"Customer\" c ON b.\"customer\" = c.\"idCustomer\" " +
                    "WHERE c.\"nameCus\" = ? AND c.\"phoneCus\" = ?";
            PreparedStatement findBillStmt = connection.prepareStatement(findBillQuery);
            findBillStmt.setString(1, nameCus);
            findBillStmt.setString(2, phone);
            ResultSet billResultSet = findBillStmt.executeQuery();

            if (!billResultSet.next()) {
                System.out.println("Không tìm thấy hóa đơn cho khách hàng này.");
                connection.rollback();
                return false;
            }
            billResultSet.getString("paymentTime");
            long billId = billResultSet.getLong("idBill");
            float billTotal = billResultSet.getFloat("total");
            boolean isPaid = billResultSet.getBoolean("paid");


            if (isPaid) {
                System.out.println("Hóa đơn này đã được thanh toán.");
                connection.rollback();
                return false;
            }

            if (totalMoney < billTotal) {
                System.out.println("Số tiền không đủ để thanh toán.");
                connection.rollback();
                return false;
            }


            String updateBillQuery = "UPDATE \"KhachSan\".\"Bill\" " +
                    "SET \"paid\" = TRUE, \"paymentTime\" = NOW() " +
                    "WHERE \"idBill\" = ?";
            PreparedStatement updateBillStmt = connection.prepareStatement(updateBillQuery);
            updateBillStmt.setLong(1, billId);
            updateBillStmt.executeUpdate();


            String updateRoomQuery = "UPDATE \"KhachSan\".\"Room\" r " +
                    "SET \"isBooked\" = TRUE " +
                    "WHERE r.\"idRoom\" IN (" +
                    "    SELECT b.\"room\" " +
                    "    FROM \"KhachSan\".\"Booking\" b " +
                    "    JOIN \"KhachSan\".\"Customer\" c ON b.\"customer\" = c.\"idCustomer\" " +
                    "    WHERE c.\"nameCus\" = ? AND c.\"phoneCus\" = ?)";
            PreparedStatement updateRoomStmt = connection.prepareStatement(updateRoomQuery);
            updateRoomStmt.setString(1, nameCus);
            updateRoomStmt.setString(2, phone);
            updateRoomStmt.executeUpdate();

            connection.commit();
            System.out.println("Thanh toán thành công!");
            return true;

        } catch (SQLException e) {
            try {
                connection.rollback(); // Rollback nếu có lỗi
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            throw new RuntimeException("Lỗi trong quá trình thanh toán: " + e.getMessage(), e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void updateBillAfterRoomCancellation(String nameCus, String phoneCus, long idPhong) {
        String query = "UPDATE \"KhachSan\".\"Bill\" b " +
                "SET \"total\" = \"total\" - (SELECT r.\"price\" FROM \"KhachSan\".\"Room\" r WHERE r.\"idRoom\" = ?) " +
                "FROM \"KhachSan\".\"Customer\" c " +
                "WHERE b.\"customer\" = c.\"idCustomer\" " +
                "AND c.\"nameCus\" = ? " +
                "AND c.\"phoneCus\" = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, idPhong);
            stmt.setString(2, nameCus);
            stmt.setString(3, phoneCus);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật hóa đơn sau khi hủy phòng.");
            } else {
                System.out.println("Không tìm thấy hóa đơn để cập nhật.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi cập nhật hóa đơn: " + e.getMessage(), e);
        }
    }



}
