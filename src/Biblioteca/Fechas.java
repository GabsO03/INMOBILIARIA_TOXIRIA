package Biblioteca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Fechas {
    /**
     * Funcion para comprobar si una fecha es anterior a otra
     * @param fecha1 como un LocalDate
     * @param fecha2 como un LocalDate
     * @return true or false dependiendo de si la fecha1 es anterior a la fecha2
     */
    public static boolean esAnterior(LocalDate fecha1,LocalDate fecha2){
        if (fecha1.isBefore(fecha2)) return true;
        else return false;
    }

    /**
     * Funcion para comprobar si una fecha es posterior a otra
     * @param fecha1 como un LocalDate
     * @param fecha2 como un LocalDate
     * @return true or false dependiendo de si la fecha1 es posterior a la fecha2
     */
    public static boolean esPosterior(LocalDate fecha1, LocalDate fecha2){
        return fecha1.isAfter(fecha2);
    }

}
