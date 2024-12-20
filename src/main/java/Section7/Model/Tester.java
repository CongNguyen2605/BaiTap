package Section7.Model;

import java.util.Scanner;

public class Tester extends Person  {
    private String testTools;

    public String getTestTools() {
        return testTools;
    }

    public void setTestTools(String testTools) {
        this.testTools = testTools;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap test Tool");
        testTools = scanner.next();
    }

    @Override
    public void infor() {
        super.infor();
        System.out.println(getTestTools());
    }
}
