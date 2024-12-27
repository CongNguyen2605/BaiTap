package Section9.Bai1.Main;

import Section9.Bai1.Model.Chicken;
import Section9.Bai1.Model.Dog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
       Dog [] dogs = new Dog[a];
        for (int i = 0 ; i < dogs.length;i++){
            dogs[i]= new Dog();
            dogs[i].input();
        }
        for (Dog dog : dogs){
            dog.infor();
        }

    }
}
