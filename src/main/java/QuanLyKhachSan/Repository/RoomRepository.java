package QuanLyKhachSan.Repository;

import QuanLyKhachSan.Model.Room;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoomRepository {
    private static List<Room> rooms = new ArrayList<>();
    private static long idNext = 1;


   public RoomRepository()  {

    }

    public List<Room> getAllRooms(){
        return rooms;
    }
    public Room getIsBooked(Long idRoom){
        for (Room room : rooms){
            if(room.isBooked() == true && room.getIdRoom() == idRoom ){
                return room;
            }
        }
        return null;
    }
    public Room getRoom(Long idRoom){
        for (Room room : rooms){
            if(room.getIdRoom() == idRoom ){
                return room;
            }
        }
        return null;
    }

    public void addRoom(String typeRoom ,float price ){
        Room room = new Room(idNext++,typeRoom,true,price);
        rooms.add(room);


    }
    public void exportRoomsToExcel(String filePath) {
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
        for (Room room : rooms) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(room.getIdRoom());
            row.createCell(1).setCellValue(room.getTypeRoom());
            row.createCell(2).setCellValue(room.isBooked());
            row.createCell(3).setCellValue(room.getPrice());
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }


        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Rooms exported to Excel file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void importRoomsFromExcel(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);


            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                Cell idCell = row.getCell(0);
                Cell typeCell = row.getCell(1);
                Cell bookedCell = row.getCell(2);
                Cell priceCell = row.getCell(3);

                String typeRoom = typeCell.getStringCellValue();

                float price = (float) priceCell.getNumericCellValue();


                Room room = new Room(idNext++, typeRoom, true, price);
                rooms.add(room);
            }

            System.out.println("Rooms imported successfully from Excel file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
