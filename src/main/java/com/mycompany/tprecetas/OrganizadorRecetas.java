/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tprecetas;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Declaracion de la clase OrganizadorRecetas.
 * En esta clase se hace la comparacion de los ingredientes de la receta y los ingredientes disponibles.
 * @author Grupo 8
 */
public class OrganizadorRecetas {
    /**
     * Declaracion de los atributos privados
     */
    private  ArrayList<Receta> listaRecetasEvaluar = new ArrayList();
    private  ArrayList<Ingrediente> listaIngredientesDisponibles = new ArrayList();
    /**
    * @param pathRecetas
    * @param pathIngredientes
    * @throws IOException
    * @return valorDevolver
    */
   public String arracarOrganizadorRecetas(String tipo,String pathRecetas,String pathIngredientes) throws IOException, Exception{
        ServicioRecetasFactory srFactory = new ServicioRecetasFactory();
        ServicioRecetas servicioReceta = srFactory.obtenerServicio(tipo);
        listaRecetasEvaluar = servicioReceta.obtenerRecetas(pathRecetas);
        listaIngredientesDisponibles = servicioReceta.obtenerIngredientes(pathIngredientes);
        return this.RecetasPosibles(listaRecetasEvaluar,listaIngredientesDisponibles);
    
    }
    
    public String arracarOrganizadorRecetasDetalle(String tipo, String pathRecetas,String pathIngredientes) throws IOException, Exception{
    
        ServicioRecetasFactory srFactory = new ServicioRecetasFactory();
        ServicioRecetas servicioReceta = srFactory.obtenerServicio(tipo);
        listaRecetasEvaluar = servicioReceta.obtenerRecetas(pathRecetas);
        listaIngredientesDisponibles = servicioReceta.obtenerIngredientes(pathIngredientes);
        return this.RecetasPosiblesDetalle(listaRecetasEvaluar,listaIngredientesDisponibles);
    
    }   

    public  String RecetasPosibles(ArrayList<Receta> listaRecetasEvaluar, ArrayList<Ingrediente> listaIngredientesDisponibles){
        String valorDevolver ="";
        for(int i=0; i<this.listaRecetasEvaluar.size(); i++){            
             if( buscarEnHeladera(listaRecetasEvaluar.get(i).getListaIngrediente(), listaIngredientesDisponibles)){
                valorDevolver = valorDevolver + " La Receta "+ listaRecetasEvaluar.get(i).getNombre()+" Es posible\n" ;  
            }else{
                valorDevolver = valorDevolver + " La Receta "+ listaRecetasEvaluar.get(i).getNombre()+" No tiene suficientes ingredientes\n" ;
            }
        }
        
        valorDevolver = valorDevolver + "\n \n \n Cantidad de archivo de recetas procesados:" + this.listaRecetasEvaluar.size();
        valorDevolver = valorDevolver + "\n Cantidad de variedad de ingredientes disponibles:" + listaIngredientesDisponibles.size();
        return valorDevolver;
    }
    
    
     public  String RecetasPosiblesDetalle(ArrayList<Receta> listaRecetasEvaluar, ArrayList<Ingrediente> listaIngredientesDisponibles){
        String valorDevolver ="";
        for(int i=0; i<this.listaRecetasEvaluar.size(); i++){            
             if( buscarEnHeladera(listaRecetasEvaluar.get(i).getListaIngrediente(), listaIngredientesDisponibles)){
                valorDevolver = valorDevolver + "\n La Receta "+ listaRecetasEvaluar.get(i).getNombre()+" Es posible";
                valorDevolver = valorDevolver + " Ingredientes Utilizados:\n";
                for(int j=0; j<listaRecetasEvaluar.get(i).getListaIngrediente().size(); j++){
                    valorDevolver = valorDevolver + " - " + listaRecetasEvaluar.get(i).getListaIngrediente().get(j).getNombre() + " --> Cantidad: " + listaRecetasEvaluar.get(i).getListaIngrediente().get(j).getCantidad() + " \n"; 
                }
            }else{
                valorDevolver = valorDevolver + "\n La Receta "+ listaRecetasEvaluar.get(i).getNombre()+" No tiene suficientes ingredientes\n" ;
            }
        }
        return valorDevolver;
    }
    
    private static boolean buscarEnHeladera(ArrayList<Ingrediente> listaIngredientesRecetas, ArrayList<Ingrediente> listaIngredientesDisponibles) {
    for (int j = 0; j < listaIngredientesRecetas.size(); j++) {            
            if( ! buscarIngredienteStringEnListaDeIngredientes(listaIngredientesRecetas.get(j).getNombre(),listaIngredientesRecetas.get(j).getCantidad(),listaIngredientesDisponibles)){
                return false;
        }
    }
    return true;
    }

    
    private static boolean buscarIngredienteStringEnListaDeIngredientes(String ingredienteBuscar,int cantidadIngredienteReceta,ArrayList<Ingrediente> listaIngredientesDisponibles){
        for (int  i = 0; i < listaIngredientesDisponibles.size() ; i++ ){
            if( ingredienteBuscar.equals(listaIngredientesDisponibles.get(i).getNombre()) ){
                if ( cantidadIngredienteReceta <= listaIngredientesDisponibles.get(i).getCantidad()){
                return true;
                }
            }
        }
        return false;
    }
}
