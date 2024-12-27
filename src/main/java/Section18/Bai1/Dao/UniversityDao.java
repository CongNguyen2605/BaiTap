package Section18.Bai1.Dao;

import Section18.Bai1.Model.University;

import java.util.List;

public interface UniversityDao {
    List<University> getAllUniversities();
    void addUniversity(University university);
    University updateUniversity(long id);
    University findById(long id);
    boolean deleteUniversity(long id);

}
