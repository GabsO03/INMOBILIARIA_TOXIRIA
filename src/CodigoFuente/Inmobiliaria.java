package CodigoFuente;

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



    public static void main(String[] args) {
        menuUser();
        int opcion1 = leerOpcionNumerica();
        String usuario = usuario(opcion1), contrasenia = contrasena(opcion1);
        if (acceso(usuario, contrasenia)) System.out.println("YES");
        else System.out.println("NO");

    }
}
