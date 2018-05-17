/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botoneratarikefren;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Profesor
 */
public class Pantalla extends JFrame {
    
    JPanel jPanelCentro;
    JFrame laPantalla;
    public Pantalla() {
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        laPantalla = this;
        
        Container contenedor = getContentPane();
        BorderLayout bl = new BorderLayout();
        
        contenedor.setLayout(bl);
        
        JPanel jPanelSur = new JPanel();
        JButton jButtonCrear = new JButton("Crear");
        jButtonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanelCentro.setBackground(Color.blue);
                JOptionPane.showMessageDialog(laPantalla, "Hola caracola");
            }
        });
        JButton jButtonSalir = new JButton("Salir");
        jPanelSur.setLayout(new FlowLayout());
        jPanelSur.add(jButtonCrear);
        jPanelSur.add(jButtonSalir);
        
        JPanel jPanelIzquierda = new JPanel();
        JButton jButtonBorrar = new JButton("Borrar");
        JButton jButtonModificar = new JButton("Modificar");
        jPanelIzquierda.setLayout(new BoxLayout(jPanelIzquierda, BoxLayout.Y_AXIS));
        jPanelIzquierda.add(jButtonBorrar);
        jPanelIzquierda.add(jButtonModificar);
        
        jPanelIzquierda.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        jPanelCentro = new JPanel();
        jPanelCentro.setBackground(Color.red);
        
        contenedor.add(jPanelSur, BorderLayout.SOUTH);
        contenedor.add(jPanelIzquierda, BorderLayout.WEST);
        contenedor.add(jPanelCentro, BorderLayout.CENTER);
        
        setVisible(true);
    }

    
}
