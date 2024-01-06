package CodigoFuente;


import java.rmi.MarshalException;
import java.util.Arrays;
//COLORES
import static Biblioteca.Colores.RED;
import static Biblioteca.Colores.GREEN;
import static Biblioteca.Colores.RESET;

//MENUS
import static Biblioteca.Login.enviarCorreo;
import static Biblioteca.Menus.menuUser;
import static Biblioteca.Menus.menuProyectosGestor;
import static Biblioteca.Menus.menuAdministrador;
import static Biblioteca.Menus.menuModificarProyecto;
import static Biblioteca.Menus.menuInversor;
import static Biblioteca.Menus.menuConfiguracion;
import static Biblioteca.Menus.menuInversiones;
import static Biblioteca.Menus.menuInicio;


import static Biblioteca.Inversiones.mostrarInversionEnProyecto;
import static Biblioteca.Inversiones.mostrarCantidades;
//LEER TEXTO
import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;
import static Biblioteca.Lectura_De_Datos.leerOpcionNumerica;

//LOGIN
import static Biblioteca.Login.login;

//PROYECTOS
import static Biblioteca.Proyectos.mostrarProyectosAdmin;
import static Biblioteca.Proyectos.mostrarProyectosNoAdmin;
import static Biblioteca.Proyectos.cambiarDescripcionProyecto;
import static Biblioteca.Proyectos.cambiarCantidadNecesaria;
import static Biblioteca.Proyectos.cambiarNombreProyecto;
import static Biblioteca.Proyectos.cambiarCantidadFinanciada;
import static Biblioteca.Proyectos.cambiarFechaFin;
import static Biblioteca.Proyectos.cambiarFechaInicio;
import static Biblioteca.Proyectos.cambiarTipoProyecto;
import static Biblioteca.Proyectos.crearDescripcionProyecto;
import static Biblioteca.Proyectos.crearNombreProyecto;
import static Biblioteca.Proyectos.crearTipoProyecto;
import static Biblioteca.Proyectos.crearFFinProyecto;
import static Biblioteca.Proyectos.crearFInicioProyecto;
import static Biblioteca.Proyectos.crearCFinanciadaProyecto;
import static Biblioteca.Proyectos.crearCNecesariaProyecto;
import static Biblioteca.Proyectos.proyectosDetallados;

public class Inmobiliaria_toxiria {
    public static void panelControlAdmin(boolean gestorBloqueado,boolean inversor1Bloqueado,boolean inversor2Bloqueado){
        String gestorBloqueadoCadena="",inversor1BloqueadoCadena="", inversor2BloqueadoCadena="";
        if (gestorBloqueado) gestorBloqueadoCadena="Bloqueado";
        if (inversor1Bloqueado) inversor1BloqueadoCadena="Bloqueado";
        if (inversor2Bloqueado) inversor2BloqueadoCadena="Bloqueado";
        System.out.println("Menú del panel de control de usuarios, estos son los usuarios del sistema:");
        System.out.println("Seleccione cuál quiere bloquear/desbloquear");
        System.out.printf("1.gestor %s\n2.inversor1 %s\n3.inversor2 %s\n4.Salir\n",gestorBloqueadoCadena,inversor1BloqueadoCadena,inversor2BloqueadoCadena);
    }


    public static String cambiarUsuario(String usuarioAntiguoEnviado){
        String usuarioActual,nuevoUsuario;
        System.out.println("Escriba su usuario actual");
        usuarioActual=leerOpcionLiteral();
        if (usuarioActual.equals(usuarioAntiguoEnviado)){
            System.out.println("Escriba el nuevo usuario");
            nuevoUsuario=leerOpcionLiteral();
            return nuevoUsuario;
        }else System.out.println("El usuario actual no es correcto, vuelva a intentarlo");
        return usuarioAntiguoEnviado;
    }
    public static String cambiarcontrasenia(String contraseniaAntiguaEnviado){
        String contraseniaActual,nuevaContrasenia;
        System.out.println("Escriba la contraseña actual");
        contraseniaActual=leerOpcionLiteral();
        if (contraseniaActual.equals(contraseniaAntiguaEnviado)){
            System.out.println("Escriba la nueva contraseña");
            nuevaContrasenia=leerOpcionLiteral();
            return nuevaContrasenia;
        }else System.out.println("La contraseña actual no es correcta, vuelva a intentarlo");
        return contraseniaAntiguaEnviado;
    }

