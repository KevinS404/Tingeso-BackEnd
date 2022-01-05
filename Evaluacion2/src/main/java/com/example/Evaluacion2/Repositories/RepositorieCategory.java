package com.example.Evaluacion2.Repositories;

import java.util.List;
import com.example.Evaluacion2.Models.Category;

public interface RepositorieCategory {

    public List<Category> getAll();
    public void updateCategory(int id, Category category);
    public Category createCategory(Category category);
    public void deleteCategory(int id);
     
}
