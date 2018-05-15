/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import static java.awt.Label.CENTER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Profesor
 */
public class Pantalla extends JFrame implements MouseListener{
    Casilla[][] casillas = new Casilla[3][3];
    int turno = 1;

    public Pantalla() {
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contenedor = getContentPane();
        GridLayout gl = new GridLayout(3,3);
        contenedor.setLayout(gl);
        
        JLabel etiqueta;
        
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                casillas[x][y] = new Casilla();
                etiqueta = new JLabel(casillas[x][y].getEstado());

	        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
	        etiqueta.setBorder(border);

                etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
                etiqueta.setFont(new Font("TimesRoman",Font.PLAIN,100));
                
                etiqueta.addMouseListener(this);
                
                contenedor.add(etiqueta);
            }
        }
        
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("se mouseClicked güey");
        turno = turno == 0 ? 1 : 0;
        JLabel etiqueta = (JLabel) e.getComponent();
        etiqueta.setText(turno == 0 ? "X" : "O");
        etiqueta.removeMouseListener(etiqueta.getMouseListeners()[0]);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("se mousePressed güey");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("se mouseReleased güey");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("se mouseEntered güey");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("se mouseExited güey");
    }
    
    
}
