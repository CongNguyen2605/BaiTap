package Section16.Bai1.Service;

import Section15.Bai1.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PersonService {
    public Set<Person> input() {
        Scanner scanner = new Scanner(System.in);
        HashSet<Person> people = new HashSet<>();
        while (true) {
            Person person = new Person();
            System.out.println("Nhập id:");
            long id = scanner.nextLong();
            scanner.nextLine(); // Xóa bộ đệm sau khi nhập số
            if (id == 0) break;
            person.setId(id);

            System.out.println("Nhập name:");
            person.setName(scanner.nextLine());

            System.out.println("Nhập age:");
            person.setAge(scanner.nextInt());

        }
        return people;
    }

    public void infor(Set<Person> personSet){
        for (Person person : personSet){
            System.out.println(person.getId()+ "-" + person.getName() + "-" + person.getAge());
        }
    }
    public void filter(Set<Person> people){
        for (Person person : people){
            if(person.getAge() <20){
                System.out.println(person.getId()+ "-" + person.getName() + "-" + person.getAge());
            }
        }
    }
    public void delete(Set<Person> people){
        Iterator<Person> personIterator = people.iterator();
      while (personIterator.hasNext()){
          Person person = personIterator.next() ;
          if(person.getName().contains("A")){
              personIterator.remove();
          }


      }
      for (Person person : people){
          System.out.println(person.getId()+ "-" + person.getName() + "-" + person.getAge());
      }

    }


}
