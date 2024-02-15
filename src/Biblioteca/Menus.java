package Biblioteca;
import CodigoFuente.GestionProyectos;
import CodigoFuente.GestionUsuarios;
import CodigoFuente.Usuario;

import java.time.LocalDate;

import static Biblioteca.AccountSettings.modificarCuenta;
import static Biblioteca.Colores.RED;
import static Biblioteca.Colores.RESET;
import static Biblioteca.Lectura_De_Datos.*;
import static Biblioteca.Proyectos.*;


public class Menus {
    public static void menuInicio(){
        System.out.println("Seleccione qué quiere hacer: \n1. Registro\n2. Iniciar sesión\n3. Salir");
    }
    public static void menuProyectosGestor(){
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Configuración.\n4. Salir");
    }
    public static void menuAdministrador(){
        System.out.println("Seleccione dónde quiere acceder: \n1. Panel de control\n2. Proyectos\n3. Configuración\n4. Salir");
    }
    public static void menuModificarProyecto(){
        System.out.println("Elija qué quiere modificar:\n1.Nombre\n2.Descripcion\n3.Tipo\n4.Cantidad necesaria\n5.Cantidad Financiada" +
                "\n6.Fecha inicio\n7.Fecha fin\n8.Nada");
    }
    public static void menuInversor(){
        System.out.println("Seleccione donde quiere acceder: \n1. Panel de Control\n2. Mis inversiones\n3. Proyectos\n4. Cartera Virtual\n5. Configuración\n6. Salir");
    }
    public static void menuConfiguracion(){
        System.out.println("Seleccione qué quiere hacer:");
        System.out.println("1. Cambiar usuario\n2. Cambiar contraseña\n3.Salir");
    }

    public static void bloquearDesbloquearUsuario (int opcion, int posicion, String[][] datosGestores, String[][] datosInversores, boolean[] gestoresBloqueados,boolean[] inversoresBloqueados) {
        switch (opcion) {
            case 1 -> {
                if ((posicion >= 0 && posicion<gestoresBloqueados.length) && datosGestores[0][posicion]!=null) {
                    if (!gestoresBloqueados[posicion]) gestoresBloqueados[posicion] = true;
                    else gestoresBloqueados[posicion]=false;
                }
                else System.out.println("Este usuario no existe.");
            }
            case 2 -> {
                if ((posicion >= 0 && posicion<inversoresBloqueados.length) && datosInversores[0][posicion]!=null) {
                    if (!inversoresBloqueados[posicion]) inversoresBloqueados[posicion] = true;
                    else inversoresBloqueados[posicion]=false;
                }
                else System.out.println("Este usuario no existe.");
            }
            default -> System.out.println("");
        }
    }
    public static void panelControlAdmin(){
        int opcion;
        do {
            System.out.println("Menú del panel de control de usuarios, estos son los usuarios del sistema.");
            System.out.println("Seleccione que tipo de usuario desea administrar.\n1. Gestor.\n2. Inversor.\n3. Salir");
            opcion = leerOpcionNumerica();
            switch (opcion) {
                case 1 -> {
                    for (Usuario u : personas) {
// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
                    }
                }
                case 2 -> ;
            }
            if (opcion != 3) {

                System.out.println("Seleccione el usuario que desea bloquear/habilitar:");
                int posicion = leerOpcionNumerica();
                bloquearDesbloquearUsuario(opcion, posicion, datosGestores, datosInversores, gestoresBloqueados, inversoresBloqueados);
            }
        } while (opcion != 3);
    }

