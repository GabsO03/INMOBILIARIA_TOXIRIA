package CodigoFuente;
import java.time.LocalDate;
import Biblioteca.Fechas;

import static Biblioteca.Colores.*;

public class Inversion implements Inversible {
    //ATRIBUTOS
    private Proyecto proyecto;
    private double cantidadParticipada;
    private String fechaInicio;
    private String ultimaActualizacion;
    //MÉTODOS
    public Inversion (Proyecto proyecto, double cantidadEntrante) {
        this.proyecto = proyecto;
        cantidadParticipada = 0;
        fechaInicio = Fechas.fechaACadena(LocalDate.now());
        aumentaInversion(cantidadEntrante);
    }
    public Proyecto getProyecto() {
        return proyecto;
    }

    //Métodos
    public String toString (){
        return RED+"Proyecto: " + proyecto.getNombre() + GREEN+"\nTipo: "+ proyecto.getTipo() + CYAN + "\nCantidad con la que ha participado: " + cantidadParticipada + "\nFecha de la primera inversión: " + fechaInicio + "\nFecha de la última inversión: " + ultimaActualizacion + RESET;
    }

    /**
     * Funcion para aumentar la inversion realizada anteriormente
     * @param cantidadEntrante como double
     */
    @Override
    public void aumentaInversion(double cantidadEntrante) {
        proyecto.setCantidadFinanciada(proyecto.getCantidadFinanciada() + cantidadEntrante);
        cantidadParticipada += cantidadEntrante;
        this.ultimaActualizacion = Fechas.fechaACadena(LocalDate.now());
    }

}
