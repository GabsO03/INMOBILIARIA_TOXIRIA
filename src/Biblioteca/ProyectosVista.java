package Biblioteca;

import CodigoFuente.GestionProyectos;

import java.time.LocalDate;

import static Biblioteca.Lectura_De_Datos.*;

public class ProyectosVista {
    /**
     * Modifica el nombre de un proyecto
     * @return una cadena con el nuevo nombre
     */
    public static String cambiarNombreProyecto(){
        System.out.println("Escriba el nuevo nombre del proyecto: ");
        return leerOpcionLiteral();
    }
    /**
     * Modifica la descripcion de un proyecto
     * @return una cadena con la nueva descripcion
     */
    public static String cambiarDescripcionProyecto(){
        System.out.println("Escriba la nueva descripción del proyecto: ");
        return leerOpcionLiteral();
    }
    /**
     * Modifica el tipo de un proyecto
     * @return una cadena con el nuevo tipo
     */
    public static String cambiarTipoProyecto(){
        String tipo;
        System.out.println("Escriba el nuevo tipo del proyecto (Préstamo, Plusvalía o Alquiler)");
        do {
            tipo = leerOpcionLiteral();
            if (!tipo.equalsIgnoreCase("préstamo")&&!tipo.equalsIgnoreCase("plusvalía")&&!tipo.equalsIgnoreCase("alquiler"))
                System.out.println("Ingrese un tipo valido.");
        } while (!tipo.equalsIgnoreCase("préstamo")&&!tipo.equalsIgnoreCase("plusvalía")&&!tipo.equalsIgnoreCase("alquiler"));
        return tipo;
    }
    /**
     * Modifica la cantidad necesaria de un proyecto
     * @return un double con la nueva cantidad necesaria
     */
    public static double cambiarCantidadNecesaria (){
        System.out.println("Escriba la nueva cantidad necesaria");
        return leerOpcionDouble();
    }
    /**
     * Modifica la fecha final de un proyecto
     * @return una cadena con la nueva fecha final
     */
    public static String cambiarFechaFin(){
        System.out.println("Escriba la nueva fecha de fin (dd/mm/aaaa)");
        return leerOpcionLiteral();
    }

    /**
     * Muestra todos los proyectos
     * @param tipo como un entero
     */
    public static void mostrarProyectos(int tipo, GestionProyectos proyectos) {
        ordenarProyectos(proyectos);
        int i = 0, tamanio = proyectos.getCantidadProyectos();
        while (i < tamanio) {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Posición: " + (i+1));
            System.out.println("Nombre: " + proyectos.devuelveProyecto(i).getNombre());
            System.out.println("Tipo: " + proyectos.devuelveProyecto(i).getTipo());
            System.out.println("Cantidad Necesaria: " + proyectos.devuelveProyecto(i).getCantidadNecesaria());
            System.out.println("Cantidad Financiada: " + proyectos.devuelveProyecto(i).getCantidadFinanciada());
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            i++;
        }
        System.out.println("Existen " + tamanio + " proyectos.");
        if (tipo == 1) System.out.println("1. Ver más detalles.\n2. Eliminar o modificar.\n3. Salir.");
    }
    public static void ordenarProyectos (GestionProyectos proyectos) {
        System.out.println("Seleccione el orden\n1. Fecha creación más reciente\n2. Fecha creación más antigua\n3. Fecha fin más cercana\n4. Fecha fin más lejana" +
                "\n5. Cantidad necesaria más baja\n6. Cantidad necesaria más alta\n7. Cantidad financiada más baja\n8. Cantidad financiada más alta");
        int orden = leerOpcionNumerica();
        proyectos.ordenarProyectos(orden);
    }
    /**
     * Funcion para mostrar todos los proyectos con más detalles
     */
    public static void proyectosDetallados(GestionProyectos proyectos) {
        for (int i = 0; i < proyectos.getCantidadProyectos(); i++) {
            System.out.println("Proyecto " + (i + 1));
            System.out.println("Nombre: " + proyectos.devuelveProyecto(i).getNombre() + "\nDescripción: " + proyectos.devuelveProyecto(i).getDescripcion() + "\nTipo: " + proyectos.devuelveProyecto(i).getTipo());
            System.out.println("Fecha Inicial: " + proyectos.devuelveProyecto(i).getFechaInicio() + "\nFecha Final: " + proyectos.devuelveProyecto(i).getFechaFin());
            System.out.println("Cantidad Necesaria: " + proyectos.devuelveProyecto(i).getCantidadNecesaria() + "\nCantidad Financiada: " + proyectos.devuelveProyecto(i).getCantidadFinanciada());
            System.out.println("Gráfico:");
            crearGrafico(proyectos.devuelveProyecto(i).getCantidadNecesaria(), proyectos.devuelveProyecto(i).getCantidadFinanciada());
            System.out.println();
        }
    }
    /**
     * Funcion para crear el grafo de cada proyecto
     * @param cantidadNecesaria como double
     * @param cantidadFinanciada como double
     */
    private static void crearGrafico(double cantidadNecesaria, double cantidadFinanciada) {
        int porcentaje = (int) ((int) (cantidadFinanciada * 100) / cantidadNecesaria);
        String caracterLleno = "#";
        String caracterVacio = "_";
        System.out.println("Cantidad financiada hasta el momento: ");
        System.out.print(caracterLleno.repeat(porcentaje));
        System.out.print(caracterVacio.repeat((100 - porcentaje)));
    }

