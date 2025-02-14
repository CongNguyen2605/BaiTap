package ThuyetTrinh.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Test {
    private static final String NAME = "CONG";

    public static void main(String[] args) throws Exception {

        Class<?> testClass = Test.class;


        Field nameField = testClass.getDeclaredField("NAME");


        nameField.setAccessible(true);


        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);

        nameField.set(null, "haha");


        System.out.println("Updated NAME: " + NAME);
    }
}
