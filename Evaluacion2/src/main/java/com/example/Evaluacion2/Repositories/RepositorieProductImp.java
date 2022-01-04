package com.example.Evaluacion2.Repositories;

import java.util.List;
import com.example.Evaluacion2.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


@Repository
public class RepositorieProductImp implements RepositorieProduct {
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * from product";
        try(Connection conn = sql2o.open()){
            return (List<Product>) conn.createQuery(sql).executeAndFetch(Product.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }
    @Override
    public Product createProduct(Product product){
        String sql = "INSERT INTO product (codigo, nombre, fecha_vencimiento, id_categoria, precio) VALUES(:codigo, :nombre, :fecha_vencimiento, :id_categoria, :precio)";

        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("codigo", product.getCodigo_producto())
            .addParameter("nombre", product.getNombre_producto())
            .addParameter("fecha_vencimiento", product.getFechaVencimiento_producto())
            .addParameter("id_categoria", product.getId_categoria())
            .addParameter("precio", product.getPrecio())
            .executeUpdate().getKey();

            product.setId(id);
            return product;

        }
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }

    @Override
    public void updateProduct(int id, Product product){

        String updateSql = "UPDATE product SET codigo = :codigo, nombre = :nombre, fecha_vencimiento = :fecha_vencimiento, id_categoria = :id_categoria, precio = :precio WHERE id = :id";

        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
                .addParameter("codigo", product.getCodigo_producto())
                .addParameter("nombre", product.getNombre_producto())
                .addParameter("fecha_vencimiento", product.getFechaVencimiento_producto())
                .addParameter("id_categoria", product.getId_categoria())
                .addParameter("precio", product.getPrecio())
                .addParameter("id", id).executeUpdate();

        }
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }

    @Override
    public void deleteProduct(int id){

        String deleteSql = "DELETE FROM product WHERE id = :id";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("id", id).executeUpdate();

        }
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
}
