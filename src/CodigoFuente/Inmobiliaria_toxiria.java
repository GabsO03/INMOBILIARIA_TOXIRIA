package CodigoFuente;

import java.util.Scanner;
//COLORES
import static Biblioteca.Colores.BLACK;
import static Biblioteca.Colores.RED;
import static Biblioteca.Colores.GREEN;
import static Biblioteca.Colores.RESET;
import static Biblioteca.Colores.YELLOW;
import static Biblioteca.Colores.BLUE;
import static Biblioteca.Colores.PURPLE;
import static Biblioteca.Colores.CYAN;
import static Biblioteca.Colores.WHITE;

//MENUS
import static Biblioteca.Menus.menuUser;
import static Biblioteca.Menus.menuProyectosGestor;
import static Biblioteca.Menus.menuAdministrador;
import static Biblioteca.Menus.menuModificarProyecto;
import static Biblioteca.Menus.menuInversor;
import static Biblioteca.Menus.menuConfiguracion;


public class Inmobiliaria_toxiria {



    public static int leerOpcionNumerica () {
        Scanner escaner = new Scanner(System.in);
        return Integer.parseInt(escaner.nextLine());
    }
    public static double leerOpcionDouble () {
        Scanner escaner = new Scanner(System.in);
        return Double.parseDouble(escaner.nextLine());
    }
    public static String leerOpcionLiteral () {
        Scanner escaner = new Scanner(System.in);
        return escaner.nextLine();
    }

    public static boolean verification (String usu, String con) {
        System.out.println("Introduzca su usuario:");
        String user = leerOpcionLiteral();
        System.out.println("Introduzca su contraseña");
        String password = leerOpcionLiteral();
        return user.equals(usu) && password.equals(con);
    }
    public static boolean loginAdmin (String user, String con) {
        while (!(verification(user, con))) System.out.println("Usuario o contraseña incorrecta.");
        System.out.println("Bienvenid@ " + user);
        return true;
    }
    public static boolean loginGestor (String user, String pass) {
        int intentos = 3;
        while (intentos > 0 && !(verification(user, pass))) {
            intentos--;
            System.out.println("Contraseña incorrecta, Te quedan " + intentos + " intentos.");
        }
        if (intentos > 0) System.out.println();
        else {
            System.out.println("Acceso denegado, tu cuenta ha sido bloqueada, espera a que el administrador te desbloquee.");
            return false;
        }
        return true;
    }
    public static boolean loginInversor (String user, String pass) {
        String passEntry;
        int intentos = 3;
        do {
            System.out.println("Introduzca su contraseña");
            passEntry = leerOpcionLiteral();
            intentos--;
            if (!(passEntry.equals(pass))) System.out.println("Contraseña incorrecta, Te quedan " + intentos + " intentos.");
        } while (intentos > 0 && !(passEntry.equals(pass)));
        if (intentos > 0) System.out.println("Bienvenid@ " + user);
        else {
            System.out.println("Tu cuenta ha sido bloqueada, espera a que el administrador te desbloquee.");
            return false;
        }
        return true;
    }
    public static boolean logged (int opcion1, String adminUser, String adminPass,  String gestorUser, String gestorPass,  String inversor1User, String inversor1Pass,  String inversor2User, String inversor2Pass) {
        int intentosUsuario=3;
        boolean succesfull=false;
        String userEntry="";

        switch (opcion1) {
            case 1 : {
                if (loginAdmin(adminUser, adminPass)) return true;
                break;
            }
            case 2 : {
                if (loginGestor(gestorUser, gestorPass)) return true;
                break;
            }
            case 3 : {
                do {
                    System.out.println("Introduzca su usuario:");
                    userEntry = leerOpcionLiteral();
                    if (userEntry.equals(inversor1User)) {
                        loginInversor(inversor1User, inversor1Pass);
                        succesfull = true;
                    } else if (userEntry.equals(inversor2User)) {
                        loginInversor(inversor2User, inversor2Pass);
                        succesfull = true;
                    } else {
                        System.out.println("Este usuario no existe.");
                        intentosUsuario--;
                    }
                } while (intentosUsuario>0&&!succesfull);
                break;
            }
        }
        if (succesfull) return true;
        return false;
    }


    //mostrarProyectos


