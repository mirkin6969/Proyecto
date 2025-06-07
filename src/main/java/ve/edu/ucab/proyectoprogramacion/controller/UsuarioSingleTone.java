package ve.edu.ucab.proyectoprogramacion.controller;

import ve.edu.ucab.proyectoprogramacion.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioSingleTone {

    private List<Usuario> usuarioList;

    private static UsuarioSingleTone instance;

    private Usuario currentUser;

    //Creamos SingleTone
    public static UsuarioSingleTone getInstance() {
        if (instance == null) {
            instance = new UsuarioSingleTone();

            Usuario usuario = new Usuario();
            usuario.setNombre("Mirko");
            usuario.setId("123");
            usuario.setSaldoInicial(400);
            usuario.setContrasena("pepo");

            instance.add(usuario);
        }

        return instance;
    }

    //Funcion para agregar usuarios a la lista
    public void add(Usuario usuario){
        if (usuarioList == null){
            usuarioList = new ArrayList<>();
        }
        usuarioList.add(usuario);
    }

    //Funcion para mostrar la lista
    public void showList(){
        if (this.usuarioList == null){
            System.out.println("Lista usuario vacia");
            return;
        }
        //Para imprimir la lista de usuarios en la terminal e ir viendo que se va cargando en memoria
        for (Usuario tmp: this.usuarioList) {
            System.out.println("Nombre: " + tmp.getNombre() + " - " + "ID: " + tmp.getId() + " - " + "Contrasena: " + tmp.getContrasena() + " - " + "Saldo Inicial: " + tmp.getSaldoInicial() + " - " + "Lista Acciones: " + tmp.getListaAcciones() + " - " + "Lista Criptomonedas: " + tmp.getListaCriptomonedas());
        }
    }

    //Devuelve la lista con los usuarios que tenga cargados
    public List<Usuario> obtenerUsuarios(){
        return usuarioList;
    }

    public void setCurrentUser(Usuario usuario){
        this.currentUser = usuario;
    }

    public Usuario getCurrentUser(){
        return this.currentUser;
    }
}
