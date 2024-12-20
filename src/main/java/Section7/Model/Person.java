package Section7.Model;

import java.util.Scanner;

public class Person {
    private Long id;
    private String name;
    private int age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id");
        id = scanner.nextLong();
        System.out.println("nhap name");
        name = scanner.next();
        System.out.println("nhap age");
        age = scanner.nextInt();

    }
    public void infor(){
        System.out.println("id :" + getId() );
        System.out.println("name :" + getName() );
        System.out.println("age :" + getAge() );
    }
}
