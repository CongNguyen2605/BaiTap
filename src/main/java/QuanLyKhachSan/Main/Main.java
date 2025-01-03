package QuanLyKhachSan.Main;

import QuanLyKhachSan.Model.Bill;
import QuanLyKhachSan.Model.Booking;
import QuanLyKhachSan.Model.Room;
import QuanLyKhachSan.Service.Impl.UserServiceImpl;
import QuanLyKhachSan.Service.Impl.BookingServiceImpl;
import QuanLyKhachSan.Service.Impl.RoomServiceImpl;
import QuanLyKhachSan.Service.Impl.BillServiceImpl;
import QuanLyKhachSan.Service.BookingService;
import QuanLyKhachSan.Service.RoomService;
import QuanLyKhachSan.Service.BillService;
import QuanLyKhachSan.Model.User;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        BookingService bookingService = new BookingServiceImpl();
        RoomService roomService = new RoomServiceImpl();
        BillService billService = new BillServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Show main menu
            System.out.println("=== Hotel Booking System ===");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Nhập tên người dùng: ");
                String name = scanner.nextLine();
                System.out.print("Nhập số điện thoại: ");
                String phone = scanner.nextLine();

                if (!userService.login(name, phone)) {
                    System.out.println("Thoát...");
                    return;
                }

                User user = userService.findUser(name, phone);
                if (user != null && user.getNameRole().equals("Admin")) {
                    showAdminMenu(scanner, bookingService, roomService, billService, name, phone);
                } else {
                    showUserMenu(scanner, bookingService, roomService, billService, name, phone);
                }
            } else if (choice == 2) {
                userService.addUser();
                System.out.println("Đăng ký thành công! Quay lại đăng nhập.");
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }


    public static void showUserMenu(Scanner scanner, BookingService bookingService, RoomService roomService, BillService billService, String name, String phone) {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            // Print header with formatting to look like a table
            System.out.printf("%-5s%-30s\n", "ID", "Option");
            System.out.println("-------------------------------");
            System.out.printf("%-5s%-30s\n", "1", "Show All Rooms");
            System.out.printf("%-5s%-30s\n", "2", "Make a Booking");
            System.out.printf("%-5s%-30s\n", "3", "Find a Booking");
            System.out.printf("%-5s%-30s\n", "4", "Payment Booking");
            System.out.printf("%-5s%-30s\n", "5", "Cancel Room Booking");
            System.out.printf("%-5s%-30s\n", "6", "View Bill");
            System.out.printf("%-5s%-30s\n", "7", "Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    List<Room> rooms = bookingService.showAllRooms();
                    System.out.printf("%-10s%-15s%-10s%-10s\n", "ID", "Type", "Booked", "Price");
                    System.out.println("--------------------------------------------");

                    for (Room room : rooms) {
                        System.out.printf("%-10d%-15s%-10b%-10.2f\n",
                                room.getIdRoom(),
                                room.getTypeRoom(),
                                room.isBooked(),
                                room.getPrice());

                    }

                }
                case 2 -> {
                    System.out.print("Enter type of So Phong: ");
                    Long numberRoom = scanner.nextLong();
                    bookingService.bookingRoom(name, phone, numberRoom);

                }
                case 3 -> {
                    List<Booking> bookings = bookingService.findAllRoomsBooking(name, phone);

                    System.out.printf("%-20s%-15s%-10s%-10s%-10s%-25s%-25s\n",
                            "Customer Name", "Phone", "Room ID", "Price", "Duration", "RentDay", "RentEnd");
                    System.out.println("----------------------------------------------------------------------------------------------");

                    for (Booking booking : bookings) {
                        System.out.printf("%-20s%-15s%-10d%-10.2f%-10d%-25s%-25s\n",
                                booking.getCustomer().getNameCustomer(),
                                booking.getCustomer().getPhoneCustomer(),
                                booking.getRoom().getIdRoom(),
                                booking.getRoom().getPrice(),
                                booking.getDuration(),
                                booking.getRentDay(),
                                booking.getRentEnd());
                    }


                }
                case 4 -> {
                    System.out.print("Enter total payment amount: ");
                    float totalMoney = scanner.nextFloat();
                    bookingService.payMent(name, phone, totalMoney);
                }
                case 5 -> {
                    System.out.print("Enter room ID to cancel: ");
                    long idRoom = scanner.nextLong();
                    bookingService.cancelRoom(name, phone, idRoom);
                }
                case 6 -> {
                    List<Bill> bills = billService.findAllBill(name, phone);

                    for (Bill bill : bills) {

                        System.out.println("==============================================");
                        System.out.printf("Bill ID: %-10d Customer: %-15s Phone: %-15s\n",
                                bill.getIdBill(),
                                bill.getCustomer().getNameCustomer(),
                                bill.getCustomer().getPhoneCustomer());
                        System.out.println("----------------------------------------------");

                        System.out.printf("%-20s%-10s\n", "Room ID", "Price");
                        System.out.println("----------------------------------------------");


                        for (Room room : bill.getRooms()) {
                            System.out.printf("%-20d%-10.2f\n",
                                    room.getIdRoom(),
                                    room.getPrice());
                        }
                        System.out.printf("\n%-20s%-25s\n", "Payment Time:", bill.getPaymentTime() != null ? bill.getPaymentTime() : "N/A");
                        System.out.printf("%-20s%-25s%-10.2f\n", "Total", "", bill.getTotal());
                        System.out.println("==============================================\n");
                    }


                }

                case 7 -> {
                    System.out.println("Exiting Admin Menu...");
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }

    public static void showAdminMenu(Scanner scanner, BookingService bookingService, RoomService roomService, BillService billService, String name, String phone) {
        while (true) {
            System.out.println("\n=== User Menu ===");

            System.out.printf("%-5s%-30s\n", "ID", "Option");
            System.out.println("-------------------------------");
            System.out.printf("%-5s%-30s\n", "1", "Show All Rooms");
            System.out.printf("%-5s%-30s\n", "2", "Add Room");
            System.out.printf("%-5s%-30s\n", "3", "Update Room");
            System.out.printf("%-5s%-30s\n", "4", "Export file exel");
            System.out.printf("%-5s%-30s\n", "5", "Import file exel");
            System.out.printf("%-5s%-30s\n", "6", "Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    List<Room> rooms = bookingService.showAllRooms();
                    System.out.printf("%-10s%-15s%-10s%-10s\n", "ID", "Type", "Booked", "Price");
                    System.out.println("--------------------------------------------");

                    for (Room room : rooms) {
                        System.out.printf("%-10d%-15s%-10b%-10.2f\n",
                                room.getIdRoom(),
                                room.getTypeRoom(),
                                room.isBooked(),
                                room.getPrice());
                    }

                }
                case 2 -> {
                    roomService.addRoom();
                }
                case 3 -> {
                    System.out.println("nhap id phong muon sua :");
                    long id = scanner.nextInt();
                    roomService.updateRoom(id);
                }
                case 4 -> {
                    roomService.exportRooms();
                    System.out.println("Export completed.");
                }
                case 5 -> {
                    roomService.importRooms();
                    System.out.println("Export completed.");
                }
                case 6 -> {
                    System.out.println("Exiting User Menu...");
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }
}
