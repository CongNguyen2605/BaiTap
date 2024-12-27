package Section18.Bai1.Dao.DaoImpl;

import Section18.Bai1.Dao.UniversityDao;
import Section18.Bai1.Model.University;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityDaoImpl implements UniversityDao {
    private List<University> universities = new ArrayList<>();
    @Override
    public List<University> getAllUniversities() {
        return universities;
    }

    @Override
    public void addUniversity(University university) {
        universities.add(university);

    }

    @Override
    public University updateUniversity(long id) {
        Scanner scanner = new Scanner(System.in);
        for(University university : universities){
            if(university.getId()== id){

                System.out.println("nhap name");
                university.setName(scanner.next());
                System.out.println("nhap address");
                university.setAddress(scanner.next());

            }
        return university;
        }
        return null;
    }

    @Override
    public University findById(long id) {
        for (University university : universities){
            if (university.getId() == id){
                System.out.println(university.getId() + "-" + university.getName() + "-" + university.getAddress());
            }
        }
        return null;
    }

    @Override
    public boolean deleteUniversity(long id) {
        return universities.removeIf(university -> university.getId() == id);
    }
}
