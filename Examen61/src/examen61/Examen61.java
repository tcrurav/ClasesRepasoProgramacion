/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen61;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class Examen61 {
    static final String CUENTAS_CORRIENTES = "cuentasCorrientes.txt";
    static ArrayList<CuentaCorriente> cuentasCorrientes = new ArrayList<>();
    
    static final String NOMINAS = "nominas.txt";
    static ArrayList<Nomina> nominas = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cuentasCorrientes.add(new CuentaCorriente("ES21-1234-1234-1234-1234", 
                "Tiburcio Cruz Ravelo", "c/las afortunadas, nº3", 100));
        cuentasCorrientes.add(new CuentaCorriente("ES22-1234-1234-1234-1234", 
                "Alberto Belilles", "c/tenerife, nº3", 10));
        cuentasCorrientes.add(new CuentaCorriente("ES23-1234-1234-1234-1234", 
                "Adán", "c/lanzarote, nº34", 1000));
        
        nominas.add(new Nomina("ES21-1234-1234-1234-1234", "Tiburcio Cruz Ravelo", 1000));
        nominas.add(new Nomina("ES22-1234-1234-1234-1234", "Alberto Belilles", 3000));
        nominas.add(new Nomina("ES23-1234-1234-1234-1234", "Adán", 10));
        
        crearFicherosConDatosCCC();
        crearFicherosConDatosNominas();
        
        actualizarFicheroCCC();
    }
    
    static void actualizarFicheroCCC(){
        try {
            FileReader fr = new FileReader(NOMINAS);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) !=  null){
                String linea[] = line.split(":");
                String numCuenta = linea[0];
                float nomina = Float.parseFloat(linea[2]);
                insertarEnFicheroCCC(numCuenta, nomina);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void crearFicherosConDatosCCC(){
        RandomAccessFile raf = null;
        try {
            
            raf = new RandomAccessFile(CUENTAS_CORRIENTES, "rw");
            
            for(CuentaCorriente ccc : cuentasCorrientes){
                raf.writeChars(ajustarA14Caracteres(ccc.getNumCuenta()));
                raf.writeChars(ajustarA14Caracteres(ccc.getTitular()));
                raf.writeChars(ajustarA14Caracteres(ccc.getDireccion()));
                raf.writeFloat(ccc.getSaldo());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    static void crearFicherosConDatosNominas(){
        FileWriter fw = null;
        try {
            
            fw = new FileWriter(NOMINAS);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(Nomina nomina : nominas){
                bw.write(nomina.getNumCuenta());
                bw.write(":");
                bw.write(nomina.getTitular());
                bw.write(":");
                bw.write(String.valueOf(nomina.getNomina()));
                bw.newLine();
            }
            
            bw.flush();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    static String ajustarA14Caracteres(String texto){
        String textoADevolver = texto + "              ";
        textoADevolver = textoADevolver.substring(0, 14);
        return textoADevolver;
    }

    private static void insertarEnFicheroCCC(String numCuenta, float nomina) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(CUENTAS_CORRIENTES, "rw");
            int tamanoTotal = 88;
            int tamanoString = 28;
            byte bufferTotal[] = new byte[tamanoTotal];
            byte bufferString[] = new byte[tamanoString];
            int inicioDelRegistro = 0;
            String numCuentaLeida;
            float saldoLeido;
            boolean cccEncontrada = false;
            while(raf.read(bufferString) != -1){
                numCuentaLeida = new String(bufferString, StandardCharsets.UTF_8);
                System.out.println("numCuentaLeida: " + numCuentaLeida);
                raf.seek(tamanoString * 3 + inicioDelRegistro);
                saldoLeido = raf.readFloat();
                System.out.println("saldoLeido: " + saldoLeido);
                
                if(numCuentaLeida.equals(numCuenta)){
                    float nuevoSaldo = nomina + saldoLeido;
//                    actualizarSaldo(tamanoString * 3 + inicioDelRegistro, nuevoSaldo);
                    raf.seek(tamanoString * 3 + inicioDelRegistro);
                    raf.writeFloat(nuevoSaldo);
                    cccEncontrada = true;
                    break;
                }
                
                inicioDelRegistro += tamanoTotal;
            }
            
            if(!cccEncontrada){
                System.out.println("La CC " + numCuenta + " no ha sido encontrada.");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(Examen61.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
