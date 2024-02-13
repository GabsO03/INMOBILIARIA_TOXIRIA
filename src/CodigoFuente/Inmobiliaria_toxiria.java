package CodigoFuente;


//COLORES
import java.time.LocalDate;

import static Biblioteca.Colores.RED;
import static Biblioteca.Colores.GREEN;
import static Biblioteca.Colores.RESET;

//MENUS
import static Biblioteca.AccountSettings.enviarCorreo;


import static Biblioteca.Inversiones.mostrarInversionEnProyecto;
import static Biblioteca.Inversiones.mostrarCantidades;
//LEER TEXTO
import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;
import static Biblioteca.Lectura_De_Datos.leerOpcionNumerica;

//LOGIN
import static Biblioteca.AccountSettings.login;
import static Biblioteca.AccountSettings.modificarCuenta;
import static Biblioteca.AccountSettings.entry;
import static Biblioteca.funcionesCadenas.comprobarFortalezaPass;

//PROYECTOS
import static Biblioteca.Menus.*;
import static Biblioteca.Proyectos.cambiarDescripcionProyecto;
import static Biblioteca.Proyectos.cambiarCantidadNecesaria;
import static Biblioteca.Proyectos.cambiarNombreProyecto;
import static Biblioteca.Proyectos.cambiarCantidadFinanciada;
import static Biblioteca.Proyectos.cambiarFechaFin;
import static Biblioteca.Proyectos.cambiarFechaInicio;
import static Biblioteca.Proyectos.cambiarTipoProyecto;

public class Inmobiliaria_toxiria {

