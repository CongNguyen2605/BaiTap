package ThuyetTrinh.Static;

public class StaticBlocks {
    private static String subject;

    static {
        System.out.println("Khối static được gọi");
    }

    static {
        subject = "Khối static (static blocks)";
    }

    StaticBlocks () {
        System.out.println("hàm main() được gọi");
        System.out.println("Subject = " + subject);
    }

    public static void main(String[] args) {
        StaticBlocks ex1 = new StaticBlocks();
    }
}
