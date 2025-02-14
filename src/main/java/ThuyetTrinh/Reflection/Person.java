package ThuyetTrinh.Reflection;

public class Person {
    private String name;
    private int tuoi;

    public Person(String name, int tuoi) {
        this.name = name;
        this.tuoi = tuoi;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public void infor(){
        System.out.println(name + " " + tuoi);

    }
}
