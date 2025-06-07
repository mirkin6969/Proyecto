package ve.edu.ucab.proyectoprogramacion.controller;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    //Funcion para validar los datos que se tengan en el registro de usuario, esto devuelve una lista de Strings en la que almacenaremos los errores del formulario en caso de que hayan
    public List<String> validarDatosFormularioRegistro(String nombre, String id, String saldoInicial, String contrasena){
        List<String> errors = new ArrayList<String>();
        if (nombre.isBlank()){
            System.out.println("Nombre es blanco");
            errors.add("nombre");
        }
        if(id.isBlank()){
            System.out.println("Id es blanco");
            errors.add("id");
        }
        if(contrasena.isBlank()){
            System.out.println("Contrasena es blanco");
            errors.add("contrasena");
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

    //Funcion para validar los datos que se tengan en el LogIn, esto devuelve una lista de Strings en la que almacenaremos los errores del formulario en caso de que hayan
    public List<String> validarDatosLogIn(String nombreUsuario, String contrasenaUsuario){
        List<String> errorsLogIn = new ArrayList<>();
        if (nombreUsuario.isBlank()){
            System.out.println("Nombre es blanco");
            errorsLogIn.add("nombreUsuario");
        }
        if (contrasenaUsuario.isBlank()){
            System.out.println("Contrasena es blanco");
            errorsLogIn.add("contrasenaUsuario");
        }
        return errorsLogIn;
    }
}