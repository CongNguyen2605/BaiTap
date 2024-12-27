package Section16.Bai3;

public class Main {
    public static void main(String[] args) {
        String s1 = "Hello Trung Tam Java";
        String s2 = "I am Java";
        String s3 = "I am joining JavaCore19";
        System.out.println(s1 + s2 + s3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s1).append(" ").append(s2).append(" ").append(s3);
        System.out.println(stringBuilder);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s1).append(" ").append(s2).append(" ").append(s3);
        System.out.println(stringBuffer);
    }
}
