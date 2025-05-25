package ve.edu.ucab.proyectoprogramacion.controller;

import ve.edu.ucab.proyectoprogramacion.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioSingleToneController {

    private List<Usuario> usuarioList;

    private static UsuarioSingleToneController instance;

    public static UsuarioSingleToneController getInstance() {
        if (instance == null) {
            instance = new UsuarioSingleToneController();
        }
        return instance;
    }

    public void add(Usuario usuario){
        if (usuarioList == null){
            usuarioList = new ArrayList<>();
        }
        usuarioList.add(usuario);
    }

    public void showList(){
        if (this.usuarioList == null){
            System.out.println("Lista usuario vacia");
            return;
        }

        for (Usuario tmp: this.usuarioList) {
            System.out.println(tmp.getId() + " - " + tmp.getNombre() + " - " + tmp.getSaldoInicial());
        }
    }
}
