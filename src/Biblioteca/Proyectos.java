package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class Proyectos {
    public static void mostrarProyectosNoAdmin (String[][] proyectsStringData, double[][] proyectsFinantialData, int contadorProyectos) {
        System.out.println();
        System.out.print("Posición: \t\t\t\t");
        for (int i = 0; i < proyectsStringData[0].length; i++) if (proyectsStringData[0][i] != null) System.out.print("Proyecto " + (i+1) + "\t\t\t\t");
        System.out.println();
        System.out.print("Nombre: \t\t\t\t");
        for (int i = 0; i < proyectsStringData[0].length; i++) if (proyectsStringData[0][i] != null) System.out.print(proyectsStringData[0][i] + "\t\t\t\t");
        System.out.println();
        System.out.print("Tipo: \t\t\t\t\t");
        for (int i = 0; i < proyectsStringData[2].length; i++) if (proyectsStringData[2][i] != null) System.out.print(proyectsStringData[2][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.print("Cantidad Necesaria:\t\t");
        for (int i = 0; i < proyectsFinantialData[0].length; i++) if (proyectsFinantialData[0][i] != 0) System.out.print(proyectsFinantialData[0][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.print("Cantidad Financiada:\t");
        for (int i = 0; i < proyectsFinantialData[1].length; i++) if (proyectsFinantialData[1][i] != 0) System.out.print(proyectsFinantialData[1][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.println("Existen " + contadorProyectos + " habilitados.");
    }

    public static void mostrarProyectosAdmin(String[][] proyectsStringData, double[][] proyectsFinantialData){
        System.out.println();
        System.out.print("Posición: \t\t\t\t");
        for (int i = 0; i < proyectsStringData[0].length; i++) if (proyectsStringData[0][i] != null) System.out.print("Proyecto " + (i+1) + "\t\t\t\t");
        System.out.println();
        System.out.print("Nombre: \t\t\t\t");
        for (int i = 0; i < proyectsStringData[0].length; i++) if (proyectsStringData[0][i] != null) System.out.print(proyectsStringData[0][i] + "\t\t\t\t");
        System.out.println();
        System.out.print("Tipo: \t\t\t\t\t");
        for (int i = 0; i < proyectsStringData[2].length; i++) if (proyectsStringData[2][i] != null) System.out.print(proyectsStringData[2][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.print("Cantidad Necesaria:\t\t");
        for (int i = 0; i < proyectsFinantialData[0].length; i++) if (proyectsFinantialData[0][i] != 0) System.out.print(proyectsFinantialData[0][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.print("Cantidad Financiada:\t");
        for (int i = 0; i < proyectsFinantialData[1].length; i++) if (proyectsFinantialData[1][i] != 0) System.out.print(proyectsFinantialData[1][i] + "\t\t\t\t\t");
        System.out.println();

        System.out.println("Escriba 0 para ver más detalles.\nEscriba -1 para salir.\nO digite la posición del proyecto que quiere eliminar o modificar");
    }

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
    public static void crearGrafico(double cantidadNecesaria,double cantidadFinanciada){
        int porcentaje= (int) ((int) (cantidadFinanciada*100)/cantidadNecesaria);
        String caracterLleno="#";
        String caracterVacio="_";
        System.out.println("Cantidad financiada hasta el momento: ");
        System.out.print(caracterLleno.repeat(porcentaje));
        System.out.print(caracterVacio.repeat((100-porcentaje)));
    }

    public static void proyectosDetallados(String[][] proyectsStringData, double[][] proyectsFinantialData){
        for (int i = 0; i < proyectsStringData[0].length; i++) {
            if (proyectsStringData[0][i] != null) {
                System.out.println("Proyecto "+(i+1));
                System.out.println("Nombre: " + proyectsStringData[0][i] + "\nDescripción: " + proyectsStringData[1][i] +"\nTipo: " + proyectsStringData[2][i]  + "\nFecha Inicial: " + proyectsStringData[3][i] + "\nFecha Final: " + proyectsStringData[4][i] + "\nCantidad Necesaria: " + proyectsFinantialData[0][i] + "\nCantidad Financiada: " + proyectsFinantialData[1][i]);
                System.out.println("Gráfico:");
                crearGrafico(proyectsFinantialData[0][i], proyectsFinantialData[1][i]);
                System.out.println();
            }
        }
    }
}
