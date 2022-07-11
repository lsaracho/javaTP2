/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tprecetas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author JSierra
 */
public class ServicioBD {
    private Connection conexion;
    
    public ServicioBD() throws SQLException{
        //sqlite crea el nuevo archivo de la base si no existe
        this.conexion = DriverManager.getConnection("jdbc:sqlite:base_de_prueba.db");
    }
    
    public void crearTablaRecetas() throws SQLException {
        String createQuery = "CREATE TABLE IF NOT EXISTS recetas ("
                + "nombreReceta varchar(255), "
                + "nombreIngrediente varchar(80), "
                + "cantidad int"
                + ")";

        Statement st = this.conexion.createStatement();
        st.execute(createQuery);
    }
    
        public void crearTablaIngredientes() throws SQLException {
        String createQuery = "CREATE TABLE IF NOT EXISTS ingredientes ("
                + "nombreIngrediente varchar(80), "
                + "cantidad int"
                + ")";

        Statement st = this.conexion.createStatement();
        st.execute(createQuery);
    }
    
    public void truncarTablaRecetas() throws SQLException {
        String deleteQuery = "DELETE FROM recetas";

        Statement st = this.conexion.createStatement();
        st.execute(deleteQuery);
    }
    
    public void truncarTablaIngredientes() throws SQLException {
        String deleteQuery = "DELETE FROM ingredientes";

        Statement st = this.conexion.createStatement();
        st.execute(deleteQuery);
    }
    
    //Falta corregir este metodo!!
    public void mostrarTodos() throws SQLException {
        String query = "SELECT nombre, cantidad FROM recetas";
        Statement st = this.conexion.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("ResultSet: ");
        
        while (rs.next()) {
            System.out.print(" -- Nombre: " + rs.getString("nombre") + " ");
            System.out.print(" -- Cantidad: " + rs.getInt("cantidad") + " ");
            System.out.println("");
        }
        
        System.out.println("Fin ResultSet");
    }
    
    public int insertRecetas(String nombreReceta, String nombreIngrediente, int cantidad) throws SQLException {
        String insertSQL = "INSERT INTO recetas(nombreReceta, nombreIngrediente, cantidad)"
                        + " VALUES(?, ?, ?)";
        
        PreparedStatement st = this.conexion.prepareStatement(insertSQL);

        st.setString(1, nombreReceta);
        st.setString(2, nombreIngrediente);
        st.setInt(3, cantidad);
        
        return st.executeUpdate();
    }
    
        public int insertIngredientes(String nombreIngrediente, int cantidad) throws SQLException {
        String insertSQL = "INSERT INTO ingredientes(nombreIngrediente, cantidad)"
                        + " VALUES(?, ?, ?)";
        
        PreparedStatement st = this.conexion.prepareStatement(insertSQL);

        st.setString(1, nombreIngrediente);
        st.setInt(3, cantidad);
        
        return st.executeUpdate();
    }
    
    public int actualizarCantidadIngredientes(String nombreIngrediente, int cantidad) throws SQLException {
        String updateSQL = "UPDATE ingredientes SET cantidad = ?"
                + " WHERE nombreIngrediente = ?";
        PreparedStatement st = this.conexion.prepareStatement(updateSQL);

        st.setInt(1, cantidad);
        st.setString(2, nombreIngrediente);
        return st.executeUpdate();
    }
    
        public int actualizarCantidadRecetas(String nombreReceta, int cantidad) throws SQLException {
        String updateSQL = "UPDATE recetas SET cantidad = ?"
                + " WHERE nombreReceta = ?";
        PreparedStatement st = this.conexion.prepareStatement(updateSQL);

        st.setInt(1, cantidad);
        st.setString(2, nombreReceta);
        return st.executeUpdate();
    }
}
