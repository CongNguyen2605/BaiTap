package Section2.Bai3;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ai da bong hay nhat viet nam !!!");
        System.out.println("A: Bellingham Lien Ha    B: Cong \n" +
                "C: Zidane LienHa    D: Dap An Khac");
        String dapan = scanner.nextLine();
        switch (dapan.toUpperCase()){
            case "A":
                System.out.println("dung");
                break;
            case "B":
                System.out.println("dung");
                break;
            case "C":
                System.out.println("dung");
                break;
            case "D":
                System.out.println("Sai");
                break;
            default:
                System.out.println("khong hop le" );
                break;
        }
    }
}
