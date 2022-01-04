package com.example.Evaluacion2.Repositories;

import java.util.List;
import com.example.Evaluacion2.Models.Product;

public interface RepositorieProduct {

    public List<Product> getAll();
    public void updateProduct(int id, Product product);
    public Product createProduct(Product product);
    public void deleteProduct(int id);
     
}
