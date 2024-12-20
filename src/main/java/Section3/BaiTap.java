package Section3;

import java.util.Scanner;

public class BaiTap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. In 10 Hello World \n" +
                "2. Tinh Tong 1 -> 100 \n" +
                "3. Tinh Giai Thua n \n" +
                "4.do while \n" +

                "5. Mang" );
        int a = scanner.nextInt();
      switch (a){
          case 1:
              for (int i =0;i<= 9; i++){
                  System.out.println("hello world");
          }
              break;
          case 2:
             int sum = 0 ;
             for (int i = 1 ; i<=100;i++){
                 sum += i;

             }
              System.out.println(sum);
             break;
          case 3:
              System.out.println("nhap so");
              int b = scanner.nextInt();
              int giaiTich = 1;
              for (int i = 1 ;i <= b; i++){
                  giaiTich *= i;
              }
              System.out.println(giaiTich);
              break;
          case 4:
              int i = 0;
              do {
                  System.out.println("hehe");
                  i++;
              }
              while (i<5);
              break;
          case 5:
              System.out.println("nhap");
              int c = scanner.nextInt();

              int arr [] = new int[c];

              for (int z = 0 ; z< arr.length;z++){
                  System.out.println("nhap phan tu thu :" + z);
                  arr[z] = scanner.nextInt();
              }
              System.out.println("mang ");
              for (int n = 0 ; n < arr.length;n++){
                  System.out.print(arr[n] + " ");
              }
              int tong = 0;
              for (int m = 0; m < arr.length;m++){
                    tong += arr[m];
              }
              System.out.println("tong" +tong);
              int max = arr[0] ;
              int min = arr[0];
              for (int q = 0;q < arr.length;q++ ){
                  if(arr[q] > max){
                     max = arr[q];
                  }
                  if (arr[q] < min){
                      min = arr[q];
                  }
              }
              System.out.println("max " + max );
              System.out.println( "min " +min );
              int temp ;
              for (int w = 0 ; w< arr.length;w++){
                  for (int u = w + 1 ;u < arr.length;u++){
                      if (arr[w] > arr[u]){
                          temp = arr[u];
                          arr[u] = arr[w];
                          arr[w] = temp;
                      }
                  }
              }
              System.out.println("mang sau khi sap xep");
              for (int g = 0 ;g< arr.length;g++){
                  System.out.println(arr[g] + "");
              }





      }

    }
}
