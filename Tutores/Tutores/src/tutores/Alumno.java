/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutores;

/**
 *
 * @author Profesor
 */
public class Alumno {
    
    String nombre;
    int idTutor;

    public Alumno(String nombre, int idTutor) {
        this.nombre = nombre;
        this.idTutor = idTutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }
    
}
