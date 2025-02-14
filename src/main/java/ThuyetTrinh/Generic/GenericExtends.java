package ThuyetTrinh.Generic;

public class GenericExtends extends GenericClass<String> {
    public GenericExtends() {
        super();
    }

    public static void main(String[] args) {
        GenericExtends genericExtends = new GenericExtends();
        genericExtends.setValue("Hello, GenericExtends!");
        System.out.println(genericExtends.getValue());
    }
}
