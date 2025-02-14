package ThuyetTrinh.SOLID.DependencyInversionPrinciple.Dung;

public class Computer {
    private inputDevice inputDevice;

    public Computer(ThuyetTrinh.SOLID.DependencyInversionPrinciple.Dung.inputDevice inputDevice) {
        this.inputDevice = inputDevice;
    }
    public void work(){
        inputDevice.input();
    }

    public static void main(String[] args) {
        Computer computer = new Computer(new KeyBoard());
        computer.work();
        Computer computer1 = new Computer(new Touchpad());
        computer1.work();
    }
}
