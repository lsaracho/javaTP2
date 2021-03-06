/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tprecetas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VTCLUSAR
 */
public class ServicioRecetasBD extends ServicioRecetas{
    
    private Connection conexion;

    public void CrearBD() throws SQLException {
        //sqlite crea el nuevo archivo de la base si no existe
        this.conexion = DriverManager.getConnection("jdbc:sqlite:base_de_prueba.db");
    }

    
    @Override
    public ArrayList obtenerIngredientes(String ing) {
        
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        
        //ServicioRecetasBD servicio = null;
        try {
            CrearBD();
        } catch (SQLException ex) {
            Logger.getLogger(TPRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {

            String query = "SELECT codigo, nombreIngrediente, cantidad FROM ingredientes";
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.print(rs.getString("nombreIngrediente"));
                ingredientes.add(new Ingrediente(rs.getString("codigo"), rs.getString("nombreIngrediente"), rs.getInt("cantidad")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        for (Ingrediente ing2 : ingredientes) {
            System.out.println(ing2.getNombre());
        }
        return ingredientes;
    }

    @Override
    public ArrayList<Receta> obtenerRecetas(String rec) {
        
        ArrayList<Receta> listaRecetas = new ArrayList<>();
        
        //ServicioRecetasBD servicio = null;
        try {
            CrearBD();
        } catch (SQLException ex) {
            Logger.getLogger(TPRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
              
        try {

            String query = "SELECT nombreReceta, codigo, nombreIngrediente, cantidad FROM recetas";
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();


                 
            while (!rs.isAfterLast()) {
                String nReceta = rs.getString("nombreReceta");
                Receta recetaAux = new Receta(nReceta);
                ArrayList<Ingrediente> ingredientesAux = new ArrayList<>();
                
                while(!rs.isAfterLast() && (nReceta.equals(rs.getString("nombreReceta"))) ){
                    
                    ingredientesAux.add(new Ingrediente(rs.getString("codigo"), rs.getString("nombreIngrediente"), rs.getInt("cantidad")));
                    rs.next();
                }
                
                recetaAux.setListaIngrediente(ingredientesAux);
                listaRecetas.add(recetaAux);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaRecetas;
        
    }

 
    
    
    
}
