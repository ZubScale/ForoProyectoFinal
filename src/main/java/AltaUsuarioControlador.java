import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class AltaUsuarioControlador {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextArea descripcionField;

    @FXML
    private ComboBox<Genero> generoComboBox;

    @FXML
    private TextField emailField;

    @FXML
    private DatePicker fechaNacimientoPicker;

    @FXML
    public void initialize() {
        // Llenar el ComboBox de género
        generoComboBox.getItems().setAll(Genero.values());
    }

    @FXML
    private void registrarUsuario() {
        try {
            String nombre = nombreField.getText();
            String usuario = usuarioField.getText();
            String password = passwordField.getText();
            String descripcion = descripcionField.getText();
            Genero genero = generoComboBox.getValue();
            String email = emailField.getText();
            LocalDate fechaNacimiento = fechaNacimientoPicker.getValue();

            // Crear el nuevo usuario
            Usuario nuevoUsuario = new Usuario(nombre, password, descripcion, genero, email, fechaNacimiento, usuario);

            // Mostrar mensaje de éxito
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro Exitoso");
            alert.setHeaderText(null);
            alert.setContentText("El usuario se ha registrado correctamente.");
            alert.showAndWait();

            // Limpiar campos
            limpiarCampos();
        } catch (IllegalArgumentException e) {
            // Mostrar mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Registro");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void limpiarCampos() {
        nombreField.clear();
        usuarioField.clear();
        passwordField.clear();
        descripcionField.clear();
        generoComboBox.getSelectionModel().clearSelection();
        emailField.clear();
        fechaNacimientoPicker.setValue(null);
    }
}