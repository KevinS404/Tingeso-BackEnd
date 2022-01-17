package com.example.Evaluacion2.Services;

import java.util.List;

import com.example.Evaluacion2.Repositories.RepositorieProduct;
import com.example.Evaluacion2.Models.Product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceProduct {
    private final RepositorieProduct repositorieProduct;

    ServiceProduct(RepositorieProduct repositorieProduct){
        this.repositorieProduct = repositorieProduct;
    }
    @RequestMapping(value = "/Product", method = RequestMethod.GET)
    public List<Product> getAllProduct(){
        return repositorieProduct.getAll();
    }
   
    @PostMapping("/newProduct")
    @ResponseBody
    public Product createProduct(@RequestBody Product product) {
        return repositorieProduct.createProduct(product);
    }
    
    @PutMapping("/Product/update/{id}")
    @ResponseBody
    public void updateProduct(@PathVariable(value = "id") int id, Product product) {
        repositorieProduct.updateProduct(id, product);
    }

    @DeleteMapping("/Product/delete/{id}")
    public void deleteProduct(@PathVariable(value = "id") int id){
        repositorieProduct.deleteProduct(id);
    }

    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hola mundo";
    }
}