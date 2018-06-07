/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiloslocos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Tiburcio
 */
public class HilosLocos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Multiplicador> multiplicadores = new ArrayList<>();
        Semaphore s = new Semaphore(1, true);
        
        for (int i = 0; i < 2; i++) {
            multiplicadores.add(new Multiplicador(i, s));
        }
        
        for(Multiplicador m : multiplicadores){
            m.start();
        }
    }
    
}
