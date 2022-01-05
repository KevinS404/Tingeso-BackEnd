package com.example.Evaluacion2.Models;

import java.sql.Date;

public class Product{
    private int id;
    private String codigo;
    private String nombre;
    private Date fecha_vencimiento;
    private int id_categoria;
    private int precio;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo_producto(String codigo_producto) {
        this.codigo = codigo_producto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre_producto) {
        this.nombre = nombre_producto;
    }
    public Date getFechaVencimiento() {
        return fecha_vencimiento;
    }
    public void setFechaVencimiento(Date fechaVencimiento_producto) {
        this.fecha_vencimiento = fechaVencimiento_producto;
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