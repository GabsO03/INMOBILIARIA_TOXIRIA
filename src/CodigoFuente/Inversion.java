package CodigoFuente;
import java.time.LocalDate;

import static Biblioteca.Colores.*;
import static Biblioteca.Lectura_De_Datos.*;

public class Inversion {
    //ATRIBUTOS
    private Inversor inversor;
    private Proyecto proyecto;
    private double cantidadParticipada;
    private LocalDate fechaInversion;

    //MÉTODOS
    public Inversion (Inversor inversor, Proyecto proyecto) {
        this.inversor = inversor;
        this.proyecto = proyecto;
    }

    public boolean financiarProyecto(double cantidadEntrante, LocalDate fechaInversion) {
        proyecto.setCantidadFinanciada(proyecto.getCantidadFinanciada() + cantidadEntrante);
        cantidadParticipada += cantidadEntrante;
        this.fechaInversion = fechaInversion;
        return inversor.paga(cantidadEntrante);
    }

    public Inversor getInversor() {
        return inversor;
    }

    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    //Métodos

    public String toString (){
        return RED+"Proyecto: " + proyecto.getNombre() + GREEN+"\nTipo: "+ proyecto.getTipo() + CYAN + "\nCantidad con la que ha participado: " + cantidadParticipada + RESET;
    }

}
