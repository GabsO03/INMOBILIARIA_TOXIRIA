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

    //Métodos

    public static int hacerInversion(GestionProyectos proyectos){
        Proyecto[] arrayProyectos = proyectos.getArrayProyectos();
        String respuesta;
        int opcion=-1;
        System.out.println("¿Quieres invertir en algún proyecto?");
        respuesta=leerOpcionLiteral();
        if(respuesta.equalsIgnoreCase("Si")){
            System.out.println("Introduzca el número del proyecto en el que deseas invertir");
            opcion=leerOpcionNumerica();
            if(opcion>arrayProyectos.length||opcion<0) {
                System.out.println("No se ha encontrado ningún proyecto con ese número");
                return -1;
            }
        }
        return opcion;
    }

    public String toString (){
        return "Nombre: " + proyecto.getNombre() + "\nTipo: "+ proyecto.getTipo() + "\nCantidad con la que ha participado: " + cantidadParticipada;
    }

}
