package CodigoFuente;

import java.time.LocalDate;

import static Biblioteca.Colores.*;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class GestionProyectos {
    private Proyecto[] arrayProyectos;
    private static int cantidadProyectos = 0;

    public int getCantidadProyectos() {
        return cantidadProyectos;
    }
    public GestionProyectos(int cantidadProyectos) {
        arrayProyectos = new Proyecto[20];
        cantidadProyectos++;
    }
    public void mostrarProyectos(int tipo) {
        int i = 0;
        while (i < arrayProyectos.length) {
            if (arrayProyectos != null) {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.print("Posición: " + i);
                System.out.print("Nombre: " + arrayProyectos[i].getNombre());
                System.out.print("Tipo: " + arrayProyectos[i].getTipo());
                System.out.print("Cantidad Necesaria: " + arrayProyectos[i].getCantidadNecesaria());
                System.out.print("Cantidad Financiada: " + arrayProyectos[i].getCantidadFinanciada());
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            }
            i++;
        }
        System.out.println("Existen " + cantidadProyectos + " habilitados.");
        if (tipo == 1)
            System.out.println("Escriba 0 para ver más detalles.\nEscriba -1 para salir.\nO digite la posición del proyecto que quiere eliminar o modificar");
    }


    private void crearGrafico(double cantidadNecesaria, double cantidadFinanciada) {
        int porcentaje = (int) ((int) (cantidadFinanciada * 100) / cantidadNecesaria);
        String caracterLleno = "#";
        String caracterVacio = "_";
        System.out.println("Cantidad financiada hasta el momento: ");
        System.out.print(caracterLleno.repeat(porcentaje));
        System.out.print(caracterVacio.repeat((100 - porcentaje)));
    }

    public void proyectosDetallados() {
        for (int i = 0; i < arrayProyectos.length; i++) {
            if (arrayProyectos[i] != null) {
                System.out.println("Proyecto " + (i + 1));
                System.out.println("Nombre: " + arrayProyectos[i].getNombre() + "\nDescripción: " + arrayProyectos[i].getDescripcion() + "\nTipo: " + arrayProyectos[i].getTipo());
                System.out.println("Fecha Inicial: " + arrayProyectos[i].getFechaInicio() + "\nFecha Final: " + arrayProyectos[i].getFechaFin());
                System.out.println("Cantidad Necesaria: " + arrayProyectos[i].getCantidadNecesaria() + "\nCantidad Financiada: " + arrayProyectos[i].getCantidadFinanciada());
                System.out.println("Gráfico:");
                crearGrafico(arrayProyectos[i].getCantidadNecesaria(), arrayProyectos[i].getCantidadFinanciada());
                System.out.println();
            }
        }
    }

    public void mostrarNombreTipoProyecto () {
        System.out.println(RED + "Nombre del proyecto\t\t\t" + GREEN + "Tipo del proyecto");
        for (Proyecto p: arrayProyectos) {
            if (p != null) System.out.println(RED + p.getNombre() + "\t\t\t\t" + GREEN + p.getTipo() + RESET);
        }
        System.out.println("¿Quieres ver más detalles sobre los proyectos? [S]í | [N]o");
        String respuesta = leerOpcionLiteral();
        if (respuesta.equalsIgnoreCase("s")) proyectosDetallados();
    }
    private void ampliar () {
        if (cantidadProyectos == arrayProyectos.length) {
            Proyecto[] aux = new Proyecto[arrayProyectos.length+20];
            for (int i = 0; i < arrayProyectos.length; i++) {
                aux[i] = arrayProyectos[i];
            }
            arrayProyectos = aux;
        }
    }
    public void crearProyecto(Proyecto proyecto) {
        arrayProyectos[cantidadProyectos++] = proyecto;
    }

    public boolean crearProyecto(String nombre, String descripcion, String tipo, LocalDate fechaInicio, LocalDate fechaFin, double cantidadNecesaria, double cantidadFinanciada) {
        ampliar();
        if (arrayProyectos[cantidadProyectos] == null) {
            arrayProyectos[cantidadProyectos++] = new Proyecto(nombre, descripcion, tipo, fechaInicio, fechaFin, cantidadNecesaria, cantidadFinanciada);
            return true;
        }
        return false;
    }

    public boolean modificarProyecto(int pos, Proyecto proyecto) {
        if (proyecto != null) {
            arrayProyectos[pos] = proyecto;
            return true;
        }
        return false;
    }
    public void modificarProyecto(int pos, String nombre, String descripcion, String tipo, LocalDate fechaInicio, LocalDate fechaFin, double cantidadNecesaria, double cantidadFinanciada) {
        if (nombre != null) arrayProyectos[pos].setNombre(nombre);
        if (descripcion != null) arrayProyectos[pos].setDescripcion(descripcion);
        if (tipo != null)  arrayProyectos[pos].setTipo(tipo);
        if (fechaInicio != null) arrayProyectos[pos].setFechaInicio(fechaInicio);
        if (fechaFin != null) arrayProyectos[pos].setFechaFin(fechaFin);
        if (cantidadNecesaria != 0) arrayProyectos[pos].setCantidadNecesaria(cantidadNecesaria);
        if (cantidadFinanciada != 0) arrayProyectos[pos].setCantidadFinanciada(cantidadFinanciada);
    }


    public boolean eliminarProyecto(int pos) {
        if (arrayProyectos[pos] != null) {
            arrayProyectos[pos] = null;
            reorganizaArray(pos);
        }
        return false;
    }

    private void reorganizaArray(int pos) {
        for (int i = pos; i < arrayProyectos.length - 1; i++) {
            arrayProyectos[i] = arrayProyectos[i + 1];
        }
        arrayProyectos[arrayProyectos.length - 1] = null;
    }

    public int buscarProyecto(String atributo, String valor) {
        return buscarProyecto(atributo, valor, 0);
    }
    public int buscarProyecto(String atributo, String valor, int posicion) {
        int codigo;
        atributo = atributo.toLowerCase();
        valor = valor.toLowerCase();
        switch (atributo) {
            case "código" -> {
                codigo = Integer.parseInt(valor);
                for (int i = 0; i < arrayProyectos.length; i++) {
                    if (arrayProyectos[i] != null && arrayProyectos[i].getCodigo() == codigo) return i;
                }
            }
            case "nombre" -> {
                for (int i = posicion; i < arrayProyectos.length; i++) {
                    if (arrayProyectos[i] != null && arrayProyectos[i].getNombre().equalsIgnoreCase(valor)) return i;
                }
            }
            case "descripción" -> {
                for (int i = posicion; i < arrayProyectos.length; i++) {
                    if (arrayProyectos[i] != null && arrayProyectos[i].getDescripcion().equalsIgnoreCase(valor)) return i;
                }
            }
            default -> System.out.println("Ese parámetro no existe.");
        }
        return -1;
    }

    public void menuProyectos(){
        System.out.println("Seleccione en qué proyecto quiere invertir: ");
        for (int i = 0; i < arrayProyectos.length; i++) {
            if (arrayProyectos[i]!=null) System.out.println(i + arrayProyectos[i].getNombre());
        }
    }

    public boolean noEstaVacio (int pos) {
        return arrayProyectos[pos] != null;
    }

    public void mostrarCantidades (int pos) {
        System.out.println("Cantidad necesaria para financiar el proyecto: " + arrayProyectos[pos].getCantidadNecesaria());
        System.out.println("Cantidad financiada hasta el momento: " + arrayProyectos[pos].getCantidadFinanciada());
        System.out.println("Cantidad restante para financiar el proyecto: "+(arrayProyectos[pos].getCantidadNecesaria() - arrayProyectos[pos].getCantidadFinanciada())+"\n");
    }
}
