/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author profesor
 */
public class Controlador implements ActionListener {
    Vista vista;
    Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void inicializarVista(){
        vista.setVisible(true);
        vista.jButtonTitula.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        modelo.cambiarPromocion();
        if(modelo.isTitula()){
            vista.jLabelTitula.setText(vista.TITULA);
            vista.jButtonTitula.setText(vista.REPETIR);
        } else {
            vista.jLabelTitula.setText(vista.NO_TITULA);
            vista.jButtonTitula.setText(vista.PROMOCIONAR);
        }
    }
    
}
