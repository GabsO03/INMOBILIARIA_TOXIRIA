package Biblioteca;
import CodigoFuente.*;

import java.util.ArrayList;

import static Biblioteca.AccountSettings.modificarCuenta;
import static Biblioteca.InversionesVista.*;
import static Biblioteca.Lectura_De_Datos.*;
import static Biblioteca.ProyectosVista.*;
import static Biblioteca.UsuariosVista.mostrarYAniadirSaldo;
import static Biblioteca.UsuariosVista.panelControlUsuarios;


public class Menus {
    /**
     * Funcion que muestra el menu inicial
     */
    public static void menuInicio() {
        System.out.println("Seleccione qué quiere hacer: \n1. Registro\n2. Iniciar sesión\n3. Salir");
    }

    /**
     * Funcion para mostrar el menu de los proyectos del gestor
     */
    public static void menuProyectosGestor() {
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Configuración de cuenta.\n4. Salir");
    }
    /**
     * Muestra el menu del administrador
     */
    public static void menuAdministrador() {
        System.out.println("Seleccione dónde quiere acceder: \n1. Panel de control\n2. Proyectos\n3. Configuración\n4. Salir");
    }
    /**
     * Muestra el menu para modificar algún proyecto
     */
    public static void menuModificarProyecto() {
        System.out.println("Elija qué quiere modificar:\n1. Nombre\n2. Descripcion\n3. Tipo\n4. Cantidad necesaria\n5. Fecha fin\n6. Nada");
    }
    /**
     * Muestra el menu del inversor
     */
    public static void menuOpcinesInversor() {
        System.out.println("Seleccione donde quiere acceder:\n1. Mis inversiones\n2. Buscar proyecto\n3. Invertir\n4. Cartera Virtual\n5. Configuración de cuenta\n6. Salir");
    }
    /**
     * Muestra el menu de la configuracion para todos los usuarios
     */
    public static void menuConfiguracion() {
        System.out.println("Seleccione qué quiere hacer:");
        System.out.println("1. Cambiar nombre de usuario\n2. Cambiar contraseña\n3. Cambiar email\n4. Salir");
    }
    /**
     * Muestra el segundo menu del administrador
     */
    public static void menuAdmin(String username, GestionUsuarios usuarios, GestionProyectos proyectos) {
        int primerSubmenu, segundoSubmenu, tercerSubmenu;
        do {
            menuAdministrador();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu) {
                case 1 -> panelControlUsuarios(usuarios);
                case 2 -> {
                    do {
                        System.out.println("Menú proyectos:\n1. Modificar/Eliminar proyectos\n2. Buscar proyectos\n3. Cancelar");
                        segundoSubmenu = leerOpcionNumerica();
                        switch (segundoSubmenu) {
                            case 1 -> {
                                mostrarProyectos(1, proyectos);
                                segundoSubmenu = leerOpcionNumerica();
                                switch (segundoSubmenu) {
                                    case 1 -> proyectosDetallados(proyectos);
                                    case 2 -> {
                                        System.out.println("Introduzca la posición");
                                        int posProyecto = leerOpcionNumerica();
                                        posProyecto--;
                                        if (posProyecto >= 0 && posProyecto < proyectos.getCantidadProyectos()) {
                                            System.out.println("¿Quiere eliminar el proyecto? [S]í | [N]o");
                                            String respuesta = leerOpcionLiteral();
                                            respuesta = respuesta.toLowerCase();
                                            switch (respuesta) {
                                                case "s" -> System.out.println("El proyecto " + proyectos.eliminarProyecto(posProyecto)  + " se ha eliminado correctamente");
                                                case "n" -> {
                                                    System.out.println("¿Quiere modificar el proyecto? [S]í | [N]o");
                                                    respuesta = leerOpcionLiteral();
                                                    if (respuesta.equalsIgnoreCase("s")) {
                                                        do {
                                                            menuModificarProyecto();
                                                            tercerSubmenu = leerOpcionNumerica();
                                                            switch (tercerSubmenu) {
                                                                case 1 ->
                                                                        proyectos.modificarProyecto(posProyecto, cambiarNombreProyecto(), null, null, null, null, 0, 0);
                                                                case 2 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, cambiarDescripcionProyecto(), null, null, null, 0, 0);
                                                                case 3 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, null, cambiarTipoProyecto(), null, null, 0, 0);
                                                                case 4 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, null, null, null, cambiarFechaFin(), 0, 0);
                                                                case 5 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, null, null, null, null, cambiarCantidadNecesaria(), 0);
                                                                case 6 -> System.out.println();
                                                                default -> System.out.println("Respuesta no válida.");
                                                            }
                                                        } while (tercerSubmenu != 6);
                                                    }
                                                }
                                            }
                                        } else System.out.println("Proyecto no encontrado.");
                                    }
                                    case 3 -> System.out.println();
                                }
                            }
                            case 2 -> buscarProyecto(proyectos);
                        }
                    } while (segundoSubmenu != 3);
                }
                case 3 -> modificarCuenta(username, usuarios);
            }
        } while (primerSubmenu != 4);
    }
    /**
     * Muestra el segundo menu del gestor
     */
    public static void menuGestor(String username, GestionUsuarios usuarios, GestionProyectos proyectos, GestionApp aplicacion) {
        int primerSubmenu;
        do {
            menuProyectosGestor();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu) {
                case 1 -> mostrarProyectos(0, proyectos); //EL TIPO ES 0 PORQUE SI PONEMOS 1 SALE MAS INFO PARA EL ADMIN
                case 2 -> {
                    proyectos.crearProyecto(cambiarNombreProyecto(), cambiarDescripcionProyecto(), cambiarTipoProyecto(), cambiarFechaFin(), cambiarCantidadNecesaria());
                    aplicacion.guardarAJSON();
                }
                case 3 -> modificarCuenta(username, usuarios);
                case 4 -> System.out.println("Saliendo");
                default -> System.out.println("Invalid response");
            }
        } while (primerSubmenu != 4);
    }

    /**
     * Funcion para buscar las inversiones realizadas por un inversor
     * @param megaGestionInversiones como array de objetos de la clase GestionInversiones
     * @param inversor como objeto de la clase Inversor
     * @return un número entero dependiendo de la posición del array donde se encuentre ese usuario o -1 si no se encuentra
     */
    public static int encuentraGestionInversiones (ArrayList<GestionInversiones> megaGestionInversiones, Inversor inversor) {
        for (int i = 0; i < megaGestionInversiones.size(); i++) {
            if (megaGestionInversiones.get(i).getInversor().getUsername().equals(inversor.getUsername())) return i;
        }
        return -1;
    }

    /**
     * Muestra el segundo menu del inversor
     */
    public static void menuInversor(String username, GestionUsuarios usuarios, GestionProyectos proyectos, ArrayList<GestionInversiones> gestionInversiones) {
        int primerSubmenu, opcionInversion, gestionIndividual = encuentraGestionInversiones(gestionInversiones,(Inversor) usuarios.devuelveUsuario(username));
        do {
            menuOpcinesInversor();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu) {
                case 1 -> System.out.println(gestionInversiones.get(gestionIndividual).devuelveMisInversiones());
                case 2 -> buscarProyecto(proyectos);
                case 3 -> {
                    System.out.println("1. Nueva inversión\n2. Actualizar inversión\n3. Cancelar");
                    opcionInversion = leerOpcionNumerica();
                    switch (opcionInversion) {
                        case 1 -> nuevaInversion(proyectos, gestionInversiones.get(gestionIndividual));
                        case 2 -> actualizarInversion(proyectos, gestionInversiones.get(gestionIndividual));
                        case 3 -> System.out.println();
                        default -> System.out.println("Invalid response.");
                    }
                }
                case 4 -> mostrarYAniadirSaldo((Inversor) usuarios.devuelveUsuario(username));
                case 5 -> modificarCuenta(username, usuarios);
            }
        } while (primerSubmenu != 6);
    }



}
