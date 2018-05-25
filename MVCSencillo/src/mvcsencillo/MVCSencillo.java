/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcsencillo;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author profesor
 */
public class MVCSencillo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);
        
        controlador.inicializarVista();
    }
    
}
