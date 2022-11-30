package uia.com.agenda.agendafxjson;

public class Evento extends InfoAgenda {
    private String fechaEvento="";


    private String tipo="";

    public Evento(int id, String fechaEvento, String name, String fecha, String email, String telefono) {
        super(id, name, fecha);
        this.fechaEvento=fechaEvento;
    }

    public Evento() {
    }

    public Evento(EventoDTO evtDTO)
    {
        super(evtDTO.getId(), evtDTO.getName(), evtDTO.getFecha());
        this.fechaEvento=evtDTO.getFechaEvento();
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
