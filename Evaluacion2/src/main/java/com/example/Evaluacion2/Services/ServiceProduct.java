package com.example.Evaluacion2.Services;

import java.util.List;
import com.example.Evaluacion2.models.Product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceProduct {
    private final Repositorieproduct repositorieProduct;

    ServicieProduct(Repositorieproduct repositorieProduct){
        this.repositorieProduct = repositorieProduct;
    }
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Product> getAllProduct(){
        return repositorieProduct.getAllProduct();
    }
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public String countProduct() {
        int total = repositorieProduct.countProduct();
        return String.format("Tienes %s productos", total);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable(value = "id") Integer id) {
        return this.repositorieProduct.getProductById(id);
    }

    @RequestMapping(value = "/getByCodigo/{codigo}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductByCodigo(@PathVariable(value = "codigo_producto") Integer codigo) {
        return this.repositorieProduct.getProductByCodigo(codigo);
    }

    @PostMapping("/newProduct")
    @ResponseBody
    public Product createProduct(@RequestBody Product product) {
        Emergencia result = repositorieProduct.createProduct(product);
        return result;
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public void updateProduct(@PathVariable(value = "id") int id, Product product) {
        repositorieProduct.updateProduct(id, product);
    }

    @PutMapping("/delete/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable(value = "id") int id, Product product){
        repositorieProduct.deleteProduct(id, product);
    }
}