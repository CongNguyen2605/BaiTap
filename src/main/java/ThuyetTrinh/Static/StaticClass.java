package ThuyetTrinh.Static;

public class StaticClass {
    private String subject;

    StaticClass (String subject) {
        this.subject = subject;
    }

    // nested static class
    static class MyWebsite {
        public static String WEBSITE = "gpcoder.com";
    }

    public void print() {
        System.out.println("Subject = " + subject);
        System.out.println("Website = " + MyWebsite.WEBSITE);
    }

    public static void main(String[] args) {
        StaticClass ex1 = new StaticClass("Core Java");
        ex1.print();
    }
}
