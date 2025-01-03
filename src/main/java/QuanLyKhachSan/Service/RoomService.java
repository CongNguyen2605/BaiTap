package QuanLyKhachSan.Service;

import QuanLyKhachSan.Model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getRooms();
    void getIsBooked(Long idRoom);
    void addRoom();
     void exportRooms();
    void importRooms();
    void updateRoom(long idRoom);

}
