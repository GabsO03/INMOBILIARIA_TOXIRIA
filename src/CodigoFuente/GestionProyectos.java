package CodigoFuente;

import Biblioteca.Fechas;
import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionProyectos {
    private ArrayList<Proyecto> arrayProyectos;

    public GestionProyectos() {
        arrayProyectos=new ArrayList<>();
    }
    public int getCantidadProyectos(){
        return arrayProyectos.size();
    }

    /**
     * Funcion para crear un nuevo proyecto
     * @param nombre como cadena
     * @param descripcion como cadena
     * @param tipo como cadena
     * @param fechaFin como una fecha
     * @param cantidadNecesaria como un double
     * @return devuelve true si se ha podido crear el proyecto o false si no se ha podido
     */
    public boolean crearProyecto(String nombre, String descripcion, String tipo, String fechaFin, double cantidadNecesaria) {
        return arrayProyectos.add(new Proyecto(nombre, descripcion, tipo, fechaFin, cantidadNecesaria));
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

    /**
     * Funcion para ordenar los proyectos según el atributo recibido como parámetro
     * @param atributo como un entero
     */
    public void ordenarProyectos (int atributo) {
        switch (atributo) {
            case 1 -> {
                arrayProyectos.sort(new Comparator<Proyecto> (){
                    @Override
                    public int compare(Proyecto o1, Proyecto o2) {
                        LocalDate f1 = Fechas.cadenaAfecha(o1.getFechaInicio());
                        LocalDate f2 = Fechas.cadenaAfecha(o2.getFechaInicio());
                        if (Fechas.esPosterior(f1, f2)) return 1;
                        else if (!Fechas.esPosterior(f1, f2)) return -1;
                        return 0;
                    }
                });
            }
            case 2 -> {
                arrayProyectos.sort(new Comparator<Proyecto> (){
                    @Override
                    public int compare(Proyecto o1, Proyecto o2) {
                        LocalDate f1 = Fechas.cadenaAfecha(o1.getFechaInicio());
                        LocalDate f2 = Fechas.cadenaAfecha(o2.getFechaInicio());
                        if (Fechas.esAnterior(f1, f2)) return 1;
                        else if (!Fechas.esAnterior(f1, f2)) return -1;
                        return 0;
                    }
                });
            }
            case 3 -> {
                arrayProyectos.sort(new Comparator<Proyecto> (){
                    @Override
                    public int compare(Proyecto o1, Proyecto o2) {
                        LocalDate f1 = Fechas.cadenaAfecha(o1.getFechaFin());
                        LocalDate f2 = Fechas.cadenaAfecha(o2.getFechaFin());
                        if (Fechas.esPosterior(f1, f2)) return 1;
                        else if (!Fechas.esPosterior(f1, f2)) return -1;
                        return 0;
                    }
                });
            }
            case 4 -> {
                arrayProyectos.sort(new Comparator<Proyecto> (){
                    @Override
                    public int compare(Proyecto o1, Proyecto o2) {
                        LocalDate f1 = Fechas.cadenaAfecha(o1.getFechaFin());
                        LocalDate f2 = Fechas.cadenaAfecha(o2.getFechaFin());
                        if (Fechas.esAnterior(f1, f2)) return 1;
                        else if (!Fechas.esAnterior(f1, f2)) return -1;
                        return 0;
                    }
                });
            }
            case 5 -> {
                arrayProyectos.sort(new Comparator<Proyecto> (){
                    @Override
                    public int compare(Proyecto o1, Proyecto o2) {
                        return (int) (o1.getCantidadNecesaria() - o2.getCantidadNecesaria());
                    }
                });
            }
            case 6 -> {
                arrayProyectos.sort(new Comparator<Proyecto> (){
                    @Override
                    public int compare(Proyecto o1, Proyecto o2) {
                        return (int) -(o1.getCantidadNecesaria() - o2.getCantidadNecesaria());
                    }
                });
            }
            case 7 -> {
                arrayProyectos.sort(new Comparator<Proyecto> (){
                    @Override
                    public int compare(Proyecto o1, Proyecto o2) {
                        return (int) (o1.getCantidadFinanciada() - o2.getCantidadFinanciada());
                    }
                });
            }
            case 8 -> {
                arrayProyectos.sort(new Comparator<Proyecto> (){
                    @Override
                    public int compare(Proyecto o1, Proyecto o2) {
                        return (int) -(o1.getCantidadFinanciada() - o2.getCantidadFinanciada());
                    }
                });
            }
            default -> System.out.println("Invalid response.");
        }
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
