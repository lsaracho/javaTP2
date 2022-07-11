/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tprecetas;

import java.awt.List;
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

    public ServicioRecetasBD() throws SQLException {
        //sqlite crea el nuevo archivo de la base si no existe
        this.conexion = DriverManager.getConnection("jdbc:sqlite:base_de_prueba.db");
    }
    @Override
    public ArrayList obtenerIngredientes(String ing) {
        
        
        
        ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
        
        try {

            String query = "SELECT nombreIngrediente, cantidad FROM ingredientes";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                ingredientes.add(new Ingrediente(rs.getString("nombreIngrediente"), rs.getInt("cantidad")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Ingrediente ing2 : ingredientes) {
            System.out.println(ing2.getNombre());
        }
        return ingredientes;
    }

    @Override
    public ArrayList obtenerRecetas(String rec) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
    
    
}
