/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen61;

/**
 *
 * @author Profesor
 */
public class Nomina {
    private String numCuenta;
    private String titular;
    private float nomina;

    public Nomina(String numCuenta, String titular, float nomina) {
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.nomina = nomina;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getNomina() {
        return nomina;
    }

    public void setNomina(float nomina) {
        this.nomina = nomina;
    }
    
    
}
