package ThuyetTrinh.Generic;

import java.util.Arrays;
import java.util.List;

public class WildCard {
    public static void print(List<? super String> list){
        for (Object obj : list){
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A" , "B" , "C");
        List<Integer> list1 = List.of(1,2,3);
        WildCard.print(list);
//        WildCard.print(list1);
    }
}
