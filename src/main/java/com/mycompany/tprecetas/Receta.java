/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tprecetas;

import java.util.ArrayList;

/**
 *
 * @author JSierra
 */
public class Receta {
    /**
     * Declaracion de los atributos privados
     */
    private String nombre;
    private ArrayList<Ingrediente> listaIngrediente;
    /**
    * Creacion del constructor
    * @param nombre
    */
    public Receta(String nombre) {
        this.nombre = nombre;
    }  
    
   /**
    * Metodo para obtener el nombre de la receta
    * @return nombre
    */
    public String getNombre() { 
        return nombre; 
    }
    /**
    * Metodo para obtener la lista de ingredientes mediante un ArrayList
    * @return listaIngredientes
    */
    public ArrayList<Ingrediente> getListaIngrediente() { 
        return listaIngrediente; 
    }
    /**
    * Metodo para establecer el nombre de la receta
    * @param nombre
    */
    public void setNombre(String nombre) { this.nombre = nombre; }
    /**
    * Metodo para establecer la lista de ingredientes mediante un ArrayList
    */
    public void setListaIngrediente(ArrayList<Ingrediente> listaIngrediente) {
        this.listaIngrediente = listaIngrediente; }
  
    class getListaIngrediente { public getListaIngrediente() { 
        }
    }
}
