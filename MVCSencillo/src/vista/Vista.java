/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author profesor
 */
public class Vista extends JFrame {
    public final String NO_TITULA = "No titula";
    public final String TITULA = "Titula";
    public final String PROMOCIONAR = "Promocionar";
    public final String REPETIR = "Repetir";
    public JButton jButtonTitula;
    public JLabel jLabelTitula;
    
    public Vista() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contenedor = getContentPane();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        jLabelTitula = new JLabel(NO_TITULA);
        contenedor.add(jLabelTitula);
        jButtonTitula = new JButton(PROMOCIONAR);
        contenedor.add(jButtonTitula);
    }
    
}
