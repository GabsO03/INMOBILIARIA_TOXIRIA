package CodigoFuente;

import java.util.Scanner;
//COLORES
import static Biblioteca.Colores.RED;
import static Biblioteca.Colores.GREEN;
import static Biblioteca.Colores.RESET;

//MENUS
import static Biblioteca.Menus.menuUser;
import static Biblioteca.Menus.menuProyectosGestor;
import static Biblioteca.Menus.menuAdministrador;
import static Biblioteca.Menus.menuModificarProyecto;
import static Biblioteca.Menus.menuInversor;
import static Biblioteca.Menus.menuConfiguracion;
import static Biblioteca.Menus.menuInversiones;

import static Biblioteca.Inversiones.mostrarInversionEnProyecto;
//LEER TEXTO
import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;
import static Biblioteca.Lectura_De_Datos.leerOpcionNumerica;

//LOGIN
import static Biblioteca.Login.logged;

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
                ,passInversor1="inversor1",userInversor2="inversor2",passInversor2="inversor2";
        //BLOQUEOS
        boolean gestorBloqueado=false,inversor1Bloqueado=false,inversor2Bloqueado=false;
        //PROYECTOS
        String nombreProyecto1="",nombreProyecto2="",nombreProyecto3="",descripcionProyecto1="",descripcionProyecto2="",descripcionProyecto3="",
                tipoProyecto1="",tipoProyecto2="",tipoProyecto3="",fechaInicioProyecto1="",fechaInicioProyecto2="",fechaInicioProyecto3="",
                fechaFinProyecto1="",fechaFinProyecto2="",fechaFinProyecto3="";
        double cantidadNecesariaProyecto1=0,cantidadNecesariaProyecto2=0,cantidadNecesariaProyecto3=0,
                cantidadFinanciadaProyecto1=0,cantidadFinanciadaProyecto2=0,cantidadFinanciadaProyecto3=0;
        boolean proyecto1=false, proyecto2=false, proyecto3=false;
        //INVERSOR
        double dineroInversor1=0,dineroInversor2=0,respuestaDouble, cantidadInvertidaInversor1Proyecto1=0,cantidadInvertidaInversor1Proyecto2=0,cantidadInvertidaInversor1Proyecto3=0,
                cantidadInvertidaInversor2Proyecto1=0,cantidadInvertidaInversor2Proyecto2=0,cantidadInvertidaInversor2Proyecto3=0;
        boolean inversor1InvertidoProyecto1=false,inversor1InvertidoProyecto2=false,inversor1InvertidoProyecto3=false,inversor2InvertidoProyecto1=false,inversor2InvertidoProyecto2=false,inversor2InvertidoProyecto3=false;
        String respuesta;


        //Menus
        int seleccionTipoUsuario;
        int primerSubmenu,segundoSubmenu,tercersubmenu, contadorProyectos = 0;

        do {
            menuUser();
            seleccionTipoUsuario = leerOpcionNumerica();
            boolean entry;
            entry=logged(seleccionTipoUsuario, userAdmin, passAdmin,  userGestor, passGestor,  userInversor1, passInversor1,  userInversor2, passInversor2);


            //ADMINISTRADOR

            if (seleccionTipoUsuario==1){
                do {
                    menuAdministrador();
                    primerSubmenu=leerOpcionNumerica();

                    switch (primerSubmenu){
                        case 1->{
                            do {
                                panelControlAdmin(gestorBloqueado,inversor1Bloqueado,inversor2Bloqueado);
                                segundoSubmenu=leerOpcionNumerica();
                                switch (segundoSubmenu){
                                    case 1 ->{
                                        if (gestorBloqueado) gestorBloqueado=false;
                                        else gestorBloqueado=true;
                                    }
                                    case 2 ->{
                                        if (inversor1Bloqueado) inversor1Bloqueado=false;
                                        else inversor1Bloqueado=true;
                                    }
                                    case 3 ->{
                                        if (inversor2Bloqueado) inversor2Bloqueado=false;
                                        else inversor2Bloqueado=true;
                                    }
                                }
                            }while (segundoSubmenu!=4);
                        }
                        case 2->{
                            do {

                                mostrarProyectosAdmin(nombreProyecto1,nombreProyecto2,nombreProyecto3,tipoProyecto1,tipoProyecto2,tipoProyecto3,
                                        cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3,
                                        cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);


                                segundoSubmenu=leerOpcionNumerica();
                                switch (segundoSubmenu){
                                    case 1-> {
                                        System.out.println(RED+"¿Quiere eliminar el proyecto?"+RESET);
                                        respuesta=leerOpcionLiteral();

                                        if (!nombreProyecto1.equals("")&&respuesta.equals("si")){
                                            nombreProyecto1="";
                                            descripcionProyecto1="";
                                            tipoProyecto1="";
                                            cantidadFinanciadaProyecto1=0;
                                            cantidadNecesariaProyecto1=0;
                                            fechaFinProyecto1="";
                                            fechaInicioProyecto1="";
                                            cantidadInvertidaInversor1Proyecto1=0;
                                            inversor1InvertidoProyecto1=false;
                                            cantidadInvertidaInversor2Proyecto1=0;
                                            inversor2InvertidoProyecto1=false;
                                            contadorProyectos--;
                                        }else if (respuesta.equals("no")){
                                            System.out.println(RED+"¿Quiere modificar el proyecto?"+RESET);
                                            respuesta=leerOpcionLiteral();
                                            if (respuesta.equals("si")){
                                                do {
                                                    menuModificarProyecto();
                                                    tercersubmenu=leerOpcionNumerica();
                                                    switch (tercersubmenu){
                                                        case 1->nombreProyecto1=cambiarNombreProyecto();
                                                        case 2->descripcionProyecto1=cambiarDescripcionProyecto();
                                                        case 3->tipoProyecto1=cambiarTipoProyecto();
                                                        case 4->cantidadNecesariaProyecto1=cambiarCantidadNecesaria();
                                                        case 5->cantidadFinanciadaProyecto1=cambiarCantidadFinanciada();
                                                        case 6->fechaInicioProyecto1=cambiarFechaInicio();
                                                        case 7->fechaFinProyecto1=cambiarFechaFin();
                                                    }

                                                }while(tercersubmenu!=8);
                                            }
                                        }
                                    }
                                    case 2->{
                                        System.out.println(RED+"¿Quiere eliminar el proyecto?"+RESET);
                                        respuesta=leerOpcionLiteral();

                                        if (!nombreProyecto2.equals("")&&respuesta.equals("si")){
                                            nombreProyecto2="";
                                            descripcionProyecto2="";
                                            tipoProyecto2="";
                                            cantidadFinanciadaProyecto2=0;
                                            cantidadNecesariaProyecto2=0;
                                            fechaFinProyecto2="";
                                            fechaInicioProyecto2="";
                                            contadorProyectos--;
                                            cantidadInvertidaInversor1Proyecto2=0;
                                            inversor1InvertidoProyecto2=false;
                                            cantidadInvertidaInversor2Proyecto2=0;
                                            inversor2InvertidoProyecto2=false;
                                        }else if (respuesta.equals("no")){
                                            System.out.println(RED+"¿Quiere modificar el proyecto?"+RESET);
                                            respuesta=leerOpcionLiteral();
                                            if (respuesta.equals("si")){
                                                do {
                                                    menuModificarProyecto();
                                                    tercersubmenu=leerOpcionNumerica();
                                                    switch (tercersubmenu){
                                                        case 1->nombreProyecto2=cambiarNombreProyecto();
                                                        case 2->descripcionProyecto2=cambiarDescripcionProyecto();
                                                        case 3->tipoProyecto2=cambiarTipoProyecto();
                                                        case 4->cantidadNecesariaProyecto2=cambiarCantidadNecesaria();
                                                        case 5->cantidadFinanciadaProyecto2=cambiarCantidadFinanciada();
                                                        case 6->fechaInicioProyecto2=cambiarFechaInicio();
                                                        case 7->fechaFinProyecto2=cambiarFechaFin();
                                                    }

                                                }while(tercersubmenu!=8);
                                            }
                                        }
                                    }
                                    case 3->{
                                        System.out.println(RED+"¿Quiere eliminar el proyecto?"+RESET);
                                        respuesta=leerOpcionLiteral();

                                        if (!nombreProyecto3.equals("")&&respuesta.equals("si")){
                                            nombreProyecto3="";
                                            descripcionProyecto3="";
                                            tipoProyecto3="";
                                            cantidadFinanciadaProyecto3=0;
                                            cantidadNecesariaProyecto3=0;
                                            fechaFinProyecto3="";
                                            fechaInicioProyecto3="";
                                            contadorProyectos--;
                                            cantidadInvertidaInversor1Proyecto3=0;
                                            inversor1InvertidoProyecto3=false;
                                            cantidadInvertidaInversor2Proyecto3=0;
                                            inversor2InvertidoProyecto3=false;
                                        }else if (respuesta.equals("no")){
                                            System.out.println(RED+"¿Quiere modificar el proyecto?"+RESET);
                                            respuesta=leerOpcionLiteral();
                                            if (respuesta.equals("si")){
                                                do {
                                                    menuModificarProyecto();
                                                    tercersubmenu=leerOpcionNumerica();
                                                    switch (tercersubmenu){
                                                        case 1->nombreProyecto3=cambiarNombreProyecto();
                                                        case 2->descripcionProyecto3=cambiarDescripcionProyecto();
                                                        case 3->tipoProyecto3=cambiarTipoProyecto();
                                                        case 4->cantidadNecesariaProyecto3=cambiarCantidadNecesaria();
                                                        case 5->cantidadFinanciadaProyecto3=cambiarCantidadFinanciada();
                                                        case 6->fechaInicioProyecto3=cambiarFechaInicio();
                                                        case 7->fechaFinProyecto3=cambiarFechaFin();
                                                    }

                                                }while(tercersubmenu!=8);
                                            }
                                        }
                                    }
                                    case 4-> proyectosDetallados(nombreProyecto1,nombreProyecto2,nombreProyecto3,
                                                descripcionProyecto1,descripcionProyecto2,descripcionProyecto3, tipoProyecto1,tipoProyecto2,tipoProyecto3,
                                                cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3, cantidadFinanciadaProyecto1,
                                                cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3,fechaInicioProyecto1,fechaInicioProyecto2,fechaInicioProyecto3,
                                                fechaFinProyecto1,fechaFinProyecto2,fechaFinProyecto3);

                                }


                            }while (segundoSubmenu!=5);

                        }
                        case 3->{
                            do {
                                menuConfiguracion();
                                segundoSubmenu=leerOpcionNumerica();
                                switch (segundoSubmenu){
                                    case 1->userAdmin=cambiarUsuario(userAdmin);

                                    case 2 ->passAdmin=cambiarcontrasenia(passAdmin);
                                }

                            }while (segundoSubmenu!=3);
                        }
                    }
                }while (primerSubmenu!=4);



            }

            // GESTOR
            if (seleccionTipoUsuario == 2&&!gestorBloqueado) {
                if (!entry) gestorBloqueado=true;
                else {
                    do {
                        menuProyectosGestor();
                        primerSubmenu = leerOpcionNumerica();
                        if (primerSubmenu == 1){
                            System.out.println(RED + "Nombre del proyecto\t\t\t" + GREEN + "Tipo del proyecto");
                            if(proyecto1){
                                System.out.println(RED + nombreProyecto1 + "\t\t\t\t" + GREEN + tipoProyecto1 + RESET);
                            }
                            if(proyecto2){
                                System.out.println(RED + nombreProyecto2 + "\t\t\t" + GREEN + tipoProyecto2 + RESET);
                            }
                            if(proyecto3){
                                System.out.println(RED + nombreProyecto3 + "\t\t\t" + GREEN + tipoProyecto3 + RESET);
                            }
                            System.out.println(RED+"¿Quieres ver más detalles sobre los proyectos?"+RESET);
                            respuesta=leerOpcionLiteral();
                            if(respuesta.equalsIgnoreCase("si")) proyectosDetallados(nombreProyecto1,nombreProyecto2,nombreProyecto3,
                                    descripcionProyecto1,descripcionProyecto2,descripcionProyecto3, tipoProyecto1,tipoProyecto2,tipoProyecto3,
                                    cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3, cantidadFinanciadaProyecto1,
                                    cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3,fechaInicioProyecto1,fechaInicioProyecto2,fechaInicioProyecto3,
                                    fechaFinProyecto1,fechaFinProyecto2,fechaFinProyecto3);
                        }
                        if (primerSubmenu == 2) {
                            if (nombreProyecto1.equalsIgnoreCase("")) {
                                crearNombreProyecto();
                                nombreProyecto1 = leerOpcionLiteral();
                                crearDescripcionProyecto();
                                descripcionProyecto1 = leerOpcionLiteral();
                                crearTipoProyecto();
                                tipoProyecto1 = leerOpcionLiteral();
                                crearCNecesariaProyecto();
                                cantidadNecesariaProyecto1 = leerOpcionDouble();
                                do {
                                    crearCFinanciadaProyecto();
                                    cantidadFinanciadaProyecto1 = leerOpcionDouble();
                                    if (cantidadFinanciadaProyecto1>cantidadNecesariaProyecto1) System.out.println("No puede ser mayor que la cantdad necesaria");
                                }while (cantidadFinanciadaProyecto1>cantidadNecesariaProyecto1);
                                crearFInicioProyecto();
                                fechaInicioProyecto1 = leerOpcionLiteral();
                                crearFFinProyecto();
                                fechaFinProyecto1 = leerOpcionLiteral();
                                contadorProyectos++;
                                proyecto1=true;
                            } else if (nombreProyecto2.equalsIgnoreCase("")) {
                                crearNombreProyecto();
                                nombreProyecto2 = leerOpcionLiteral();
                                crearDescripcionProyecto();
                                descripcionProyecto2 = leerOpcionLiteral();
                                crearTipoProyecto();
                                tipoProyecto2 = leerOpcionLiteral();
                                crearCNecesariaProyecto();
                                cantidadNecesariaProyecto2 = leerOpcionDouble();
                                do {
                                    crearCFinanciadaProyecto();
                                    cantidadFinanciadaProyecto2 = leerOpcionDouble();
                                    if (cantidadFinanciadaProyecto2>cantidadNecesariaProyecto2) System.out.println("No puede ser mayor que la cantdad necesaria");
                                }while (cantidadFinanciadaProyecto2>cantidadNecesariaProyecto2);
                                crearFInicioProyecto();
                                fechaInicioProyecto2 = leerOpcionLiteral();
                                crearFFinProyecto();
                                fechaFinProyecto2 = leerOpcionLiteral();
                                contadorProyectos++;
                                proyecto2=true;
                            } else if (nombreProyecto3.equalsIgnoreCase("")) {
                                crearNombreProyecto();
                                nombreProyecto3 = leerOpcionLiteral();
                                crearDescripcionProyecto();
                                descripcionProyecto3 = leerOpcionLiteral();
                                crearTipoProyecto();
                                tipoProyecto3 = leerOpcionLiteral();
                                crearCNecesariaProyecto();
                                cantidadNecesariaProyecto3 = leerOpcionDouble();

                                do {
                                    crearCFinanciadaProyecto();
                                    cantidadFinanciadaProyecto3 = leerOpcionDouble();
                                    if (cantidadFinanciadaProyecto3>cantidadNecesariaProyecto3) System.out.println("No puede ser mayor que la cantdad necesaria");
                                }while (cantidadFinanciadaProyecto3>cantidadNecesariaProyecto3);

                                crearFInicioProyecto();
                                fechaInicioProyecto3 = leerOpcionLiteral();
                                crearFFinProyecto();
                                fechaFinProyecto3 = leerOpcionLiteral();
                                contadorProyectos++;
                                proyecto3=true;
                            } else System.out.println("No se pueden crear más proyectos");
                        }
                        if (primerSubmenu==3){
                            do {
                                menuConfiguracion();
                                segundoSubmenu=leerOpcionNumerica();
                                switch (segundoSubmenu){
                                    case 1->userGestor=cambiarUsuario(userGestor);

                                    case 2 ->passGestor=cambiarcontrasenia(passGestor);
                                }

                            }while (segundoSubmenu!=3);
                        }
                    }while(primerSubmenu!=4);
                }

            } else if (gestorBloqueado)System.out.println("Su usuario está bloqueado, contacte con el administrador del sistema para desbloquearlo");

            //INVERSOR1
            if(seleccionTipoUsuario==3&&!inversor1Bloqueado) {
                if (!entry) inversor1Bloqueado=true;
                else {
                    do {
                        menuInversor();
                        primerSubmenu = leerOpcionNumerica();
                        switch (primerSubmenu) {
                            case 1 -> {
                                System.out.println(RED + "Nombre del proyecto\t\t\t" + GREEN + "Tipo del proyecto" + RESET);
                                if(inversor1InvertidoProyecto1){
                                    System.out.println(RED + nombreProyecto1 + "\t\t\t\t" + GREEN + tipoProyecto1 + RESET);
                                }
                                if(inversor1InvertidoProyecto2){
                                    System.out.println(RED + nombreProyecto2 + "\t\t\t" + GREEN + tipoProyecto2 + RESET);
                                }
                                if(inversor1InvertidoProyecto3){
                                    System.out.println(RED + nombreProyecto3 + "\t\t\t" + GREEN + tipoProyecto3 + RESET);
                                }
                            }
                            case 2 -> {
                                if (inversor1InvertidoProyecto1) mostrarInversionEnProyecto(nombreProyecto1,tipoProyecto1,cantidadInvertidaInversor1Proyecto1);
                                if (inversor1InvertidoProyecto2) mostrarInversionEnProyecto(nombreProyecto2,tipoProyecto2,cantidadInvertidaInversor1Proyecto2);
                                if (inversor1InvertidoProyecto3) mostrarInversionEnProyecto(nombreProyecto3,tipoProyecto3,cantidadInvertidaInversor1Proyecto3);


                            }
                            case 3 -> {
                                mostrarProyectosNoAdmin(nombreProyecto1, nombreProyecto2, nombreProyecto3, tipoProyecto1, tipoProyecto2, tipoProyecto3,
                                        cantidadNecesariaProyecto1, cantidadNecesariaProyecto2, cantidadNecesariaProyecto3,
                                        cantidadFinanciadaProyecto1, cantidadFinanciadaProyecto2, cantidadFinanciadaProyecto3);
                                System.out.println(RED+"¿Quieres ver más detalles sobre los proyectos?"+RESET);
                                respuesta=leerOpcionLiteral();
                                if(respuesta.equalsIgnoreCase("si")) {
                                    proyectosDetallados(nombreProyecto1, nombreProyecto2, nombreProyecto3,
                                            descripcionProyecto1, descripcionProyecto2, descripcionProyecto3, tipoProyecto1, tipoProyecto2, tipoProyecto3,
                                            cantidadNecesariaProyecto1, cantidadNecesariaProyecto2, cantidadNecesariaProyecto3, cantidadFinanciadaProyecto1,
                                            cantidadFinanciadaProyecto2, cantidadFinanciadaProyecto3, fechaInicioProyecto1, fechaInicioProyecto2, fechaInicioProyecto3,
                                            fechaFinProyecto1, fechaFinProyecto2, fechaFinProyecto3);

                                }
                                    System.out.println(RED+"¿Quieres invertir en algún proyecto?"+RESET);
                                    respuesta=leerOpcionLiteral();
                                    if (respuesta.equalsIgnoreCase("si")){
                                        do {
                                            menuInversiones(nombreProyecto1,nombreProyecto2,nombreProyecto3);
                                            segundoSubmenu=leerOpcionNumerica();
                                            switch (segundoSubmenu){
                                                case 1->{
                                                    System.out.println("Cantidad necesaria para financiar el proyecto: "+cantidadNecesariaProyecto1);
                                                    System.out.println("Cantidad financiada hasta el momento: "+cantidadFinanciadaProyecto1);
                                                    System.out.println("Cantidad restante para financiar el proyecto: "+(cantidadNecesariaProyecto1-cantidadFinanciadaProyecto1+"\n"));
                                                    System.out.println(RED+"¿Cuánto desea invertir?"+RESET);
                                                    respuestaDouble=leerOpcionDouble();
                                                    if (respuestaDouble<=dineroInversor1){
                                                        inversor1InvertidoProyecto1=true;
                                                        cantidadFinanciadaProyecto1+=respuestaDouble;
                                                        cantidadInvertidaInversor1Proyecto1+=respuestaDouble;
                                                        dineroInversor1-=respuestaDouble;
                                                    }else System.out.println("No tienes suficiente saldo. Actualmente cuentas con "+dineroInversor1);
                                                }
                                                case 2->{
                                                    System.out.println("Cantidad necesaria para financiar el proyecto: "+cantidadNecesariaProyecto2);
                                                    System.out.println("Cantidad financiada hasta el momento: "+cantidadFinanciadaProyecto2);
                                                    System.out.println("Cantidad restante para financiar el proyecto: "+(cantidadNecesariaProyecto2-cantidadFinanciadaProyecto2+"\n"));
                                                    System.out.println(RED+"¿Cuánto desea invertir?"+RESET);
                                                    respuestaDouble=leerOpcionDouble();
                                                    if (respuestaDouble<=dineroInversor1){
                                                        inversor1InvertidoProyecto2=true;
                                                        cantidadFinanciadaProyecto2+=respuestaDouble;
                                                        cantidadInvertidaInversor1Proyecto2+=respuestaDouble;
                                                        dineroInversor1-=respuestaDouble;
                                                    }else System.out.println("No tienes suficiente saldo. Actualmente cuentas con "+dineroInversor1);
                                                }
                                                case 3->{
                                                    System.out.println("Cantidad necesaria para financiar el proyecto: "+cantidadNecesariaProyecto3);
                                                    System.out.println("Cantidad financiada hasta el momento: "+cantidadFinanciadaProyecto3);
                                                    System.out.println("Cantidad restante para financiar el proyecto: "+(cantidadNecesariaProyecto3-cantidadFinanciadaProyecto3+"\n"));
                                                    System.out.println(RED+"¿Cuánto desea invertir?"+RESET);
                                                    respuestaDouble=leerOpcionDouble();
                                                    if (respuestaDouble<=dineroInversor1){
                                                        inversor1InvertidoProyecto3=true;
                                                        cantidadFinanciadaProyecto3+=respuestaDouble;
                                                        cantidadInvertidaInversor1Proyecto3+=respuestaDouble;
                                                        dineroInversor1-=respuestaDouble;
                                                    }else System.out.println("No tienes suficiente saldo. Actualmente cuentas con "+dineroInversor1);
                                                }
                                            }
                                        }while (segundoSubmenu!=4);

                                    }



                            }
                            case 4 -> {
                                System.out.println("Tienes " + dineroInversor1 + "€");
                                System.out.print("Introduzca el saldo que quiere añadir a su cartera digital: ");
                                dineroInversor1 += leerOpcionDouble();
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

            }else if (inversor1Bloqueado&&seleccionTipoUsuario==3) System.out.println("Su usuario está bloqueado, contacte con el administrador para desbloquearlo");

            //INVERSOR2
            if (seleccionTipoUsuario==4&&!inversor2Bloqueado){
                if (!entry) inversor2Bloqueado=true;
                else {
                    do{
                        menuInversor();
                        primerSubmenu=leerOpcionNumerica();
                        switch (primerSubmenu){
                            case 1->{
                                System.out.println(RED + "Nombre del proyecto\t\t\t" + GREEN + "Tipo del proyecto" + RESET);
                                if(inversor2InvertidoProyecto1){
                                    System.out.println(RED + nombreProyecto1 + "\t\t\t\t" + GREEN + tipoProyecto1 + RESET);
                                }
                                if(inversor2InvertidoProyecto2){
                                    System.out.println(RED + nombreProyecto2 + "\t\t\t" + GREEN + tipoProyecto2 + RESET);
                                }
                                if(inversor2InvertidoProyecto3){
                                    System.out.println(RED + nombreProyecto3 + "\t\t\t" + GREEN + tipoProyecto3 + RESET);
                                }
                            }
                            case 2->{
                                if (inversor2InvertidoProyecto1) mostrarInversionEnProyecto(nombreProyecto1,tipoProyecto1,cantidadInvertidaInversor2Proyecto1);
                                if (inversor2InvertidoProyecto2) mostrarInversionEnProyecto(nombreProyecto2,tipoProyecto2,cantidadInvertidaInversor2Proyecto2);
                                if (inversor2InvertidoProyecto3) mostrarInversionEnProyecto(nombreProyecto3,tipoProyecto3,cantidadInvertidaInversor2Proyecto3);
                            }
                            case 3->{
                                mostrarProyectosNoAdmin(nombreProyecto1,nombreProyecto2,nombreProyecto3,tipoProyecto1,tipoProyecto2,tipoProyecto3,
                                        cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3,
                                        cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);
                                System.out.println(RED+"¿Quieres ver más detalles sobre los proyectos?"+RESET);
                                respuesta=leerOpcionLiteral();
                                if(respuesta.equalsIgnoreCase("si")) {
                                    proyectosDetallados(nombreProyecto1,nombreProyecto2,nombreProyecto3,
                                            descripcionProyecto1,descripcionProyecto2,descripcionProyecto3, tipoProyecto1,tipoProyecto2,tipoProyecto3,
                                            cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3, cantidadFinanciadaProyecto1,
                                            cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3,fechaInicioProyecto1,fechaInicioProyecto2,fechaInicioProyecto3,
                                            fechaFinProyecto1,fechaFinProyecto2,fechaFinProyecto3);
                                }
                                System.out.println(RED+"¿Quieres invertir en algún proyecto?"+RESET);
                                respuesta=leerOpcionLiteral();
                                if (respuesta.equalsIgnoreCase("si")){
                                    do {
                                        menuInversiones(nombreProyecto1,nombreProyecto2,nombreProyecto3);
                                        segundoSubmenu=leerOpcionNumerica();
                                        switch (segundoSubmenu){
                                            case 1->{
                                                System.out.println("Cantidad necesaria para financiar el proyecto: "+cantidadNecesariaProyecto1);
                                                System.out.println("Cantidad financiada hasta el momento: "+cantidadFinanciadaProyecto1);
                                                System.out.println("Cantidad restante para financiar el proyecto: "+(cantidadNecesariaProyecto1-cantidadFinanciadaProyecto1+"\n"));
                                                System.out.println(RED+"¿Cuánto desea invertir?"+RED);
                                                respuestaDouble=leerOpcionDouble();
                                                if (respuestaDouble<=dineroInversor2){
                                                    inversor2InvertidoProyecto1=true;
                                                    cantidadFinanciadaProyecto1+=respuestaDouble;
                                                    cantidadInvertidaInversor2Proyecto1+=respuestaDouble;
                                                    dineroInversor2-=respuestaDouble;
                                                }else System.out.println("No tienes suficiente saldo. Actualmente cuentas con "+dineroInversor2);
                                            }
                                            case 2->{
                                                System.out.println("Cantidad necesaria para financiar el proyecto: "+cantidadNecesariaProyecto2);
                                                System.out.println("Cantidad financiada hasta el momento: "+cantidadFinanciadaProyecto2);
                                                System.out.println("Cantidad restante para financiar el proyecto: "+(cantidadNecesariaProyecto2-cantidadFinanciadaProyecto2+"\n"));
                                                System.out.println(RED+"¿Cuánto desea invertir?"+RESET);
                                                respuestaDouble=leerOpcionDouble();
                                                if (respuestaDouble<=dineroInversor2){
                                                    inversor2InvertidoProyecto2=true;
                                                    cantidadFinanciadaProyecto2+=respuestaDouble;
                                                    cantidadInvertidaInversor2Proyecto2+=respuestaDouble;
                                                    dineroInversor2-=respuestaDouble;
                                                }else System.out.println("No tienes suficiente saldo. Actualmente cuentas con "+dineroInversor2);
                                            }
                                            case 3->{
                                                System.out.println("Cantidad necesaria para financiar el proyecto: "+cantidadNecesariaProyecto3);
                                                System.out.println("Cantidad financiada hasta el momento: "+cantidadFinanciadaProyecto3);
                                                System.out.println("Cantidad restante para financiar el proyecto: "+(cantidadNecesariaProyecto3-cantidadFinanciadaProyecto3+"\n"));
                                                System.out.println(RED+"¿Cuánto desea invertir?"+RESET);
                                                respuestaDouble=leerOpcionDouble();
                                                if (respuestaDouble<=dineroInversor2){
                                                    inversor2InvertidoProyecto3=true;
                                                    cantidadFinanciadaProyecto3+=respuestaDouble;
                                                    cantidadInvertidaInversor2Proyecto3+=respuestaDouble;
                                                    dineroInversor2-=respuestaDouble;
                                                }else System.out.println("No tienes suficiente saldo. Actualmente cuentas con "+dineroInversor2);
                                            }
                                        }
                                    }while (segundoSubmenu!=4);

                                }
                            }
                            case 4->{
                                System.out.println("Tienes " + dineroInversor2 + "€");
                                System.out.print("Introduzca el saldo que quiere añadir a su cartera digital: ");
                                dineroInversor2+=leerOpcionDouble();
                            }
                            case 5->{
                                do {
                                    menuConfiguracion();
                                    segundoSubmenu=leerOpcionNumerica();
                                    switch (segundoSubmenu){
                                        case 1->passInversor2=cambiarUsuario(passInversor2);

                                        case 2 ->passInversor2=cambiarcontrasenia(passInversor2);
                                    }

                                }while (segundoSubmenu!=3);
                            }
                        }
                    }while(primerSubmenu!=6);
                }
            } else if (inversor2Bloqueado)System.out.println("Bloqueado");



        }while(seleccionTipoUsuario!=5);
        System.out.println("Estoy probando la rama del tema 3");
    }
}

