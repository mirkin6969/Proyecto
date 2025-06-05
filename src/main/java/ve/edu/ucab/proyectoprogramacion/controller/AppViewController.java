package ve.edu.ucab.proyectoprogramacion.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import ve.edu.ucab.proyectoprogramacion.model.Usuario;
import ve.edu.ucab.proyectoprogramacion.model.activos.Activo;

import java.util.List;

public class AppViewController {

    private UsuarioController usuarioController = new UsuarioController();

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
    private ComboBox combolistausuarios;

    @FXML
    private TextField nuevosaldousuario;

    @FXML
    private TextField nombreUsuario;

    @FXML
    private TextField idUsuario;

    @FXML
    private TextField saldoInicialUsuario;

    @FXML
    private Label errornombre;

    @FXML
    private Label errorid;

    @FXML
    private Label errorsaldo;

    @FXML
    private Label errorsaldonumero;

    // onSelectedPerfilItem
    @FXML
    protected void onSelectedPerfilItem() {
        this.apagarPaneles();
        System.out.println("le di click a perfil item");
        this.perfilPane.setVisible(true);
    }

    @FXML
    protected void onSelectedfondearCuentaItem() {
        this.apagarPaneles();
        System.out.println("le di click a fondear item");
        this.fondearPane.setVisible(true);
    }

    @FXML
    protected void onSelectedcatalogoActivoItem() {
        this.apagarPaneles();
        System.out.println("le di click a catalogoActivo item");
        this.catalogoActivoPane.setVisible(true);
    }

    @FXML
    protected void onSelectedoperacionesItem() {
        this.apagarPaneles();
        System.out.println("le di click a operaciones item");
        this.operacionesPane.setVisible(true);
    }

    @FXML
    protected void onSelectedportafolioItem() {
        this.apagarPaneles();
        System.out.println("le di click a portafolio item");
        this.portafolioPane.setVisible(true);
    }

    @FXML
    protected void onSelectedcatalogoactivos(){
        ActivoSingleTone.getInstance().imprimirActivos();
    }

    @FXML
    protected void onSelectedaceptarItem(){

        // limpiando los errores
        this.errornombre.setVisible(false);
        this.errorid.setVisible(false);
        this.errorsaldo.setVisible(false);
        this.errorsaldonumero.setVisible(false);


        // validando campos del formulario
        List<String> errors = this.usuarioController.validarDatosFormularioRegistro(this.nombreUsuario.getText(),
                this.idUsuario.getText(),
                this.saldoInicialUsuario.getText());

        if (!errors.isEmpty()) {
            if (errors.contains("nombre"))
                this.errornombre.setVisible(true);
            if (errors.contains("id"))
                this.errorid.setVisible(true);
            if (errors.contains("saldo"))
                this.errorsaldo.setVisible(true);
            if (errors.contains("saldonumero"))
                this.errorsaldonumero.setVisible(true);
            return;
        }

        // creando objeto usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(this.nombreUsuario.getText());
        usuario.setId(this.idUsuario.getText());
        usuario.setSaldoInicial(Integer.parseInt(this.saldoInicialUsuario.getText()));

        // catgando el usuario en la lista
        UsuarioSingleTone.getInstance().add(usuario);

        // limpio el formulario
        this.nombreUsuario.setText("");
        this.idUsuario.setText("");
        this.saldoInicialUsuario.setText("");

        // vuelvo a la pantalla de perfil
        this.onSelectedPerfilItem();
    }

    @FXML
    protected void onClickmostrarlistaButton(){
        UsuarioSingleTone.getInstance().showList();
    }

    @FXML
    protected void onSelectedregistroUsuarioItem(){
        this.apagarPaneles();
        this.registroPane.setVisible(true);
    }

    @FXML
    protected void onClickfondearcuenta(){
        this.apagarPaneles();
        List<Usuario> lista= UsuarioSingleTone.getInstance().obtenerUsuarios();
        if (lista == null){
            this.fondearcuentasecundario.setVisible(true);
            return;
        }
        for(Usuario tmp : lista){
            this.combolistausuarios.setItems(FXCollections.observableList(lista));
        }
        this.fondearcuentasecundario.setVisible(true);
    }

    @FXML
    protected void onSelectedaceptarItemfondearcuenta(){
        this.apagarPaneles();
        Usuario usuario = (Usuario)this.combolistausuarios.getValue();
        Integer nuevosaldo = Integer.parseInt(this.nuevosaldousuario.getText());
        usuario.setSaldoInicial(nuevosaldo + usuario.getSaldoInicial());
    }

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

    @FXML
    protected void onSelectedvenderactivoItem(){
        this.apagarPaneles();

    }

    @FXML
    protected void onClickcomprarActivo(){

    }

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
    }


}