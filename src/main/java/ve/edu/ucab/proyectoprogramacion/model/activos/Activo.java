package ve.edu.ucab.proyectoprogramacion.model.activos;

import java.util.List;

public abstract class Activo {
    //Definimos los Atributos que tienen en comun las acciones y las criptos
    private String nombre;
    private String simbolo;
    private double precioActual;

    //Constructor
    public Activo(String nombre, String simbolo, double precioActual) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.precioActual = precioActual;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Precio: $%.2f", nombre, simbolo, precioActual);
    }
}
