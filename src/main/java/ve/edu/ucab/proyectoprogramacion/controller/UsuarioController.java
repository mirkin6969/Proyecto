package ve.edu.ucab.proyectoprogramacion.controller;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    public List<String> validarDatosFormularioRegistro(String nombre, String id, String saldoInicial){
        List<String> errors = new ArrayList<String>();
        if (nombre.isBlank()){
            System.out.println("Nombre es blanco");
            errors.add("nombre");
        }
        if(id.isBlank()){
            System.out.println("Id es blanco");
            errors.add("id");
        }
        if (saldoInicial.isBlank()){
            System.out.println("saldo es blanco");
            errors.add("saldo");
        } else {
            try {
                int saldo = Integer.parseInt(saldoInicial);

            } catch (Exception e) {
                System.out.println("saldo no es un entero");
                errors.add("saldonumero");
            }
        }

        return errors;
    }
}