package Biblioteca;

import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class Proyectos {
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
        System.out.println("Escriba el nuevo tipo del proyecto (Préstamo, Plusvalía o Alquiler)");
        return leerOpcionLiteral();
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
     * Modifica la cantidad financiada de un proyecto
     * @return un double con la nueva cantidad financiada
     */
    public static double cambiarCantidadFinanciada (){
        System.out.println("Escriba la nueva cantidad financiada");
        return leerOpcionDouble();
    }
    /**
     * Modifica la fecha inicial de un proyecto
     * @return una cadena con la nueva fecha inicial
     */
    public static String cambiarFechaInicio(){
        System.out.println("Escriba la nueva fecha de inicio (dd/mm/aaaa)");
        return leerOpcionLiteral();
    }
    /**
     * Modifica la fecha final de un proyecto
     * @return una cadena con la nueva fecha final
     */
    public static String cambiarFechaFin(){
        System.out.println("Escriba la nueva fecha de fin (dd/mm/aaaa)");
        return leerOpcionLiteral();
    }
}
