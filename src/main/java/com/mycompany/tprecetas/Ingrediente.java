/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tprecetas;

/**
 *
 * @author JSierra
 */
public class Ingrediente {
    /**
    * Declaracion de los atributos privados
    */
    private String codigo, nombre;
    private int cantidad;
    /**
    * Creacion del Constructor
    * @param codigo
    * @param nombre
    * @param cantidad
   */
    public Ingrediente(String codigo, String nombre, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    /**
    * Metodo para establecer formato de ingredientes en su respectivo formato
    */
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    /**
    * Metodo para obtener cada ingrediente en su respectivo formato
    */
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    
}
