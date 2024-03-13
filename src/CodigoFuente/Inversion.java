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
        financiarProyecto(cantidadEntrante);
    }

    /**
     * Funcion para poder financiar en un proyecto
     * @param cantidadEntrante como double
     * @return true si se ha podido financiar o false si no
     */
    public void financiarProyecto(double cantidadEntrante) {
        proyecto.setCantidadFinanciada(proyecto.getCantidadFinanciada() + cantidadEntrante);
        cantidadParticipada += cantidadEntrante;
        this.ultimaActualizacion = Fechas.fechaACadena(LocalDate.now());
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    //Métodos

    public String toString (){
        return RED+"Proyecto: " + proyecto.getNombre() + GREEN+"\nTipo: "+ proyecto.getTipo() + CYAN + "\nCantidad con la que ha participado: " + cantidadParticipada + "\nFecha de la primera inversión: " + fechaInicio + "\nFecha de la última inversión: " + ultimaActualizacion + RESET;
    }

    @Override
    public void aumentaInversion() {

    }

    @Override
    public void disminuyeInversion() {

    }
}
