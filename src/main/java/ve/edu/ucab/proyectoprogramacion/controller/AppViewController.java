package ve.edu.ucab.proyectoprogramacion.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import ve.edu.ucab.proyectoprogramacion.model.Usuario;
import ve.edu.ucab.proyectoprogramacion.model.activos.Accion;
import ve.edu.ucab.proyectoprogramacion.model.activos.Activo;
import ve.edu.ucab.proyectoprogramacion.model.activos.Criptomoneda;

import java.util.List;

public class AppViewController {

    private UsuarioController usuarioController = new UsuarioController();

    //Los distintos ID que conectan el codigo con lo que se muestra en la pantalla
    @FXML
    private Pane perfilPane;

    @FXML
    private Pane fondearPane;

    @FXML
    private Pane catalogoActivoPane;

    @FXML
    private Pane operacionesPane;

    @FXML
    private Pane portafolioPane;

    @FXML
    private Pane registroPane;

    @FXML
    private Pane fondearcuentasecundario;

    @FXML
    private Pane operacionesComprar;

    @FXML
    private Pane operacionesVender;

    @FXML
    private Pane usuarioLogIn;

    @FXML
    private ComboBox comboSeleccionActivo;

    @FXML
    private ComboBox comboSeleccionActivoVenta;

    @FXML
    private TextField nuevosaldousuario;

    @FXML
    private TextField nombreUsuario;

    @FXML
    private TextField idUsuario;

    @FXML
    private TextField saldoInicialUsuario;

    @FXML
    private TextField contrasenaUsuario;

    @FXML
    private TextField nombreUsuarioLogIn;

    @FXML
    private TextField contrasenaUsuarioLogIn;

    @FXML
    private Label errornombre;

    @FXML
    private Label errorid;

    @FXML
    private Label errorsaldo;

    @FXML
    private Label errorsaldonumero;

    @FXML
    private Label errorcontrasena;

    @FXML
    private Label errornombreusuarioLogIn;

    @FXML
    private Label errorcontrasenaLogIn;

    @FXML
    private Label errorlistavaciaLogIn;

    @FXML
    private Label nombreUsuarioLogInexitoso;

    @FXML
    private Label contrasenaUsuarioLogInexitoso;

    @FXML
    private Label saldoInsuficienteCompra;

    // Muestra el panel principal de perfil
    @FXML
    protected void onSelectedPerfilItem() {
        this.apagarPaneles();
        System.out.println("le di click a perfil item");
        this.perfilPane.setVisible(true);
    }

    // Muestra el panel principal de fondearCuenta
    @FXML
    protected void onSelectedfondearCuentaItem() {
        this.apagarPaneles();
        System.out.println("le di click a fondear item");
        this.fondearPane.setVisible(true);
    }

    // Muestra el panel principal de catalogo
    @FXML
    protected void onSelectedcatalogoActivoItem() {
        this.apagarPaneles();
        System.out.println("le di click a catalogoActivo item");
        this.catalogoActivoPane.setVisible(true);
    }

    // Muestra el panel principal de operaciones
    @FXML
    protected void onSelectedoperacionesItem() {
        this.apagarPaneles();
        System.out.println("le di click a operaciones item");
        this.operacionesPane.setVisible(true);
    }

    //Muestra el panel de portafolio
    @FXML
    protected void onSelectedportafolioItem() {
        this.apagarPaneles();
        System.out.println("le di click a portafolio item");
        this.portafolioPane.setVisible(true);
    }

    //Imprime todos los activos
    @FXML
    protected void onSelectedcatalogoactivos(){
        ActivoSingleTone.getInstance().imprimirActivos();
    }

