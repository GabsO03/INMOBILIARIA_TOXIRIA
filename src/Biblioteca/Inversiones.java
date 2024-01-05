package Biblioteca;

public class Inversiones {
    public static void mostrarInversionEnProyecto(String nombreProyecto, String tipoProyecto, double cantidadParticipada){
        System.out.println("Nombre: "+nombreProyecto);
        System.out.println("Tipo: "+tipoProyecto);
        System.out.println("Cantidad con la que ha participado: "+ cantidadParticipada);
    }

    public static void mostrarCantidades (double[][] proyectsFinantialData, int segundoSubmenu) {
        System.out.println("Cantidad necesaria para financiar el proyecto: " + proyectsFinantialData[0][segundoSubmenu]);
        System.out.println("Cantidad financiada hasta el momento: " + proyectsFinantialData[1][segundoSubmenu]);
        System.out.println("Cantidad restante para financiar el proyecto: "+((proyectsFinantialData[0][segundoSubmenu]-proyectsFinantialData[1][segundoSubmenu])+"\n"));
    }
}
