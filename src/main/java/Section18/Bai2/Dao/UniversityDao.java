package Section18.Bai2.Dao;

import Section18.Bai2.Model.University;

import java.util.List;

public interface UniversityDao {
    void addUniversity(University university);
    List<University> findAllUniversity();
}
