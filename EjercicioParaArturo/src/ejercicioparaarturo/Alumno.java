/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparaarturo;

/**
 *
 * @author Profesor
 */
public class Alumno {
    int numMatricula;
    String nombre;
    float notaMedia;

    public Alumno(int numMatricula, String nombre, float notaMedia) {
        this.numMatricula = numMatricula;
        this.nombre = nombre;
        this.notaMedia = notaMedia;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }
    
    
}
