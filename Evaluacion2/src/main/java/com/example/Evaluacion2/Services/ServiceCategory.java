
package com.example.Evaluacion2.Services;

import java.util.List;

import com.example.Evaluacion2.Repositories.RepositorieCategory;
import com.example.Evaluacion2.Models.Category;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceCategory {
    private final RepositorieCategory repositorieCategory;

    ServiceCategory(RepositorieCategory repositorieCategory){
        this.repositorieCategory = repositorieCategory;
    }
    @RequestMapping(value = "/Category", method = RequestMethod.GET)
    public List<Category> getAll(){
        return repositorieCategory.getAll();
    }
  
    @PostMapping("/newCategory")
    @ResponseBody
    public Category createCategory(@RequestBody Category Category) {
        Category result = repositorieCategory.createCategory(Category);
        return result;
    }

    @PutMapping("/Category/update/{id}")
    @ResponseBody
    public void updateCategory(@PathVariable(value = "id") int id, Category category) {
        repositorieCategory.updateCategory(id, category);
    }

    @DeleteMapping("/Category/delete/{id}")
    @ResponseBody
    public void deleteCategory(@PathVariable(value = "id") int id){
        repositorieCategory.deleteCategory(id);
    }
}
