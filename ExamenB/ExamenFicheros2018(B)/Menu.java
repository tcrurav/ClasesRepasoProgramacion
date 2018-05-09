


package clientes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Menu {

    public static void main(String[] args) {
        
        String nif=null;
        String nombre=null;
        String telefono=null;
        String direccion=null;
        double deuda=0;
        boolean error=true;
        int opcion;
        Scanner teclado = new Scanner(System.in);
        
        do{
            try{
                error=true;
                System.out.println();
                System.out.println("1.- AÑADIR CLIENTE");
                System.out.println("2.- LISTAR CLIENTES");
                System.out.println("3.- BUSCAR CLIENTES");
                System.out.println("4.- BORRAR CLIENTE");
                System.out.println("5.- BORRAR FICHERO");
                System.out.println("6.- SALIR DE LA APLICACION");
                System.out.println();
                System.out.print("SELECCIONE UNA OPCION DEL MENU: ");
                opcion = teclado.nextInt();
                System.out.println();
            }
            catch(InputMismatchException ime){
                System.out.println("El tipo de dato introducido no es correcto");
                error = true;
                continue;
            }
            catch(Exception e){
                System.out.println("Error de teclado");
                error=true;
                continue;
            }
            finally{
                teclado.nextLine();
            }
            
            switch(opcion){
                
                case 1:{
                    do{
                        try{
                            System.out.print("Introduzca el NIF del cliente: ");
                            nif = teclado.nextLine();
                            comprobarStringVacio(nif);
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                    do{
                        try{
                            error=true;
                            System.out.print("Introduzca el nombre del cliente: ");
                            nombre=teclado.nextLine();
                            comprobarStringVacio(nombre);
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                    do{
                        try{
                            error=true;
                            System.out.print("Introduzca el teléfono del cliente: ");
                            telefono=teclado.nextLine();
                            comprobarStringVacio(telefono);
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                    do{
                        try{
                            error=true;
                            System.out.print("Introduzca la dirección del cliente: ");
                            direccion=teclado.nextLine();
                            comprobarStringVacio(direccion);
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                    do{
                        try{
                            error=true;
                            System.out.print("Introduzca la deuda del cliente: ");
                            deuda=teclado.nextDouble();
                            error=false;
                        }
                        catch(InputMismatchException ime){
                            System.out.println("El tipo de dato introducido no es correcto");
                            error=true;
                            continue;
                        }
                        catch(Exception e){
                            System.out.println("Error de teclado");
                            error=true;
                            continue;
                        }
                    }
                    while(error);
                    
                        Clientes cliente = new Clientes (nif,nombre,telefono,direccion,deuda);
                        anadirCliente(cliente);
                        error=true;
                        break;
                }
                    
                case 2:{
                    listarClientes();
                    error=true;
                    break;
                }
                    
                case 3:{
                    do{
                        try{
                            error=true;
                            String buscarDni;
                            System.out.print("Introduzca el DNI del cliente a buscar: ");
                            buscarDni=teclado.nextLine();
                            comprobarStringVacio(buscarDni);
                            buscarClientes(buscarDni);
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }   
                    while(error);
                    error=true;
                    break;
                }
                    
                case 4:{
                    do{
                        try{
                            error=true;
                            String borrarNif;
                            System.out.print("Introduzca el DNI del cliente a buscar: ");
                            borrarNif=teclado.nextLine();
                            comprobarStringVacio(borrarNif);
                            borrarCliente(borrarNif);
                            error=false;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    while(error);
                    error=true; 
                    break;
                }
                    
                case 5:{
                    System.out.print("¿Seguro que desea borrar el fichero? (s para borrar u otra tecla para anular): ");
                    String borrado=teclado.nextLine();
                    if(borrado.equals("s")){
                        borrarFichero();
                    }
                    else{
                        System.out.println("La acción ha sido cancelada");
                    }
                    break;
                }
                    
                case 6:{
                    error=false;
                    break;
                }
            }           
        }
        while(error);
        System.out.println("Fin del programa");
    }
  public static void  anadirCliente(Clientes cliente){
        try{ 
            File fichero = new File("cli.dat");
            if(fichero.exists()==false){
                fichero.createNewFile();
            }
           
             FileOutputStream flujo = new FileOutputStream(fichero,true);
            if(tieneRegistros())
            {               
           ObjectOutputStream escritor = new MiObjectOutputStream(flujo);
            
            
           else
            {    
            ObjectOutputStream escritor = new ObjectOutputStream(flujo);
            
            
            }
        }
        catch(IOException ioe){
            System.out.println("Error de fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    public static void listarClientes(){
        try{
            File fichero = new File("cli.dat");
            FileInputStream flujo = new FileInputStream(fichero);
            ObjectInputStream lector = new ObjectInputStream(flujo);
            boolean finalFichero=false;
            Clientes cliente;
            System.out.println("LISTADO DE CLIENTES");
            System.out.println("===================");
             cliente =(Clientes)lector.readObject();
            while(cliente!=null){
                      //
            cliente =(Clientes)lector.readObject();}
            lector.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println("Fichero no encontrado");
        }
        catch(IOException ioe){
            System.out.println("Error de fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    public static void buscarClientes(String buscarNif){
        boolean encontrado=false;
        try{
            File fichero = new File("cli.dat");
            FileInputStream flujo = new FileInputStream(fichero);
            ObjectInputStream lector = new ObjectInputStream(flujo);
            boolean finalFichero=false;
            Clientes cliente;
            System.out.println("DATOS DEL CLIENTE BUSCADO");
            System.out.println("=========================");
            while(!encontrado){
               
                }
            }
            lector.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println("Fichero no encontrado");
        }
        catch(IOException ioe){
            System.out.println("Error de fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
        if(!encontrado){
            System.out.println("El cliente buscado no existe");
            }
    }
    
    public static void borrarCliente(String borrarNif){
        File ficheroEntrada=null;
        File ficheroSalida=null;
        FileInputStream flujoEntrada=null;
        FileOutputStream flujoSalida=null;
        ObjectInputStream lector=null;
        ObjectOutputStream escritor=null;
        boolean finalFichero=false;
        do{
        try{
            ficheroEntrada = new File("cli.dat");
            ficheroSalida = new File("cli2.dat");
            flujoEntrada = new FileInputStream(ficheroEntrada);
            flujoSalida = new FileOutputStream(ficheroSalida);
            lector = new ObjectInputStream(flujoEntrada);
            escritor = new ObjectOutputStream(flujoSalida);
           
            Clientes cliente;
            while(!finalFichero){
                
            }
       // }catch(EOFException eofe ){
              //          finalFichero=true;
        }catch(FileNotFoundException fnfe){
            System.out.println("Fichero no encontrado");
        
        
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
        }while(!finalFichero);
        try{
            lector.close();
            escritor.close();
            ficheroEntrada.delete();
            ficheroSalida.renameTo(ficheroEntrada);
        }
        catch(IOException ioe){
            System.out.println("Error de fichero");
        }
    }
    
    public static void borrarFichero(){
        File fichero = new File("cli.dat");
        fichero.delete();
        System.out.println("El fichero ha sido borrado");
    }
  
    public static void comprobarStringVacio(String cadena)throws Exception{
        if(cadena.equals("")){
            throw new Exception("Debe introducir un dato");
        }
    }
     private static boolean tieneRegistros(){
       boolean tiene = false ;
        
         try {
            
         File fichero = new File("cli.dat");
            FileInputStream flujo = new FileInputStream(fichero);
            ObjectInputStream lector = new ObjectInputStream(flujo);
            
         
        Clientes cliente = null ;
        

            // Leer el objeto del fichero
            cliente = (Clientes) lector.readObject();

            if (cliente != null)
                tiene = true ;
            flujo.close();
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println( "Error: " + e.getMessage() ) ;
        } catch (Exception ex) {
            System.out.println( "Capturada excepción en tieneRegistros()" ) ;}
        finally {
          // fiCliLec.close();
          //  fluent.close();
       }

        return(tiene);
    }

}  

