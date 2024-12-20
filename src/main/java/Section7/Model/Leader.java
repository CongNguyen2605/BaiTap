package Section7.Model;

import java.util.Scanner;

public class Leader extends Person  {
    private int teamSize;
    private final double SALARY = 10000000;

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public double getSALARY() {
        return SALARY;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap team size : ");
        teamSize = scanner.nextInt();
    }

    @Override
    public void infor() {
        super.infor();
        System.out.println(getTeamSize());
    }

    public double bonus(){
        if (teamSize > 10){
            return SALARY * 0.5;
        }
        else {
            return SALARY * 0.1;
        }
    }
}
