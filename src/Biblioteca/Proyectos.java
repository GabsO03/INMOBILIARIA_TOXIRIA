package Biblioteca;

import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class Proyectos {
    public static void mostrarProyectosNoAdmin (String[][] proyectsStringData, double[][] proyectsFinantialData) {
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
        System.out.println("Escriba el nuevo tipo del proyecto");
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
    public static String cambiarFechaInicio(){
        System.out.println("Escriba la nueva fecha de inicio");
        return leerOpcionLiteral();
    }
    public static String cambiarFechaFin(){
        System.out.println("Escriba la nueva fecha de fin");
        return leerOpcionLiteral();
    }
    public static String crearNombreProyecto(int posicion){
        System.out.print("Introduzca el nombre del proyecto "+posicion+": ");
        return leerOpcionLiteral();
    }
    public static String crearDescripcionProyecto(int posicion){
        System.out.print("Introduzca la descripción del proyecto"+posicion+": ");
        return leerOpcionLiteral();
    }
    public static String crearTipoProyecto(int posicion){
        System.out.print("Introduzca el Tipo del proyecto (Préstamo, Plusvalía o Alquiler)"+posicion+": ");
        return leerOpcionLiteral();
    }
    public static double crearCNecesariaProyecto(int posicion){
        System.out.print("Introduzca la cantidad necesaria del proyecto"+posicion+": ");
        return leerOpcionDouble();
    }
    public static double crearCFinanciadaProyecto(int posicion){
        System.out.print("Introduzca la cantidad financiada hasta el momento del proyecto"+posicion+": ");
        return leerOpcionDouble();
    }
    public static String crearFInicioProyecto(int posicion){
        System.out.print("Introduzca la fecha de inicio del proyecto (dd/mm/aaaa)"+posicion+": ");
        return leerOpcionLiteral();
    }
    public static String crearFFinProyecto(int posicion){
        System.out.print("Introduzca la fecha final del proyecto (dd/mm/aaaa)"+posicion+": ");
        return leerOpcionLiteral();
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
