package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class Proyectos {

    public static String cambiarNombreProyecto(){
        System.out.println("Escriba el nuevo nombre del proyecto: ");
        return leerOpcionLiteral();
    }
    public static String cambiarDescripcionProyecto(){
        System.out.println("Escriba la nueva descripción del proyecto: ");
        return leerOpcionLiteral();
    }
    public static String cambiarTipoProyecto(){
        System.out.println("Escriba el nuevo tipo del proyecto (Préstamo, Plusvalía o Alquiler)");
        return leerOpcionLiteral();
    }
    public static double cambiarCantidadNecesaria (){
        System.out.println("Escriba la nueva cantidad necesaria");
        return leerOpcionDouble();
    }
    public static double cambiarCantidadFinanciada (){
        System.out.println("Escriba la nueva cantidad financiada");
        return leerOpcionDouble();
    }
    public static LocalDate cambiarFechaInicio(){
        System.out.println("Escriba la nueva fecha de inicio (dd/mm/aaaa)");
        return LocalDate.parse(leerOpcionLiteral(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public static LocalDate cambiarFechaFin(){
        System.out.println("Escriba la nueva fecha de fin (dd/mm/aaaa)");
        return LocalDate.parse(leerOpcionLiteral(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


    // TODO: 15/02/2024 SEGUIR CON LA CREACION DEL PROYECTO
    public static void nuevoProyecto(){
        String nombreProyecto, descripcionProyecto,tipoProyecto;
        float cantidadNecesaria, cantidadFinanciada;
        LocalDate fechaInicio, fechaFin;
    }


}
