/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tiburcio
 */
public class Vista extends JFrame{
    public final static String BOTON_CREAR = "BOTON_CREAR";
    public JTextField jTextFieldNombre;
    public JButton jButtonCrear;
    
    public Vista() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contenedor = getContentPane();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        
        JPanel jPanelDatos = new JPanel();
        jPanelDatos.setLayout(null);

        JLabel jLabelNombre = new JLabel("Nombre del fichero:");
        jLabelNombre.setBounds(10, 10, 200, 30);
        jTextFieldNombre = new JTextField();
        jTextFieldNombre.setBounds(10, 50, 200, 30);
        
        jPanelDatos.add(jLabelNombre);
        jPanelDatos.add(jTextFieldNombre);
        
        JPanel jPanelBotonera = new JPanel();
        jPanelBotonera.setLayout(new FlowLayout(FlowLayout.CENTER));
        jButtonCrear = new JButton("Crear");
        jButtonCrear.setName(BOTON_CREAR);
        jPanelBotonera.add(jButtonCrear);
        
        contenedor.add(jPanelDatos);
        contenedor.add(jPanelBotonera);
        
    }
    
    public void inicilizarVista(){
        
    }
}
