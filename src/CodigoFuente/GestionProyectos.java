package CodigoFuente;

import Biblioteca.Fechas;
import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestionProyectos {
    private ArrayList<Proyecto> arrayProyectos;

    public GestionProyectos() {
        arrayProyectos=new ArrayList<>();
    }
    public int getCantidadProyectos(){
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
        System.out.println("Existen " + arrayProyectos.size() + " habilitados.");
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
        for (int i = 0; i < arrayProyectos.size(); i++) {
            System.out.println("Proyecto " + (i + 1));
            System.out.println("Nombre: " + arrayProyectos.get(i).getNombre() + "\nDescripción: " + arrayProyectos.get(i).getDescripcion() + "\nTipo: " + arrayProyectos.get(i).getTipo());
            System.out.println("Fecha Inicial: " + arrayProyectos.get(i).getFechaInicio() + "\nFecha Final: " + arrayProyectos.get(i).getFechaFin());
            System.out.println("Cantidad Necesaria: " + arrayProyectos.get(i).getCantidadNecesaria() + "\nCantidad Financiada: " + arrayProyectos.get(i).getCantidadFinanciada());
            System.out.println("Gráfico:");
            crearGrafico(arrayProyectos.get(i).getCantidadNecesaria(), arrayProyectos.get(i).getCantidadFinanciada());
            System.out.println();
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
    public boolean crearProyecto(String nombre, String descripcion, String tipo, String fechaInicio, String fechaFin, double cantidadNecesaria, double cantidadFinanciada) {
        return arrayProyectos.add(new Proyecto(nombre, descripcion, tipo, fechaInicio, fechaFin, cantidadNecesaria, cantidadFinanciada));
    }

    /**
     * Funcion para poder modificar un proyecto ya creado
     * @param pos como entero
     * @param nombre como cadena
     * @param descripcion como cadena
     * @param tipo como cadena
     * @param fechaInicio como cadena
     * @param fechaFin como cadena
     * @param cantidadNecesaria como un double
     * @param cantidadFinanciada como un double
     */
    public void modificarProyecto(int pos, String nombre, String descripcion, String tipo, String fechaInicio, String fechaFin, double cantidadNecesaria, double cantidadFinanciada) {
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
     * @param pos como entero
     */
    public String eliminarProyecto(int pos) {
        String nombre =arrayProyectos.get(pos).getNombre();
        arrayProyectos.remove(pos);
        return nombre;
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
                LocalDate date1 = Fechas.cadenaAfecha(valorInicial);
                LocalDate date2 = Fechas.cadenaAfecha(valorFinal);
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    LocalDate fechaProyecto = Fechas.cadenaAfecha(arrayProyectos.get(i).getFechaInicio());
                        if (Fechas.esPosterior(fechaProyecto, date1) && Fechas.esAnterior(fechaProyecto, date2)) System.out.println(arrayProyectos.get(i));
                }
            }
            case "Fecha de fin" -> {
                LocalDate date1 = Fechas.cadenaAfecha(valorInicial);
                LocalDate date2 = Fechas.cadenaAfecha(valorFinal);
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    LocalDate fechaProyecto = Fechas.cadenaAfecha(arrayProyectos.get(i).getFechaFin());
                    if (Fechas.esPosterior(fechaProyecto, date1) && Fechas.esAnterior(fechaProyecto, date2)) {
                        System.out.println(arrayProyectos.get(i));
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
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    if (arrayProyectos.get(i).getCantidadFinanciada() >= v1 && arrayProyectos.get(i).getCantidadFinanciada() <= v2)
                        System.out.println(arrayProyectos.get(i));

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
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    if (arrayProyectos.get(i).getDescripcion().equalsIgnoreCase(valor)) return i;
                }
            }
            case "tipo" -> {
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    if (arrayProyectos.get(i).getTipo().equalsIgnoreCase(valor)) return i;
                }
            }
            case "fecha de inicio" -> {
                LocalDate aux = Fechas.cadenaAfecha(valor);
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    LocalDate fechaProyecto = Fechas.cadenaAfecha(arrayProyectos.get(i).getFechaInicio());
                    if (fechaProyecto == aux) return i;
                }
            }
            case "fecha de fin" -> {
                LocalDate aux = Fechas.cadenaAfecha(valor);
                for (int i = 0; i < arrayProyectos.size(); i++) {
                    LocalDate fechaProyecto = Fechas.cadenaAfecha(arrayProyectos.get(i).getFechaFin());
                    if (fechaProyecto == aux) return i;
                }
            }
            default -> System.out.println("Ese parámetro no existe.");
        }
        return -1;
    }

    public Proyecto devuelveProyecto (int pos) {
        return arrayProyectos.get(pos);
    }

    public String crearJSON(){
        Gson gson=new Gson();
        return gson.toJson(this);
    }
    public void guardarAJSON(){
        String jsonCreado = crearJSON();
        try{
            FileWriter fichero = new FileWriter("GestionProyectos.json");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(jsonCreado);
            fichero.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static GestionProyectos recuperarJSON() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader buffer = new BufferedReader(new FileReader("GestionProyectos.json"));
        return gson.fromJson(buffer, GestionProyectos.class);
    }
}
