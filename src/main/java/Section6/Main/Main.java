package Section6.Main;

import Section6.Model.School;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int a  = scanner.nextInt();
        School [] schoolList = new School[a];
        for (int i = 0 ; i< a;i++){
          schoolList[i] = new School();
          schoolList[i].input();
        }
        for (School school1 : schoolList){
            school1.infor();
        }


        String s = scanner.next();
        for (School school : schoolList){
            if(school.getSchoolName().equals(s)){
                System.out.println(school.getId() + "-"+ school.getSchoolName() + "-" + school.getAddress());
            }
        }

    }
}
