package com.example.Evaluacion2.Repositories;

import java.util.List;
import com.example.Evaluacion2.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


@Repository
public class RepositorieCategoryImp implements RepositorieCategory {
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Category> getAll() {
        String sql = "SELECT * from category";
        try(Connection conn = sql2o.open()){
            return (List<Category>) conn.createQuery(sql).executeAndFetch(Category.class);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }
    @Override
    public Category createCategory(Category category){
        String sql = "INSERT INTO category (nombre) VALUES(:nombre)";

        try (Connection con = sql2o.open()) {
            int id =  (int) con.createQuery(sql,true)
            .addParameter("nombre", category.getNombre())
            .executeUpdate().getKey();

            category.setId(id);
            return category;

        }
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
        return null;
    }

    @Override
    public void updateCategory(int id, Category category){

        String updateSql = "UPDATE category SET nombre = :nombre WHERE id = :id";

        try (Connection con = sql2o.open()) {
            con.createQuery(updateSql)
                .addParameter("nombre", category.getNombre())
                .addParameter("id", id).executeUpdate();

        }
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }

    @Override
    public void deleteCategory(int id){

        String deleteSql = "DELETE FROM category WHERE id = :id";

        try (Connection con = sql2o.open()) {
            con.createQuery(deleteSql)
            .addParameter("id", id).executeUpdate();

        }
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
        }
    }
}
