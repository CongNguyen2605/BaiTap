package ThuyetTrinh.Generic;

public class GenericClass<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        GenericClass<Integer> genericClass = new GenericClass<>();
        genericClass.setValue(1);
        System.out.println(genericClass.getValue());

        GenericClass<String> genericClass1 = new GenericClass<>();
        genericClass1.setValue("asdasd");
        System.out.println(genericClass1.getValue());
    }
}