    //Lo que ocurre al darle a aceptar en registro de usuario
    @FXML
    protected void onSelectedaceptarItem(){

        // Limpiando los errores
        this.errornombre.setVisible(false);
        this.errorid.setVisible(false);
        this.errorsaldo.setVisible(false);
        this.errorsaldonumero.setVisible(false);
        this.errorcontrasena.setVisible(false);

        // Validando campos del formulario
        List<String> errors = this.usuarioController.validarDatosFormularioRegistro(this.nombreUsuario.getText(),
                this.idUsuario.getText(),
                this.saldoInicialUsuario.getText(), this.contrasenaUsuario.getText());

        //Pregunta si la lista de errores contiene alguno de los campos a rellenar, de ser asi imprime los textos rojos de error
        if (!errors.isEmpty()) {
            if (errors.contains("nombre"))
                this.errornombre.setVisible(true);
            if (errors.contains("id"))
                this.errorid.setVisible(true);
            if (errors.contains("saldo"))
                this.errorsaldo.setVisible(true);
            if (errors.contains("saldonumero"))
                this.errorsaldonumero.setVisible(true);
            if (errors.contains("contrasena"))
                this.errorcontrasena.setVisible(true);
            return;
        }

        // Creando objeto usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(this.nombreUsuario.getText());
        usuario.setId(this.idUsuario.getText());
        usuario.setSaldoInicial(Integer.parseInt(this.saldoInicialUsuario.getText()));
        usuario.setContrasena(this.contrasenaUsuario.getText());

        // Cargando el usuario en la lista
        UsuarioSingleTone.getInstance().add(usuario);

        // Limpio el formulario
        this.nombreUsuario.setText("");
        this.idUsuario.setText("");
        this.saldoInicialUsuario.setText("");
        this.contrasenaUsuario.setText("");

        // Vuelvo a la pantalla de perfil
        this.onSelectedPerfilItem();
    }

    //Lo que ocurre cuando le doy a mostrar lista de usuarios
    @FXML
    protected void onClickmostrarlistaButton(){
        UsuarioSingleTone.getInstance().showList();
    }

    //Prende la pantalla de registrar usuario
    @FXML
    protected void onSelectedregistroUsuarioItem(){
        this.apagarPaneles();
        this.registroPane.setVisible(true);
    }

    //Lo que ocurre al darle click al boton de fondear cuenta
    @FXML
    protected void onClickfondearcuenta(){
        this.apagarPaneles();
        //Accedemos al usuarioActual, de no haber se manda al panel de registrarse
        Usuario currentUser = UsuarioSingleTone.getInstance().getCurrentUser();
        if (currentUser == null){
            this.registroPane.setVisible(true);
            return;
        }
        this.fondearcuentasecundario.setVisible(true);
    }

    //Lo que ocurre al darle a aceptar el fondeo del usuarioActual
    @FXML
    protected void onSelectedaceptarItemfondearcuenta(){
        this.apagarPaneles();
        Usuario usuario = UsuarioSingleTone.getInstance().getCurrentUser();
        Integer nuevosaldo = Integer.parseInt(this.nuevosaldousuario.getText());
        usuario.setSaldoInicial(nuevosaldo + usuario.getSaldoInicial());
    }

    //Si se oprime el boton de iniciar sesion se muestra la pantalla para iniciar sesion
    @FXML
    protected void onSelectediniciarsesion(){
        this.apagarPaneles();
        this.usuarioLogIn.setVisible(true);
    }

    //Lo que ocurre al darle al boton aceptar en iniciar sesion
    @FXML
    protected void onClickaceptarloginCuenta(){

        //Limpiando los errores
        this.errorcontrasenaLogIn.setVisible(false);
        this.errornombreusuarioLogIn.setVisible(false);
        this.errorlistavaciaLogIn.setVisible(false);
        this.nombreUsuarioLogInexitoso.setVisible(false);
        this.contrasenaUsuarioLogInexitoso.setVisible(false);

        //Validamos campos del formulario
        List<String> errorsLogIn = this.usuarioController.validarDatosLogIn(
                this.nombreUsuarioLogIn.getText(), this.contrasenaUsuarioLogIn.getText());

        //Preguntarmos si la lista de errores contiene alguno de los campos de texto a rellenar
        if (!errorsLogIn.isEmpty()){
            if (errorsLogIn.contains("nombreUsuario"))
                this.errornombreusuarioLogIn.setVisible(true);
            if (errorsLogIn.contains("contrasenaUsuario"))
                this.errorcontrasenaLogIn.setVisible(true);
            return;
        }

        //Preguntamos si la lista de usuario esta vacia, en caso de ser asi indica que no hay usuarios y que debe iniciar sesion
        List<Usuario> listaUsuario = UsuarioSingleTone.getInstance().obtenerUsuarios();
        if (listaUsuario == null){
            this.errorlistavaciaLogIn.setVisible(true);
            return;
        }
        boolean founduser = false;
        for (Usuario tmp : listaUsuario){
            if (tmp.getNombre().equals(this.nombreUsuarioLogIn.getText())) {
                founduser = true;
                this.nombreUsuarioLogInexitoso.setVisible(true);

                if (tmp.getContrasena().equals(this.contrasenaUsuarioLogIn.getText())) {
                    this.contrasenaUsuarioLogInexitoso.setVisible(true);
                    this.apagarPaneles();
                    UsuarioSingleTone.getInstance().setCurrentUser(tmp);
                } else{
                    this.errorcontrasenaLogIn.setVisible(true);
                    return;
                }
            }
        }

        if(!founduser) {
            this.errornombreusuarioLogIn.setVisible(true);
            return;
        }

        this.perfilPane.setVisible(true);
    }

