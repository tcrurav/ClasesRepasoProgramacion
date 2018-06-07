/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiloslocos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiburcio
 */
public class Multiplicador extends Thread{
    int numHilo;
    Semaphore s;

    public Multiplicador(int numHilo, Semaphore s) {
        this.numHilo = numHilo;
        this.s = s;
    }
    
    @Override
    public void run() {
        try {
            s.acquire();
            for (int i = 0; i < 50000000; i++) {
                System.out.println("El hilo " + numHilo + " va por el " + i);
                if(i%10 == 0 && i != 0){
                    s.release();
                    s.acquire();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Multiplicador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
