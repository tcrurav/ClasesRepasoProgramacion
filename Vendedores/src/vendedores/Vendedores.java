/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendedores;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiburcio
 */
public class Vendedores {
    static TreeMap<String,String> vendoresTreeMap;
    static TreeSet<Vendedor> vendoresTreeSet;
    
    static final int OPCION_CREAR_OBJETO_EN_TREESET = 1;
    static final int OPCION_CREAR_TREEMAP = 2;
    static final int OPCION_SALIR = 3;
    
    public static void main(String[] args) {
        vendoresTreeMap = new TreeMap<>();
        vendoresTreeSet = new TreeSet<>();

        menu();
    }

    private static void menu() {
        int opcion;
        Scanner teclado = new Scanner(System.in);
        
        do {
            System.out.println("1. Crear Objeto Vendedor");
            System.out.println("2. Generar TreeMap");
            System.out.println("3. Salir");
            
            opcion = teclado.nextInt();
            
            switch(opcion){
                case OPCION_
            }
            
        } while(opcion != OPCION_SALIR);
    }
    
    void 
}
