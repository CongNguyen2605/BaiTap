package ThuyetTrinh.Static;

public class StaticMethod {
    public static void printStatic(){
        System.out.println("haha");
    }
    public void printNonStatic(){
        System.out.println("hoho");
    }

    public static void main(String[] args) {
        StaticMethod staticMethod = new StaticMethod();
        staticMethod.printNonStatic();


        StaticMethod.printStatic();
    }
}
