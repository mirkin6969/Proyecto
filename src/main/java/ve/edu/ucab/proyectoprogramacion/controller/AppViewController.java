package ve.edu.ucab.proyectoprogramacion.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import ve.edu.ucab.proyectoprogramacion.model.Usuario;

import java.util.List;

public class AppViewController {

    private UsuarioController usuarioController = new UsuarioController();

    @FXML
    private Label welcomeText;

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
    private Button registroButton;

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

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

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

    //@FXML
    //private void onSelectedregistroItem(){
     //   System.out.println("Estoy aqui");
    //}


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
        UsuarioSingleToneController.getInstance().add(usuario);

        // limpio el formulario
        this.nombreUsuario.setText("");
        this.idUsuario.setText("");
        this.saldoInicialUsuario.setText("");

        // vuelvo a la pantalla de perfil
        this.onSelectedPerfilItem();
    }

    @FXML
    protected void onClickmostrarlistaButton(){
        UsuarioSingleToneController.getInstance().showList();
    }

    @FXML
    protected void onSelectedregistroUsuarioItem(){
        this.apagarPaneles();
        this.registroPane.setVisible(true);
    }

    private void apagarPaneles(){
        this.fondearPane.setVisible(false);
        this.perfilPane.setVisible(false);
        this.catalogoActivoPane.setVisible(false);
        this.operacionesPane.setVisible(false);
        this.portafolioPane.setVisible(false);
        this.registroPane.setVisible(false);
    }


}