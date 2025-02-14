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



}
