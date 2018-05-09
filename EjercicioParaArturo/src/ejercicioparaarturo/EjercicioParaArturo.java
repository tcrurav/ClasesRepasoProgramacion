/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparaarturo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor
 */
public class EjercicioParaArturo {

    static ArrayList<Alumno> alumnos = new ArrayList<>();
    static ArrayList<Nota> notas = new ArrayList<>();
    final static int TAMANO_ALUMNO = 36; // 4 + 14 * 2 + 4
    final static String FICHERO_ALUMNOS = "alumnos.txt";
    final static String FICHERO_ALUMNOS_SUSPEDIDOS = "suspendidos.txt";
    final static String FICHERO_NOTAS = "notas.txt";
    final static int TAMANO_NOMBRE = 14;
    
    public static void main(String[] args) {
        crearArrayDeAlumnos();
        crearArrayDeNotas();
        
        crearFicheroDirectoAlumnos();
        leerFicheroDirectoAlumnos();
        
        crearFicheroSecuencialNotas();
        leerFicheroSecuencialNotas();
        
        crearFicheroSecuencialSuspendidos();
        leerFicheroSecuencialSuspendidos();
    }

    private static void crearFicheroDirectoAlumnos() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File(FICHERO_ALUMNOS);
            raf = new RandomAccessFile(fichero, "rw");
            
            for(Alumno a : alumnos){
                raf.writeInt(a.getNumMatricula());
                System.out.println("nombre al crearFicheroDirectoAlumnos: " + a.getNombre() + ".");
                raf.writeChars(a.getNombre());
                raf.writeFloat(a.getNotaMedia());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void crearArrayDeNotas() {
        notas.add(new Nota(0, 5, 5, 5));
        notas.add(new Nota(TAMANO_ALUMNO, 6, 6, 6));
        notas.add(new Nota(TAMANO_ALUMNO * 2, 7, 7, 7));
        notas.add(new Nota(TAMANO_ALUMNO * 3, 3, 3, 3));
    }
    
    private static void crearArrayDeAlumnos() {
        alumnos.add(new Alumno(0, ajustarA14("Arturo"), 5));
        alumnos.add(new Alumno(TAMANO_ALUMNO, ajustarA14("Manuel Alejandro"), 6));
        alumnos.add(new Alumno(TAMANO_ALUMNO * 2, ajustarA14("Santiago"), 7));
        alumnos.add(new Alumno(TAMANO_ALUMNO * 3, ajustarA14("Efrén"), 3));
    }

    private static String ajustarA14(String texto) {
        String ajuste = texto;
        ajuste += "              "; // 14 espacios en blanco
        ajuste = ajuste.substring(0, TAMANO_NOMBRE);
        System.out.println("ajuste: " + ajuste + ".");
        return ajuste;
    }

    private static void crearFicheroSecuencialSuspendidos() {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
                     
            File ficheroNotas = new File(FICHERO_NOTAS);
            FileReader fr = new FileReader(ficheroNotas);
            br = new BufferedReader(fr);
            
            File ficheroAlumnosSuspendidos = new File(FICHERO_ALUMNOS_SUSPEDIDOS);
            FileWriter fw = new FileWriter(ficheroAlumnosSuspendidos);
            bw = new BufferedWriter(fw);
           
            Alumno alumnoLeido;
            int numMatricula, nota1, nota2, nota3;
            while((numMatricula = br.read()) != -1){
                nota1 = br.read();
                nota2 = br.read();
                nota3 = br.read();
                alumnoLeido = leerAlumnoDelFicheroDirecto(numMatricula);
                if(alumnoLeido.getNotaMedia() < 5){
                    bw.write(numMatricula);
                    bw.write(alumnoLeido.getNombre());
                    bw.write(nota1);
                    bw.write(nota2);
                    bw.write(nota3);
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }

    private static void crearFicheroSecuencialNotas() {
        FileWriter fw = null;
        try {
            File fichero = new File(FICHERO_NOTAS);
            fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(Nota n : notas){
                bw.write(n.getNumMatricula());
                bw.write(n.getNota1());
                bw.write(n.getNota2());
                bw.write(n.getNota3());
            }
            
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    private static Alumno leerAlumnoDelFicheroDirecto(int numMatricula) {
        Alumno alumno = null;
        RandomAccessFile raf = null;
        try {
            File ficheroAlumnos = new File(FICHERO_ALUMNOS);
            raf = new RandomAccessFile(ficheroAlumnos, "r");
            
            raf.seek(numMatricula);
            int numMatriculaBuscada = raf.read();
            System.out.println("numMatriculaBuscada: " + numMatriculaBuscada);
            
            byte[] b = new byte[TAMANO_NOMBRE];
            raf.read(b, 0, TAMANO_NOMBRE);
            String nombre = new String(b, StandardCharsets.UTF_8);
            System.out.println("nombre: " + nombre);
            
            float notaMedia = raf.readFloat();
            System.out.println("notaMedia: " + notaMedia);
            
            alumno = new Alumno(numMatriculaBuscada, nombre, notaMedia);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alumno;
    }

    private static void leerFicheroSecuencialSuspendidos() {
        BufferedReader br = null;
        try {

            File ficheroAlumnosSuspendidos = new File(FICHERO_ALUMNOS_SUSPEDIDOS);
            FileReader fr = new FileReader(ficheroAlumnosSuspendidos);
            br = new BufferedReader(fr);
           
            Alumno alumnoLeido;
            int numMatricula, nota1, nota2, nota3;
            while((numMatricula = br.read()) != -1){                   
                char[] b = new char[TAMANO_NOMBRE];
                br.read(b, 0, TAMANO_NOMBRE);
                String nombre = String.valueOf(b);
                
                nota1 = br.read();
                nota2 = br.read();
                nota3 = br.read();
                
                System.out.println("numMatricula: " + numMatricula +
                                   ", nombre: " + nombre +
                                   ", nota1: " + nota1 +
                                   ", nota2: " + nota2 +
                                   ", nota3: " + nota3);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    private static void leerFicheroSecuencialNotas() {
        BufferedReader br = null;
        try {

            File ficheroNotas = new File(FICHERO_NOTAS);
            FileReader fr = new FileReader(ficheroNotas);
            br = new BufferedReader(fr);
           
            int numMatricula, nota1, nota2, nota3;
            while((numMatricula = br.read()) != -1){                                   
                nota1 = br.read();
                nota2 = br.read();
                nota3 = br.read();
                
                System.out.println("numMatricula: " + numMatricula +
                                   ", nota1: " + nota1 +
                                   ", nota2: " + nota2 +
                                   ", nota3: " + nota3);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    private static void leerFicheroDirectoAlumnos() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File(FICHERO_ALUMNOS);
            raf = new RandomAccessFile(fichero, "r");
            
            int numMatricula;
            String nombre;
            byte[] b = new byte[TAMANO_NOMBRE];
            float notaMedia;
            while((numMatricula = raf.read()) != -1){
//                raf.read(b, 0, TAMANO_NOMBRE);
                raf.readUTF();
                nombre = new String(b, StandardCharsets.UTF_8);
                
                notaMedia = raf.readFloat();
                
                System.out.println("numMatricula: " + numMatricula +
                                   ", nombre: " + nombre +
                                   ", notaMedia: " + notaMedia);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(EjercicioParaArturo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
