package CodigoFuente;

import Biblioteca.Fechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static Biblioteca.Colores.*;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class GestionProyectos {
    private ArrayList<Proyecto> arrayProyectos;

    public GestionProyectos() {
        arrayProyectos=new ArrayList<>();
    }

    public int tamanioArray(){
        return arrayProyectos.size();
    }
    /**
     * Muestra todos los proyectos
     * @param tipo como un entero
     */
    public void mostrarProyectos(int tipo) {
        int i = 0;
        while (i < arrayProyectos.size()) {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Posición: " + (i+1));
                System.out.println("Nombre: " + arrayProyectos.get(i).getNombre());
                System.out.println("Tipo: " + arrayProyectos.get(i).getTipo());
                System.out.println("Cantidad Necesaria: " + arrayProyectos.get(i).getCantidadNecesaria());
                System.out.println("Cantidad Financiada: " + arrayProyectos.get(i).getCantidadFinanciada());
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            i++;
        }
        System.out.println("Existen " + cantidadProyectos + " habilitados.");
        if (tipo == 1) System.out.println("1. Ver más detalles.\n2. Eliminar o modificar.\n3. Salir.");
    }

    /**
     * Funcion para crear el grafo de cada proyecto
     * @param cantidadNecesaria como double
     * @param cantidadFinanciada como double
     */
    private void crearGrafico(double cantidadNecesaria, double cantidadFinanciada) {
        int porcentaje = (int) ((int) (cantidadFinanciada * 100) / cantidadNecesaria);
        String caracterLleno = "#";
        String caracterVacio = "_";
        System.out.println("Cantidad financiada hasta el momento: ");
        System.out.print(caracterLleno.repeat(porcentaje));
        System.out.print(caracterVacio.repeat((100 - porcentaje)));
    }

    /**
     * Funcion para mostrar todos los proyectos con más detalles
     */
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



    /**
     * Funcion para crear un nuevo proyecto
     * @param nombre como cadena
     * @param descripcion como cadena
     * @param tipo como cadena
     * @param fechaInicio como una fecha
     * @param fechaFin como una fecha
     * @param cantidadNecesaria como un double
     * @param cantidadFinanciada como un double
     * @return devuelve true si se ha podido crear el proyecto o false si no se ha podido
     */
    public boolean crearProyecto(String nombre, String descripcion, String tipo, LocalDate fechaInicio, LocalDate fechaFin, double cantidadNecesaria, double cantidadFinanciada) {
        ampliar();
        if (arrayProyectos[cantidadProyectos] == null) {
            arrayProyectos[cantidadProyectos++] = new Proyecto(nombre, descripcion, tipo, fechaInicio, fechaFin, cantidadNecesaria, cantidadFinanciada);
            return true;
        }
        return false;
    }

    /**
     * Funcion para poder modificar un proyecto ya creado
     * @param pos como entero
     * @param nombre como cadena
     * @param descripcion como cadena
     * @param tipo como cadena
     * @param fechaInicio como una fecha
     * @param fechaFin como una fecha
     * @param cantidadNecesaria como un double
     * @param cantidadFinanciada como un double
     */
    public void modificarProyecto(int pos, String nombre, String descripcion, String tipo, LocalDate fechaInicio, LocalDate fechaFin, double cantidadNecesaria, double cantidadFinanciada) {
        if (nombre != null) arrayProyectos.get(pos).setNombre(nombre);
        if (descripcion != null) arrayProyectos.get(pos).setDescripcion(descripcion);
        if (tipo != null)  arrayProyectos.get(pos).setTipo(tipo);
        if (fechaInicio != null) arrayProyectos.get(pos).setFechaInicio(fechaInicio);
        if (fechaFin != null) arrayProyectos.get(pos).setFechaFin(fechaFin);
        if (cantidadNecesaria != 0) arrayProyectos.get(pos).setCantidadNecesaria(cantidadNecesaria);
        if (cantidadFinanciada != 0) arrayProyectos.get(pos).setCantidadFinanciada(cantidadFinanciada);
    }

    /**
     * Funcion para eliminar un proyecto
     * @param pos
     * @return
     */
    public boolean eliminarProyecto(int pos) {
        if (arrayProyectos[pos] != null) {
            arrayProyectos[pos] = null;
            reorganizaArray(pos);
        }
        return false;
    }

    /**
     * Funcion para cuando borramos un proyecto reorganizar el array
     * @param pos como entero
     */

    private void reorganizaArray(int pos) {
        for (int i = pos; i < arrayProyectos.length - 1; i++) {
            arrayProyectos[i] = arrayProyectos[i + 1];
        }
        arrayProyectos[arrayProyectos.length - 1] = null;
    }

    /**
     * Funcion para buscar un proyecto dentro de un rango
     * @param atributo como cadena
     * @param valorInicial como cadena
     * @param valorFinal como cadena
     */
    public void buscarProyectoRango(String atributo, String valorInicial, String valorFinal) {
        System.out.println("Listado completo de proyectos según " + atributo + " (desde " + valorInicial + " hasta " + valorFinal + "):");

        switch (atributo) {
            case "Fecha de inicio" -> {
                LocalDate date1 = LocalDate.parse(valorInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate date2 = LocalDate.parse(valorFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                for (int i = 0; i < arrayProyectos.size(); i++) {
                        if (Fechas.esPosterior(arrayProyectos.get(i).getFechaInicio(), date1) && Fechas.esAnterior(arrayProyectos.get(i).getFechaInicio(), date2)) System.out.println(arrayProyectos.get(i));
                }
            }
            case "Fecha de fin" -> {
                LocalDate date1 = LocalDate.parse(valorInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate date2 = LocalDate.parse(valorFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                for (int i = 0; i < arrayProyectos.length; i++) {
                    if (arrayProyectos[i] != null) {
                        if (Fechas.esPosterior(arrayProyectos[i].getFechaFin(), date1) && Fechas.esAnterior(arrayProyectos[i].getFechaFin(), date2)) {
                            System.out.println(arrayProyectos[i]);
                        }
                    }
                }
            }
            case "Cantidad necesaria" -> {
                double v1 = Double.parseDouble(valorInicial);
                double v2 = Double.parseDouble(valorFinal);
                for (int i = 0; i < arrayProyectos.size(); i++) {
                        if (arrayProyectos.get(i).getCantidadNecesaria() >= v1 && arrayProyectos.get(i).getCantidadNecesaria() <= v2)
                            System.out.println(arrayProyectos.get(i));
                }
            }
            case "Cantidad financiada" -> {
                double v1 = Double.parseDouble(valorInicial);
                double v2 = Double.parseDouble(valorFinal);
                for (int i = 0; i < arrayProyectos.length; i++) {
                    if (arrayProyectos[i] != null) {
                        if (arrayProyectos[i].getCantidadFinanciada() >= v1 && arrayProyectos[i].getCantidadFinanciada() <= v2)
                            System.out.println(arrayProyectos[i]);
                    }
                }
            }
            default -> System.out.println("Error en datos introducidos.");
        }
    }

    /**
     * Funcion para buscar un proyecto dando el valor por parámetro
     * @param atributo como cadena
     * @param valor como cadena
     * @return un entero con la posicion donde se encuentra el proyecto o -1 si no lo ha encontrado
     */
    public int buscarProyecto(String atributo, String valor) {
        int codigo;
        atributo = atributo.toLowerCase();
        valor = valor.toLowerCase();
        switch (atributo) {
            case "código" -> {
                codigo = Integer.parseInt(valor);
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    if (arrayProyectos.get(i).getCodigo() == codigo) return i;
                }
            }
            case "nombre" -> {
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    if (arrayProyectos.get(i).getNombre().equalsIgnoreCase(valor)) return i;
                }
            }
            case "descripción" -> {
                for (int i = 0; i < arrayProyectos.length; i++) {
                    if (arrayProyectos[i] != null && arrayProyectos[i].getDescripcion().equalsIgnoreCase(valor)) return i;
                }
            }
            case "tipo" -> {
                for (int i = 0; i < arrayProyectos.length; i++) {
                    if (arrayProyectos[i] != null && arrayProyectos[i].getTipo().equalsIgnoreCase(valor)) return i;
                }
            }
            case "fecha de inicio" -> {
                LocalDate aux = LocalDate.parse(valor, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    if (arrayProyectos.get(i).getFechaInicio() == aux) return i;
                }
            }
            case "fecha de fin" -> {
                LocalDate aux = LocalDate.parse(valor, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                for (int i = 0; i < arrayProyectos.length; i++) {
                    if (arrayProyectos[i] != null && arrayProyectos[i].getFechaFin() == aux) return i;
                }
            }
            default -> System.out.println("Ese parámetro no existe.");
        }
        return -1;
    }

    public Proyecto devuelveProyecto (int pos) {
        if (arrayProyectos[pos] != null) return arrayProyectos[pos];
        return null;
    }
}
