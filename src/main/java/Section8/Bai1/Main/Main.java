package Section8.Bai1.Main;

import Section8.Bai1.Models.Car;
import Section8.Bai1.Models.House;
import Section8.Bai1.Models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        List<House> houses = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int a ;
        do {
            System.out.println("1.Them House \n" +
                    "2.Them Car \n" +
                    "3.Them Person \n" +
                    "4.In House \n" +
                    "5.In Car \n" +
                    "6. Mua Tai San \n" +
                    "7. In Person");
             a = scanner.nextInt();
            if(a==1){
                House house = new House();
                house.input();
                houses.add(house);
            }
            if(a==2){
                Car car = new Car();
                car.input();
                cars.add(car);
            }
            if (a==3){
                Person person = new Person();
                person.input();
                people.add(person);
            }
            if (a==4){
                for (House house : houses){
                    house.infor();
                }
            }
            if (a==5){
             for (Car car : cars){
                car.infor();}
            }
            if (a==6){
                int b;

                do { System.out.println("Them Xe \n" +
                        "Them Nha \n");
                     b = scanner.nextInt();
                    if(b==1){

                        System.out.println("Chon nguoi" );
                        for (int i = 0 ;i< people.size();i++){
                            System.out.println(i + 1 );
                            people.get(i).infor();
                        }
                        int c = scanner.nextInt() - 1;
                        Person person1 = people.get(c);

                        System.out.println("chon xe");
                      for (Car car : cars){
                          car.infor();
                      }
                        int d = scanner.nextInt() -1 ;
                        Car car = cars.get(d);
                        person1.getCarList().add(car);


                    }
                    if (b==2){
                        System.out.println("Chon nguoi" );
                        for (int i = 0 ;i< people.size();i++){
                            System.out.println(i + 1 );
                            people.get(i).infor();
                        }
                        int c = scanner.nextInt() - 1;
                        Person person1 = people.get(c);

                        System.out.println("chon xe");
                        for (House house : houses){
                            house.infor();
                        }
                        int d = scanner.nextInt() -1 ;
                        House house = houses.get(d);
                        person1.getHouses().add(house);


                    }

                }
                while (b!=0);
            }
            if (a==7){
                for (int i = 0 ;i< people.size();i++){
                    System.out.println(i + 1 );
                    people.get(i).infor();
                }
            }
        }
        while (a!=0);
    }
}
