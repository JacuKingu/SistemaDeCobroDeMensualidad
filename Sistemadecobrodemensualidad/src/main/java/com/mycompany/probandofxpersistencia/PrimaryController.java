package com.mycompany.probandofxpersistencia;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.stage.Stage;



public class PrimaryController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtDNI;
    
    
    private Stage dialogStage;
    
    @FXML
    private void agregar() throws IOException {
        String dni = txtDNI.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String url = "jdbc:mysql://localhost:3306/dbmensualidad";
        String usuario = "root";
        String contraseña = "";
        String alertMessage = "";
        //conexion 
        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
                String sql = "INSERT INTO personas (dni, nombre, apellido) VALUES (?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, dni);
                    statement.setString(2, nombre);
                    statement.setString(3, apellido);

                    
                    int filasAfectadas = statement.executeUpdate();
                    if (filasAfectadas > 0) {
                        alertMessage += "Persona Agregada Correctamente\n";
                    } else {
                        alertMessage += "No se pudo agregar los datos\n";
                    }
                }
        } catch (SQLException e) {
            alertMessage += "Error al establecer la conexión o ejecutar la consulta";
        }
        if (alertMessage.length() != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Informe proceso");
            alert.setHeaderText("Alerta");
            alert.setContentText(alertMessage);
            alert.showAndWait();
        }
    }
}
