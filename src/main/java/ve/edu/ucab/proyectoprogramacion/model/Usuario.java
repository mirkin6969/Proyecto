package ve.edu.ucab.proyectoprogramacion.model;

import ve.edu.ucab.proyectoprogramacion.model.activos.Activo;

import java.util.List;

public class Usuario {
    private String nombre;
    private String id;
    private int saldoInicial;
    private List<Activo> listaActivos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String toString(){
        return this.getNombre();
    }
}
