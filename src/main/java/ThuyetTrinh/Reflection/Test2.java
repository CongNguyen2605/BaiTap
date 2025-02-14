package ThuyetTrinh.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Person.class;
        Person person = (Person) clazz.getDeclaredConstructor().newInstance();
        System.out.println(clazz.getName());
        Field [] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(person,"haha");
            }
        }
        for (Field field : fields){
            if(field.getName().equals("name")){
                field.setAccessible(true);
              String name = (String) field.get(person);
                System.out.println("name :" + name);
            }
        }
        Method [] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            if(method.getName().equals("setTuoi")){
                method.invoke(person,12);
            }
        }
        for (Method method : methods){
            if(method.getName().equals("setName")){
                method.invoke(person,"cong");
            }
        }
        for (Method method : methods){
            if(method.getName().equals("getTuoi")){
              int tuoi = (int)  method.invoke(person);
                System.out.println(tuoi);

            }
        }
        for (Method method : methods){
            if(method.getName().equals("infor")){
               method.invoke(person);

            }
        }
    }
}
