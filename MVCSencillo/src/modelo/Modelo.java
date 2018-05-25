/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author profesor
 */
public class Modelo {
    String nombre;
    boolean titula = false;

    public Modelo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTitula() {
        return titula;
    }

    public void setTitula(boolean titula) {
        this.titula = titula;
    }
    
    public void cambiarPromocion(){
        if(isTitula()){
            setTitula(false);
        } else {
            setTitula(true);
        } 
            
    }
}
