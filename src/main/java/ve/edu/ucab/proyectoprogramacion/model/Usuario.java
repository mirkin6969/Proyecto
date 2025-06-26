package ve.edu.ucab.proyectoprogramacion.model;

import ve.edu.ucab.proyectoprogramacion.controller.UsuarioSingleTone;
import ve.edu.ucab.proyectoprogramacion.model.activos.Accion;
import ve.edu.ucab.proyectoprogramacion.model.activos.Activo;
import ve.edu.ucab.proyectoprogramacion.model.activos.Criptomoneda;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    //Atributos que deberia tener cada usuario (Tenemos una lista de activos ya que ahi almacenaremos todos los activos del usuario)
    private String nombre;
    private String id;
    private int saldoInicial;
    private String contrasena;
    private List<Activo> listaCriptomonedas;
    private List<Activo> listaAcciones;

    public Usuario() {
        listaCriptomonedas=new ArrayList<>();
        listaAcciones = new ArrayList<>();
    }

    //Getters y Setters
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Activo> getListaCriptomonedas() {
        return listaCriptomonedas;
    }

    public void setListaCriptomonedas(List<Activo> listaCriptomonedas) {
        this.listaCriptomonedas = listaCriptomonedas;
    }

    public List<Activo> getListaAcciones() {
        return listaAcciones;
    }

    public void setListaAcciones(List<Activo> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }

    //Funcion para agregar al usuario una accion
    public void addAccion(Accion accion){
        if (listaAcciones == null){
            listaAcciones = new ArrayList<>();
        }
        listaAcciones.add(accion);
    }

    //Funcion para agregar al usuario una criptomoneda
    public void addCripto(Criptomoneda criptomoneda){
        if (listaCriptomonedas == null){
            listaCriptomonedas = new ArrayList<>();
        }
        listaCriptomonedas.add(criptomoneda);
    }

    //Funcion para quitar acciones de la lista de acciones
    public boolean quitarAccion(Accion accion) {
        if (listaAcciones != null && listaAcciones.contains(accion)) {
            listaAcciones.remove(accion);
            return true;
        }
        return false;
    }

    //Funcion para quitar criptomonedas de la lista de criptomonedas
    public boolean quitarCripto(Criptomoneda criptomoneda) {
        if (listaCriptomonedas != null && listaCriptomonedas.contains(criptomoneda)) {
            listaCriptomonedas.remove(criptomoneda);
            return true;
        }
        return false;
    }

    public boolean tieneAccion(Accion accion) {
        return listaAcciones != null && listaAcciones.contains(accion);
    }

    public boolean tieneCripto(Criptomoneda criptomoneda) {
        return listaCriptomonedas != null && listaCriptomonedas.contains(criptomoneda);
    }

    public String toString(){
        return this.getNombre();
    }
}
