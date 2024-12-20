package Section7.Model;

import java.util.Scanner;

public class Developer extends  Person{
   private String languges;

   public String getLanguges() {
      return languges;
   }

   public void setLanguges(String languges) {
      this.languges = languges;
   }

   @Override
   public void input() {
      super.input();
      Scanner scanner = new Scanner(System.in);
      System.out.println("nhap languages :"  );
      languges = scanner.next();

   }

   @Override
   public void infor() {
      super.infor();
      System.out.println("languages : " + getLanguges());
   }
}
