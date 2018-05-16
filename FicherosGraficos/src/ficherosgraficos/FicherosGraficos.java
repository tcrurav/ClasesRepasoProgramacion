/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosgraficos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor
 */
public class FicherosGraficos {
    
    public static void main(String[] args) {
        new Pantalla();
    }
    
    public static void crearFichero(String nombre, String datos){
        BufferedWriter bw = null;
        try {
            File fichero = new File(nombre);
            FileWriter fw = new FileWriter(fichero);
            bw = new BufferedWriter(fw);
            
            bw.write(datos);
            bw.newLine();
            bw.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(FicherosGraficos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(FicherosGraficos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
