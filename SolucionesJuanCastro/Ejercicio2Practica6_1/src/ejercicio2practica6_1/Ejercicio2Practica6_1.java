/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2practica6_1;

/**
 *
 * @author juan
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;
public class Ejercicio2Practica6_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        float notamedia=0.f;
        Alumnos alumno = null;
         
        try
        {
        File ficheroseria = new File("seriali.dat");
        FileInputStream flujo = new FileInputStream(ficheroseria);
            ObjectInputStream lector = new ObjectInputStream(flujo);
          File ficherosecuen = new File("fichSec.txt");  
           FileWriter flujosecu = new FileWriter(ficherosecuen,true);
            PrintWriter escritor = new PrintWriter(flujosecu); 
            
          alumno = (Alumnos) lector.readObject();

            while(alumno != null)
            {
                notamedia=alumno.notas[0]+alumno.notas[1]+alumno.notas[2];
              escritor.println(alumno.dni);
              escritor.println(alumno.nombre);
              escritor.println(notamedia);
              alumno= (Alumnos) lector.readObject();
            }
            lector.close();
            escritor.close();
        }
        catch(IOException ioe){
            System.out.println("Error de fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
}
