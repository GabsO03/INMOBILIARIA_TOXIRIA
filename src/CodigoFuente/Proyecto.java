package CodigoFuente;

import java.time.LocalDate;

public class Proyecto {
    //ATRIBUTOS
    private int codigo;
    private String nombre;
    private String descripcion;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double cantidadNecesaria;
    private double cantidadFinanciada;
    private static int cantidadProyectos = 2580;

    //MÉTODOS

    //constructores
    public Proyecto(String nombre, String descripcion, String tipo, LocalDate fechaInicio, LocalDate fechaFin, double cantidadNecesaria, double cantidadFinanciada) {
        this.codigo = cantidadProyectos++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadNecesaria = cantidadNecesaria;
        this.cantidadFinanciada = cantidadFinanciada;
    }

    //setters
    public void setNombre (String nombre) { this.nombre = nombre; }
    public void setDescripcion (String descripcion) { this.descripcion = descripcion; }
    public void setTipo (String tipo) { this.tipo = tipo; }
    public void setFechaInicio (LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setFechaFin (LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public void setCantidadNecesaria (double cantidadNecesaria) { this.cantidadNecesaria = cantidadNecesaria; }
    public void setCantidadFinanciada (double cantidadFinanciada) { this.cantidadFinanciada = cantidadFinanciada; }

    //getters
    public int getCodigo () {
        return codigo;
    }
    public String getNombre () { return nombre; }
    public String getDescripcion () { return descripcion; }
    public String getTipo () { return tipo; }
    public LocalDate getFechaInicio () { return fechaInicio; }
    public LocalDate getFechaFin () { return fechaFin; }
    public double getCantidadNecesaria () { return cantidadNecesaria; }
    public double getCantidadFinanciada () { return cantidadFinanciada; }

    public String toString () {
        return "Nombre: " + nombre + "\nTipo: " + tipo + "\nCantidad Necesaria: " + cantidadNecesaria + "\nCantidad Financiada: " + cantidadFinanciada + "\n";
    }


}
