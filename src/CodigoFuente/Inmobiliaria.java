package CodigoFuente;

import org.w3c.dom.ls.LSOutput;

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
    public static String usuario (int opcion) {
        return switch (opcion) {
            case 1 -> "administrador";
            case 2 -> "gestor";
            case 3 -> "inversor1";
            case 4 -> "inversor2";
            default -> "";
        };
    }

    public static String contrasena (int opcion) {
        return switch (opcion) {
            case 1 -> "administrador";
            case 2 -> "gestor";
            case 3 -> "inversor1";
            case 4 -> "inversor2";
            default -> "";
        };
    }

    public static boolean acceso (String usu, String con) {
        System.out.println("Introduzca su usario:");
        String user = leerOpcionLiteral();
        System.out.println("Introduzca su contraseña");
        String password = leerOpcionLiteral();
        return user.equals(usu) && password.equals(con);
    }

    //mostrarProyectos
    public static void menuProyectos(){
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Salir");
    }

    public static String creaProyectos(){
        System.out.print("Introduzca el nombre del proyecto: ");
        String nombreProyecto= leerOpcionLiteral();
        System.out.print("Introduzca una descripción para el proyecto: ");
        String descripcionProyecto= leerOpcionLiteral();
        System.out.print("Introduzca el tipo del proyecto (si es préstamo, plusvalía o alquiler): ");
        String tipoProyecto= leerOpcionLiteral();
        System.out.print("Introduzca la cantidad necesaria para este proyecto: ");
        String cantidadNecesariaProyecto= leerOpcionLiteral();
        System.out.print("Introduzca la cantidad financiada hasta el momento: ");
        String cantidadFinanciadaProyecto= leerOpcionLiteral();
        System.out.print("Introduzca la fecha inicial del proyecto: ");
        String fechaInicialProyecto= leerOpcionLiteral();
        System.out.print("Introduzca la fecha final del proyecto: ");
        String fechaFinalProyecto= leerOpcionLiteral();
        
    }

    public static void main(String[] args) {
        menuUser();
        int opcion1 = leerOpcionNumerica();
        int opcion2;
        String usuario = usuario(opcion1), contrasenia = contrasena(opcion1);
        if (acceso(usuario, contrasenia)) System.out.println("YES"); //Cambiar y poner que sea hasta 3 veces como máximo
        else System.out.println("NO");
        if(opcion1==2) {
            menuProyectos();
            if(leerOpcionNumerica()==2){
                creaProyectos();
            }
        }
    }
}
