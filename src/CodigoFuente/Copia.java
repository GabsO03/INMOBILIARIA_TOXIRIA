package CodigoFuente;

import java.util.Scanner;

public class Copia {
    public static void menuUser () {
        System.out.println("Seleccione su tipo de usuario\n1. Administrador.\n2. Gestor.\n3. Inversor.\n4. Salir");
    }
    public static int leerOpcionNumerica () {
        Scanner escaner = new Scanner(System.in);
        return Integer.parseInt(escaner.nextLine());
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
    public static void menuProyectos(){
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Salir");
    }

    //Administrador
    public static void menuAdministrador(){
        System.out.println("Bienvenido, administrador");
        System.out.println("Seleccione dónde quiere acceder: \n1.Panel de control\n2.Proyectos\n3.Configuración\n4.Salir");
    }
    public static void panelControlAdmin(boolean gestorBloqueado,boolean inversor1Bloqueado,boolean inversor2Bloqueado){
        String gestorBloqueadoCadena="",inversor1BloqueadoCadena="", inversor2BloqueadoCadena="";
        if (gestorBloqueado) gestorBloqueadoCadena="Bloqueado";
        if (inversor1Bloqueado) inversor1BloqueadoCadena="Bloqueado";
        if (inversor2Bloqueado) inversor2BloqueadoCadena="Bloqueado";
        System.out.println("Menú del panel de control de usuarios, estos son los usuarios del sistema:");
        System.out.println("Seleccione cuál quiere bloquear/desbloquear");
        System.out.printf("1.gestor %s\n2.inversor1 %s\n3.inversor2 %s\n4.Salir",gestorBloqueadoCadena,inversor1BloqueadoCadena,inversor2BloqueadoCadena);

    }



    public static void main(String[] args) {
        //USUARIOS
        String userAdmin="administrador",passAdmin="administrador",userGestor="gestor",passGestor="gestor",userInversor1="inversor1"
                ,passInversor1="inversor1",userInversor2="inversor2",passInversor2="inversor2";
        //BLOQUEOS
        boolean gestorBloqueado=false,inversor1Bloqueado=false,inversor2Bloqueado=false;
        //PROYECTOS
        String nombreProyecto1="",nombreProyecto2="",nombreProyecto3="",descripcionProyecto1="",descripcionProyecto2="",descripcionProyecto3="",
                tipoProyecto1="",tipoProyecto2="",tipoProyecto3="",cantidadNecesariaProyecto1="",cantidadNecesariaProyecto2="",cantidadNecesariaProyecto3="",
                cantidadFinanciadaProyecto1="",cantidadFinanciadaProyecto2="",cantidadFinanciadaProyecto3="",fechaInicioProyecto1="",fechaInicioProyecto2="",fechaInicioProyecto3="",
                fechaFinProyecto1="",fechaFinProyecto2="",fechaFinProyecto3="";
        //INVERSOR
        double dineroInversor1=0,dineroInversor2=0;

        //Menus
        int seleccionTipoUsuario;
        int primerSubmenu,segundoSubmenu, contadorProyectos = 0;

        do {
            menuUser();
            seleccionTipoUsuario = leerOpcionNumerica();
            boolean entry;
            entry=logged(seleccionTipoUsuario, userAdmin, passAdmin,  userGestor, passGestor,  userInversor1, passInversor1,  userInversor2, passInversor2);
            System.out.println(entry);

            //
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
                            menuProyectos();

                        }
                        case 3->{

                        }
                    }
                }while (primerSubmenu!=4);



            }

            //
            if (seleccionTipoUsuario == 2) {
                menuProyectos();
                if (leerOpcionNumerica() == 2) {
                    do {
                        contadorProyectos++;
                        System.out.print("Introduzca el nombre del proyecto: ");
                        //String nombreProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca una descripción para el proyecto: ");
                        //String descripcionProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca el tipo del proyecto (si es préstamo, plusvalía o alquiler): ");
                        // String tipoProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca la cantidad necesaria para este proyecto: ");
                        // String cantidadNecesariaProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca la cantidad financiada hasta el momento: ");
                        //String cantidadFinanciadaProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca la fecha inicial del proyecto: ");
                        //String fechaInicialProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca la fecha final del proyecto: ");
                        //String fechaFinalProyecto1 = leerOpcionLiteral();
                    }while(contadorProyectos<=3);
                }
            }
        }while(seleccionTipoUsuario!=4);
    }
}
