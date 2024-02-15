package CodigoFuente;


//COLORES
import java.time.LocalDate;

import static Biblioteca.Colores.RED;
import static Biblioteca.Colores.GREEN;
import static Biblioteca.Colores.RESET;

//MENUS
import static Biblioteca.AccountSettings.enviarCorreo;

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
        GestionUsuarios usuarios=new GestionUsuarios(50);
        //BLOQUEOS


        //PROYECTOS
        GestionProyectos proyectos = new GestionProyectos(20);
        proyectos.crearProyecto("Villa verde", "La villa más fea","Plusvalía", LocalDate.now(), LocalDate.now().plusMonths(5), 4521.56f, 521.56f);
        proyectos.crearProyecto("Villa azul", "La villa más bonita", "Préstamo", LocalDate.now().plusDays(5), LocalDate.now().plusMonths(9), 85112.54, 5112.54);

        //INVERSOR
        double[] dineroInversores = new double[cantidadInversores];
        double respuestaDouble;
        String respuesta;

        //Menus
        int seleccionTipoUsuario,seleccionInicial,codigoUsuario = 0;
        int primerSubmenu,segundoSubmenu,tercersubmenu, contadorProyectos = 0;
        //REGISTRO
        String nombre, nuevoUsuario, correoNuevoUsuario,passNuevoUsuario,passRepetidaNuevoUsuario,tipoNuevoUsuario;
        boolean registroCorrecto=false;


        do {
            menuInicio();
            seleccionInicial=leerOpcionNumerica();
            if (seleccionInicial==1){
                do {
                    do {
                        System.out.println("Escriba su tipo de usuario (I)Inversor (G)Gestor: ");
                        tipoNuevoUsuario = leerOpcionLiteral();
                        if (!tipoNuevoUsuario.equalsIgnoreCase("G") && !tipoNuevoUsuario.equalsIgnoreCase("I")) {
                            System.out.println("Error, tiene que escribir 'G' o 'I'");
                        }
                    } while (!tipoNuevoUsuario.equalsIgnoreCase("G") && !tipoNuevoUsuario.equalsIgnoreCase("I"));


                } while (!registroCorrecto);
                if (tipoNuevoUsuario.equalsIgnoreCase("G")){
                    System.out.println("Escriba su nombre comlpeto: ");
                    nombre=leerOpcionLiteral();
                    System.out.println("Escriba su nombre de usuario: ");
                    nuevoUsuario=leerOpcionLiteral();
                    do {
                        System.out.println("Escriba su contraseña: ");
                        passNuevoUsuario=leerOpcionLiteral();
                        System.out.println("Vuelva a escribir su contraseña: ");
                        passRepetidaNuevoUsuario=leerOpcionLiteral();
                        if (!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario)) System.out.println("Error, las contraseñas deben de ser iguales\nVuelva a intentarlo");
                    }while (!comprobarFortalezaPass(passNuevoUsuario)&&!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario));
                    System.out.println("Escriba su email: ");
                    correoNuevoUsuario=leerOpcionLiteral();

                        int codigoEnviado = (int) (Math.random() * 99999) + 10000;
                        System.out.println("Se está enviando un código de verificacion...");
                        enviarCorreo(correoNuevoUsuario,"Correo de verificación","Su código de verificación es: "+ codigoEnviado);
                        System.out.println("Revise su bandeja de entrada y escriba el código");
                        codigoUsuario=leerOpcionNumerica();
                        if (codigoEnviado!=codigoUsuario) System.out.println("ERROR, el código no es correcto");
                        else{
                            usuarios.insertarUsuarioGestor(nombre,nuevoUsuario,passNuevoUsuario,correoNuevoUsuario);
                            System.out.println("Usuario registrado correctamente");
                        }



                }else {
                    System.out.println("Escriba su nombre comlpeto: ");
                    nombre=leerOpcionLiteral();
                    System.out.println("Escriba su nombre de usuario: ");
                    nuevoUsuario=leerOpcionLiteral();
                    do {
                        System.out.println("Escriba su contraseña: ");
                        passNuevoUsuario=leerOpcionLiteral();
                        System.out.println("Vuelva a escribir su contraseña: ");
                        passRepetidaNuevoUsuario=leerOpcionLiteral();
                        if (!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario)) System.out.println("Error, las contraseñas deben de ser iguales\nVuelva a intentarlo");
                    }while (!comprobarFortalezaPass(passNuevoUsuario)&&!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario));
                    System.out.println("Escriba su email: ");
                    correoNuevoUsuario=leerOpcionLiteral();

                    int codigoEnviado = (int) (Math.random() * 99999) + 10000;
                    System.out.println("Se está enviando un código de verificacion...");
                    enviarCorreo(correoNuevoUsuario,"Correo de verificación","Su código de verificación es: "+ codigoEnviado);
                    System.out.println("Revise su bandeja de entrada y escriba el código");
                    codigoUsuario=leerOpcionNumerica();
                    if (codigoEnviado!=codigoUsuario) System.out.println("ERROR, el código no es correcto");
                    else{
                        usuarios.insertarUsuarioInversor(nombre,nuevoUsuario,passNuevoUsuario,correoNuevoUsuario);
                        System.out.println("Usuario registrado correctamente");
                    }

                }
                // TODO: 14/02/2024 CONTINUAR CON LOS USUARIOS (NO PREOCUPARSE POR LOS ERRORES :)🩵 ) 




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
                                if (primerSubmenu == 1) proyectos.mostrarNombreTipoProyecto();
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
                        } else System.out.println("Su usuario está bloqueado, contacte con el administrador para desbloquearlo");
                    }
                } while (seleccionTipoUsuario != 4);
            }
        }while(seleccionInicial!=3);
    }
}