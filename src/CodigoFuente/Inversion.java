package CodigoFuente;

public class Inversion {
    //ATRIBUTOS
    private Inversor inversor;
    private Proyecto proyecto;
    private double cantidadParticipada;

    //MÉTODOS
    public Inversion (Inversor inversor, Proyecto proyecto) {
        this.inversor = inversor;
        this.proyecto = proyecto;
    }

    public boolean financiarProyecto (double cantidadEntrante) {
        proyecto.setCantidadFinanciada(proyecto.getCantidadFinanciada() + cantidadEntrante);
        cantidadParticipada += cantidadEntrante;
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



    public String toString (){
        return "Nombre: " + proyecto.getNombre() + "\nTipo: "+ proyecto.getTipo() + "\nCantidad con la que ha participado: " + cantidadParticipada;
    }

}
