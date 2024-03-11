package CodigoFuente;
import java.time.LocalDate;

import static Biblioteca.Colores.*;
import static Biblioteca.Lectura_De_Datos.*;

public class Inversion {
    //ATRIBUTOS
    private Proyecto proyecto;
    private double cantidadParticipada;
    private LocalDate fechaInversion;
    //MÉTODOS
    public Inversion (Proyecto proyecto, double cantidadEntrante) {
        this.proyecto = proyecto;
        cantidadParticipada = 0;
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
        this.fechaInversion = LocalDate.now();
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    //Métodos

    public String toString (){
        return RED+"Proyecto: " + proyecto.getNombre() + GREEN+"\nTipo: "+ proyecto.getTipo() + CYAN + "\nCantidad con la que ha participado: " + cantidadParticipada + "\nFecha de la inversión: " + fechaInversion + RESET;
    }

}
