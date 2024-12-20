package Section5.TrungTamJava.Model;

import java.util.List;
import java.util.Scanner;

public class CourseScore {
    private Long id;
    private int score;
    private String name;

    public CourseScore(Long id, int score, String name) {
        this.id = id;
        this.score = score;
        this.name = name;
    }

    public CourseScore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        score = scanner.nextInt();
        name = scanner.next();
    }
    public  void infor(){

            if(getScore() <5){
                System.out.println("yeu");
                System.out.println(getId());
                System.out.println(getName());
                System.out.println(getScore());
            }
           else if(getScore() <7){
                System.out.println("TB");
                System.out.println(getId());
                System.out.println(getName());
                System.out.println(getScore());
            }
            else  if(getScore() <8){
                System.out.println("TB");
                System.out.println(getId());
                System.out.println(getName());
                System.out.println(getScore());
            }
            else  if(getScore() <9){
                System.out.println("GIOI");
                System.out.println(getId());
                System.out.println(getName());
                System.out.println(getScore());
            }
            else{
                System.out.println("Xuat sac");
                System.out.println(getId());
                System.out.println(getName());
                System.out.println(getScore());

        }
    }
}
