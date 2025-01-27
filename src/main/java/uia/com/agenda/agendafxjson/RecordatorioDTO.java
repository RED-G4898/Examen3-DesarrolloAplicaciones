package uia.com.agenda.agendafxjson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class RecordatorioDTO extends InfoAgenda{

    private String tipo;
    private String fechaRecordatorio;

    private ObservableList<EventoDTO> itemsDTO = FXCollections.observableArrayList();


    public RecordatorioDTO(String tipo, String name, String fechaRecordatorio, String fecha) {
        super(-1, name, fecha);
        this.tipo = tipo;
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public RecordatorioDTO() {
    }

    public RecordatorioDTO(InfoAgenda infoAgenda)
    {
        this.setName(infoAgenda.getName());
        this.setFecha(infoAgenda.getFecha());
    }


    public String getFechaRecordatorio() {
        return fechaRecordatorio;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String text) {
        this.tipo = text;

    }

    public void setFechaRecordatorio(String text) {
        this.fechaRecordatorio = text;

    }

    public String getname() {
        return super.getName();
    }

    public void setname(String text) {
        super.setName(text);
    }

    public ObservableList<EventoDTO> getItemsDTO() {
        return itemsDTO;
    }
}
