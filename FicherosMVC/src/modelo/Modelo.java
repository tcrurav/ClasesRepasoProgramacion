/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiburcio
 */
public class Modelo {
    String nombreFichero;

    public Modelo() {
    }

    public String getNombreFichero() {
        return nombreFichero;
    }

    public void setNombreFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }
    
    public void crearFichero(){
        File fichero = new File(nombreFichero);
        System.out.println("Se creó el fichero");
    }
    
    public void agregarLinea(String linea){
        FileWriter fw = null;
        try {
            File fichero = new File(nombreFichero);
            fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(linea);
            bw.newLine();
            bw.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
