/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1practica6_1;

/**
 *
 * @author Juan
 */
import java.io.EOFException;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Ejercicio1Practica6_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
      int NumCuentaSec=0;
        int NumCuentaDirec=0;
        String TitularSecu=" ";
        float Nomina=0;
        float saldo=0;
         String TitularDirec=" ";
        String Direccion="";
      try
      {
      File ficherosecu = new File("Nominas.txt");
            FileReader flujosecu = new FileReader(ficherosecu);
            Scanner lector = new Scanner(flujosecu);   
        File ficherodirec = new File("Cuentas.txt");
           
            RandomAccessFile flujodric =new RandomAccessFile(ficherodirec,"rw");
            
            while(lector.hasNext())
            {
                TitularDirec="";
                Direccion="";
                            NumCuentaSec=Integer.parseInt(lector.nextLine());
                           TitularSecu=lector.nextLine();
                           Nomina=Float.parseFloat(lector.nextLine());
                flujodric.seek((NumCuentaSec -1)*52);
                // Registro fichero dierecto 52 bytes 4 (numcuenta) 10x2 titular 10x2 direccion 8 saldo
                NumCuentaDirec = flujodric.readInt();
                if( NumCuentaDirec!= NumCuentaSec)
                        System.out.println(" Cuenta no actualizada");
                else
                {
                 
                 for(int i=0;i<10;i++){
                TitularDirec+=flujodric.readChar();
                               
                }
                 for(int i=0;i<10;i++){
                Direccion+=flujodric.readChar();
                               
                }
                 
                 saldo=flujodric.readFloat();
                }
                saldo+=Nomina;
                flujodric.seek((NumCuentaSec -1)*52); 
                flujodric.writeInt(NumCuentaSec);
               flujodric.writeChars( TitularDirec);
               flujodric.writeChars(Direccion);
               flujodric.writeFloat(saldo); 
            } 
            lector.close();
            flujodric.close();
          }catch(IOException ioe){
            System.out.println("Error de acceso al fichero");
        }
        catch(Exception e){
            System.out.println("Error de fichero");
        }
        
    }
    
}  
        
      

