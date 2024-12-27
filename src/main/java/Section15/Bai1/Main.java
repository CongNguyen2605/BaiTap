package Section15.Bai1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        ListExam listExam = new ListExam();
        people = listExam.input();
        System.out.println("infor");
        listExam.infor(people);
        System.out.println("filter");
        listExam.filter(people);
        System.out.println("Delete");
        listExam.delete(people);
        listExam.infor(people);
        System.out.println("sort");
        listExam.sort(people);



    }
}
