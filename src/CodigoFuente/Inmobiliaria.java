package CodigoFuente;

import java.util.Objects;
import java.util.Scanner;

public class Inmobiliaria {
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
        while (!verification(user, con)) System.out.println("Contraseña incorrecta.");
        System.out.println("Bienvenid@ " + user);
        return true;
    }
    public static boolean loginGestor (String user, String pass) {
        int intentos = 3;
        while (intentos > 0 && !(verification(user, pass))) {
            intentos--;
            System.out.println("Contraseña incorrecta, Te quedan " + intentos + " intentos.");
        }
        if (intentos > 0) System.out.println("Bienvenid@ " + user);
        else {
            System.out.println("Acceso denegado, tu cuenta ha sido bloqueada, espera a que el administrador te desbloquee.");
            return false;
        }
        return true;
    }
    public static boolean loginInversor (String user, String pass) {
        System.out.println("Introduzca su contraseña");
        String passEntry = leerOpcionLiteral();System.out.println("Introduzca");
        int intentos = 3;
        while (intentos > 0 && !(passEntry.equals(pass))) {
            intentos--;
            System.out.println("Contraseña incorrecta, Te quedan " + intentos + " intentos.");
        }
        if (intentos > 0) System.out.println("Bienvenid@ " + user);
        else {
            System.out.println("Acceso denegado, tu cuenta ha sido bloqueada, espera a que el administrador te desbloquee.");
            return false;
        }
        return true;
    }
    public static boolean logged (int opcion1, String adminUser, String adminPass,  String gestorUser, String gestorPass,  String inversor1User, String inversor1Pass,  String inversor2User, String inversor2Pass) {
        boolean succesfull = false;

        switch (opcion1) {
            case 1 : {
                if (loginAdmin(adminUser, adminPass)) succesfull=true;
            }
            case 2 : {
                if (loginGestor(gestorUser, gestorPass)) succesfull=true;
            }
            case 3 : {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Introduzca su usuario:");
                    String userEntry = leerOpcionLiteral();
                    if (userEntry.equals(inversor1User)) if (loginInversor(inversor1User, inversor1Pass)) succesfull=true;
                    else if (userEntry.equals(inversor2User)) if (loginInversor(inversor2User, inversor2Pass)) succesfull=true;
                    else System.out.println("Este usuario no existe.");
                }
            }
        }
        return succesfull;
    }

    //mostrarProyectos
    public static void menuProyectos(){
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Salir");
    }

    //Administrador
    public static void menuAdministrador(){
        System.out.println("Bienvenido, administrador");
        System.out.println("Seleccione dónde quiere acceder: \n1.Panel de control\n2.Proyectos\n3.Configuración");
    }
    public static void panelControlAdmin(){
        System.out.println("Menú del panel de control de usuarios, estos son los usuarios del sistema:");
        System.out.println("1.gestor\n2.inversor1\n3. inversor2");
    }



    public static void main(String[] args) {
        do {
            menuUser();
            int opcion1 = leerOpcionNumerica();
            int opcion2, contadorProyectos = 1;
            if (opcion1==1){
                menuAdministrador();
                opcion2=leerOpcionNumerica();
                switch (opcion2){
                    case 1:{
                        panelControlAdmin();
                    }
                    case 2:{
                        menuProyectos();
                    }
                    case 3:{

                    }
                }


            }

            //
            if (opcion1 == 2) {
                menuProyectos();
                if (leerOpcionNumerica() == 2) {
                    do {
                        contadorProyectos++;
                        System.out.print("Introduzca el nombre del proyecto: ");
                        String nombreProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca una descripción para el proyecto: ");
                        String descripcionProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca el tipo del proyecto (si es préstamo, plusvalía o alquiler): ");
                        String tipoProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca la cantidad necesaria para este proyecto: ");
                        String cantidadNecesariaProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca la cantidad financiada hasta el momento: ");
                        String cantidadFinanciadaProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca la fecha inicial del proyecto: ");
                        String fechaInicialProyecto1 = leerOpcionLiteral();
                        System.out.print("Introduzca la fecha final del proyecto: ");
                        String fechaFinalProyecto1 = leerOpcionLiteral();
                    }while(contadorProyectos<=3);
                }
            }
        }while(leerOpcionNumerica()!=4);
    }
}
