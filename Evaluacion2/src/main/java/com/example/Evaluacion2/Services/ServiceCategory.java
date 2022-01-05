/*
package com.example.Evaluacion2.Services;

import java.util.List;
import com.example.Evaluacion2.models.Category;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceCategory {
    private final RepositorieCategory repositorieCategory;

    ServicieCategory(RepositorieCategory repositorieCategory){
        this.repositorieCategory = repositorieCategory;
    }
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Category> getAllCategory(){
        return repositorieCategory.getAllCategory();
    }
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public String countCategory() {
        int total = repositorieCategory.countCategory();
        return String.format("Tienes %s Categorias", total);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Category getCategoryById(@PathVariable(value = "id") Integer id) {
        return this.repositorieCategory.getCategoryById(id);
    }

    @RequestMapping(value = "/getByNombre/{nombre}", method = RequestMethod.GET)
    @ResponseBody
    public Category getCategoryByNombre(@PathVariable(value = "nombre") String nombre) {
        return this.repositorieCategory.getCategoryByNombre(nombre);
    }

    @PostMapping("/newCategory")
    @ResponseBody
    public Category createCategory(@RequestBody Category Category) {
        Emergencia result = repositorieCategory.createCategory(Category);
        return result;
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public void updateCategory(@PathVariable(value = "id") int id, Category Category) {
        repositorieCategory.updateCategory(id, Category);
    }

    @PutMapping("/delete/{id}")
    @ResponseBody
    public void deleteCategory(@PathVariable(value = "id") int id, Category Category){
        repositorieCategory.deleteCategory(id, Category);
    }
}
*/