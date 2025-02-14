package ThuyetTrinh.Reflection;

import java.lang.reflect.Method;

class Student {
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> personClass = Student.class;

        Object personInstance = personClass.getDeclaredConstructor().newInstance();
        Method greetMethod = personClass.getMethod("greet", String.class);
        greetMethod.invoke(personInstance, "Alice");
    }
}
