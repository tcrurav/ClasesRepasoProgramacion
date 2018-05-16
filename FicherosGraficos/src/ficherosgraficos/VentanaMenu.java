/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosgraficos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Profesor
 */
public class VentanaMenu extends JFrame implements ActionListener{

    public VentanaMenu() {
        setSize(500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Container contenedor = getContentPane();
        contenedor.setLayout(null);
        
        JButton jButtonCrearFichero = new JButton("Crear Fichero");
        jButtonCrearFichero.setBounds(128, 258, 200, 20);
        
        contenedor.add(jButtonCrearFichero);
        
        jButtonCrearFichero.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Pantalla();
    }
    
}
