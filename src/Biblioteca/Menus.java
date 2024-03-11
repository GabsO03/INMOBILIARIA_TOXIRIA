package Biblioteca;
import CodigoFuente.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static Biblioteca.AccountSettings.modificarCuenta;
import static Biblioteca.Lectura_De_Datos.*;
import static Biblioteca.Proyectos.*;


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
        System.out.println("Elija qué quiere modificar: \n1.Nombre\n2.Descripcion\n3.Tipo\n4.Cantidad necesaria\n5.Cantidad Financiada" +
                "\n6.Fecha inicio\n7.Fecha fin\n8.Nada");
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
        System.out.println("1. Cambiar contraseña\n2. Cambiar email\n3. Salir");
    }
    /**
     * Muestra el panel de control de cada usuario
     */
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
                                                                case 1 ->
                                                                        proyectos.modificarProyecto(posProyecto, cambiarNombreProyecto(), null, null, null, null, 0, 0);
                                                                case 2 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, cambiarDescripcionProyecto(), null, null, null, 0, 0);
                                                                case 3 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, null, cambiarTipoProyecto(), null, null, 0, 0);
                                                                case 4 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, null, null, cambiarFechaInicio(), null, 0, 0);
                                                                case 5 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, null, null, null, cambiarFechaFin(), 0, 0);
                                                                case 6 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, null, null, null, null, cambiarCantidadNecesaria(), 0);
                                                                case 7 ->
                                                                        proyectos.modificarProyecto(posProyecto, null, null, null, null, null, 0, cambiarCantidadFinanciada());
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
    public static void menuGestor(String username, GestionUsuarios usuarios, GestionProyectos proyectos) {
        int primerSubmenu;
        do {
            menuProyectosGestor();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu) {
                case 1 -> proyectos.mostrarProyectos(0); //EL TIPO ES 0 PORQUE SI PONEMOS 1 SALE MAS INFO PARA EL ADMIN
                case 2 ->
                        proyectos.crearProyecto(cambiarNombreProyecto(), cambiarDescripcionProyecto(), cambiarTipoProyecto(), cambiarFechaInicio(), cambiarFechaFin(), cambiarCantidadNecesaria(), cambiarCantidadFinanciada());
                case 3 -> modificarCuenta(username, usuarios);
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
            if (megaGestionInversiones.get(i).getPropietario() == inversor) return i;
        }
        return -1;
    }

    /**
     * Funcion para buscar un determinado proyecto
     * @param proyectos un objeto de la clase GestionProyectos
     */
    public static void buscarProyecto (GestionProyectos proyectos) {
        int tipoBusqueda, position;
        String atributo, valor, valorInicial, valorFinal;
        do {
            System.out.println("Elija el tipo de busqueda.\n1. Por atributo simple.\n2. Por rango.\n3. Cancelar");
            tipoBusqueda = leerOpcionNumerica();
            switch (tipoBusqueda) {
                case 1 -> {
                    System.out.println("Introduzca el atributo del proyecto (Nombre || Tipo || Descripcion || Fecha de inicio/fin || Cantidad necesaria/financiada):");
                    atributo = leerOpcionLiteral();
                    System.out.println("Introduzca el valor (fecha dd/mm/yyyy):");
                    valor = leerOpcionLiteral();
                    position = proyectos.buscarProyecto(atributo, valor);
                    System.out.println(proyectos.devuelveProyecto(position));
                }
                case 2 -> {
                    System.out.println("Introduzca el atributo del proyecto (Fecha de inicio/fin || Cantidad necesaria/financiada):");
                    atributo = leerOpcionLiteral();
                    System.out.println("Introduzca el valor inicial (fecha dd/mm/yyyy):");
                    valorInicial = leerOpcionLiteral();
                    System.out.println("Introduzca el valor final (fecha dd/mm/yyyy):");
                    valorFinal = leerOpcionLiteral();
                    proyectos.buscarProyectoRango(atributo, valorInicial, valorFinal);
                }
                case 3 -> System.out.println();
                default -> System.out.println("Invalid response.");
            }
        } while (tipoBusqueda != 3);
    }

    /**
     * Funcion para mostrar y añadir saldo al inversor
     * @param inversor como objeto de la clase Inversor
     */
    public static void mostrarYAniadirSaldo(Inversor inversor){
        String respuesta;
        double cantidad;
        System.out.println("Tu saldo actual es de " + inversor.getSaldo() );
        System.out.println("¿Quieres añadir saldo? (Sí o No)");
        respuesta=leerOpcionLiteral();
        if(respuesta.equalsIgnoreCase("Sí")){
            System.out.println("Introduce cuanto saldo quieres añadir");
            cantidad=leerOpcionDouble();
            inversor.setSaldo(inversor.getSaldo() + cantidad);
            System.out.println("Tu saldo ahora es de " + inversor.getSaldo());
        } else System.out.println("Cancelando.");
    }
    /**
     * Muestra el segundo menu del inversor
     */
    public static void menuInversor(String username, GestionUsuarios usuarios, GestionProyectos proyectos, ArrayList<GestionInversiones> megaGestionInversiones) {
        Inversor aux = (Inversor) usuarios.devuelveUsuario(username);
        int primerSubmenu, opcionInversion, gestionIndividual = encuentraGestionInversiones(megaGestionInversiones, aux);
        do {
            menuOpcinesInversor();
            primerSubmenu = leerOpcionNumerica();
            switch (primerSubmenu) {
                case 1 -> megaGestionInversiones[gestionIndividual].mostrarMisInversiones();
                case 2 -> buscarProyecto(proyectos);
                case 3 -> {
                    System.out.println("1. Nueva inversión\n2. Actualizar inversión\n3. Cancelar");
                    opcionInversion = leerOpcionNumerica();
                    switch (opcionInversion) {
                        case 1 -> nuevaInversion(proyectos, megaGestionInversiones[gestionIndividual], aux);
                        case 2 -> actualizarInversion(proyectos, megaGestionInversiones[gestionIndividual]);
                        case 3 -> System.out.println();
                        default -> System.out.println("Invalid response.");
                    }
                }
                case 4 -> mostrarYAniadirSaldo(aux);
                case 5 -> modificarCuenta(username, usuarios);
            }
        } while (primerSubmenu != 6);
    }

    /**
     * Funcion para realizar una nueva inversion
     * @param proyectos como objeto de la clase GestionProyectos
     * @param inversiones proyectos como objeto de la clase GestionInversiones
     * @param propietario proyectos como objeto de la clase Inversor
     */
    public static void nuevaInversion (GestionProyectos proyectos, GestionInversiones inversiones, Inversor propietario) {
        String respuesta;
        double cantidadParticipativa;
        LocalDate date;
        System.out.println("Escriba el nombre del proyecto en el que quiere invertir");
        inversiones.proyectosAunNoInvertidos(proyectos);
        respuesta = leerOpcionLiteral();
        int pos = proyectos.buscarProyecto("nombre", respuesta);
        if (pos >= 0) {
            System.out.println("Introduzca la cantidad que quieres invertir en el proyecto:");
            cantidadParticipativa = leerOpcionDouble();
            date = LocalDate.now();
            inversiones.nuevaInversion(propietario, proyectos.devuelveProyecto(pos), cantidadParticipativa, date);
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
        LocalDate fechaActualizacion;
        System.out.println("Escribe el nombre del proyecto que actualizar");
        inversiones.mostrarMisInversiones();
        respuesta = leerOpcionLiteral();
        int pos = proyectos.buscarProyecto("nombre", respuesta);
        if (pos >= 0) {
            System.out.println("Introduzca la cantidad que quieres añadir en el proyecto:");
            cantidadParticipativa = leerOpcionDouble();
            fechaActualizacion = LocalDate.now();
            inversiones.actualizarInversion(pos, cantidadParticipativa, fechaActualizacion);
        } else System.out.println("Ese proyecto no existe o escribiste el nombre incorrectamente.");
    }

}
