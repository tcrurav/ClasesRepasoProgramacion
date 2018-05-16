/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosgraficos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Profesor
 */
public class Pantalla extends JFrame implements ActionListener{
    final String BOTON_VOLVER_ATRAS = "BOTON_VOLVER_ATRAS";
    final String BOTON_CREAR_FICHERO = "BOTON_CREAR_FICHERO";
    final String BOTON_CREAR_FICHERO_DESDE_MENU = "BOTON_CREAR_FICHERO_DESDE_MENU";
    
    Container contenedor;
    JPanel jPanelMenu;
    JPanel jPanelAlta;
    JTextField jTextFieldNombreFichero;
    JTextArea jTextAreaContenidoFichero;
    
    public Pantalla() {
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        contenedor = getContentPane();
        contenedor.setLayout(null);
        
        cargarMenu();
        cargarFormularioAlta();
        
        setVisible(true);
    }
    
    void cargarMenu(){
        jPanelMenu = new JPanel();
        jPanelMenu.setBounds(0, 0, 500, 500);
        jPanelMenu.setLayout(null);
        JButton jButtonCrearFicheroDesdeMenu = new JButton("Crear Fichero");
        jButtonCrearFicheroDesdeMenu.setBounds(128, 258, 200, 20);
        jButtonCrearFicheroDesdeMenu.setName(BOTON_CREAR_FICHERO_DESDE_MENU);
        
        jPanelMenu.add(jButtonCrearFicheroDesdeMenu);
        
        contenedor.add(jPanelMenu);
        
        jButtonCrearFicheroDesdeMenu.addActionListener(this);
    }
    
    void cargarFormularioAlta(){
        jPanelAlta = new JPanel();
        jPanelAlta.setBounds(0, 0, 500, 500);
        jPanelAlta.setLayout(null);
        
        JLabel jLabelNombreFichero = new JLabel("Nombre del fichero:");
        jLabelNombreFichero.setBounds(5, 28, 127, 20);
        jTextFieldNombreFichero = new JTextField();
        jTextFieldNombreFichero.setBounds(128, 28, 200, 20);
        
        JLabel jLabelNombreContenidoFichero = new JLabel("Contenido del fichero:");
        jLabelNombreContenidoFichero.setBounds(5, 53, 127, 20);
        jTextAreaContenidoFichero = new JTextArea();
        jTextAreaContenidoFichero.setBounds(128, 53, 200, 200);
        
        JButton jButtonCrearFichero = new JButton("Crear Fichero");
        jButtonCrearFichero.setBounds(128, 258, 200, 20);
        jButtonCrearFichero.setName(BOTON_CREAR_FICHERO);
        
        JButton jButtonVolverAtras = new JButton("Volver Atrás");
        jButtonVolverAtras.setBounds(128, 283, 200, 20);
        jButtonVolverAtras.setName(BOTON_VOLVER_ATRAS);
        
        jPanelAlta.add(jLabelNombreFichero);
        jPanelAlta.add(jTextFieldNombreFichero);
        jPanelAlta.add(jLabelNombreContenidoFichero);
        jPanelAlta.add(jTextAreaContenidoFichero);
        jPanelAlta.add(jButtonCrearFichero);
        jPanelAlta.add(jButtonVolverAtras);
        
        contenedor.add(jPanelAlta);
        jPanelAlta.setVisible(false);
        
        jButtonCrearFichero.addActionListener(this);
        jButtonVolverAtras.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreBotonPulsado = ((JButton) e.getSource()).getName();
        
        switch(nombreBotonPulsado){
            case BOTON_CREAR_FICHERO_DESDE_MENU:
                jPanelMenu.setVisible(false);
                jPanelAlta.setVisible(true);
                break;
            case BOTON_CREAR_FICHERO:
                FicherosGraficos.crearFichero(jTextFieldNombreFichero.getText(), 
                                      jTextAreaContenidoFichero.getText());
                jPanelAlta.setVisible(false);
                jPanelMenu.setVisible(true);
                break;
            case BOTON_VOLVER_ATRAS:
                jPanelAlta.setVisible(false);
                jPanelMenu.setVisible(true);
                break; 
        }
        
    }
    
}
