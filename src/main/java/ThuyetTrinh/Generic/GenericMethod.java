package ThuyetTrinh.Generic;

public class GenericMethod {
    public static  <T extends String> void print(T[] arrays){
        for (T element : arrays){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer [] intarray = {1,2,3};
        String [] stringarray = {"1" , "2" ,"3"};
//        GenericMethod.print(intarray);
        GenericMethod.print(stringarray);
    }
}
