/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherodirecto;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


import java.util.*;

public class FicheroDirecto {
    
    
    
    
    
    
    public static void consultarPelicula(int codPelicula){
        
        try{
            
            File fichero = new File("fichDir.txt");
            //Crea un flujo de e/s de acceso directo en modo lectura
            RandomAccessFile flujo = new RandomAccessFile(fichero,"rw");
            // Avanza desde el origen codpeliculas -1 registros
            flujo.seek((codPelicula-1)*40);
            
            System.out.println("INFORMACION DE LA PELICULA SOLICITADA");
            System.out.println("CODIGO: "+codPelicula);
            System.out.println("DIRECTOR: "+director);
            System.out.println("AÃ‘O: "+anio);
            System.out.println("UNIDADES: "+unidades);}
            else 
             System.out.println("la pelicula no esta dada de alta");   
            flujo.close();
            System.out.println();
            }
            catch(FileNotFoundException fnfe){
                System.out.println("No se ha encontrado el fichero");
            }
            catch(EOFException eofe){
                System.out.println("La pelÃ­cula consultada no existe");
            }
            catch(IOException ioe){
                System.out.println("Error de lectura");
            }
            catch(Exception e){
                System.out.println("Error de fichero");
            }
    }
    
    //Cada registro del fichero tiene 40 bytes
    public static void AltaDePelicula(int codPelicula,String director,int anio,int unidades){
        
        try{
            File fichero = new File("fichDir.txt");
            if(fichero.exists()==false){
                fichero.createNewFile();
            }
            RandomAccessFile flujo =new RandomAccessFile(fichero,"rw");
            //Avanza en el fichero hasta situarse al principio del registro correspondiente al codigo de pelicula
            // El registro tiene 40 bytes
            flujo.seek((codPelicula-1)*40);
            
             flujo.seek((codPelicula-1)*40);   
            
            flujo.writeInt(unidades);
            flujo.close();}
        }catch(IOException ioe){
            System.out.println("Error de acceso al fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    public static void BajaDePelicula(int codPelicula){
        
        try{File fichero = new File("fichDir.txt");
            RandomAccessFile flujo = new RandomAccessFile(fichero,"rw");
            flujo.seek((codPelicula-1)*40);
            codigo=flujo.readInt();
            
            
            System.out.println("INFORMACION DE LA PELICULA SOLICITADA");
            System.out.println("CODIGO: "+codPelicula);
            System.out.println("DIRECTOR: "+director);
            System.out.println("AÃ‘O: "+anio);
            System.out.println("UNIDADES: "+unidades);
            
            System.out.println("Desea dar de baja");
            opcion=teclas.nextLine(); 
            if(opcion.equalsIgnoreCase("s"))
            //ponemos de nuevo el puntero al principio del registro
            
            }}
            else 
            System.out.println("La pelicula no esta dad de alta");    
            
        } catch(FileNotFoundException fnfe){
            System.out.println("Archivo no encontrado");
        }
        catch(NullPointerException npe){
            System.out.println("La pelÃ­cula a eliminar no existe");
        }
        catch(IOException ioe){
            System.out.println("Error de acceso al fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    public static void modificarPelicula(int codPelicula){
       
           
           try{  
            File fichero = new File("fichDir.txt");
            RandomAccessFile flujo = new RandomAccessFile(fichero,"rw");
            flujo.seek((codPelicula-1)*40); 
            
           do
           {
               opcion=0;
           
            System.out.println("INFORMACION DE LA PELICULA SOLICITADA");
            System.out.println("CODIGO: "+codPelicula);
            System.out.println(" 1  DIRECTOR: "+director);
            System.out.println("2  AÃ‘O: "+anio);
            System.out.println("3 UNIDADES: "+unidades);
            System.out.println("4 TERMINAR");
            System.out.println();
         opcion=teclado.nextInt();
                while(opcion<0||opcion>4){
                    System.out.println("Seleccione una opciÃ³n correcta");
                }   
                
               switch(opcion){
                
                case 1:{
                    System.out.println("Intruduzca director");
                    director=tecla.nextLine();
                    break;
                    }
                case 2:{
                    System.out.println("Intruduzca año");
                    anio=teclado.nextInt();
                    break;
                    }
                case 3:{
                    System.out.println("Intruduzca cantidad");
                    unidades=teclado.nextInt();
                    break;
                    }
                   
                case 4:{
                    System.out.println("Salir"); 
                } } 
               }while(opcion!=4);
                                
                // situamos el puntero para grabar         
            flujo.seek((codPelicula-1)*40); 
            
            }
          else 
             System.out.println("la pelicula no esta dada de alta");   
              
        }
        catch(IOException ioe){
            System.out.println("Error de acceso al fichero");
            
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    
    public static void listarPeliculas(){
        
             
          try{
           File fichero = new File("fichDir.txt");
           
            RandomAccessFile flujo = new RandomAccessFile(fichero,"r");
           //ponemos el puntero al principio del fichero
            flujo.seek(0);
            // 
            System.out.println("PELICULA ");
            System.out.println("CODIGO: "+codPelicula);
            System.out.println("DIRECTOR: "+director);
            System.out.println("AÃ‘O: "+anio);
            System.out.println("UNIDADES: "+unidades);
            }
            }   
            
            }catch(EOFException e){
            finfichero=true;
            }catch(IOException ioe){
            System.out.println("Error de acceso al fichero");
             
        }catch(Exception e){
            System.out.println("Error de fichero");
        
        }
    }

    public static void main(String[] args) {
        
        int codPelicula=0;
        String director=null;
        int anio=0;
        int unidades=0;
        boolean error=true;
        int opcion=0;
        Scanner teclado = new Scanner(System.in);
        do{
            try{
                error=true;
                System.out.println("1.- ALTAS");
                System.out.println("2.- BAJAS");
                System.out.println("3.- CONSULTAS");
                System.out.println("4.- MODIFICACIONES");
                System.out.println("5.- LISTADOS POR PANTALLA");
                System.out.println("6.- INICIALIZAR EL FICHERO");
                System.out.println("7.- SALIR DEL PROGRAMA");
                System.out.println();
                System.out.print("SELECCIONE UNA OPCIÃ“N DEL MENÃš: ");
                opcion=teclado.nextInt();
                if(opcion<0||opcion>7){
                    System.out.println("Seleccione una opciÃ³n correcta");
                }
            }
            
                    FicheroDirecto.AltaDePelicula(codPelicula,director,anio,unidades);
                break;
                }
                    
                case 2:{
                    do{
                        try
                            FicheroDirecto.BajaDePelicula(codPelicula);
                            
                        }
                        catch(InputMismatchException ime){
                            System.out.println("Debe introducir un nÃºmero entero");
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        finally{
                            teclado.nextLine();
                        }
                    }
                    while(error);
                    error=true;
                    break;
                }
                    
                case 3:{
                    do{
                        try{
                            error=true;
                            S
                            FicheroDirecto.consultarPelicula(codPelicula);
                            error=false;
                        }
                        catch(InputMismatchException ime){
                            System.out.println("Debe introducir un nÃºmero entero");
                            error=true;
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                        }
                        finally{
                            teclado.nextLine();
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
                            
                            modificarPelicula(codPelicula);
                            error=false;
                        }
                        catch(InputMismatchException ime){
                            System.out.println("Debe introducir dÃ­gitos numÃ©ricos");
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            error=true;
                        }
                        finally{
                            teclado.nextLine();
                        }
                    }
                    while(error);
                    error=true;
                    break;
                }
                    
                case 5:{
                    FicheroDirecto.listarPeliculas();
                    error=true;
                    break;
                    
                }
                   case 6:{
                    FicheroDirecto.crearfichero();
                    error=true;
                    break;
                    
                } 
                case 7:{
                    error=false;
                    break;
                }
            }
        }
        while(error);
        System.out.println("Fin del programa");
    }
        public static void crearfichero(){
       // Crea un fichero vacio con los cóodigos de pelicula con valor cero
            int i;
            String director="bcccccccccccccccccccbbbnnnnnnnnnnnnnnnnnn";
            director=director.substring(0,14);
            
                try{
            File fichero = new File("fichDir.txt");
            fichero.delete();
            
                fichero.createNewFile();
            
            //Crea un flujo de E/S para un fichero de acceso directo, en modo rw para grabar
            RandomAccessFile flujo =new RandomAccessFile(fichero,"rw");
           for(i=1;i<=1000;i++) 
           {flujo.writeInt(0);
            flujo.writeChars(director);
            flujo.writeInt(0);
            flujo.writeInt(0);}
           
            flujo.close();
        }catch(IOException ioe){
            System.out.println("Error de acceso al fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
    }
    }

