package Biblioteca;
import CodigoFuente.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Biblioteca.AccountSettings.enviarCorreo;
import static Biblioteca.AccountSettings.modificarCuenta;
import static Biblioteca.Lectura_De_Datos.*;
import static Biblioteca.Proyectos.*;
import static Biblioteca.funcionesCadenas.comprobarFortalezaPass;


public class Menus {
    public static void menuInicio() {
        System.out.println("Seleccione qué quiere hacer: \n1. Registro\n2. Iniciar sesión\n3. Salir");
    }

    public static void menuProyectosGestor() {
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Configuración de cuenta.\n4. Salir");
    }

    public static void menuAdministrador() {
        System.out.println("Seleccione dónde quiere acceder: \n1. Panel de control\n2. Proyectos\n3. Configuración\n4. Salir");
    }

    public static void menuModificarProyecto() {
        System.out.println("Elija qué quiere modificar: \n1.Nombre\n2.Descripcion\n3.Tipo\n4.Cantidad necesaria\n5.Cantidad Financiada" +
                "\n6.Fecha inicio\n7.Fecha fin\n8.Nada");
    }

    public static void menuOpcinesInversor() {
        System.out.println("Seleccione donde quiere acceder:\n1. Mis inversiones\n2. Invertir\n3. Cartera Virtual\n4. Configuración de cuenta\n5. Salir");
    }

    public static void menuConfiguracion() {
        System.out.println("Seleccione qué quiere hacer:");
        System.out.println("1. Cambiar usuario\n2. Cambiar contraseña\n3.Salir");
    }

    public static void panelControlUsuarios(GestionUsuarios usuarios) {
        int posicion, opcion;
        do {
            System.out.println("Menú del panel de control de usuarios.");
            usuarios.muestraUsuarios();
            System.out.println("Introduzca el número del usuario que quieras bloquear o desbloquear (0 para cancelar)");
            posicion = leerOpcionNumerica();
            if (posicion != 0){
                System.out.println("1. Bloquear.\n2. Desbloquear\n3. Cancelar");
                opcion = leerOpcionNumerica();
                if (opcion == 1 || opcion == 2) usuarios.bloquearDesbloquearUsuario(opcion, posicion);
            }
        } while (posicion != 0);
    }


