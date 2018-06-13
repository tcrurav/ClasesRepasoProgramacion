/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notas;

/**
 *
 * @author Tiburcio
 */
public class Alumno {
    String nombre;
    int notaPrimeraEvaluacion;
    int notaSegundaEvaluacion;
    int notaTerceraEvaluacion;

    public Alumno(String nombre, int notaPrimeraEvaluacion, int notaSegundaEvaluacion, int notaTerceraEvaluacion) {
        this.nombre = nombre;
        this.notaPrimeraEvaluacion = notaPrimeraEvaluacion;
        this.notaSegundaEvaluacion = notaSegundaEvaluacion;
        this.notaTerceraEvaluacion = notaTerceraEvaluacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNotaPrimeraEvaluacion() {
        return notaPrimeraEvaluacion;
    }

    public void setNotaPrimeraEvaluacion(int notaPrimeraEvaluacion) {
        this.notaPrimeraEvaluacion = notaPrimeraEvaluacion;
    }

    public int getNotaSegundaEvaluacion() {
        return notaSegundaEvaluacion;
    }

    public void setNotaSegundaEvaluacion(int notaSegundaEvaluacion) {
        this.notaSegundaEvaluacion = notaSegundaEvaluacion;
    }

    public int getNotaTerceraEvaluacion() {
        return notaTerceraEvaluacion;
    }

    public void setNotaTerceraEvaluacion(int notaTerceraEvaluacion) {
        this.notaTerceraEvaluacion = notaTerceraEvaluacion;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", notaPrimeraEvaluacion=" + notaPrimeraEvaluacion + ", notaSegundaEvaluacion=" + notaSegundaEvaluacion + ", notaTerceraEvaluacion=" + notaTerceraEvaluacion + '}';
    } 
}
