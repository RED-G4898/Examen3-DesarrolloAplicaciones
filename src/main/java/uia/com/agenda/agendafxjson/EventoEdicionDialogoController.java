package uia.com.agenda.agendafxjson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EventoEdicionDialogoController {
    @FXML
    public TextField tipoEventoField;
    @FXML
    public TextField nameEventoField;
    @FXML
    public TextField fechaEventoField;
    @FXML
    public TextField fechaEventoEventoField;
    @FXML
    public Button okEventoBoton;

    private Stage dialogStage;
    private EventoDTO eventoActualDTO;
    private boolean okClicked = false;

    @FXML
    public void handleEventoOk(ActionEvent actionEvent) {
        if (isInputValid())
        {
            this.eventoActualDTO = new EventoDTO();
            this.eventoActualDTO.setTipo(tipoEventoField.getText());
            this.eventoActualDTO.setName(nameEventoField.getText());
            this.eventoActualDTO.setFecha(fechaEventoField.getText());
            this.eventoActualDTO.setFechaEvento(fechaEventoEventoField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (tipoEventoField.getText() == null || tipoEventoField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (nameEventoField.getText() == null || nameEventoField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (fechaEventoField.getText() == null || fechaEventoField.getText().length() == 0) {
            errorMessage += "No valid fecha!\n";
        }

        if (fechaEventoEventoField.getText() == null || fechaEventoEventoField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }



    /**
     * Sets the eventoActualDTO to be edited in the dialog.
     *
     * @param eventoActualDTO
     */
    public void setEvento(EventoDTO eventoActualDTO)
    {
        this.eventoActualDTO = eventoActualDTO;

        tipoEventoField.setText(eventoActualDTO.getTipo());
        nameEventoField.setText(eventoActualDTO.getName());
        fechaEventoField.setText(eventoActualDTO.getFecha());
        fechaEventoEventoField.setText(eventoActualDTO.getFechaEvento());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked()
    {
        return okClicked;
    }

    public void setEventos(ContactoDTO contactoActual)
    {

    }

    public EventoDTO getEventoActualDTO() {
        return eventoActualDTO;
    }

    public void setEventoActualDTO(EventoDTO eventoActualDTO) {
        this.eventoActualDTO = eventoActualDTO;
    }

    public void limpiaFX() {
        this.fechaEventoField.setText("");
        this.tipoEventoField.setText("");
        this.nameEventoField.setText("");
        this.fechaEventoEventoField.setText("");
    }
}
