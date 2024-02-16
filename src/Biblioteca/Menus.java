package Biblioteca;
import CodigoFuente.*;

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
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Configuración de cuenta.\n4. Salir");
    }
    public static void menuAdministrador(){
        System.out.println("Seleccione dónde quiere acceder: \n1. Panel de control\n2. Proyectos\n3. Configuración\n4. Salir");
    }
    public static void menuModificarProyecto(){
        System.out.println("Elija qué quiere modificar: \n1.Nombre\n2.Descripcion\n3.Tipo\n4.Cantidad necesaria\n5.Cantidad Financiada" +
                "\n6.Fecha inicio\n7.Fecha fin\n8.Nada");
    }
    public static void menuOpcinesInversor(){
        System.out.println("Seleccione donde quiere acceder:\n1. Mis inversiones\n2. Proyectos\n3. Cartera Virtual\n4. Configuración de cuenta\n5. Salir");
    }
    public static void menuConfiguracion(){
        System.out.println("Seleccione qué quiere hacer:");
        System.out.println("1. Cambiar usuario\n2. Cambiar contraseña\n3.Salir");
    }

    public static void panelControlUsuarios(GestionUsuarios usuarios){
        int posicion, opcion;
        do {
            System.out.println("Menú del panel de control de usuarios.");
            usuarios.muestraUsuarios();
            System.out.println("Introduzca el número del usuario que quieras bloquear o desbloquear");
            posicion = leerOpcionNumerica();
            System.out.println("1. Bloquear.\n2. Desbloquear");
            opcion = leerOpcionNumerica();
            usuarios.bloquearDesbloquearUsuario(opcion, posicion);
        } while (posicion != 3);
    }
    public static void misInversiones(GestionInversiones inversiones, Inversor usuario){
        Inversion[] arrayInversiones=inversiones.getInversiones();
        for (Inversion inversion:arrayInversiones) {
            if (inversion!=null && inversion.getInversor()==usuario){
                System.out.println(inversion);
            }
        }
    }
    public static void invertir(){
        double cantidadInvertida;
        System.out.println("Introduzca la cantidad que quieres invertir en el proyecto");
        cantidadInvertida=leerOpcionDouble();
        if(Inversion.financiarProyecto(cantidadInvertida)) System.out.println("Su inversion se ha realizado");
    }

    public static void menuAdmin (GestionUsuarios usuarios, GestionProyectos proyectos) {
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

    public static void menuGestor(int pos, GestionUsuarios usuarios, GestionProyectos proyectos){
        int primerSubmenu;
            do {
                menuProyectosGestor();
                primerSubmenu = leerOpcionNumerica();
                switch (primerSubmenu){
                    case 1 ->proyectos.mostrarProyectos(0); //EL TIPO ES 0 PORQUE SI PONEMOS 1 SALE MAS INFO PARA EL ADMIN
                    case 2 ->proyectos.crearProyecto(cambiarNombreProyecto(),cambiarDescripcionProyecto(),cambiarTipoProyecto(),cambiarFechaInicio(),cambiarFechaFin(),cambiarCantidadNecesaria(),cambiarCantidadFinanciada());
                    case 3 -> modificarCuenta(pos, usuarios);
                }

            } while (primerSubmenu != 4);
    }

    public static void menuInversor(int pos, GestionUsuarios usuarios, GestionProyectos proyectos, GestionInversiones inversiones, Inversor inversor){
        int primerSubmenu;
        do{
            menuOpcinesInversor();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu){
                case 1 -> misInversiones(inversiones, inversor);
                case 2 -> {
                    proyectos.mostrarProyectos(0);
                    if (Inversion.hacerInversion(proyectos)!=-1){
                        invertir(); // TODO: 16/02/2024 QUE SIGA GABI??
                    }
                }
                case 3 -> inversor.mostrarYAniadirSaldo();
                case 4 -> modificarCuenta(pos, usuarios);
            }
        }while (primerSubmenu != 5);
    }
}
