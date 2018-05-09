package ficherosecuencial;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FicheroSecuencial {
    
    public static void altaFichero(String matricula,String marca,String modelo,String dniTitular,String nombreTitular){
        
        try{
            //Crea un objeto File asociado al fichero fichSec.txt
            File fichero = new File("fichSec.txt");
            if(!fichero.exists()){
            fichero.createNewFile();
            }
            //Crea un flujo de caracteres para grabar
            FileWriter flujo = new FileWriter(fichero,true);
            //Enlaza el flujo de salida con la clase PrintWrite que tiene el metodo println
            PrintWriter escritor = new PrintWriter(flujo);
            // Escribe los campos cada uno en una linea
            
        }
        catch (IOException ioe){
            System.out.println("Error al crear el fichero");
        }
        catch (Exception e){
            System.out.println("Error de fichero");
        }
        
    }
    
   // public static void buscarVehiculo(String matBuscar,int numLineas){
      public static void consulta(String matBuscar){ 
    String matricula,marca,modelo,dnititular,nombretitular;
          try{
            File fichero = new File("fichSec.txt");
            // Crea un flujo de lectura
            FileReader flujo = new FileReader(fichero);
            // Enlaza con la clase Scanner que tiene el método nextLine()
            Scanner lector = new Scanner(flujo);
                      
            matricula=lector.nextLine();
          }
        catch(IOException ioe){
            System.out.println("Error al leer el fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    public static void listadoPorPantalla(){
        String matricula,marca,modelo,dnititular,nombretitular;
        try{
            File fichero = new File("fichSec.txt");
            FileReader flujo = new FileReader(fichero);
            Scanner lector = new Scanner(flujo);
           System.out.println("LOS DATOS DEL VEHICULO SOLICITADO SON:");        
            
         
           
        }
        catch(IOException ioe){
            System.out.println("Error al leer el fichero");
        }
        catch(Exception e){
            System.out.println("Error de lectura");
        }
    }
    
    
    
    
           
           

   
        public static void main(String[] args) {
            
            String matricula=null;
            String marca=null;
            String modelo=null;
            String dniTitular=null;
            String nombreTitular=null;
            boolean error=true;
            int opcion=0;
            
            Scanner teclado = new Scanner(System.in);
        
            
               
                

               
}}
