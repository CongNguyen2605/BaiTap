package Multi_Threads.VD2.Singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {} // Private constructor

    public static Singleton getInstance() {
        if (instance == null) { // Kiểm tra thể hiện có tồn tại không
            instance = new Singleton(); // Tạo thể hiện nếu chưa có
        }
        return instance;
    }
}

//public class Singleton {
//    private static Singleton instance;
//
//    private Singleton() {} // Private constructor
//
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}

//🔍 Ưu điểm:
//        ✔ Đảm bảo chỉ có một thể hiện duy nhất được tạo.
//        ✔ Tránh tình trạng race condition.
//
//        ❌ Nhược điểm:
//        Chậm do mỗi lần gọi getInstance() đều phải đồng bộ hóa, gây giảm hiệu suất khi nhiều luồng truy cập.