package ThuyetTrinh.SOLID.DependencyInversionPrinciple.Sai;

import java.security.Key;

public class Computer {
    private KeyBoard keyBoard;

    public Computer(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }
    public void work(){
        keyBoard.type();
    }

    public static void main(String[] args) {
        Computer computer = new Computer(new KeyBoard());
        computer.work();
    }
}
