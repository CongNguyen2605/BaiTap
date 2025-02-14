package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Model.Room;
import QuanLyKhachSan.Connect.JDBCConnect;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoomRepository {

    private final Connection connection;

    public RoomRepository() {
        try {
            this.connection = JDBCConnect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database: " + e.getMessage(), e);
        }
    }


    public List<Room> getAllRooms() {
        List<Room> roomList = new ArrayList<>();
        try {
            String query = "SELECT \"idRoom\", \"typeRoom\", \"isBooked\", \"price\" FROM \"KhachSan\".\"Room\"";
            PreparedStatement stmt = connection.prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getLong("idRoom"),
                        resultSet.getString("typeRoom"),
                        resultSet.getBoolean("isBooked"),
                        resultSet.getFloat("price")
                );
                roomList.add(room);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all rooms: " + e.getMessage());
        }
        return roomList;
    }


    public Room getRoom(Long idRoom) {
        try {
            String query = "SELECT \"idRoom\", \"typeRoom\", \"isBooked\", \"price\" FROM \"KhachSan\".\"Room\" WHERE \"idRoom\" = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, idRoom);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return new Room(
                        resultSet.getLong("idRoom"),
                        resultSet.getString("typeRoom"),
                        resultSet.getBoolean("isBooked"),
                        resultSet.getFloat("price")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error finding room: " + e.getMessage());
        }
        return null;
    }


    public Room getIsBooked(Long idRoom) {
        try {
            String query = "SELECT \"idRoom\", \"typeRoom\", \"isBooked\", \"price\" FROM \"KhachSan\".\"Room\" WHERE \"idRoom\" = ? AND \"isBooked\" = true";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, idRoom);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return new Room(
                        resultSet.getLong("idRoom"),
                        resultSet.getString("typeRoom"),
                        resultSet.getBoolean("isBooked"),
                        resultSet.getFloat("price")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error finding booked room: " + e.getMessage());
        }
        return null;
    }


    public void addRoom(String typeRoom, float price) {
        try {
            // The idRoom will be auto-generated, so we don't need to include it in the query
            String query = "INSERT INTO \"KhachSan\".\"Room\" (\"typeRoom\", \"isBooked\", \"price\") VALUES (?, false, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, typeRoom);
            stmt.setFloat(2, price);

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                long idRoom = generatedKeys.getLong(1);
                System.out.println("Room added with idRoom: " + idRoom);
            }
        } catch (SQLException e) {
            System.err.println("Error adding room: " + e.getMessage());
        }
    }




    public void exportRoomsToExcel(String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Rooms");

            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Type Room", "Is Booked", "Price"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                style.setFont(font);
                cell.setCellStyle(style);
            }

            int rowNum = 1;
            for (Room room : getAllRooms()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(room.getIdRoom());
                row.createCell(1).setCellValue(room.getTypeRoom());
                row.createCell(2).setCellValue(room.isBooked());
                row.createCell(3).setCellValue(room.getPrice());
            }

            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(fileOut);
            System.out.println("Rooms exported to Excel file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void importRoomsFromExcel(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) rowIterator.next(); // Skip header row

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String typeRoom = row.getCell(1).getStringCellValue();
                float price = (float) row.getCell(3).getNumericCellValue();

                addRoom(typeRoom, price);
            }

            System.out.println("Rooms imported successfully from Excel file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateRoomStatus(Room room) {
        String updateQuery = "UPDATE \"KhachSan\".\"Room\" SET \"isBooked\" = ? WHERE \"idRoom\" = ?";

        try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {

            stmt.setBoolean(1, room.isBooked());
            stmt.setLong(2, room.getIdRoom());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No room found with ID: " + room.getIdRoom());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating room status: " + e.getMessage());
        }
    }

}