    /**
     * Funcion para buscar un proyecto dentro de un rango
     * @param atributo como cadena
     * @param valorInicial como cadena
     * @param valorFinal como cadena
     * @param proyectos como cadena
     */
    public static void buscarProyectoRango(String atributo, String valorInicial, String valorFinal, GestionProyectos proyectos) {
        System.out.println("Listado completo de proyectos según " + atributo + " (desde " + valorInicial + " hasta " + valorFinal + "):");
        atributo = atributo.toLowerCase();
        int tamanio = proyectos.getCantidadProyectos();
        switch (atributo) {
            case "fecha de inicio" -> {
                LocalDate date1 = Fechas.cadenaAfecha(valorInicial);
                LocalDate date2 = Fechas.cadenaAfecha(valorFinal);
                for (int i = 0; i < tamanio; i++) {
                    LocalDate fechaProyecto = Fechas.cadenaAfecha(proyectos.devuelveProyecto(i).getFechaInicio());
                    if (Fechas.esPosterior(fechaProyecto, date1) && Fechas.esAnterior(fechaProyecto, date2)) System.out.println(proyectos.devuelveProyecto(i));
                }
            }
            case "fecha de fin" -> {
                LocalDate date1 = Fechas.cadenaAfecha(valorInicial);
                LocalDate date2 = Fechas.cadenaAfecha(valorFinal);
                for (int i = 0; i < tamanio; i++) {
                    LocalDate fechaProyecto = Fechas.cadenaAfecha(proyectos.devuelveProyecto(i).getFechaFin());
                    if (Fechas.esPosterior(fechaProyecto, date1) && Fechas.esAnterior(fechaProyecto, date2)) {
                        System.out.println(proyectos.devuelveProyecto(i));
                    }
                }
            }
            case "cantidad necesaria" -> {
                double v1 = Double.parseDouble(valorInicial);
                double v2 = Double.parseDouble(valorFinal);
                for (int i = 0; i < tamanio; i++) {
                    if (proyectos.devuelveProyecto(i).getCantidadNecesaria() >= v1 && proyectos.devuelveProyecto(i).getCantidadNecesaria() <= v2)
                        System.out.println(proyectos.devuelveProyecto(i));
                }
            }
            case "cantidad financiada" -> {
                double v1 = Double.parseDouble(valorInicial);
                double v2 = Double.parseDouble(valorFinal);
                for (int i = 0; i < tamanio; i++) {
                    if (proyectos.devuelveProyecto(i).getCantidadFinanciada() >= v1 && proyectos.devuelveProyecto(i).getCantidadFinanciada() <= v2)
                        System.out.println(proyectos.devuelveProyecto(i));

                }
            }
            default -> System.out.println("Error en datos introducidos.");
        }
    }

    /**
     * Funcion para buscar un determinado proyecto
     * @param proyectos un objeto de la clase GestionProyectos
     */
    public static void buscarProyecto (GestionProyectos proyectos) {
        int tipoBusqueda, position;
        String atributo, valor, valorInicial, valorFinal;
        do {
            System.out.println("Elija el tipo de busqueda.\n1. Por atributo simple.\n2. Por rango.\n3. Cancelar");
            tipoBusqueda = leerOpcionNumerica();
            switch (tipoBusqueda) {
                case 1 -> {
                    System.out.println("Introduzca el atributo del proyecto (ejemplo: Nombre || Tipo || Descripcion || Fecha de inicio/fin || Cantidad necesaria/financiada):");
                    atributo = leerOpcionLiteral();
                    System.out.println("Introduzca el valor (ejemplo: fecha dd/mm/yyyy):");
                    valor = leerOpcionLiteral();
                    position = proyectos.buscarProyecto(atributo, valor);
                    if (position >= 0)
                        System.out.println(proyectos.devuelveProyecto(position));
                    else System.out.println("Ese proyecto no existe.");
                }
                case 2 -> {
                    System.out.println("Introduzca el atributo del proyecto (Fecha de inicio/fin || Cantidad necesaria/financiada):");
                    atributo = leerOpcionLiteral();
                    System.out.println("Introduzca el valor inicial (fecha dd/mm/yyyy):");
                    valorInicial = leerOpcionLiteral();
                    System.out.println("Introduzca el valor final (fecha dd/mm/yyyy):");
                    valorFinal = leerOpcionLiteral();
                    buscarProyectoRango(atributo, valorInicial, valorFinal, proyectos);
                }
                case 3 -> System.out.println();
                default -> System.out.println("Invalid response.");
            }
        } while (tipoBusqueda != 3);
    }

}
