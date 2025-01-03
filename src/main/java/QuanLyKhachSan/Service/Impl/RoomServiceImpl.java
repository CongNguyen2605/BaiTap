package QuanLyKhachSan.Service.Impl;

import QuanLyKhachSan.Model.Customer;
import QuanLyKhachSan.Model.Room;
import QuanLyKhachSan.Repository.RoomRepository;
import QuanLyKhachSan.Service.RoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository = new RoomRepository();


    @Override
    public List<Room> getRooms() {
       List<Room> rooms =   roomRepository.getAllRooms();
       return rooms;
    }

    @Override
    public void getIsBooked(Long idRoom) {
        roomRepository.getIsBooked(idRoom);
    }

    @Override
    public void addRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap type room");
        String typeRoom = scanner.next();
        System.out.println("nhap price");
        float price = scanner.nextFloat();
        roomRepository.addRoom(typeRoom,price);
    }

    @Override
    public void exportRooms() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path to import rooms: ");
        String filePath = scanner.nextLine();

        roomRepository.exportRoomsToExcel(filePath);
    }

    @Override
    public void importRooms() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path to import rooms: ");
        String filePath = scanner.nextLine();
        roomRepository.importRoomsFromExcel(filePath);
    }

    @Override
    public void updateRoom(long idRoom) {
        Room room = roomRepository.getRoom(idRoom);
        if (room == null) {
            System.out.println("Phòng không tồn tại!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập loại phòng mới (để trống nếu không thay đổi): ");
        String typeRoom = scanner.nextLine().trim();

        System.out.print("Nhập giá mới (nhập 0 nếu không thay đổi): ");
        float price = scanner.nextFloat();

        room.setTypeRoom(typeRoom.isEmpty() ? room.getTypeRoom() : typeRoom);
        room.setPrice(price > 0 ? price : room.getPrice());

        System.out.println("Cập nhật thông tin phòng thành công!");
        System.out.printf("Loại phòng: %s, Giá phòng: %.2f\n", room.getTypeRoom(), room.getPrice());
    }


}
