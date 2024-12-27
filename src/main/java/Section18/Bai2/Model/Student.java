package Section18.Bai2.Model;

public class Student {
    private int id;
    private String name;
    private int age;
    private int idUniversity;

    public Student(int id, String name, int age, int idUniversity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.idUniversity = idUniversity;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", idUniversity=" + idUniversity +
                '}';
    }
}