    public static void menuAdmin(int pos, GestionUsuarios usuarios, GestionProyectos proyectos) {
        int primerSubmenu, segundoSubmenu, tercerSubmenu;
        do {
            menuAdministrador();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu) {
                case 1 -> panelControlUsuarios(usuarios);
                case 2 -> {
                    do {
                        proyectos.mostrarProyectos(1);
                        segundoSubmenu = leerOpcionNumerica();
                        switch (segundoSubmenu) {
                            case 1 -> proyectos.proyectosDetallados();
                            case 2 -> {
                                System.out.println("Introduzca la posición");
                                int posProyecto = leerOpcionNumerica();
                                posProyecto--;
                                if (posProyecto >= 0 && posProyecto < proyectos.getCantidadProyectos()) {
                                    System.out.println("¿Quiere eliminar el proyecto? [S]í | [N]o");
                                    String respuesta = leerOpcionLiteral();
                                    respuesta = respuesta.toLowerCase();
                                    switch (respuesta) {
                                        case "s" -> proyectos.eliminarProyecto(posProyecto);
                                        case "n" -> {
                                            System.out.println("¿Quiere modificar el proyecto? [S]í | [N]o");
                                            respuesta = leerOpcionLiteral();
                                            if (respuesta.equalsIgnoreCase("s")) {
                                                do {
                                                    menuModificarProyecto();
                                                    tercerSubmenu = leerOpcionNumerica();
                                                    switch (tercerSubmenu) {
                                                        case 1 -> proyectos.modificarProyecto(posProyecto, cambiarNombreProyecto(), null, null, null, null, 0, 0);
                                                        case 2 -> proyectos.modificarProyecto(posProyecto, null, cambiarDescripcionProyecto(), null, null, null, 0, 0);
                                                        case 3 -> proyectos.modificarProyecto(posProyecto, null, null, cambiarTipoProyecto(), null, null, 0, 0);
                                                        case 4 -> proyectos.modificarProyecto(posProyecto, null, null, null, cambiarFechaInicio(), null, 0, 0);
                                                        case 5 -> proyectos.modificarProyecto(posProyecto, null, null, null, null, cambiarFechaFin(), 0, 0);
                                                        case 6 -> proyectos.modificarProyecto(posProyecto, null, null, null, null, null, cambiarCantidadNecesaria(), 0);
                                                        case 7 -> proyectos.modificarProyecto(posProyecto, null, null, null, null, null, 0, cambiarCantidadFinanciada());
                                                        case 8 -> System.out.println();
                                                        default -> System.out.println("Respuesta no válida.");
                                                    }
                                                } while (tercerSubmenu != 8);
                                            }
                                        }
                                    }
                                } else System.out.println("Proyecto no encontrado.");
                            }
                            case 3 -> System.out.println();
                        }
                    } while (segundoSubmenu != -1);
                }
                case 3 -> modificarCuenta(pos, usuarios);
            }
        } while (primerSubmenu != 4);
    }

    public static void menuGestor(int pos, GestionUsuarios usuarios, GestionProyectos proyectos) {
        int primerSubmenu;
        do {
            menuProyectosGestor();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu) {
                case 1 -> proyectos.mostrarProyectos(0); //EL TIPO ES 0 PORQUE SI PONEMOS 1 SALE MAS INFO PARA EL ADMIN
                case 2 ->
                        proyectos.crearProyecto(cambiarNombreProyecto(), cambiarDescripcionProyecto(), cambiarTipoProyecto(), cambiarFechaInicio(), cambiarFechaFin(), cambiarCantidadNecesaria(), cambiarCantidadFinanciada());
                case 3 -> modificarCuenta(pos, usuarios);
            }

        } while (primerSubmenu != 4);
    }
    public static int encuentraGestionInversiones (GestionInversiones[] megaGestionInversiones, Inversor inversor) {
        for (int i = 0; i < megaGestionInversiones.length; i++) {
            if (megaGestionInversiones[i].getPropietario() == inversor) return i;
        }
        return -1;
    }


    public static void mostrarYAniadirSaldo(Inversor inversor){
        String respuesta;
        double cantidad;
        System.out.println("Tu saldo actual es de " + inversor.getSaldo() );
        System.out.println("¿Quieres añadir saldo?");
        respuesta=leerOpcionLiteral();
        if(respuesta.equalsIgnoreCase("Si")){
            System.out.println("Introduce cuanto saldo quieres añadir");
            cantidad=leerOpcionDouble();
            inversor.setSaldo(inversor.getSaldo() + cantidad);
            System.out.println("Tu saldo ahora es de " + inversor.getSaldo());
        }
    }

    public static void menuInversor(int pos, GestionUsuarios usuarios, GestionProyectos proyectos, GestionInversiones[] megaGestionInversiones) {
        Inversor aux = (Inversor) usuarios.devuelveUsuario(pos);
        int primerSubmenu, opcionInversion, gestionIndividual = encuentraGestionInversiones(megaGestionInversiones, aux);
        do {
            menuOpcinesInversor();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu) {
                case 1 -> megaGestionInversiones[gestionIndividual].mostrarMisInversiones();
                case 2 -> {
                    System.out.println("1. Nueva inversión\n2. Actualizar inversión\n3. Cancelar");
                    opcionInversion = leerOpcionNumerica();
                    switch (opcionInversion) {
                        case 1 -> nuevaInversion(proyectos, megaGestionInversiones[gestionIndividual], aux);
                        case 2 -> actualizarInversion(proyectos, megaGestionInversiones[gestionIndividual], aux);
                        case 3 -> System.out.println();
                        default -> System.out.println("Invalid response.");
                    }
                }
                case 3 -> mostrarYAniadirSaldo(aux);
                case 4 -> modificarCuenta(pos, usuarios);
            }
        } while (primerSubmenu != 5);
    }
    public static void nuevaInversion (GestionProyectos proyectos, GestionInversiones inversiones, Inversor propietario) {
        String respuesta;
        double cantidadParticipativa;
        String fecha;
        LocalDate date;
        System.out.println("Escriba el nombre del proyecto en el que quiere invertir");
        inversiones.proyectosAunNoInvertidos(proyectos);
        respuesta = leerOpcionLiteral();
        int pos = proyectos.buscarProyecto("nombre", respuesta);
        if (pos >= 0) {
            System.out.println("Introduzca la cantidad que quieres invertir en el proyecto:");
            cantidadParticipativa = leerOpcionDouble();
            System.out.println("Introduzca la fecha (dd/mm/yyyy):");
            fecha = leerOpcionLiteral();
            date = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            inversiones.nuevaInversion(propietario, proyectos.devuelveProyecto(pos), cantidadParticipativa, date);
        } else System.out.println("Ese proyecto no existe o escribiste el nombre incorrectamente.");
    }
    public static void actualizarInversion (GestionProyectos proyectos, GestionInversiones inversiones, Inversor propietario) {
        String respuesta;
        double cantidadParticipativa;
        String fecha;
        LocalDate fechaActualizacion;
        System.out.println("Escribe el nombre del proyecto que actualizar");
        inversiones.mostrarMisInversiones();
        respuesta = leerOpcionLiteral();
        int pos = proyectos.buscarProyecto("nombre", respuesta);
        if (pos >= 0) {
            System.out.println("Introduzca la cantidad que quieres añadir en el proyecto:");
            cantidadParticipativa = leerOpcionDouble();
            System.out.println("Introduzca la fecha (dd/mm/yyyy):");
            fecha = leerOpcionLiteral();
            fechaActualizacion = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            inversiones.actualizarInversion(pos, cantidadParticipativa, fechaActualizacion);
        } else System.out.println("Ese proyecto no existe o escribiste el nombre incorrectamente.");
    }

}
