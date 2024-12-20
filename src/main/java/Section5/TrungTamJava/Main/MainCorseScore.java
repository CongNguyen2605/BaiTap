package Section5.TrungTamJava.Main;

import Section5.TrungTamJava.Model.CourseScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCorseScore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      CourseScore [] courseScores = new CourseScore[n];
     for (int i = 0 ; i < n;i++){
         courseScores[i] = new CourseScore();
         courseScores[i].input();
     }
     for (CourseScore courseScore : courseScores){
         courseScore.infor();
     }

    }
}
