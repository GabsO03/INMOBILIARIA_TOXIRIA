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
        String nombreProyecto1="",nombreProyecto2="",nombreProyecto3="", tipoProyecto1="",tipoProyecto2="",tipoProyecto3="";
        double cantidadNecesariaProyecto1=0,cantidadNecesariaProyecto2=0,cantidadNecesariaProyecto3=0,
                cantidadFinanciadaProyecto1=0,cantidadFinanciadaProyecto2=0,cantidadFinanciadaProyecto3=0;
        //NEW ADD

        String[] nombresProyectos = {"TestName","",""};
        String[] descripcionesProyectos = {"TestDesc","",""};
        String[] tiposProyectos = {"TestType","",""};
        String[] fechasInicioProyectos = {"TestDate","",""};
        String[] fechasFinProyectos = {"TestDate","",""};
        double[] cantidadesNecesariasProyectos = new double[3];
        cantidadesNecesariasProyectos[0] = 3000.0;
        double[] cantidadesFinanciadasProyectos = new double[3];
        cantidadesFinanciadasProyectos[0] = 500.0;
        boolean[] proyectosHabilitados = {false, false, false};
        proyectosHabilitados[0] = true;


        //INVERSOR
        double dineroInversor1=0,dineroInversor2=0,respuestaDoubleA, cantidadInvertidaInversor1Proyecto1=0,cantidadInvertidaInversor1Proyecto2=0,cantidadInvertidaInversor1Proyecto3=0,
                cantidadInvertidaInversor2Proyecto1=0,cantidadInvertidaInversor2Proyecto2=0,cantidadInvertidaInversor2Proyecto3=0;
        boolean inversor1InvertidoProyecto1=false,inversor1InvertidoProyecto2=false,inversor1InvertidoProyecto3=false,inversor2InvertidoProyecto1=false,inversor2InvertidoProyecto2=false,inversor2InvertidoProyecto3=false;
        //String respuesta;
        double[] dinerosInversores = new double[2];
        double[] cantidadesInvertidasProyecto01Inversor = new double[2];
        double[] cantidadesInvertidasProyecto02Inversor = new double[2];
        double[] cantidadesInvertidasProyecto03Inversor = new double[2];
        double respuestaDouble;
        boolean[] invirtieronProyecto01Inversores = {false, false};
        boolean[] invirtieronProyecto02Inversores = {false, false};
        boolean[] invirtieronProyecto03Inversores = {false, false};
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

                                mostrarProyectosAdmin(nombresProyectos, tiposProyectos, cantidadesNecesariasProyectos, cantidadesFinanciadasProyectos);

                                segundoSubmenu=leerOpcionNumerica();
                                if (segundoSubmenu>0&&segundoSubmenu<4) {
                                    System.out.println("¿Quiere eliminar el proyecto? [S]í | [N]o");
                                    respuesta=leerOpcionLiteral();

                                    if (!nombresProyectos[segundoSubmenu-1].isEmpty()&&respuesta.equalsIgnoreCase("s")){
                                        nombresProyectos[segundoSubmenu-1]="";
                                        descripcionesProyectos[segundoSubmenu-1]="";
                                        tiposProyectos[segundoSubmenu-1]="";
                                        cantidadesFinanciadasProyectos[segundoSubmenu-1]=0;
                                        cantidadesNecesariasProyectos[segundoSubmenu-1]=0;
                                        fechasFinProyectos[segundoSubmenu-1]="";
                                        fechasInicioProyectos[segundoSubmenu-1]="";
                                        cantidadesInvertidasProyecto01Inversor[0]=0;
                                        invirtieronProyecto01Inversores[0]=false;
                                        cantidadesInvertidasProyecto01Inversor[1]=0;
                                        invirtieronProyecto01Inversores[1]=false;
                                        contadorProyectos--;
                                    }else if (respuesta.equalsIgnoreCase("n")){
                                        System.out.println("¿Quiere modificar el proyecto? [S]í | [N]o");
                                        respuesta=leerOpcionLiteral();
                                        if (respuesta.equalsIgnoreCase("s")){
                                            do {
                                                menuModificarProyecto();
                                                tercersubmenu=leerOpcionNumerica();
                                                switch (tercersubmenu){
                                                    case 1->nombresProyectos[segundoSubmenu-1]=cambiarNombreProyecto();
                                                    case 2->descripcionesProyectos[segundoSubmenu-1]=cambiarDescripcionProyecto();
                                                    case 3->tiposProyectos[segundoSubmenu-1]=cambiarTipoProyecto();
                                                    case 4->cantidadesNecesariasProyectos[segundoSubmenu-1]=cambiarCantidadNecesaria();
                                                    case 5->cantidadesFinanciadasProyectos[segundoSubmenu-1]=cambiarCantidadFinanciada();
                                                    case 6->fechasInicioProyectos[segundoSubmenu-1]=cambiarFechaInicio();
                                                    case 7->fechasFinProyectos[segundoSubmenu-1]=cambiarFechaFin();
                                                }
                                            } while(tercersubmenu!=8);
                                        }
                                    }
                                }
                                else if (segundoSubmenu==4) proyectosDetallados(nombresProyectos, descripcionesProyectos, tiposProyectos, cantidadesNecesariasProyectos, cantidadesFinanciadasProyectos, fechasInicioProyectos, fechasFinProyectos);
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
                            System.out.println(RED +  "Nombre del proyecto\t\t\t" + GREEN + "Tipo del proyecto");
                            if(proyectosHabilitados[0]){
                                System.out.println(RED + nombresProyectos[0] + "\t\t\t\t" + GREEN + tiposProyectos[0] + RESET);
                            }
                            if(proyectosHabilitados[1]){
                                System.out.println(RED + nombresProyectos[1] + "\t\t\t" + GREEN + tiposProyectos[1] + RESET);
                            }
                            if(proyectosHabilitados[2]){
                                System.out.println(RED + nombresProyectos[2] + "\t\t\t" + GREEN + tiposProyectos[2] + RESET);
                            }
                            System.out.println("¿Quieres ver más detalles sobre los proyectos? [S]í | [N]o");
                            respuesta=leerOpcionLiteral();
                            if(respuesta.equalsIgnoreCase("s")) proyectosDetallados(nombresProyectos, descripcionesProyectos, tiposProyectos,
                                    cantidadesNecesariasProyectos, cantidadesFinanciadasProyectos, fechasInicioProyectos, fechasFinProyectos);

                        }
                        if (primerSubmenu == 2) {
                            int i = 0;
                            boolean hayPlaza = false;
                            while (i < nombresProyectos.length&&!hayPlaza) {
                                if (nombresProyectos[i].isEmpty()) hayPlaza = true;
                                else i++;
                            }
                            if (hayPlaza){
                                nombresProyectos[i] = crearNombreProyecto(i+1);
                                descripcionesProyectos[i] = crearDescripcionProyecto(i+1);
                                tiposProyectos[i] = crearTipoProyecto(i+1);
                                cantidadesNecesariasProyectos[i] = crearCNecesariaProyecto(i+1);
                                do {
                                    cantidadesFinanciadasProyectos[i] = crearCFinanciadaProyecto(i+1);
                                    if (cantidadesFinanciadasProyectos[i] > cantidadesNecesariasProyectos[i])
                                        System.out.println("El monto excede la cantidad necesaria");
                                } while (cantidadesFinanciadasProyectos[i] > cantidadesNecesariasProyectos[i]);
                                fechasInicioProyectos[i] = crearFInicioProyecto(i+1);
                                fechasFinProyectos[i] = crearFFinProyecto(i+1);
                                contadorProyectos++;
                                proyectosHabilitados[i] = true;
                            } else System.out.println("Ya no puedes crear más proyectos");
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
                                if(invirtieronProyecto01Inversores[0]){
                                    System.out.println(RED + nombreProyecto1 + "\t\t\t\t" + GREEN + tipoProyecto1 + RESET);
                                }
                                if(invirtieronProyecto02Inversores[0]){
                                    System.out.println(RED + nombreProyecto2 + "\t\t\t" + GREEN + tipoProyecto2 + RESET);
                                }
                                if(invirtieronProyecto01Inversores[0]){
                                    System.out.println(RED + nombreProyecto3 + "\t\t\t" + GREEN + tipoProyecto3 + RESET);
                                }
                            }
                            case 2 -> {
                                if (invirtieronProyecto01Inversores[0]) mostrarInversionEnProyecto(nombreProyecto1,tipoProyecto1,cantidadInvertidaInversor1Proyecto1);
                                if (invirtieronProyecto02Inversores[0]) mostrarInversionEnProyecto(nombreProyecto2,tipoProyecto2,cantidadInvertidaInversor1Proyecto2);
                                if (invirtieronProyecto01Inversores[0]) mostrarInversionEnProyecto(nombreProyecto3,tipoProyecto3,cantidadInvertidaInversor1Proyecto3);


                            }
                            case 3 -> {
                                mostrarProyectosNoAdmin(nombresProyectos, tiposProyectos, cantidadesNecesariasProyectos, cantidadesFinanciadasProyectos);
                                System.out.println(RED+"¿Quieres ver más detalles sobre los proyectos?"+RESET);
                                respuesta=leerOpcionLiteral();
                                if(respuesta.equalsIgnoreCase("si")) {
                                    proyectosDetallados(nombresProyectos, descripcionesProyectos, tiposProyectos, cantidadesNecesariasProyectos, cantidadesFinanciadasProyectos, fechasInicioProyectos, fechasFinProyectos);
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
                                mostrarProyectosNoAdmin(nombresProyectos, tiposProyectos, cantidadesNecesariasProyectos, cantidadesFinanciadasProyectos);
                                System.out.println(RED+"¿Quieres ver más detalles sobre los proyectos?"+RESET);
                                respuesta=leerOpcionLiteral();
                                if(respuesta.equalsIgnoreCase("si")) proyectosDetallados(nombresProyectos, descripcionesProyectos, tiposProyectos, cantidadesNecesariasProyectos, cantidadesFinanciadasProyectos, fechasInicioProyectos, fechasFinProyectos);

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
    }
}

