/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tprecetas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Declaracion de la clase ObtenerArchivo.
 * Se obtiene el archivo de recetas e ingredientes.
 * @author Grupo8
 */
public class ObtenerArchivo {
    private ArrayList<File> listaArchivosRecetas = new ArrayList();
    private ArrayList<File> listaArchivosIngredientes = new ArrayList();
    
      /**
     Constructor (String pathRecetas, String pathIngredientes) \f
     Return: n/a
     * @param pathRecetasEntrada
     * @param pathIngredientesEntrada
     */        
    public ObtenerArchivo(String pathRecetasEntrada, String pathIngredientesEntrada){        
        
        LectorPath pathRecetas = new LectorPath(pathRecetasEntrada);
        LectorPath pathIngredientes = new LectorPath(pathIngredientesEntrada);
        
        listaArchivosRecetas = pathRecetas.getFiles();
        listaArchivosIngredientes = pathIngredientes.getFiles();
    }
    
    /**
     Metodo para convertir un FILE de ingredientes en una lista de ingredientes \f
     Return: ArrayList(Ingredientes)
     */ 
    public ArrayList<Ingrediente> ConvertirPathIngredientes() throws FileNotFoundException, IOException{
        
        String row;
        ArrayList<Ingrediente> listaIngredientes = new ArrayList();
        File file;
        FileReader fr;
        BufferedReader csvIngredientes;

        
        if(!listaArchivosIngredientes.isEmpty()){
            for(int i=0; i<listaArchivosIngredientes.size();i++){
                file = new File (listaArchivosIngredientes.get(i).toString());
                fr = new FileReader(file);
                csvIngredientes = new BufferedReader(fr);
                
                while ((row = csvIngredientes.readLine()) != null){
                    String[] data = row.split(";");
                    Ingrediente ingredienteAux = new Ingrediente(data[0], data[1], Integer.parseInt(data[2]));
                    listaIngredientes.add(ingredienteAux);                 
                }
                 csvIngredientes.close();
                
            }               
        }
        return listaIngredientes;
    }
    
    
    /**
     Metodo para convertir un FILE de recetas en una lista de recetas \f
     Return: ArrayList(receta)
     * @return 
     * @throws java.io.FileNotFoundException
     */ 
    public ArrayList<Receta> ConvertirPathRecetas() throws FileNotFoundException, IOException{
        
        String row;
        ArrayList<Receta> listaRecetas = new ArrayList();
        File file;
        FileReader fr;
        BufferedReader csvRecetas;
        
        if(!listaArchivosRecetas.isEmpty()){
            for(int i=0; i<listaArchivosRecetas.size();i++){
                ArrayList<Ingrediente> listaIngredientes = new ArrayList();
                file = new File (listaArchivosRecetas.get(i).toString());
                fr = new FileReader(file);
                csvRecetas = new BufferedReader(fr);
                while ((row = csvRecetas.readLine()) != null){
                    String[] data = row.split(";");
                    Ingrediente ingredienteAux = new Ingrediente(data[0], data[1], Integer.parseInt(data[2]));
                    listaIngredientes.add(ingredienteAux);                 
                }
                csvRecetas.close();
                Receta recetaAux = new Receta(listaArchivosRecetas.get(i).toString());
                recetaAux.setListaIngrediente(listaIngredientes);
                listaRecetas.add(recetaAux); 
            }
        }     
        return listaRecetas;
    }
}
