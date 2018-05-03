/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Profesor
 */
public class Pantalla extends JFrame implements ActionListener{
    ArrayList<JButton> botones = new ArrayList<>();
    String titulosBotones[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
                                "*", "/", "+", "-", "=", "DEL"};
    JTextField jTextField;

    public Pantalla() {
        setTitle("Calculadora");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        
        BoxLayout boxLayout = new BoxLayout(container,BoxLayout.Y_AXIS);
        container.setLayout(boxLayout);
        
        GridLayout gridLayout = new GridLayout(4, 4);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(gridLayout);
        
        jTextField = new JTextField();
        jTextField.setEditable(false);
        
        for (int i = 0; i < titulosBotones.length; i++) {
            System.out.println(i);
            System.out.println(titulosBotones[i]);
            botones.add(new JButton(titulosBotones[i]));
            jPanel.add(botones.get(i));
            System.out.println("se guardó el botón");
            botones.get(i).addActionListener(this);
        }
        
        container.add(jTextField);
        container.add(jPanel);
        
        setVisible(true);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        Component componente = (Component) e.getSource();
        
        System.out.println("botón pulsado: " + ((JButton)componente).getText());
        
        jTextField.setText(jTextField.getText() + ((JButton)componente).getText());
    }   
}
