package QuanLyKhachSan.Service;

import QuanLyKhachSan.Model.User;

import java.util.List;

public interface UserService {
    void addUser();
    User findUser(String name , String phone);
    boolean login(String name, String phone);
   void getAllUser();

}
