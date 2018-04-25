package ejercicio2practica6_1;
import java.io.*;

public class Alumnos implements Serializable{
    
    String dni;
    String nombre;
    float[] notas= new float[3];
   
    
    public Alumnos(String dni,String nombre,float[] notas){
        this.dni=dni;
        this.nombre=nombre;
        this.notas=notas;
    }
    
}