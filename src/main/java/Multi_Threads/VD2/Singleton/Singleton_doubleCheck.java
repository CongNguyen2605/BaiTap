package Multi_Threads.VD2.Singleton;

public class Singleton_doubleCheck {
    private static volatile Singleton_doubleCheck instance;

    private Singleton_doubleCheck() {}

    public static Singleton_doubleCheck getInstance() {
        if (instance == null) { // Kiểm tra lần 1 (tránh synchronized không cần thiết)
            synchronized (Singleton.class) { // Đồng bộ hóa khi cần
                if (instance == null) { // Kiểm tra lần 2 (chỉ tạo instance một lần)
                    instance = new Singleton_doubleCheck();
                }
            }
        }
        return instance;
    }
}
//🔍 Tại sao dùng volatile?
//        Đảm bảo mọi thay đổi của instance được cập nhật ngay lập tức giữa các luồng.
//        Tránh lỗi hủy hoại một phần (partially constructed object) khi một luồng đọc instance trước khi nó được khởi tạo hoàn chỉnh.
//        ✅ Ưu điểm:
//        ✔ Hiệu suất cao hơn synchronized.
//        ✔ Đảm bảo an toàn trong môi trường đa luồng.
//
//        ❌ Nhược điểm:
//        Cấu trúc phức tạp hơn một chút.