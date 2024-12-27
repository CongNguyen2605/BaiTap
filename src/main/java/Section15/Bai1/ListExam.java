package Section15.Bai1;

import java.util.*;

class ListExam {
    public List<Person> input() {
        List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter person details (id, name, age). Enter 0 as id to stop:");

            System.out.print("ID: ");
            long id = scanner.nextLong();
            if (id == 0) break; // Thoát nếu ID = 0

            System.out.print("Name: ");
            String name = scanner.next();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            Person person = new Person();
            person.setId(id);
            person.setName(name);
            person.setAge(age);

            people.add(person); // Thêm đối tượng Person vào danh sách
        }

        return people; // Trả về danh sách các đối tượng Person
    }

    public void infor(List<Person> people){
        for (Person person : people){
            System.out.println(person.getId() + "-" + person.getName() + "-" + person.getAge());
        }

    }
    public void filter(List<Person> people){
        for (Person person : people){
            if (person.getAge() <20){
                System.out.println(person.getId() + "-" + person.getName() + "-" + person.getAge());
            }
        }
    }
    public void delete(List<Person> people) {

        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();

            if (person.getName().toLowerCase(Locale.ROOT).startsWith("a")) {
                iterator.remove();
            }
        }}

    public void sort(List<Person> people){

        people.sort(Comparator.comparingInt(Person :: getAge));
        for (Person person : people){
            System.out.println(person.getId()+ "-" + person.getName()+"-" + person.getAge());
        }
    }


}


