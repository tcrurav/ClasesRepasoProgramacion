/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coches;

import java.io.Serializable;

/**
 *
 * @author Profesor
 */
public class Coche implements Serializable {
    private static final long serialVersionUID = 1234L;
    
    String marca;
    String modelo;
    String matricula;

    public Coche(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "marca: " + marca + ", modelo: " + modelo + ", matricula: " + matricula;
    }
    
    
}
