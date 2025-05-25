module ve.edu.ucab.proyectoprogramacion {
    requires javafx.controls;
    requires javafx.fxml;


    opens ve.edu.ucab.proyectoprogramacion to javafx.fxml;
    exports ve.edu.ucab.proyectoprogramacion;
    exports ve.edu.ucab.proyectoprogramacion.controller;
    opens ve.edu.ucab.proyectoprogramacion.controller to javafx.fxml;
}