    //Administrador


    public static void mostrarProyectosNoAdmin(String nombreProyecto1, String nombreProyecto2, String nombreProyecto3, String tipoProyecto1, String tipoProyecto2, String tipoProyecto3,
                                               double cantidadNecesariaProyecto1, double cantidadNecesariaProyecto2, double cantidadNecesariaProyecto3,
                                               double cantidadFinanciadaProyecto1, double cantidadFinanciadaProyecto2, double cantidadFinanciadaProyecto3){
        System.out.println("\t\t\t\tProyecto 1 \t\t\t Proyecto 2 \t\t\t Proyecto 3");
        System.out.println("Nombre: \t" + nombreProyecto1 + nombreProyecto2 + nombreProyecto3);
        System.out.println("Tipo: \t\t" + tipoProyecto1 + tipoProyecto2 + tipoProyecto3);
        System.out.printf("Cantidad Necesaria: %.2f\t %.2f\t %.2f\n",cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3);
        System.out.printf("Cantidad Financiada: %.2f\t %.2f\t %.2f\n",cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);
    }
    public static void mostrarProyectosAdmin(String nombreProyecto1, String nombreProyecto2, String nombreProyecto3, String tipoProyecto1, String tipoProyecto2, String tipoProyecto3,
                                               double cantidadNecesariaProyecto1, double cantidadNecesariaProyecto2, double cantidadNecesariaProyecto3,
                                               double cantidadFinanciadaProyecto1, double cantidadFinanciadaProyecto2, double cantidadFinanciadaProyecto3){
        System.out.println("\t\t\t\tProyecto 1 \t\t\t Proyecto 2 \t\t\t Proyecto 3");
        System.out.println("Nombre: \t" + nombreProyecto1 + nombreProyecto2 + nombreProyecto3);
        System.out.println("Tipo: \t\t" + tipoProyecto1 + tipoProyecto2 + tipoProyecto3);
        System.out.printf("Cantidad Necesaria: %.2f\t %.2f\t %.2f\n",cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3);
        System.out.printf("Cantidad Financiada: %.2f\t %.2f\t %.2f\n",cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);

        System.out.println("Elija cual quiere eliminar o modificar: \n1. Proyecto 1\n2. Proyecto 2\n3. Proyecto 3\n4.Ver más detalles\n5. Ninguno");
    }
    //MODIFICAR PROYECTOS:

    public static String cambiarNombreProyecto(){
        System.out.println("Escriba el nuevo nombre del proyecto: ");
        return leerOpcionLiteral();
    }
    public static String cambiarDescripcionProyecto(){
        System.out.println("Escriba la nueva descripción del proyecto: ");
        return leerOpcionLiteral();
    }
    public static String cambiarTipoProyecto(){
        System.out.println("Escriba el nuevo tipo del proyecto");
        return leerOpcionLiteral();
    }
    public static double cambiarCantidadNecesaria (){
        System.out.println("Escriba la nueva cantidad necesaria");
        return leerOpcionDouble();
    }
    public static double cambiarCantidadFinanciada (){
        System.out.println("Escriba la nueva cantidad financiada");
        return leerOpcionDouble();
    }
    public static String cambiarFechaInicio(){
        System.out.println("Escriba la nueva fecha de inicio");
        return leerOpcionLiteral();
    }
    public static String cambiarFechaFin(){
        System.out.println("Escriba la nueva fecha de fin");
        return leerOpcionLiteral();
    }




    public static void panelControlAdmin(boolean gestorBloqueado,boolean inversor1Bloqueado,boolean inversor2Bloqueado){
        String gestorBloqueadoCadena="",inversor1BloqueadoCadena="", inversor2BloqueadoCadena="";
        if (gestorBloqueado) gestorBloqueadoCadena="Bloqueado";
        if (inversor1Bloqueado) inversor1BloqueadoCadena="Bloqueado";
        if (inversor2Bloqueado) inversor2BloqueadoCadena="Bloqueado";
        System.out.println("Menú del panel de control de usuarios, estos son los usuarios del sistema:");
        System.out.println("Seleccione cuál quiere bloquear/desbloquear");
        System.out.printf("1.gestor %s\n2.inversor1 %s\n3.inversor2 %s\n4.Salir\n",gestorBloqueadoCadena,inversor1BloqueadoCadena,inversor2BloqueadoCadena);
    }



