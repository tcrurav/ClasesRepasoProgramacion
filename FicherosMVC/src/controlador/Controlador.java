/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author Tiburcio
 */
public class Controlador implements ActionListener{
    Vista vista;
    Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void inicializarVista(){          
        vista.jButtonCrear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String botonPulsado = ((JButton) e.getSource()).getName();
        
        switch(botonPulsado){
            case Vista.BOTON_CREAR:
                modelo.setNombreFichero(vista.jTextFieldNombre.getText());
                modelo.crearFichero();
                break;
        }
    }
}
