package ThuyetTrinh.SOLID.DependencyInversionPrinciple.Dung;

public class Touchpad implements inputDevice{
    @Override
    public void input() {
        System.out.println("touchpad");
    }
}
