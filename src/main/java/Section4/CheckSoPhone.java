package Section4;

import java.util.regex.Pattern;

public class CheckSoPhone {
    public static boolean CheckSoPhone(String phone){
        String pattern = "^0\\d{9}$";
        return Pattern.matches(pattern,phone);
    }
    public static String kiemTraNhaMan(String phone){
       if(phone.startsWith("090") || phone.startsWith("093") ){
           return "Mobi";
       }
       else if (phone.startsWith("086")){
           return "Viettel";
       }
       else {
           return "khong xac dinh";
       }
    }
    public static boolean checkGmail(String gmail){
        String pattern = "^[a-zA-Z0-9]{6,}@gmail\\.com$";
        return Pattern.matches(pattern,gmail);
    }
    public static void main(String[] args) {
    String phone = "0901247174";
        System.out.println(CheckSoPhone.CheckSoPhone(phone));
        System.out.println(CheckSoPhone.kiemTraNhaMan(phone));
        System.out.println(CheckSoPhone.checkGmail(phone));
    }
}
