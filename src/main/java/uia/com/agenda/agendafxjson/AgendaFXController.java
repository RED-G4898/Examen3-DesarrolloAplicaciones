package uia.com.agenda.agendafxjson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgendaFXController implements Initializable {

    @FXML private TableView<ContactoDTO> table;
    @FXML private TableColumn<ContactoDTO, String> tipo;
    @FXML private TableColumn<ContactoDTO, String> name;
    @FXML private TableColumn<ContactoDTO, String> fechaRecordatorio;
    @FXML private TableColumn<ContactoDTO, String> fecha;
    @FXML
    private Label tipoLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label fechaLabel;
    @FXML
    private Label fechaRecordatorioLabel;

    @FXML
    private Label fechaEventoLabel;

    // Reference to the main application.
    private AgendaFXApplication mainApp;

    public ObservableList<ContactoDTO> list;

    public ObservableList<RecordatorioDTO> listRecordatorios = FXCollections.observableArrayList();

    public ObservableList<EventoDTO> listEventos = FXCollections.observableArrayList();

    @FXML
    private TableColumn fechaRecordatorioCol;
    @FXML
    private TableColumn fechaEventoCol;
    @FXML
    private Label fechaLabelRecordatorio;
    @FXML
    private Label fechaLabelEvento;
    @FXML
    private Button nuevoBoton;
    @FXML
    private TableColumn fechaRecordatorioRecordatorioCol;
    @FXML
    private TableColumn fechaEventoEventoCol;
    @FXML
    private Button nuevoBotonRecordatorio;
    @FXML
    private Button nuevoBotonEvento;
    @FXML
    private TableView<RecordatorioDTO> tableRecordatorio;
    @FXML
    private TableView tableEvento;
    @FXML
    private TableColumn nameRecordatorioCol;
    @FXML
    private TableColumn nameEventoCol;
    @FXML
    private Label nameLabelRecordatorio;
    @FXML
    private Label nameLabelEvento;
    @FXML
    private Label fechaRecordatorioLabelRecordatorio;
    @FXML
    private Label fechaEventoLabelEvento;
    @FXML
    private TableColumn tipoRecordatorioCol;
    @FXML
    private TableColumn tipoEventoCol;
    @FXML
    private Label tipoLabelRecordatorio;
    @FXML
    private Label tipoLabelEvento;
    private Agenda miAgenda;
    @FXML
    private Label nombreContactoActual;
    @FXML
    private Label nombreRecordatorioActual;
    @FXML
    private Label nombreEventoActual;
    private ContactoDTO contactoActualDTO;
    private RecordatorioDTO recordatorioActualDTO;
    private EventoDTO eventoActualDTO;
    private ContactoEdicionDialogoController controllerContacto = null;
    private RecordatorioEdicionDialogoController  controllerRecordatorio = null;
    private EventoEdicionDialogoController controllerEvento = null;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        name.setCellValueFactory(new PropertyValueFactory<ContactoDTO, String>("name"));
        fecha.setCellValueFactory(new PropertyValueFactory<ContactoDTO, String>("fecha"));
        table.setItems(list);

        // Clear person details.
        showContactoDetails(null);

        // Listen for selection changes and show the person details when changed.
        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showContactoDetails((ContactoDTO) newValue));

        tipoRecordatorioCol.setCellValueFactory(new PropertyValueFactory<RecordatorioDTO, String>("tipo"));
        nameRecordatorioCol.setCellValueFactory(new PropertyValueFactory<RecordatorioDTO, String>("name"));
        fechaRecordatorioRecordatorioCol.setCellValueFactory(new PropertyValueFactory<RecordatorioDTO, String>("fechaRecordatorio"));
        fechaRecordatorioCol.setCellValueFactory(new PropertyValueFactory<RecordatorioDTO, String>("fecha"));
        tableRecordatorio.setItems(listRecordatorios);

        // Clear person details.
        showRecordatorioDetails(null);

        // Listen for selection changes and show the person details when changed.
        tableRecordatorio.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue2) -> showRecordatorioDetails((RecordatorioDTO) newValue2));

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(AgendaFXApplication mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        table.setItems(list);
        tableRecordatorio.setItems(listRecordatorios);
    }




    private void showContactoDetails(ContactoDTO contactoDTO)
    {
        this.contactoActualDTO = contactoDTO;
        if (contactoDTO != null) {
            // Fill the labels with info from the contactoDTO object.
            nameLabel.setText(this.contactoActualDTO.getname());
            fechaLabel.setText(this.contactoActualDTO.getFecha());
            this.mainApp.setContactoActual(contactoDTO);
        } else {
            // ContactoDTO is null, remove all the text.
            tipoLabel.setText("");
            nameLabel.setText("");
            fechaRecordatorioLabel.setText("");
            fechaLabel.setText("");
        }
    }




    private void showRecordatorioDetails(RecordatorioDTO recordatorioDTO) {
        if (recordatorioDTO != null) {
            // Fill the labels with info from the recordatorioDTO object.
            nombreContactoActual.setText(this.contactoActualDTO.getname());
            tipoLabelRecordatorio.setText(recordatorioDTO.getTipo());
            nameLabelRecordatorio.setText(recordatorioDTO.getName());
            fechaRecordatorioLabelRecordatorio.setText(recordatorioDTO.getFechaRecordatorio());
            fechaLabelRecordatorio.setText(recordatorioDTO.getFecha());
            this.mainApp.setRecordatorioActual(recordatorioDTO);
        } else {
            // Recordatorio is null, remove all the text.
            tipoLabelRecordatorio.setText("");
            nameLabelRecordatorio.setText("");
            fechaRecordatorioLabelRecordatorio.setText("");
            fechaLabelRecordatorio.setText("");
        }
    }

    private void showEventoDetails(EventoDTO evento) {
        if (evento != null) {
            // Fill the labels with info from the recordatorio object.
            nombreRecordatorioActual.setText(this.recordatorioActualDTO.getname());
            tipoLabelEvento.setText(evento.getTipo());
            nameLabelEvento.setText(evento.getName());
            fechaEventoLabelEvento.setText(evento.getFechaEvento());
            fechaLabelEvento.setText(evento.getFecha());
            this.mainApp.setEventoActual(evento);
        } else {
            // Recordatorio is null, remove all the text.
            tipoLabelEvento.setText("");
            nameLabelEvento.setText("");
            fechaEventoLabelEvento.setText("");
            fechaLabelEvento.setText("");
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewContacto() throws IOException {
        this.contactoActualDTO = new ContactoDTO();
        boolean okClicked = mainApp.showContactoEdicionDialogo();
        if (okClicked)
        {
            list.add(this.controllerContacto.getContactoActualDTO());
            this.miAgenda.agrega(this.controllerContacto.getContactoActualDTO());
            this.serializa();
            this.controllerContacto.limpiaFX();
            //this.contactoActualDTO.limpia();
        }
    }

    private void serializa() throws IOException {
        this.miAgenda.serializa();
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @Deprecated
    private void handleEditContacto() {
        ContactoDTO selectedContactoDTO = table.getSelectionModel().getSelectedItem();

        if (selectedContactoDTO != null) {
            boolean okClicked = mainApp.showContactoEdicionDialogo();
            if (okClicked) {
                showContactoDetails(selectedContactoDTO);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No ContactoDTO Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }


    @FXML
    public void handleNewRecordatorio(ActionEvent actionEvent) throws IOException {
        this.recordatorioActualDTO = new RecordatorioDTO();
        boolean okClicked = mainApp.showRecordatorioEdicionDialogo();
        if (okClicked) {
            this.contactoActualDTO.getItemsDTO().add(this.controllerRecordatorio.getRecordatorioActualDTO());
            this.miAgenda.agregaRecordatorio(this.contactoActualDTO.getName(), this.controllerRecordatorio.getRecordatorioActualDTO());
            this.serializa();
            this.controllerRecordatorio.limpiaFX();
            listRecordatorios.add(this.controllerRecordatorio.getRecordatorioActualDTO());
        }
    }

    @FXML
    public void handleEditRecordatorio(ActionEvent actionEvent) throws IOException {
        RecordatorioDTO selectedRecordatorioDTO = tableRecordatorio.getSelectionModel().getSelectedItem();

        if (selectedRecordatorioDTO != null) {
            boolean okClicked = mainApp.showRecordatorioEdicionDialogo();
            if (okClicked) {
                showRecordatorioDetails(selectedRecordatorioDTO);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Recordatorio Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleNewEvento(ActionEvent actionEvent) throws IOException {
        this.eventoActualDTO = new EventoDTO();
        boolean okClicked = mainApp.showEventoEdicionDialogo();
        if (okClicked) {
            this.recordatorioActualDTO.getItemsDTO().add(this.controllerEvento.getEventoActualDTO());
            this.miAgenda.agregaEvento(this.recordatorioActualDTO.getName(), this.controllerEvento.getEventoActualDTO());
            this.serializa();
            this.controllerEvento.limpiaFX();
            listEventos.add(this.controllerEvento.getEventoActualDTO());
        }
    }

    public void setAgenda(Agenda agenda)
    {
        miAgenda = agenda;
        list = FXCollections.observableArrayList();

        for(int i=0; i<miAgenda.getItems().size(); i++)
        {
            ContactoDTO contacto = new ContactoDTO(miAgenda.getItems().get(i));
            list.add(contacto);
            contactoActualDTO= contacto;
        }
    }

    public void setControllerRecordatorio(RecordatorioEdicionDialogoController controllerRecordatorio)
    {
        this.controllerRecordatorio=controllerRecordatorio;
    }

    public void setControllerContacto(ContactoEdicionDialogoController controllerContacto)
    {
        this.controllerContacto=controllerContacto;
    }

    public void setControllerEvento(EventoEdicionDialogoController controllerEvento)
    {
        this.controllerEvento=controllerEvento;
    }

    public void setContactoActual(ContactoDTO contactoDTO)
    {
        this.contactoActualDTO=contactoDTO;

        for(int i=0; i<this.list.size(); i++)
        {
            if(this.contactoActualDTO == this.list.get(i))
            {
                for (int j = 0; j < miAgenda.getItems().size(); j++)
                {
                    if(miAgenda.getItems().get(j).getName().contentEquals(contactoActualDTO.getName()))
                    {
                        nombreContactoActual.setText(contactoActualDTO.getName());
                        this.listRecordatorios = contactoActualDTO.getItemsDTO();
                        tableRecordatorio.setItems(listRecordatorios);
                        break;
                    }
                }
                break;
            }
        }
    }

    // Correct recordatorioActual() method
    public void setRecordatorioActual(RecordatorioDTO recordatorioDTO)
    {
        this.recordatorioActualDTO=recordatorioDTO;

        for(int i=0; i<this.listRecordatorios.size(); i++)
        {
            if(this.recordatorioActualDTO == this.listRecordatorios.get(i))
            {
                for (int j = 0; j < miAgenda.getItems().size(); j++)
                {
                    if(miAgenda.getItems().get(j).getName().contentEquals(contactoActualDTO.getName()))
                    {
                        for (int k = 0; k < miAgenda.getItems().get(j).getItems().size(); k++)
                        {
                            if(miAgenda.getItems().get(j).getItems().get(k).getName().contentEquals(recordatorioActualDTO.getName()))
                            {
                                nombreRecordatorioActual.setText(recordatorioActualDTO.getName());
                                this.listEventos = recordatorioActualDTO.getItemsDTO();
                                tableEvento.setItems(listEventos);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    public void setEventoActual(EventoDTO eventoDTO)
    {
        this.eventoActualDTO=eventoDTO;

        for(int i=0; i<this.listEventos.size(); i++)
        {
            if(this.eventoActualDTO == this.listEventos.get(i))
            {
                for (int j = 0; j < miAgenda.getItems().size(); j++)
                {
                    if(miAgenda.getItems().get(j).getName().contentEquals(eventoActualDTO.getName()))
                    {
                        nombreEventoActual.setText(eventoActualDTO.getName());
                        break;
                    }
                }
                break;
            }
        }
    }
}