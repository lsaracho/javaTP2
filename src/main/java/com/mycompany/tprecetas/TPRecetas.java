/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tprecetas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author JSierra
 */
public class TPRecetas {

    public static void main(String[] args) {
        ServicioBD servicio = null;
        try {
            servicio = new ServicioBD();
        } catch (SQLException ex) {
            Logger.getLogger(TPRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /****************************************
        * CREA TABLA PRIMERA VEZ
        ***************************************
        try {
            servicio.crearTablaRecetas();
        } catch (SQLException ex) {
            Logger.getLogger(TPRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        String obtenerPathRecetas = "";
        String ObtenerPathIngredientes = "";
        OrganizadorRecetas nuevaOrganizador = new OrganizadorRecetas();
        try {
            nuevaOrganizador.arracarOrganizadorRecetas(obtenerPathRecetas, ObtenerPathIngredientes);
        } catch (IOException ex) {
            Logger.getLogger(TPRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        InterfazUsuario ventana = new InterfazUsuario();
           ventana.show();
        
    }


}