    public static void crearNombreProyecto(){
        System.out.print("Introduzca el nombre del proyecto: ");
    }
    public static void crearDescripcionProyecto(){
        System.out.print("Introduzca la descripción del proyecto: ");
    }
    public static void crearTipoProyecto(){
        System.out.print("Introduzca el Tipo del proyecto (Préstamo, Plusvalía o Alquiler): ");
    }
    public static void crearCNecesariaProyecto(){
        System.out.print("Introduzca la cantidad necesaria del proyecto: ");
    }
    public static void crearCFinanciadaProyecto(){
        System.out.print("Introduzca la cantidad financiada hasta el momento del proyecto: ");
    }
    public static void crearFInicioProyecto(){
        System.out.print("Introduzca la fecha de inicio del proyecto (dd/mm/aaaa): ");
    }
    public static void crearFFinProyecto(){
        System.out.print("Introduzca la fecha final del proyecto (dd/mm/aaaa): ");
    }
    public static void crearGrafico(double cantidadNecesaria,double cantidadFinanciada){
        int porcentaje= (int) ((int) (cantidadFinanciada*100)/cantidadNecesaria);
        String caracterLleno="#";
        String caracterVacio="_";
        System.out.println("Cantidad financiada hasta el momento: ");
        System.out.print(caracterLleno.repeat(porcentaje));
        System.out.print(caracterVacio.repeat((100-porcentaje)));

    }
    public static void proyectosDetallados(String nombreProyecto1,String nombreProyecto2,String nombreProyecto3,String descripcionProyecto1,String descripcionProyecto2,
                                           String descripcionProyecto3,String tipoProyecto1,String tipoProyecto2, String tipoProyecto3,
                                           double cantidadNecesariaProyecto1,double cantidadNecesariaProyecto2,double cantidadNecesariaProyecto3,
                                           double cantidadFinanciadaProyecto1,double cantidadFinanciadaProyecto2,double cantidadFinanciadaProyecto3,
                                           String fechaInicioProyecto1,String fechaInicioProyecto2,String fechaInicioProyecto3,
                                           String fechaFinProyecto1,String fechaFinProyecto2,String fechaFinProyecto3){
        System.out.println("Proyecto 1: ");
        System.out.println("Nombre: "+nombreProyecto1+"\nDescripción: "+descripcionProyecto1+"\nTipo: "+tipoProyecto1+"\nCantidad Necesaria: "+cantidadNecesariaProyecto1+"\nCantidad Financiada: "+cantidadFinanciadaProyecto1+"\nFecha Inicial: "+fechaInicioProyecto1+"\nFecha Final: "+fechaFinProyecto1);
        System.out.println("Gráfico:");
        crearGrafico(cantidadNecesariaProyecto1,cantidadFinanciadaProyecto1);
        System.out.println("\nProyecto 2: ");
        System.out.println("Nombre: "+nombreProyecto2+"\nDescripción: "+descripcionProyecto2+"\nTipo: "+tipoProyecto2+"\nCantidad Necesaria: "+cantidadNecesariaProyecto2+"\nCantidad Financiada: "+cantidadFinanciadaProyecto2+"\nFecha Inicial: "+fechaInicioProyecto2+"\nFecha Final: "+fechaFinProyecto2);
        System.out.println("Gráfico:");
        crearGrafico(cantidadNecesariaProyecto2,cantidadFinanciadaProyecto2);
        System.out.println("\nProyecto 3: ");
        System.out.println("Nombre: "+nombreProyecto3+"\nDescripción: "+descripcionProyecto3+"\nTipo: "+tipoProyecto3+"\nCantidad Necesaria: "+cantidadNecesariaProyecto3+"\nCantidad Financiada: "+cantidadFinanciadaProyecto3+"\nFecha Inicial: "+fechaInicioProyecto3+"\nFecha Final: "+fechaFinProyecto3);
        System.out.println("Gráfico:");
        crearGrafico(cantidadNecesariaProyecto3,cantidadFinanciadaProyecto3);
        System.out.println();


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
        String userAdmin="administrador",passAdmin="administrador",userGestor="gestor",passGestor="gestor",userInversor1="inversor1"
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
        double dineroInversor1=0,dineroInversor2=0;
        String respuesta="";

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
                                        System.out.println("¿Quiere eliminar el proyecto?");
                                        respuesta=leerOpcionLiteral();

                                        if (!nombreProyecto1.equals("")&&respuesta.equals("si")){
                                            nombreProyecto1="";
                                            descripcionProyecto1="";
                                            tipoProyecto1="";
                                            cantidadFinanciadaProyecto1=0;
                                            cantidadNecesariaProyecto1=0;
                                            fechaFinProyecto1="";
                                            fechaInicioProyecto1="";
                                            contadorProyectos--;
                                        }else if (respuesta.equals("no")){
                                            System.out.println("¿Quiere modificar el proyecto?");
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
                                        System.out.println("¿Quiere eliminar el proyecto?");
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
                                        }else if (respuesta.equals("no")){
                                            System.out.println("¿Quiere modificar el proyecto?");
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
                                        System.out.println("¿Quiere eliminar el proyecto?");
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
                                        }else if (respuesta.equals("no")){
                                            System.out.println("¿Quiere modificar el proyecto?");
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
                            System.out.println("¿Quieres ver más detalles sobre los proyectos?");
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
            //INVERSOR
            if(seleccionTipoUsuario==3){
                if (userInversor1.equalsIgnoreCase("inversor1")&&!inversor1Bloqueado) {
                        do{
                            menuInversor();
                            primerSubmenu=leerOpcionNumerica();
                            switch (primerSubmenu){
                                case 1->{
                                    System.out.println();
                                }
                                case 2->{

                                }
                                case 3->{
                                    mostrarProyectosNoAdmin(nombreProyecto1,nombreProyecto2,nombreProyecto3,tipoProyecto1,tipoProyecto2,tipoProyecto3,
                                            cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3,
                                            cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);
                                }
                                case 4->{
                                    System.out.println("Tienes " + dineroInversor1 + "€");
                                    System.out.print("Introduzca el saldo que quiere añadir a su cartera digital: ");
                                    dineroInversor1+=leerOpcionDouble();
                                }
                                case 5->{
                                    do {
                                        menuConfiguracion();
                                        segundoSubmenu=leerOpcionNumerica();
                                        switch (segundoSubmenu){
                                            case 1->userInversor1=cambiarUsuario(userInversor1);

                                            case 2 ->passInversor1=cambiarcontrasenia(passInversor1);
                                        }

                                    }while (segundoSubmenu!=3);
                                }
                            }
                        }while(primerSubmenu!=6);

                } else if (inversor1Bloqueado){
                    System.out.println("Su usuario está bloqueado, contacte con el administrador para desbloquearlo");

                }
                if (userInversor2.equalsIgnoreCase("inversor2")&&!inversor2Bloqueado) {
                    if (!entry) inversor2Bloqueado=true;
                    else {
                        do{
                            menuInversor();
                            primerSubmenu=leerOpcionNumerica();
                            switch (primerSubmenu){
                                case 1->{
                                    System.out.println();
                                }
                                case 2->{

                                }
                                case 3->{
                                    mostrarProyectosNoAdmin(nombreProyecto1,nombreProyecto2,nombreProyecto3,tipoProyecto1,tipoProyecto2,tipoProyecto3,
                                            cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3,
                                            cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);
                                    System.out.println("¿Quieres ver más detalles sobre los proyectos?");
                                    respuesta=leerOpcionLiteral();
                                    if(respuesta.equalsIgnoreCase("si")) proyectosDetallados(nombreProyecto1,nombreProyecto2,nombreProyecto3,
                                            descripcionProyecto1,descripcionProyecto2,descripcionProyecto3, tipoProyecto1,tipoProyecto2,tipoProyecto3,
                                            cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3, cantidadFinanciadaProyecto1,
                                            cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3,fechaInicioProyecto1,fechaInicioProyecto2,fechaInicioProyecto3,
                                            fechaFinProyecto1,fechaFinProyecto2,fechaFinProyecto3);
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

                } else if (inversor2Bloqueado) {
                    System.out.println("Su usuario está bloqueado, contacte con el administrador para desbloquearlo");
                }




            }
        }while(seleccionTipoUsuario!=4);
    }
}

