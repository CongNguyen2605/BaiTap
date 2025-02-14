package ThuyetTrinh.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> person = Person.class;
        Person person1 = (Person) person.getDeclaredConstructor().newInstance();
        System.out.println(person.getName());
        Field [] fields = person.getDeclaredFields();
        for (Field field : fields){
            System.out.println("- " +field.getName());
        }
        for (Field field : fields){
           if(field.getName().equals("tuoi")){
               field.setAccessible(true);
               field.setInt(person1,12);
           }
        }
        for (Field field : fields){
            if(field.getName().equals("tuoi")){
                field.setAccessible(true);
               int age =  field.getInt(person1);
                System.out.println(age);
            }

        }
        Method [] methods = person.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }
        for (Method method : methods){
           if (method.getName().equals("setName")){
               method.invoke(person1,"cong");
           }
        }
        for (Method method : methods){
            if (method.getName().equals("getName")){
               String name = (String) method.invoke(person1);
                System.out.println(name);
            }
        }
    }
}
