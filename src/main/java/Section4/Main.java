package Section4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String string = "string1";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chuoi : ");
        String s = scanner.nextLine();
        System.out.println("do dai chuoi :" + s.length());
        if(string.contains(s)){
            System.out.println("co ton tai");
        }
        else {
            System.out.println("khong ton tai");
        }
        for (int i = 0 ; i< string.length();i++){
            if(string.contains("s") ){

                System.out.println("co ton tai ");
                break;
            }
            else {
                System.out.println("khong ton tai");
                break;
            }
        }

        String [] words = string.split("\\s");
        for (String word : words){
            System.out.println(word);
        }





    }
}
