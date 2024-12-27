package Section19.Dao;

import Section19.Model.Category;

import java.util.List;

public interface CategoryDao {
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int idcategory);
    List<Category> allCategory();

}
