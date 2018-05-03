/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor
 */
public class Tutores {

    /**
     * @param args the command line arguments
     */
    static final int TAMANO_TUTOR = 56;
    static final String FICHALUMNOS = "alumnos.txt";
    static ArrayList<Tutor> tutores = new ArrayList<>();
    static ArrayList<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here

        alumnos.add(new Alumno("Santiago", 0));
        alumnos.add(new Alumno("Alle", 0));
        alumnos.add(new Alumno("Efrén", 0));
        alumnos.add(new Alumno("Arturo", 1));

        tutores.add(new Tutor("Saul", "Yoquese"));
        tutores.add(new Tutor("Tiburcio", "Cruz"));
        crearFicheroAlumno();

    }

    public static void crearFicheroAlumno() {

        FileWriter fw = null;
        try {
            File file = new File(FICHALUMNOS);
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Alumno a : alumnos){
                bw.write(a.getNombre() + ":" + a.getIdTutor());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Tutores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Tutores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
