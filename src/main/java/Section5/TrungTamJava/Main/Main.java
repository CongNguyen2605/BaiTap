package Section5.TrungTamJava.Main;

import Section5.TrungTamJava.Model.PerSon;
import Section5.TrungTamJava.Model.Table;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(3,"hehe","3/10/2032", 3.1F);
        Table table1 = new Table();
        table1.setTenBan("hoho");
        System.out.println(table.toString());
        System.out.println(table1.toString());

        PerSon perSon = new PerSon();
        perSon.input();
        perSon.infor();
    }
}
