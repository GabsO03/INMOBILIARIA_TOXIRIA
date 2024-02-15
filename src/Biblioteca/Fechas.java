package Biblioteca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Fechas {
    public static boolean esAnterior(LocalDateTime fecha1,LocalDateTime fecha2){
        if (fecha1.isBefore(fecha2)) return true;
        else return false;
    }
    public static boolean esAnterior(LocalDate fecha1,LocalDate fecha2){
        if (fecha1.isBefore(fecha2)) return true;
        else return false;
    }
    public static long segundosRestantes(LocalDateTime fecha){
        LocalDateTime ahora= LocalDateTime.now();
        return ChronoUnit.SECONDS.between(ahora,fecha);
    }
    public static long minutosRestantes(LocalDateTime fecha){
        LocalDateTime ahora= LocalDateTime.now();
        return ChronoUnit.MINUTES.between(ahora,fecha);
    }
    public static long horasRestantes(LocalDateTime fecha){
        LocalDateTime ahora= LocalDateTime.now();
        return ChronoUnit.HOURS.between(ahora,fecha);
    }
    public static long diasRestantes(LocalDateTime fecha){
        LocalDateTime ahora= LocalDateTime.now();
        return ChronoUnit.DAYS.between(ahora,fecha);
    }
    public static long diasRestantes(LocalDate fecha){
        LocalDate ahora= LocalDate.now();
        return ChronoUnit.DAYS.between(ahora,fecha);
    }
    public static String formatear(LocalDate fecha){
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }
    public static String formatear(LocalDateTime fecha){
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }
}
