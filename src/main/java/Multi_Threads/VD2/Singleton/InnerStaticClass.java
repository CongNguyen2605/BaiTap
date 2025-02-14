package Multi_Threads.VD2.Singleton;

public class InnerStaticClass {
    private InnerStaticClass() {}

    private static class SingletonHelper {
        private static final InnerStaticClass INSTANCE = new InnerStaticClass();
    }

    public static InnerStaticClass getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
//    Cách hoạt động:
//        SingletonHelper chỉ được tải vào bộ nhớ khi gọi getInstance(), đảm bảo Lazy Initialization.
//        An toàn luồng vì lớp SingletonHelper chỉ được tải một lần duy nhất.
//        ✅ Ưu điểm:
//        ✔ Không cần synchronized (tận dụng cơ chế class loading của JVM).
//        ✔ Hiệu suất cao.
//        ✔ Đơn giản và dễ hiểu.