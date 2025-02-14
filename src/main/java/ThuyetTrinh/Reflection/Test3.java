package ThuyetTrinh.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3 {
    private int sum(int a , int b){
        return a+ b;
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Test3.class;
        Test3 test3 = (Test3) clazz.getDeclaredConstructor().newInstance();
        var method = clazz.getDeclaredMethod("sum", int.class, int.class);
        method.setAccessible(true);
        int sum = (int) method.invoke(test3 , 3 ,4);
        System.out.println(sum);
        Method [] m = clazz.getDeclaredMethods();
        for (Method method1 : m){
            System.out.println(method1.getName());
        }

    }
}
