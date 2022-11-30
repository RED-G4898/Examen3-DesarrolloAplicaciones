package uia.com.agenda.agendafxjson;

public class EventoDTO extends InfoAgenda {
    private String tipo;
    private String fechaEvento;

    public EventoDTO(String tipo, String name, String fechaEvento, String fecha) {
        super(-1, name, fecha);
        this.tipo = tipo;
        this.fechaEvento = fechaEvento;
    }

    public EventoDTO() {
    }

    public EventoDTO(InfoAgenda infoAgenda)
    {
        this.setName(infoAgenda.getName());
        this.setFecha(infoAgenda.getFecha());
    }


    public String getFechaEvento() {
        return fechaEvento;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String text) {
        this.tipo = text;

    }

    public void setFechaEvento(String text) {
        this.fechaEvento = text;

    }

    public String getname() {
        return super.getName();
    }

    public void setname(String text) {
        super.setName(text);
    }
}
