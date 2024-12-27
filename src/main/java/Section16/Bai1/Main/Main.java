package Section16.Bai1.Main;

import Section15.Bai1.Person;
import Section16.Bai1.Service.PersonService;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        Person person = new Person();
        PersonService personService = new PersonService();
       people = personService.input();
        System.out.println("infor");
        personService.infor(people);
        System.out.println("filter");
        personService.filter(people);
        System.out.println("delete");
        personService.delete(people);
    }
}
