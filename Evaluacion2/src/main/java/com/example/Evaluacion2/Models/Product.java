package com.example.Evaluacion2.Models;

import java.sql.Date;

public class Product{
    private int id;
    private int codigo_producto;
    private String nombre_producto;
    private Date fechaVencimiento_producto;
    private int id_categoria;
    private int precio;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCodigo_producto() {
        return codigo_producto;
    }
    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }
    public String getNombre_producto() {
        return nombre_producto;
    }
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    public Date getFechaVencimiento_producto() {
        return fechaVencimiento_producto;
    }
    public void setFechaVencimiento_producto(Date fechaVencimiento_producto) {
        this.fechaVencimiento_producto = fechaVencimiento_producto;
    }
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    

}