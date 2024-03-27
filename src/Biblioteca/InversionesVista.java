package Biblioteca;

import CodigoFuente.GestionInversiones;
import CodigoFuente.GestionProyectos;

import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class InversionesVista {
    /**
     * Funcion para realizar una nueva inversion
     * @param proyectos como objeto de la clase GestionProyectos
     * @param inversiones proyectos como objeto de la clase GestionInversiones
     */
    public static void nuevaInversion (GestionProyectos proyectos, GestionInversiones inversiones) {
        String respuesta;
        double cantidadParticipativa;
        System.out.println("Escriba el nombre del proyecto en el que quiere invertir");
        inversiones.proyectosAunNoInvertidos(proyectos);
        respuesta = leerOpcionLiteral();
        int pos = proyectos.buscarProyecto("nombre", respuesta);
        if (pos >= 0) {
            System.out.println("Introduzca la cantidad que quieres invertir en el proyecto:");
            cantidadParticipativa = leerOpcionDouble();
            if (inversiones.nuevaInversion(proyectos.devuelveProyecto(pos), cantidadParticipativa))
                System.out.println("Inversión existosa, los detalles están disponibles para revisión.");
            else
                System.out.println("No cuentas con saldo suficiente para realizar esta transacción.");

        } else System.out.println("Ese proyecto no existe o escribiste el nombre incorrectamente.");
    }

    /**
     * Funcion para actualizar una inversion ya realizada anteriormente
     * @param proyectos como objeto de la clase GestionProyectos
     * @param inversiones proyectos como objeto de la clase GestionInversiones
     */
    public static void actualizarInversion (GestionProyectos proyectos, GestionInversiones inversiones) {
        String respuesta;
        double cantidadParticipativa;
        System.out.println("Escribe el nombre del proyecto que actualizar");
        System.out.println(inversiones.devuelveMisInversiones());
        respuesta = leerOpcionLiteral();
        int pos = proyectos.buscarProyecto("nombre", respuesta);
        if (pos >= 0) {
            System.out.println("Introduzca la cantidad que quieres añadir en el proyecto:");
            cantidadParticipativa = leerOpcionDouble();
            if (inversiones.actualizarInversion(pos, cantidadParticipativa))
                System.out.println("Inversión existosa, los detalles están disponibles para revisión.");
            else
                System.out.println("No cuentas con saldo suficiente para realizar esta transacción.");

        } else System.out.println("Ese proyecto no existe o escribiste el nombre incorrectamente.");
    }


}