    //Boton para que cuando le de a vender en la pestana activos me lleve a la ventana donde me permite vender los activos del usuario que esta logeado
    @FXML
    protected void onSelectedvenderactivoItem(){
        this.apagarPaneles();

    }

    //Boton para que cuando le de a comprar en la pestana activos me lleve a la ventana donde me permita comprar los activos del usuario que esta logeado
    @FXML
    protected void onSelectedcompraractivoItem(){
        this.apagarPaneles();
        List<Activo> lista = ActivoSingleTone.getInstance().obtenerActivos();
        if(lista == null){
            this.operacionesComprar.setVisible(true);
            return;
        }
        this.comboSeleccionActivo.setItems(FXCollections.observableList(lista));
        this.operacionesComprar.setVisible(true);
    }


    //Lo que ocurre cuando le de al boton de comprar
    @FXML
    protected void onClickcomprarActivo(){

        //Apaga los paneles al ingresar
        this.apagarPaneles();
        this.saldoInsuficienteCompra.setVisible(false);
        Usuario usuarioActual = UsuarioSingleTone.getInstance().getCurrentUser();


        //Pregunta si en efecto hay un usuario logeado, sino lo lleva a que se registre
        if(usuarioActual == null){
            this.apagarPaneles();
            this.registroPane.setVisible(true);
            return;
        }

        //Obtenemos el valor de la seleccion del comboBox
        Object activo = (Object) this.comboSeleccionActivo.getValue();

        Activo seleccionActivo = (Activo) activo;
        if (usuarioActual.getSaldoInicial() >= seleccionActivo.getPrecioActual()){
            if(activo.getClass() == Accion.class) {
                // Esto ocurre si la seleccion de compra es una accion
                usuarioActual.addAccion((Accion) seleccionActivo);
                double nuevoSaldo = usuarioActual.getSaldoInicial() - seleccionActivo.getPrecioActual();
                usuarioActual.setSaldoInicial((int) nuevoSaldo);
            } else {
                // Esto ocurre si la seleccion de compra es una cripto, (PREGUNTAR A FRAN SI EL CASTEO DE DOUBLE A INT ES VALIDO POR EL CASTEO EXPLICITO QUE DECIA EN INTERNET)
                usuarioActual.addCripto((Criptomoneda) seleccionActivo);
                double nuevoSaldo = usuarioActual.getSaldoInicial() - seleccionActivo.getPrecioActual();
                usuarioActual.setSaldoInicial((int) nuevoSaldo);
            }
        }else{
            //Si no tiene saldo muestra un mensaje de saldo insuficiente
            this.saldoInsuficienteCompra.setVisible(true);
        }
    }

    //Funcion para apagar todos los paneles
    private void apagarPaneles(){
        this.fondearPane.setVisible(false);
        this.perfilPane.setVisible(false);
        this.catalogoActivoPane.setVisible(false);
        this.operacionesPane.setVisible(false);
        this.portafolioPane.setVisible(false);
        this.registroPane.setVisible(false);
        this.fondearcuentasecundario.setVisible(false);
        this.operacionesVender.setVisible(false);
        this.operacionesComprar.setVisible(false);
        this.usuarioLogIn.setVisible(false);
    }


}