    public static void menuAdmin (GestionUsuarios usuarios, GestionProyectos proyectos) {
        int primerSubmenu, segundoSubmenu, tercerSubmenu;
        do {
            menuAdministrador();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu) {
                case 1 -> panelControlAdmin();
                case 2 -> {
                    do {
                        proyectos.mostrarProyectos(1);
                        segundoSubmenu = leerOpcionNumerica();
                        if (segundoSubmenu > 0 && segundoSubmenu <= proyectos.getCantidadProyectos()) {
                            System.out.println("¿Quiere eliminar el proyecto? [S]í | [N]o");
                            String respuesta = leerOpcionLiteral();

                            if (respuesta.equalsIgnoreCase("s")) {
                                proyectos.eliminarProyecto(segundoSubmenu);
                            } else if (respuesta.equalsIgnoreCase("n")) {
                                System.out.println("¿Quiere modificar el proyecto? [S]í | [N]o");
                                respuesta = leerOpcionLiteral();
                                if (respuesta.equalsIgnoreCase("s")) {
                                    do {
                                        menuModificarProyecto();
                                        tercerSubmenu = leerOpcionNumerica();
                                        switch (tercerSubmenu) {
                                            case 1 -> proyectos.modificarProyecto(segundoSubmenu, cambiarNombreProyecto(), null, null, null, null, 0, 0);
                                            case 2 -> proyectos.modificarProyecto(segundoSubmenu, null, cambiarDescripcionProyecto(), null, null, null, 0, 0);
                                            case 3 -> proyectos.modificarProyecto(segundoSubmenu, null, null, cambiarTipoProyecto(), null, null, 0, 0);
                                            case 4 -> proyectos.modificarProyecto(segundoSubmenu, null, null, null, cambiarFechaInicio(), null, 0, 0);
                                            case 5 -> proyectos.modificarProyecto(segundoSubmenu, null, null, null, null, cambiarFechaFin(), 0, 0);
                                            case 6 -> proyectos.modificarProyecto(segundoSubmenu, null, null, null, null, null, cambiarCantidadNecesaria(), 0);
                                            case 7 -> proyectos.modificarProyecto(segundoSubmenu, null, null, null, null, null, 0, cambiarCantidadFinanciada());

                                            default -> System.out.println("Invalid response");
                                        }
                                    } while (tercerSubmenu != 8);
                                }
                            }
                        } else if (segundoSubmenu == 0)
                            proyectos.proyectosDetallados();
                    } while (segundoSubmenu != -1);
                }
              //  case 3 -> modificarCuenta(datosAdmins);
            }
        } while (primerSubmenu != 4);
    }

    public static void menuGestor(GestionUsuarios usuario, GestionProyectos proyectos){
        int primerSubmenu, segundoSubmenu, tercerSubmenu;
            do {
                menuProyectosGestor();
                primerSubmenu = leerOpcionNumerica();
                switch (primerSubmenu){
                    case 1 ->proyectos.mostrarProyectos(0); //EL TIPO ES 0 PORQUE SI PONEMOS 1 SALE MAS INFO PARA EL ADMIN
                    case 2 ->{
                        proyectos.crearProyecto();
                }

            } while (primerSubmenu != 4);

    }

    public static void menuInversor(GestionUsuarios usuarios, GestionProyectos proyectos){
        int primerSubmenu, segundoSubmenu, tercerSubmenu;
        String respuesta;
        double respuestaDouble;
            do {
                menuInversor();
                primerSubmenu = leerOpcionNumerica();
                switch (primerSubmenu) {
                    case 1 -> {
                        /*System.out.println(RED + "Nombre del proyecto\t\t\t" + GREEN + "Tipo del proyecto" + RESET);
                                       for (int i = 0; i < invirtioInvesorEnProyecto.length; i++) {
                                           if (invirtioInvesorEnProyecto[0][i])
                                               System.out.println(RED + proyectsStringData[0][i] + "\t\t\t\t" + GREEN + proyectsStringData[2][i] + RESET);
                                       }*/
                    }
                    case 2 -> {
                                        /*for (int i = 0; i < invirtioInvesorEnProyecto.length; i++) {
                                            if (invirtioInvesorEnProyecto[0][i])
                                                mostrarInversionEnProyecto(proyectsStringData[0][i], proyectsStringData[2][i], cantidadesInvirtioInversoresProyectos[0][i]);
                                        }*/
                    }
                    case 3 -> {
                        proyectos.mostrarProyectos(seleccionTipoUsuario);
                        System.out.println(RED + "¿Quieres ver más detalles sobre los proyectos?" + RESET);
                        respuesta = leerOpcionLiteral();
                        if (respuesta.equalsIgnoreCase("si")) {
                            proyectos.proyectosDetallados();
                        }
                        System.out.println(RED + "¿Quieres invertir en algún proyecto?" + RESET);
                        respuesta = leerOpcionLiteral();
                        if (respuesta.equalsIgnoreCase("si")) {
                            do {
                                proyectos.menuProyectos();
                                segundoSubmenu = leerOpcionNumerica();
                                if (proyectos.noEstaVacio(segundoSubmenu)) {
                                    proyectos.mostrarCantidades(segundoSubmenu);
                                    System.out.println(RED + "¿Cuánto desea invertir?" + RESET);
                                    respuestaDouble = leerOpcionDouble();
                                    if (respuestaDouble <= dineroInversores[0]) {
                                                    /*    invirtioInvesorEnProyecto[0][segundoSubmenu] = true;
                                                        proyectsFinantialData[1][segundoSubmenu] += respuestaDouble;
                                                        cantidadesInvirtioInversoresProyectos[0][segundoSubmenu] += respuestaDouble;
                                                        dineroInversores[0] -= respuestaDouble;*/
                                    } else
                                        System.out.println("No cuentas con saldo suficiente para realizar este tipo de operación");

                                } else System.out.println("Este proyecto no está disponible");
                            } while ((segundoSubmenu > 0 && segundoSubmenu <= proyectos.getCantidadProyectos()));
                        }
                    }
                    case 4 -> {
                        System.out.println("Tienes " + dineroInversores[0] + "€");
                        System.out.print("Introduzca el saldo que quiere añadir a su cartera digital: ");
                        dineroInversores[posicionAccesoExitoso] += leerOpcionDouble();
                    }
                    case 5 -> modificarCuenta(datosInversores);
                }
            } while (primerSubmenu != 6);
    }
}
