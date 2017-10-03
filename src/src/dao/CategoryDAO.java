package dao;

import bean.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories();

    Category getCategory(int id);

    int addCategory(Category category);

    int updateCategory(Category category);

    int deleteCategory(Category category);

}
