package com.example.Evaluacion2.Services;

import java.util.List;

import com.example.Evaluacion2.Repositories.RepositorieProduct;
import com.example.Evaluacion2.Models.Product;

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
public class ServiceProduct {
    private final RepositorieProduct repositorieProduct;

    ServiceProduct(RepositorieProduct repositorieProduct){
        this.repositorieProduct = repositorieProduct;
    }
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Product> getAllProduct(){
        return repositorieProduct.getAll();
    }
    /*
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public String countProduct() {
        int total = repositorieProduct.countProduct();
        return String.format("Tienes %s productos", total);
    }
    */

    /* terminar
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable(value = "id") Integer id) {
        return this.repositorieProduct.getAll(id);
    }
    
    @RequestMapping(value = "/getByCodigo/{codigo}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductByCodigo(@PathVariable(value = "codigo_producto") Integer codigo) {
        return this.repositorieProduct.getProductByCodigo(codigo);
    }
    */

    @PostMapping("/newProduct")
    @ResponseBody
    public Product createProduct(@RequestBody Product product) {
        return repositorieProduct.createProduct(product);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public void updateProduct(@PathVariable(value = "id") int id, Product product) {
        repositorieProduct.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable(value = "id") int id){
        repositorieProduct.deleteProduct(id);
    }
}