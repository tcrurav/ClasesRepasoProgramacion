/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendedores;

/**
 *
 * @author Tiburcio
 */
public class Vendedor {
    String nombre;
    String dni;
    String telefono;
    int ventas[];

    public Vendedor(String nombre, String dni, String telefono, int[] ventas) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int[] getVentas() {
        return ventas;
    }

    public void setVentas(int[] ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + ", ventas=" + ventas + '}';
    }
    
}
