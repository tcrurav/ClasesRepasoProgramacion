/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumarfacil;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Pantalla extends JFrame implements ActionListener{
    final int WIDTH = 200;
    final int HEIGHT = 200;
    JLabel resultado;
    JTextField operando1;
    JTextField operando2;
    
    Pantalla(){
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rellenarPantallaConElementos();
        
        setVisible(true);
    }

    private void rellenarPantallaConElementos() {
        Container container = getContentPane();
               
        JButton boton = new JButton("púlsame");
        operando1 = new JTextField();
        operando2 = new JTextField();
        resultado = new JLabel("0");
        
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        container.add(operando1);
        container.add(operando2);
        container.add(boton);
        container.add(resultado);
        
        boton.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int valorOperando1 = Integer.valueOf(operando1.getText());
        int valorOperando2 = Integer.valueOf(operando2.getText());
        
        resultado.setText(String.valueOf(valorOperando1 + valorOperando2));
    }
    
    
}
