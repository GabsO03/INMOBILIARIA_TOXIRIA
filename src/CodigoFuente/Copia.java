package CodigoFuente;

import java.util.Scanner;

public class Copia {
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";

    public static void menuUser () {
        System.out.println("Seleccione su tipo de usuario\n1. Administrador.\n2. Gestor.\n3. Inversor.\n4. Salir");
    }
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
    public static void menuProyectosGestor(){
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Configuración.\n4. Salir");
    }

    //Administrador
    public static void menuAdministrador(){
        System.out.println("Seleccione dónde quiere acceder: \n1.Panel de control\n2.Proyectos\n3.Configuración\n4.Salir");
    }

    public static void mostrarProyectosAdmin(String nombreProyecto1,String nombreProyecto2,String nombreProyecto3,String tipoProyecto1,String tipoProyecto2, String tipoProyecto3,
                                             double cantidadNecesariaProyecto1,double cantidadNecesariaProyecto2,double cantidadNecesariaProyecto3,
                                             double cantidadFinanciadaProyecto1,double cantidadFinanciadaProyecto2,double cantidadFinanciadaProyecto3){
        System.out.println("\t\t\t\tProyecto 1 \t\t\t Proyecto 2 \t\t\t Proyecto 3");
        System.out.println("Nombre: \t" + nombreProyecto1 + nombreProyecto2 + nombreProyecto3);
        System.out.println("Tipo: \t\t" + tipoProyecto1 + tipoProyecto2 + tipoProyecto3);
        System.out.println("Cantidad Necesaria: " + cantidadNecesariaProyecto1 + cantidadNecesariaProyecto2 + cantidadNecesariaProyecto3);
        System.out.println("Cantidad Financiada: " + cantidadFinanciadaProyecto1 + cantidadFinanciadaProyecto2 + cantidadFinanciadaProyecto3);
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

    public static void menuInversor(){
        System.out.println("Seleccione donde quiere acceder: \n1. Panel de Control\n2. Mis inversiones\n3. Proyectos\n4. Cartera Virtual\n5. Configuración\n6. Salir");
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
    public static void proyectosDetallados(String nombreProyecto1,String nombreProyecto2,String nombreProyecto3,String descripcionProyecto1,String descripcionProyecto2,
                                           String descripcionProyecto3,String tipoProyecto1,String tipoProyecto2, String tipoProyecto3,
                                           double cantidadNecesariaProyecto1,double cantidadNecesariaProyecto2,double cantidadNecesariaProyecto3,
                                           double cantidadFinanciadaProyecto1,double cantidadFinanciadaProyecto2,double cantidadFinanciadaProyecto3,
                                           String fechaInicioProyecto1,String fechaInicioProyecto2,String fechaInicioProyecto3,
                                           String fechaFinProyecto1,String fechaFinProyecto2,String fechaFinProyecto3){
        System.out.println("Proyecto 1: ");
        System.out.println("Nombre: "+nombreProyecto1+"\nDescripción: "+descripcionProyecto1+"\nTipo: "+tipoProyecto1+"\nCantidad Necesaria: "+cantidadNecesariaProyecto1+"\nCantidad Financiada: "+cantidadFinanciadaProyecto1+"\nFecha Inicial: "+fechaInicioProyecto1+"\nFecha Final: "+fechaFinProyecto1);
        System.out.println("Proyecto 2: ");
        System.out.println("Nombre: "+nombreProyecto2+"\nDescripción: "+descripcionProyecto2+"\nTipo: "+tipoProyecto2+"\nCantidad Necesaria: "+cantidadNecesariaProyecto2+"\nCantidad Financiada: "+cantidadFinanciadaProyecto2+"\nFecha Inicial: "+fechaInicioProyecto2+"\nFecha Final: "+fechaFinProyecto2);
        System.out.println("Proyecto 3: ");
        System.out.println("Nombre: "+nombreProyecto3+"\nDescripción: "+descripcionProyecto3+"\nTipo: "+tipoProyecto3+"\nCantidad Necesaria: "+cantidadNecesariaProyecto3+"\nCantidad Financiada: "+cantidadFinanciadaProyecto3+"\nFecha Inicial: "+fechaInicioProyecto3+"\nFecha Final: "+fechaFinProyecto3);
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
        int primerSubmenu,segundoSubmenu, contadorProyectos = 0;

        do {
            menuUser();
            seleccionTipoUsuario = leerOpcionNumerica();
            boolean entry;
            entry=logged(seleccionTipoUsuario, userAdmin, passAdmin,  userGestor, passGestor,  userInversor1, passInversor1,  userInversor2, passInversor2);
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

                        }
                        case 3->{

                        }
                    }
                    if(primerSubmenu==2){
                        mostrarProyectosAdmin(nombreProyecto1,nombreProyecto2,nombreProyecto3,tipoProyecto1,tipoProyecto2,tipoProyecto3,
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
                }while (primerSubmenu!=4);



            }

            //
            if (seleccionTipoUsuario == 2) { //&& Si usuario esta desbloquado que acceda, venga Adrián, tu lo puedes sacar.
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
                            crearCFinanciadaProyecto();
                            cantidadFinanciadaProyecto1 = leerOpcionDouble();
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
                            crearCFinanciadaProyecto();
                            cantidadFinanciadaProyecto2 = leerOpcionDouble();
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
                            crearCFinanciadaProyecto();
                            cantidadFinanciadaProyecto3 = leerOpcionDouble();
                            crearFInicioProyecto();
                            fechaInicioProyecto3 = leerOpcionLiteral();
                            crearFFinProyecto();
                            fechaFinProyecto3 = leerOpcionLiteral();
                            contadorProyectos++;
                            proyecto3=true;
                        } else System.out.println("No se pueden crear más proyectos");
                    }
                }while(primerSubmenu!=4);
            }
            if(seleccionTipoUsuario==3){
                if (userInversor1.equalsIgnoreCase("inversor1")) {
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
                                mostrarProyectosAdmin(nombreProyecto1,nombreProyecto2,nombreProyecto3,tipoProyecto1,tipoProyecto2,tipoProyecto3,
                                        cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3,
                                        cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);
                            }
                            case 4->{
                                System.out.println("Tienes " + dineroInversor1 + "€");
                                System.out.print("Introduzca el saldo que quiere añadir a su cartera digital: ");
                                dineroInversor1+=leerOpcionDouble();
                            }
                        }
                    }while(primerSubmenu!=6);
                }
                if (userInversor2.equalsIgnoreCase("inversor2")) {
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
                                mostrarProyectosAdmin(nombreProyecto1,nombreProyecto2,nombreProyecto3,tipoProyecto1,tipoProyecto2,tipoProyecto3,
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
                        }
                    }while(primerSubmenu!=6);
                }
            }
        }while(seleccionTipoUsuario!=4);
    }
}
