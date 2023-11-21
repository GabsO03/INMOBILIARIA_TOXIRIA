package CodigoFuente;
import java.util.Scanner;
public class Inmobiliaria {
    //Funciones para el login.
    public static void menuPrincipal () {
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


    public static boolean logged (int opcion1, String usuario, String contrasenia) {
        boolean succesfull = false;

        String adminUser = "adminUser", adminPass = "adminPass",
                gestorUser = "gestorUser", gestorPass = "gestorPass",
                inversor1User = "inversor1User", inversor1Pass = "inversor1Pass",
                inversor2User = "inversor2User", inversor2Pass = "inversor2Pass";
        boolean logged = switch (opcion1) {
            case 1 -> loginAdmin(adminUser, adminPass);
            case 2 -> loginGestor(gestorUser, gestorPass);
           // case 3 -> System.out.println(0);

            default -> true;
        };
        return succesfull;
    }



    //mostrarProyectos




    public static void main(String[] args) {
        int opcion1 = leerOpcionNumerica();
        menuPrincipal();
    }
}
