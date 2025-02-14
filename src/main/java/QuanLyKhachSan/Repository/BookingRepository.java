package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Connect.JDBCConnect;
import QuanLyKhachSan.Model.Booking;
import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Model.Room;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    private Connection connection;

    public BookingRepository() {
        try {
            this.connection = JDBCConnect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database: " + e.getMessage(), e);
        }
    }




    public Booking addBooking(Room room, Customer customer, int duration, String rentEnd) {
        String insertQuery = "INSERT INTO \"KhachSan\".\"Booking\" (\"customer\", \"room\", \"rentDay\", \"duration\", \"rentEnd\") " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, customer.getIdCustomer());
            stmt.setLong(2, room.getIdRoom());

            stmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));

            stmt.setInt(4, duration);

            String formattedRentEnd = rentEnd.replace("T", " ");

            Timestamp rentEndTimestamp = Timestamp.valueOf(formattedRentEnd);
            stmt.setTimestamp(5, rentEndTimestamp);

            // Execute the update
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating booking failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long bookingId = generatedKeys.getLong(1);
                    return new Booking(bookingId, customer, room, LocalDate.now().toString(), duration, rentEnd);
                } else {
                    throw new SQLException("Creating booking failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding booking: " + e.getMessage(), e);
        }
    }

    public List<Booking> findBooking() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT b.\"idBooking\", b.\"rentDay\", b.\"duration\", b.\"rentEnd\", " +
                "c.\"idCustomer\", c.\"nameCus\", c.\"phoneCus\", " +
                "r.\"idRoom\", r.\"typeRoom\",r.\"isBooked\", r.\"price\" " +
                "FROM \"KhachSan\".\"Booking\" b " +
                "JOIN \"KhachSan\".\"Customer\" c ON b.\"customer\" = c.\"idCustomer\" " +
                "JOIN \"KhachSan\".\"Room\" r ON b.\"room\" = r.\"idRoom\"";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {

                Customer customer = new Customer(
                        resultSet.getInt("idCustomer"),
                        resultSet.getString("nameCus"),
                        resultSet.getString("phoneCus")
                );

                Room room = new Room(
                        resultSet.getLong("idRoom"),
                        resultSet.getString("typeRoom"),
                        resultSet.getBoolean("isBooked"),
                        resultSet.getFloat("price")

                );

                Booking booking = new Booking(
                        resultSet.getLong("idBooking"),
                        customer,
                        room,
                        resultSet.getString("rentDay"),
                        resultSet.getInt("duration"),
                        resultSet.getString("rentEnd")
                );

                bookings.add(booking);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving bookings: " + e.getMessage(), e);
        }

        return bookings;
    }
    public void deleteBookingByCustomer(String nameCus, String phoneCus) {
        String query = "DELETE FROM \"KhachSan\".\"Booking\" b " +
                "USING \"KhachSan\".\"Customer\" c " +
                "WHERE b.\"customer\" = c.\"idCustomer\" " +
                "AND c.\"nameCus\" = ? " +
                "AND c.\"phoneCus\" = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nameCus);
            stmt.setString(2, phoneCus);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã xóa " + rowsAffected + " bản ghi đặt phòng liên quan đến khách hàng.");
            } else {
                System.out.println("Không có bản ghi đặt phòng nào để xóa.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi xóa các bản ghi đặt phòng: " + e.getMessage(), e);
        }
    }
    public void deleteBookingByRoomIdAndCustomer(long idPhong, String nameCus, String phoneCus) {
        String query = "DELETE FROM \"KhachSan\".\"Booking\" b " +
                "USING \"KhachSan\".\"Customer\" c " +
                "WHERE b.\"customer\" = c.\"idCustomer\" " +
                "AND b.\"room\" = ? " +
                "AND c.\"nameCus\" = ? " +
                "AND c.\"phoneCus\" = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, idPhong);
            stmt.setString(2, nameCus);
            stmt.setString(3, phoneCus);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã xóa " + rowsAffected + " bản ghi đặt phòng.");
            } else {
                System.out.println("Không có bản ghi đặt phòng nào để xóa.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi xóa đặt phòng: " + e.getMessage(), e);
        }
    }


}
