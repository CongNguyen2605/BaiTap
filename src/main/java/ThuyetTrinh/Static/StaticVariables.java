package ThuyetTrinh.Static;

public class StaticVariables {
    static int a = 0;

    public StaticVariables() {
    }
    void a(){
        a++;
        print();
    }
    void print(){
        System.out.println("count :  " + a);

    }

    public static void main(String[] args) {
        StaticVariables s1 = new StaticVariables();

        StaticVariables s2 = new StaticVariables();
        s1.a();
        s2.a();
    }
}
