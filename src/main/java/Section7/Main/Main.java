package Section7.Main;

import Section7.Model.Developer;
import Section7.Model.Leader;
import Section7.Model.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();
        List<Leader> leaders = new ArrayList<>();
        List<Tester> testers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int a ;

        do{
            System.out.println("1.  Them Thong Tin \n" +
                    "2. Xuat Thong Tin \n" +
                    "3. Tim Dev Java \n" +
                    "4. Tim Leader > 10 \n" +
                    "5. In Thong Tin Leader >10 \n" +
                    "0. Thoat");
            a = scanner.nextInt();
        if (a==1){

            int b ;
            do{
                System.out.println("1. Them Dev \n" +
                        "2.Them Test \n" +
                        "3.Them Leader \n" +
                        "0. Thoat");
               b = scanner.nextInt();
                if (b==1){
                    Developer developer = new Developer();
                    developer.input();
                    developers.add(developer);
                }
                if (b==2){
                    Tester tester = new Tester();

                    tester.input();
                    testers.add(tester);

                }
                if (b==3){
                    Leader leader = new Leader();
                    leader.input();
                    leaders.add(leader);
                }
            }
            while (b!=0);




        }
        if(a==2){
            int b ;
            do {

                System.out.println("1. In Dev \n" +
                        "2.In Test \n" +
                        "3.In Leader \n" +
                        "0. Thoat");
                b = scanner.nextInt();

                if(b==1){
                 for (Developer developer : developers){
                     developer.infor();
                 }
                }
                if(b==2){
                   for (Tester tester : testers){
                       tester.infor();
                   }
                }
                if(b==3){
                   for (Leader leader : leaders){
                       leader.infor();
                   }

                }
            }
            while (b!=0);
        }
        if(a==3){

            for (Developer developer : developers){
                if(developer.getLanguges().equals("Java")){
                    developer.infor();
                }
            }
        }
        if (a==4){
            for (Leader leader : leaders){
                if(leader.getTeamSize() > 10){
                    leader.infor();
                }
            }
        }
        if(a==5){
            for (Leader leader : leaders){
                if (leader.getTeamSize()>10){
                    leader.infor();
                    System.out.println(leader.bonus());
                }
            }
        }

        }
        while (a!=0);
        scanner.close();
    }
}
