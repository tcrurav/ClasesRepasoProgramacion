/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coches;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor
 */
public class Coches {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Coche> coches = new ArrayList<>();
        coches.add(new Coche("Audi", "A4", "GC-4433-CJ"));
        coches.add(new Coche("Volkswagen", "Polo Classic", "4433AAF"));
        coches.add(new Coche("Audi", "A3", "TF-4433-CJ"));

        escribirEnFichero(coches);

//        ImprimirFichero();
//        
//        consultar();
        
//        darDeBaja();
//        


        actualizarFichero();
        
        ImprimirFichero();

    }

    private static void escribirEnFichero(ArrayList<Coche> coches) {
        FileOutputStream fos = null;
        try {
            File fichero = new File("coches.txt");
            fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Coche c : coches) {
                oos.writeObject(c);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void ImprimirFichero() {
        /* Y ahora leemos del fichero */
        FileInputStream fis = null;
        try {
            File fichero = new File("coches.txt");
            fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Coche coche;

            while (true) {
                try {
                    coche = (Coche) ois.readObject();
                    System.out.println(coche.toString());
                } catch (Exception e) {
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void consultar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame la matrícula del coche a buscar: ");
        String matriculaLeida = teclado.nextLine();
        
        FileInputStream fis = null;
        try {
            File fichero = new File("coches.txt");
            fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Coche coche;

            while (true) {
                try {
                    coche = (Coche) ois.readObject();
                    if(coche.getMatricula().equals(matriculaLeida)){
                        System.out.println("Los datos del coche consultado son: ");
                        System.out.println(coche.toString());
                    }
                    
                } catch (Exception e) {
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void darDeBaja() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame la matrícula del coche a buscar: ");
        String matriculaLeida = teclado.nextLine();
        
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File fichero = new File("coches.txt");
            fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            File fichTemporal = new File("temporal.txt");
            fos = new FileOutputStream(fichTemporal);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Coche coche;

            while (true) {
                try {
                    coche = (Coche) ois.readObject();
                    if(!coche.getMatricula().equals(matriculaLeida)){
                        oos.writeObject(coche);
                    }
                    
                } catch (Exception e) {
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        File fichero = new File("coches.txt");
        fichero.delete();
        
        File fichTemporal = new File("temporal.txt");
        fichero = new File("coches.txt");
        fichTemporal.renameTo(fichero);
    }

    private static void actualizarFichero() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame la matrícula del coche a buscar: ");
        String matriculaLeida = teclado.nextLine();
        
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File fichero = new File("coches.txt");
            fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            File fichTemporal = new File("temporal.txt");
            fos = new FileOutputStream(fichTemporal);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Coche coche;

            while (true) {
                try {
                    coche = (Coche) ois.readObject();
                    if(!coche.getMatricula().equals(matriculaLeida)){
                        oos.writeObject(coche);
                    } else {
                        System.out.println("Dame la marca: ");
                        String marca = teclado.nextLine();
                        System.out.println("Dame la modelo: ");
                        String modelo = teclado.nextLine();
                        System.out.println("Dame la matrícula: ");
                        String matricula = teclado.nextLine();
                        
                        oos.writeObject(new Coche(marca, modelo, matricula));
                    }
                    
                } catch (Exception e) {
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Coches.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        File fichero = new File("coches.txt");
        fichero.delete();
        
        File fichTemporal = new File("temporal.txt");
        fichero = new File("coches.txt");
        fichTemporal.renameTo(fichero);
    }

}
