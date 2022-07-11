/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tprecetas;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VTCLUSAR
 */
public class ServicioRecetasTXT extends ServicioRecetas{


    private ArrayList<File> listaArchivosRecetas = new ArrayList();
    private ArrayList<File> listaArchivosIngredientes = new ArrayList();
    
      /**
     Constructor (String pathRecetas, String pathIngredientes) \f
     Return: n/a
     * @param pathRecetasEntrada
     * @param pathIngredientesEntrada
     */        

    
    /**
     Metodo para convertir un FILE de ingredientes en una lista de ingredientes \f
     Return: ArrayList(Ingredientes)
     */ 
    @Override
    public ArrayList obtenerIngredientes(String ing){    
        
        
        LectorPath pathIngredientes = new LectorPath(ing);     
        
        listaArchivosIngredientes = pathIngredientes.getFiles();
        String row;
        ArrayList<Ingrediente> listaIngredientes = new ArrayList();
        File file;
        FileReader fr = null;
        BufferedReader csvIngredientes;

        
        if(!listaArchivosIngredientes.isEmpty()){
            for(int i=0; i<listaArchivosIngredientes.size();i++){
                file = new File (listaArchivosIngredientes.get(i).toString());
                try {
                    fr = new FileReader(file);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ServicioRecetasTXT.class.getName()).log(Level.SEVERE, null, ex);
                }
                csvIngredientes = new BufferedReader(fr);
                
                try {
                    while ((row = csvIngredientes.readLine()) != null){
                        String[] data = row.split(";");
                        Ingrediente ingredienteAux = new Ingrediente(data[0], data[1], Integer.parseInt(data[2]));                 
                        listaIngredientes.add(ingredienteAux);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServicioRecetasTXT.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    csvIngredientes.close();
                } catch (IOException ex) {
                    Logger.getLogger(ServicioRecetasTXT.class.getName()).log(Level.SEVERE, null, ex);
                }
                
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
    @Override
    public ArrayList<Receta> obtenerRecetas(String rec){
        LectorPath pathRecetas = new LectorPath(rec);          
        listaArchivosRecetas = pathRecetas.getFiles();
        
        String row;
        ArrayList<Receta> listaRecetas = new ArrayList();
        File file;
        FileReader fr = null;
        BufferedReader csvRecetas;
        
        if(!listaArchivosRecetas.isEmpty()){
            for(int i=0; i<listaArchivosRecetas.size();i++){
                ArrayList<Ingrediente> listaIngredientes = new ArrayList();
                file = new File (listaArchivosRecetas.get(i).toString());
                try {
                    fr = new FileReader(file);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ServicioRecetasTXT.class.getName()).log(Level.SEVERE, null, ex);
                }
                csvRecetas = new BufferedReader(fr);
                try {
                    while ((row = csvRecetas.readLine()) != null){
                        String[] data = row.split(";");
                        Ingrediente ingredienteAux = new Ingrediente(data[0], data[1], Integer.parseInt(data[2]));                 
                        listaIngredientes.add(ingredienteAux);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServicioRecetasTXT.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    csvRecetas.close();
                } catch (IOException ex) {
                    Logger.getLogger(ServicioRecetasTXT.class.getName()).log(Level.SEVERE, null, ex);
                }
                Receta recetaAux = new Receta(listaArchivosRecetas.get(i).toString());
                recetaAux.setListaIngrediente(listaIngredientes);
                listaRecetas.add(recetaAux); 
            }
        }     
        return listaRecetas;
    }



}
