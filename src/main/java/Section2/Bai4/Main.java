package Section2.Bai4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if(age<1){
            System.out.println("tre so sinh");
        }
        else if( age <= 3){
            System.out.println("em be");
        }
        else if (age <= 18){
            System.out.println("tre lon");
        }
        else if (age <= 40){
            System.out.println("nguoi lon");
        }
        else if ( age< 60){
            System.out.println("trung lien");
        }
        else {
            System.out.println("nguoi gia");
        }
    }
}