    public static void main(String[] args) {
        //USUARIOS
        String userAdmin="admin",passAdmin="admin",userGestor="gestor",passGestor="gestor",userInversor1="inversor1"
                ,passInversor1="inversor1";
        //NEW ADD t04
        int cantidadAdmins = 2, cantidadGestores = 4, cantidadInversores = 4;
        String[] adminsUsers = new String[cantidadAdmins];   String[] adminsPass = new String[cantidadAdmins];
        String[] gestorUsers = new String[cantidadGestores];   String[] gestorPass = new String[cantidadGestores]; String[] gestorMail= new String[cantidadGestores];
        String[] inversorUsers = new String[cantidadInversores];   String[] inversorPass = new String[cantidadInversores];String[] inversorMail= new String[cantidadInversores];

        //Usuarios que ya existen jejeje
        String[][] datosAdmins = new String[5][cantidadAdmins];
        String[][] datosGestores = new String[5][cantidadGestores];
        String[][] datosInversores = new String[5][cantidadInversores];

        datosAdmins[0][0]= "Adrian";
        datosAdmins[0][1]= "Eladio";
        datosAdmins[1][0]= "adrianCb";
        datosAdmins[1][1]= "eladioBl";
        datosAdmins[2][0]= "5565sf6d$";
        datosAdmins[2][1]= "hjdsfn74";

        datosGestores[0][0]= "Gabriel";
        datosGestores[0][1]= "Alex";
        datosGestores[1][0]= "gabOp";
        datosGestores[1][1]= "alexGb";
        datosGestores[2][0]= "ncfv55&%%";
        datosGestores[2][1]= "ghvh8858";

        datosInversores[0][0]= "Alejandro";
        datosInversores[0][1]= "Jesús";
        datosInversores[1][0]= "aloOp";
        datosInversores[1][1]= "jesusMm";
        datosInversores[2][0]= "jbhk5&84";
        datosInversores[2][1]= "fx55fxh$43";
        datosInversores[3][0]= "inversor1inmobiliaria@yopmail.com";
        datosInversores[3][1]= "inversor2inmobiliaria@yopmail.com";


        //BLOQUEOS
        boolean gestorBloqueado=false,inversor1Bloqueado=false,inversor2Bloqueado=false;
        //PROYECTOS
        boolean[] proyectosHabilitados = new boolean[20];

        //new add t04 array bidim para los proyectos
        int cantidadProyectos = 20;
        String[][] proyectsStringData = new String[5][cantidadProyectos];
        double[][] proyectsFinantialData = new double[2][cantidadProyectos];
        proyectsStringData[0][0]="Villa verde";
        proyectsStringData[0][1]="Villa azul";
        proyectsStringData[0][15]="Villa rojo";
        proyectsStringData[0][19]="Villa pink";
        proyectsStringData[1][0]="La villa más fea";
        proyectsStringData[1][1]="La villa más fghjg";
        proyectsStringData[1][15]="La villa más kokomkk";
        proyectsStringData[1][19]="La villa más bonita";
        proyectsStringData[2][0]="Tipo 0";
        proyectsStringData[2][1]="Tipo 1";
        proyectsStringData[2][15]="Tipo 15";
        proyectsStringData[2][19]="Tipo 19";
        proyectsFinantialData[0][0]=4521.56;
        proyectsFinantialData[0][1]=85112.54;
        proyectsFinantialData[0][15]=10000;
        proyectsFinantialData[0][19]=500;
        proyectsFinantialData[1][0]=521.56;
        proyectsFinantialData[1][1]=5112.54;
        proyectsFinantialData[1][15]=100;
        proyectsFinantialData[1][19]=15;


        //INVERSOR
        double[] dineroInversores = new double[cantidadInversores];
        double respuestaDouble;
        String respuesta;

        double[][] cantidadesInvirtioInversoresProyectos = new double[10][20];
        boolean[][] invirtioInvesorEnProyecto = new boolean[10][20];

        //Menus
        int seleccionTipoUsuario,seleccionInicial,codigoUsuario;
        int primerSubmenu,segundoSubmenu,tercersubmenu, contadorProyectos = 0;
        for (int i = 0; i < proyectsStringData[0].length; i++) if (proyectsStringData[0][i]!=null) contadorProyectos++;
        //REGISTRO
        String nombreNuevoUsuario, correoNuevoUsuario,passNuevoUsuario,tipoNuevoUsuario;
        boolean registroCorrecto=false;
        int contadorInversores=1;
        int contadorGestores=1;
        int contadorCorreosGestor=1;
        int contadorCorreosInversor=1;


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


                        System.out.println("Escriba su nombre de usuario: ");
                        nombreNuevoUsuario = leerOpcionLiteral();
                        System.out.println("Escriba su contraseña: ");
                        passNuevoUsuario = leerOpcionLiteral();
                        //LÓGICA PARA CONTROLAR LA CONTRASEÑA

                        System.out.println("Escriba su correo electrónico:");
                        correoNuevoUsuario = leerOpcionLiteral();
                        System.out.println("Se está enviando un correo de verificación para su nuevo usuario...");
                        enviarCorreo(correoNuevoUsuario, "Correo de verificación", "Su código de verificación es:" + codigoEnviado);
                        System.out.println("Correo enviado, escriba su código de verificación: ");
                        codigoUsuario = leerOpcionNumerica();
                        if (codigoEnviado == codigoUsuario) {
                            System.out.println("Usuario registrado correctamente");
                            if (tipoNuevoUsuario.equalsIgnoreCase("G")){
                                gestorMail[contadorCorreosGestor]=correoNuevoUsuario;
                                gestorUsers[contadorGestores]=nombreNuevoUsuario;
                                gestorPass[contadorGestores]=passNuevoUsuario;
                                contadorGestores++;
                                contadorCorreosGestor++;
                            }
                            if (tipoNuevoUsuario.equalsIgnoreCase("I")){
                                inversorMail[contadorCorreosInversor]=correoNuevoUsuario;
                                inversorUsers[contadorInversores]=nombreNuevoUsuario;
                                inversorPass[contadorInversores]=passNuevoUsuario;
                                contadorInversores++;
                                contadorCorreosInversor++;
                            }
                            registroCorrecto = true;
                        } else System.out.println("El código no es correcto, vuelve a intentarlo: \n");
                    } while (!registroCorrecto);



            }

            if (seleccionInicial==2){
                do {
                    menuUser(adminsUsers,gestorUsers,inversorUsers);
                    seleccionTipoUsuario = leerOpcionNumerica();
                    boolean entry;
                    entry = login(seleccionTipoUsuario, datosAdmins, datosGestores, datosInversores);


                    //ADMINISTRADOR

                    if (seleccionTipoUsuario == 1 || seleccionTipoUsuario == 2) {
                        do {
                            menuAdministrador();
                            primerSubmenu = leerOpcionNumerica();
                            switch (primerSubmenu) {
                                case 1 -> {
                                    do {
                                        panelControlAdmin(gestorBloqueado, inversor1Bloqueado, inversor2Bloqueado);
                                        segundoSubmenu = leerOpcionNumerica();
                                        switch (segundoSubmenu) {
                                            case 1 -> {
                                                if (gestorBloqueado) gestorBloqueado = false;
                                                else gestorBloqueado = true;
                                            }
                                            case 2 -> {
                                                if (inversor1Bloqueado) inversor1Bloqueado = false;
                                                else inversor1Bloqueado = true;
                                            }
                                            case 3 -> {
                                                if (inversor2Bloqueado) inversor2Bloqueado = false;
                                                else inversor2Bloqueado = true;
                                            }
                                        }
                                    } while (segundoSubmenu != 4);
                                }
                                case 2 -> {
                                    do {

                                        mostrarProyectosAdmin(proyectsStringData, proyectsFinantialData);

                                        segundoSubmenu = leerOpcionNumerica();
                                        if (segundoSubmenu > 0 && segundoSubmenu <= cantidadProyectos) {
                                            System.out.println("¿Quiere eliminar el proyecto? [S]í | [N]o");
                                            respuesta = leerOpcionLiteral();

                                            if (proyectsStringData[0][segundoSubmenu - 1] != null && respuesta.equalsIgnoreCase("s")) {
                                                for (int i = 0; i < proyectsStringData.length; i++)
                                                    proyectsStringData[i][segundoSubmenu - 1] = null;
                                                for (int i = 0; i < proyectsFinantialData.length; i++)
                                                    proyectsFinantialData[i][segundoSubmenu - 1] = 0;
                                                for (int i = 0; i < invirtioInvesorEnProyecto.length; i++)
                                                    invirtioInvesorEnProyecto[i][segundoSubmenu - 1] = false;
                                                contadorProyectos--;
                                            } else if (respuesta.equalsIgnoreCase("n")) {
                                                System.out.println("¿Quiere modificar el proyecto? [S]í | [N]o");
                                                respuesta = leerOpcionLiteral();
                                                if (respuesta.equalsIgnoreCase("s")) {
                                                    do {
                                                        menuModificarProyecto();
                                                        tercersubmenu = leerOpcionNumerica();
                                                        switch (tercersubmenu) {
                                                            case 1 ->
                                                                    proyectsStringData[0][segundoSubmenu - 1] = cambiarNombreProyecto();
                                                            case 2 ->
                                                                    proyectsStringData[1][segundoSubmenu - 1] = cambiarDescripcionProyecto();
                                                            case 3 ->
                                                                    proyectsStringData[2][segundoSubmenu - 1] = cambiarTipoProyecto();
                                                            case 4 ->
                                                                    proyectsStringData[3][segundoSubmenu - 1] = cambiarFechaInicio();
                                                            case 5 ->
                                                                    proyectsStringData[4][segundoSubmenu - 1] = cambiarFechaFin();
                                                            case 6 ->
                                                                    proyectsFinantialData[0][segundoSubmenu - 1] = cambiarCantidadNecesaria();
                                                            case 7 ->
                                                                    proyectsFinantialData[1][segundoSubmenu - 1] = cambiarCantidadFinanciada();
                                                        }
                                                    } while (tercersubmenu != 8);
                                                }
                                            }
                                        } else if (segundoSubmenu == 0)
                                            proyectosDetallados(proyectsStringData, proyectsFinantialData);
                                    } while (segundoSubmenu != -1);
                                }
                                case 3 -> {
                                    do {
                                        menuConfiguracion();
                                        segundoSubmenu = leerOpcionNumerica();
                                        switch (segundoSubmenu) {
                                            case 1 -> userAdmin = cambiarUsuario(userAdmin);
                                            case 2 -> passAdmin = cambiarcontrasenia(passAdmin);
                                        }
                                    } while (segundoSubmenu != 3);
                                }
                            }
                        } while (primerSubmenu != 4);
                    }

                    // GESTOR
                    if ((seleccionTipoUsuario == 3 || seleccionTipoUsuario == 4 || seleccionTipoUsuario == 5 || seleccionTipoUsuario == 6) && !gestorBloqueado) {
                        if (!entry) gestorBloqueado = true;
                        else {
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
                                    if (respuesta.equalsIgnoreCase("s"))
                                        proyectosDetallados(proyectsStringData, proyectsFinantialData);

                                }
                                if (primerSubmenu == 2) {
                                    int i = 0;
                                    boolean hayPlaza = false;
                                    while (i < proyectsStringData[0].length && !hayPlaza) {
                                        if (proyectsStringData[0][i] == null) hayPlaza = true;
                                        else i++;
                                    }
                                    if (hayPlaza) {
                                        proyectsStringData[0][i] = crearNombreProyecto(i + 1);
                                        proyectsStringData[1][i] = crearDescripcionProyecto(i + 1);
                                        proyectsStringData[2][i] = crearTipoProyecto(i + 1);
                                        proyectsStringData[3][i] = crearFInicioProyecto(i + 1);
                                        proyectsStringData[4][i] = crearFFinProyecto(i + 1);
                                        proyectsFinantialData[0][i] = crearCNecesariaProyecto(i + 1);
                                        do {
                                            proyectsFinantialData[1][i] = crearCFinanciadaProyecto(i + 1);
                                            if (proyectsFinantialData[1][i] > proyectsFinantialData[0][i])
                                                System.out.println("El monto excede la cantidad necesaria");
                                        } while (proyectsFinantialData[1][i] > proyectsFinantialData[0][i]);

                                        contadorProyectos++;
                                        proyectosHabilitados[i] = true;
                                    } else System.out.println("Ya no puedes crear más proyectos");
                                }

                                if (primerSubmenu == 3) {
                                    do {
                                        menuConfiguracion();
                                        segundoSubmenu = leerOpcionNumerica();
                                        switch (segundoSubmenu) {
                                            case 1 -> userGestor = cambiarUsuario(userGestor);
                                            case 2 -> passGestor = cambiarcontrasenia(passGestor);
                                        }

                                    } while (segundoSubmenu != 3);
                                }
                            } while (primerSubmenu != 4);
                        }

                    } else if (gestorBloqueado)
                        System.out.println("Su usuario está bloqueado, contacte con el administrador del sistema para desbloquearlo");

                    //INVERSOR
                    if ((seleccionTipoUsuario == 7 || seleccionTipoUsuario == 8 || seleccionTipoUsuario == 9 || seleccionTipoUsuario == 10) && !inversor1Bloqueado) {
                        if (!entry) inversor1Bloqueado = true;
                        else {
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
                                        mostrarProyectosNoAdmin(proyectsStringData, proyectsFinantialData);
                                        System.out.println(RED + "¿Quieres ver más detalles sobre los proyectos?" + RESET);
                                        respuesta = leerOpcionLiteral();
                                        if (respuesta.equalsIgnoreCase("si")) {
                                            proyectosDetallados(proyectsStringData, proyectsFinantialData);
                                        }
                                        System.out.println(RED + "¿Quieres invertir en algún proyecto?" + RESET);
                                        respuesta = leerOpcionLiteral();
                                        if (respuesta.equalsIgnoreCase("si")) {
                                            do {
                                                menuInversiones(proyectsStringData);
                                                segundoSubmenu = leerOpcionNumerica();
                                                if ((segundoSubmenu > 0 && segundoSubmenu <= cantidadProyectos) && proyectosHabilitados[segundoSubmenu]) {
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
                                            } while ((segundoSubmenu > 0 && segundoSubmenu <= cantidadProyectos) && proyectosHabilitados[segundoSubmenu]);
                                        }
                                    }
                                    case 4 -> {
                                        System.out.println("Tienes " + dineroInversores[0] + "€");
                                        System.out.print("Introduzca el saldo que quiere añadir a su cartera digital: ");
                                        dineroInversores[0] += leerOpcionDouble();
                                    }
                                    case 5 -> {
                                        do {
                                            menuConfiguracion();
                                            segundoSubmenu = leerOpcionNumerica();
                                            switch (segundoSubmenu) {
                                                case 1 -> userInversor1 = cambiarUsuario(userInversor1);

                                                case 2 -> passInversor1 = cambiarcontrasenia(passInversor1);
                                            }

                                        } while (segundoSubmenu != 3);
                                    }
                                }
                            } while (primerSubmenu != 6);
                        }

                    } else if (inversor1Bloqueado && seleccionTipoUsuario == 3)
                        System.out.println("Su usuario está bloqueado, contacte con el administrador para desbloquearlo");
                } while (seleccionTipoUsuario != 5);
            }

        }while(seleccionInicial!=3);
    }
}