    public static void main(String[] args) {
        //USUARIOS
        int cantidadAdmins = 2, cantidadGestores = 4, cantidadInversores = 4;

        //Usuarios que ya existen jejeje
        String[][] datosAdmins = new String[4][cantidadAdmins];
        String[][] datosGestores = new String[5][cantidadGestores];
        String[][] datosInversores = new String[5][cantidadInversores];

        datosAdmins[0][0]= "Adrian";
        datosAdmins[0][1]= "Eladio";
        datosAdmins[1][0]= "adrianCb";
        datosAdmins[1][1]= "eladioBl";
        datosAdmins[2][0]= "easyPass";
        datosAdmins[2][1]= "hjdsfn74";

        datosGestores[0][0]= "Gabriel";
        datosGestores[0][1]= "Alex";
        datosGestores[1][0]= "gabOp";
        datosGestores[1][1]= "alexGb";
        datosGestores[2][0]= "ncfv55&%%";
        datosGestores[2][1]= "ghvh8858";
        datosGestores[3][0]="gestorinmobiliaria@yopmail.com";
        datosGestores[3][1]="gestor2inmobiliaria@yopmail.com";

        datosInversores[0][0]= "Alejandro";
        datosInversores[0][1]= "Jesús";
        datosInversores[1][0]= "aloOp";
        datosInversores[1][1]= "jesusMm";
        datosInversores[2][0]= "jbhk5&84";
        datosInversores[2][1]= "fx55fxh$43";
        datosInversores[3][0]= "inversor1inmobiliaria@yopmail.com";
        datosInversores[3][1]= "inversor2inmobiliaria@yopmail.com";


        //BLOQUEOS
        boolean[] gestoresBloqueados = new boolean[cantidadGestores];
        boolean[] inversoresBloqueados = new boolean[cantidadInversores];
        gestoresBloqueados[0] = true;
        inversoresBloqueados[1] = true;

        //PROYECTOS
        GestionProyectos proyectos = new GestionProyectos(20);
        proyectos.crearProyecto("Villa verde", "La villa más fea","Plusvalía", LocalDate.now(), LocalDate.now().plusMonths(5), 4521.56f, 521.56f);
        proyectos.crearProyecto("Villa azul", "La villa más bonita", "Préstamo", LocalDate.now().plusDays(5), LocalDate.now().plusMonths(9), 85112.54, 5112.54);


/*        int cantidadProyectos = 20;
        String[][] proyectsStringData = new String[5][cantidadProyectos];
        double[][] proyectsFinantialData = new double[2][cantidadProyectos];
        proyectsStringData[0][0]=;
        proyectsStringData[0][1]=;
        proyectsStringData[0][15]="Villa rojo";
        proyectsStringData[0][19]="Villa pink";
        proyectsStringData[1][0]=;
        proyectsStringData[1][1]="La villa más fghjg";
        proyectsStringData[1][15]="La villa más kokomkk";
        proyectsStringData[1][19]=;
        proyectsStringData[2][0]="Tipo 0";
        proyectsStringData[2][1]="Tipo 1";
        proyectsStringData[2][15]="Tipo 15";
        proyectsStringData[2][19]="Tipo 19";
        proyectsFinantialData[0][0]=;
        proyectsFinantialData[0][1]=;
        proyectsFinantialData[0][15]=10000;
        proyectsFinantialData[0][19]=500;
        proyectsFinantialData[1][0]=;
        proyectsFinantialData[1][1]=;
        proyectsFinantialData[1][15]=100;
        proyectsFinantialData[1][19]=15;*/


        //INVERSOR
        double[] dineroInversores = new double[cantidadInversores];
        double respuestaDouble;
        String respuesta;

        double[][] cantidadesInvirtioInversoresProyectos = new double[10][20];
        boolean[][] invirtioInvesorEnProyecto = new boolean[10][20];

        //Menus
        int seleccionTipoUsuario,seleccionInicial,codigoUsuario;
        int primerSubmenu,segundoSubmenu,tercersubmenu, contadorProyectos = 0;
        //REGISTRO
        String nombre, nuevoUsuario, correoNuevoUsuario,passNuevoUsuario,passRepetidaNuevoUsuario,tipoNuevoUsuario;
        boolean registroCorrecto=false;


        do {
            menuInicio();
            seleccionInicial=leerOpcionNumerica();
            if (seleccionInicial==1){
                do {
                    int codigoEnviado = (int) (Math.random() * 99999) + 10000;
                    do {
                        System.out.println("Escriba su tipo de usuario (I)Inversor (G)Gestor: ");
                        tipoNuevoUsuario = leerOpcionLiteral();
                        if (!tipoNuevoUsuario.equalsIgnoreCase("G") && !tipoNuevoUsuario.equalsIgnoreCase("I")) {
                            System.out.println("Error, tiene que escribir 'G' o 'I'");
                        }
                    } while (!tipoNuevoUsuario.equalsIgnoreCase("G") && !tipoNuevoUsuario.equalsIgnoreCase("I"));

                    int pos = 0;
                    boolean hayPlaza = false;
                    if (tipoNuevoUsuario.equalsIgnoreCase("G")){
                        while (pos < datosGestores[0].length && !hayPlaza) {
                            if (datosGestores[0][pos] == null) hayPlaza = true;
                            else pos++;
                        }
                    }
                    else {
                        while (pos < datosInversores[0].length && !hayPlaza) {
                            if (datosInversores[0][pos] == null) hayPlaza = true;
                            else pos++;
                        }
                    }

                    if (hayPlaza){
                        System.out.println("Escriba su usuario: ");
                        nuevoUsuario = leerOpcionLiteral();
                        do {
                            System.out.println("Escriba su contraseña: ");
                            passNuevoUsuario = leerOpcionLiteral();
                        }while(!comprobarFortalezaPass(passNuevoUsuario));
                        do {
                            System.out.println("Escriba su contraseña de nuevo: ");
                            passRepetidaNuevoUsuario = leerOpcionLiteral();
                            if (!passNuevoUsuario.equals(passRepetidaNuevoUsuario)) System.out.println("Las contraseñas no coinciden");
                        }while(!passRepetidaNuevoUsuario.equals(passNuevoUsuario));

                        System.out.println("Escriba su correo electrónico:");
                        correoNuevoUsuario = leerOpcionLiteral();
                        System.out.println("Se está enviando un correo de verificación para su nuevo usuario...");
                        enviarCorreo(correoNuevoUsuario, "Correo de verificación", "Su código de verificación es:" + codigoEnviado);
                        System.out.println("Correo enviado, escriba su código de verificación: ");
                        codigoUsuario = leerOpcionNumerica();
                        if (codigoEnviado == codigoUsuario) {
                            System.out.println("Usuario registrado correctamente");
                            System.out.println("Escriba su nombre");
                            nombre=leerOpcionLiteral();
                            if (tipoNuevoUsuario.equalsIgnoreCase("G")) {
                                datosGestores[0][pos] = nombre;
                                datosGestores[1][pos] = nuevoUsuario;
                                datosGestores[2][pos] = passNuevoUsuario;
                                datosGestores[3][pos] = correoNuevoUsuario;
                                gestoresBloqueados[pos] = false;
                            }
                            if (tipoNuevoUsuario.equalsIgnoreCase("I")) {
                                datosInversores[0][pos] = nombre;
                                datosInversores[1][pos] = nuevoUsuario;
                                datosInversores[2][pos] = passNuevoUsuario;
                                datosInversores[3][pos] = correoNuevoUsuario;
                                inversoresBloqueados[pos] = false;
                            }
                            registroCorrecto = true;
                        } else System.out.println("El código no es correcto, vuelve a intentarlo: \n");
                    } else System.out.println("ERROR: CANTIDAD DE USUARIO DE ESTE TIPO EXCEDIDA");
                } while (!registroCorrecto);



            }

            if (seleccionInicial==2){
                do {
                    menuUser();
                    seleccionTipoUsuario = leerOpcionNumerica();
                    int posicionAccesoExitoso = login(seleccionTipoUsuario, datosAdmins, datosGestores, datosInversores, gestoresBloqueados, inversoresBloqueados);
                    boolean entry = entry(seleccionTipoUsuario, posicionAccesoExitoso, cantidadGestores, cantidadInversores);


                    //ADMINISTRADOR
                    if (seleccionTipoUsuario == 1) {
                        do {
                            menuAdministrador();
                            primerSubmenu = leerOpcionNumerica();
                            switch (primerSubmenu) {
                                case 1 ->  panelControlAdmin(datosGestores, datosInversores, gestoresBloqueados, inversoresBloqueados);
                                case 2 -> {
                                    do {

                                        proyectos.mostrarProyectos(seleccionTipoUsuario);

                                        segundoSubmenu = leerOpcionNumerica();
                                        if (segundoSubmenu > 0 && segundoSubmenu <= proyectos.getCantidadProyectos()) {
                                            System.out.println("¿Quiere eliminar el proyecto? [S]í | [N]o");
                                            respuesta = leerOpcionLiteral();

                                            if (respuesta.equalsIgnoreCase("s")) {
                                                proyectos.eliminarProyecto(segundoSubmenu);
                                            } else if (respuesta.equalsIgnoreCase("n")) {
                                                System.out.println("¿Quiere modificar el proyecto? [S]í | [N]o");
                                                respuesta = leerOpcionLiteral();
                                                if (respuesta.equalsIgnoreCase("s")) {
                                                    do {
                                                        menuModificarProyecto();
                                                        tercersubmenu = leerOpcionNumerica();
                                                        switch (tercersubmenu) {
                                                            case 1 ->
                                                                    proyectos.modificarProyecto(segundoSubmenu, cambiarNombreProyecto(), null, null, null, null, 0, 0);
                                                            case 2 ->
                                                                    proyectos.modificarProyecto(segundoSubmenu, null, cambiarDescripcionProyecto(), null, null, null, 0, 0);
                                                            case 3 ->
                                                                    proyectos.modificarProyecto(segundoSubmenu, null, null, cambiarTipoProyecto(), null, null, 0, 0);
                                                            case 4 ->
                                                                    proyectos.modificarProyecto(segundoSubmenu, null, null, null, cambiarFechaInicio(), null, 0, 0);
                                                            case 5 ->
                                                                    proyectos.modificarProyecto(segundoSubmenu, null, null, null, null, cambiarFechaFin(), 0, 0);
                                                            case 6 ->
                                                                    proyectos.modificarProyecto(segundoSubmenu, null, null, null, null, null, cambiarCantidadNecesaria(), 0);
                                                            case 7 ->
                                                                    proyectos.modificarProyecto(segundoSubmenu, null, null, null, null, null, 0, cambiarCantidadFinanciada());

                                                            default -> System.out.println("Invalid response");
                                                        }
                                                    } while (tercersubmenu != 8);
                                                }
                                            }
                                        } else if (segundoSubmenu == 0)
                                            proyectos.proyectosDetallados();
                                    } while (segundoSubmenu != -1);
                                }
                                case 3 -> modificarCuenta(datosAdmins);
                            }
                        } while (primerSubmenu != 4);
                    }

                    // GESTOR
                    if ((seleccionTipoUsuario == 2) && entry) {
                        if (!gestoresBloqueados[posicionAccesoExitoso]) {
                            do {
                                menuProyectosGestor();
                                primerSubmenu = leerOpcionNumerica();
                                if (primerSubmenu == 1) {
                                    System.out.println(RED + "Nombre del proyecto\t\t\t" + GREEN + "Tipo del proyecto");
                                    for (int i = 0; i < cantidadProyectos; i++) {
                                        if (proyectosHabilitados[i])
                                            System.out.println(RED + proyectsStringData[0][i] + "\t\t\t\t" + GREEN + proyectsStringData[2][i] + RESET);
                                    }
                                    System.out.println("¿Quieres ver más detalles sobre los proyectos? [S]í | [N]o");
                                    respuesta = leerOpcionLiteral();
                                    if (respuesta.equalsIgnoreCase("s")) proyectos.proyectosDetallados();

                                }
                                if (primerSubmenu == 2) {
                                    String name = cambiarNombreProyecto();
                                    String descripcion = cambiarDescripcionProyecto();
                                    String tipo = cambiarTipoProyecto();
                                    LocalDate fechaInicio = cambiarFechaInicio();
                                    LocalDate fechaFin = cambiarFechaInicio();
                                    double cantidadNecesaria = cambiarCantidadNecesaria();
                                    double cantidadFinanciada;
                                do {
                                        cantidadFinanciada = cambiarCantidadFinanciada();
                                        if (cantidadFinanciada > cantidadNecesaria)
                                            System.out.println("El monto excede la cantidad necesaria");
                                    } while (cantidadFinanciada > cantidadNecesaria);
                                proyectos.crearProyecto(name, descripcion, tipo, fechaInicio, fechaFin, cantidadNecesaria, cantidadFinanciada);
                                }

                                if (primerSubmenu == 3) modificarCuenta(datosGestores);
                            } while (primerSubmenu != 4);
                        } else System.out.println("Su usuario está bloqueado, contacte con el administrador del sistema para desbloquearlo");
                    }

                    //INVERSOR
                    if ((seleccionTipoUsuario == 3) && entry) {
                        if (!inversoresBloqueados[posicionAccesoExitoso]) {
                            do {
                                menuInversor();
                                primerSubmenu = leerOpcionNumerica();
                                switch (primerSubmenu) {
                                    case 1 -> {
                                        System.out.println(RED + "Nombre del proyecto\t\t\t" + GREEN + "Tipo del proyecto" + RESET);
                                        for (int i = 0; i < invirtioInvesorEnProyecto.length; i++) {
                                            if (invirtioInvesorEnProyecto[0][i])
                                                System.out.println(RED + proyectsStringData[0][i] + "\t\t\t\t" + GREEN + proyectsStringData[2][i] + RESET);
                                        }
                                    }
                                    case 2 -> {
                                        for (int i = 0; i < invirtioInvesorEnProyecto.length; i++) {
                                            if (invirtioInvesorEnProyecto[0][i])
                                                mostrarInversionEnProyecto(proyectsStringData[0][i], proyectsStringData[2][i], cantidadesInvirtioInversoresProyectos[0][i]);
                                        }
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
                                                menuInversiones(proyectsStringData);
                                                segundoSubmenu = leerOpcionNumerica();
                                                segundoSubmenu--;
                                                if (proyectosHabilitados[segundoSubmenu]) {
                                                    mostrarCantidades(proyectsFinantialData, segundoSubmenu);
                                                    System.out.println(RED + "¿Cuánto desea invertir?" + RESET);
                                                    respuestaDouble = leerOpcionDouble();
                                                    if (respuestaDouble <= dineroInversores[0]) {
                                                        invirtioInvesorEnProyecto[0][segundoSubmenu] = true;
                                                        proyectsFinantialData[1][segundoSubmenu] += respuestaDouble;
                                                        cantidadesInvirtioInversoresProyectos[0][segundoSubmenu] += respuestaDouble;
                                                        dineroInversores[0] -= respuestaDouble;
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
                        } else System.out.println("Su usuario está bloqueado, contacte con el administrador para desbloquearlo");
                    }
                } while (seleccionTipoUsuario != 4);
            }
        }while(seleccionInicial!=3);
    }
}