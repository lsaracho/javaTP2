/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tprecetas;

import java.io.File;
import java.util.ArrayList;
/**
 *
 * @author JSierra
 */
public class LectorPath {
    /**
     * Declaracion del atributo privado
     */
    private String path;
    /**
    * Creacion del constructor
    * @param pathEntrada
    */
    public LectorPath(String pathEntrada){
        this.path = pathEntrada;
    }
    /**
    * Se obtiene los archivos mediante un ArrayList
    * @return listaArchivos
    */      
    public ArrayList<File> getFiles() {

        ArrayList<String>  listaArchivosString = new ArrayList();
        File archivoPath = new File( this.path );
        ArrayList<File> listaArchivos = new ArrayList();
               
        if ( archivoPath.isDirectory( )) {
            for (int j=0; j<archivoPath.listFiles().length; j++){
                listaArchivos.add(archivoPath.listFiles()[j]);
            }
        } 
        return listaArchivos;
    }
}
