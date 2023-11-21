// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean bloqueado = false, logueado = false;
        String adminUser = "adminUser", adminPass = "adminPass",
                gestorUser = "gestorUser", gestorPass = "gestorPass",
                inversor1User = "inversor1User", inversor1Pass = "inversor1Pass",
                inversor2User = "inversor2User", inverso2Pass = "inversor2Pass";
        int intentos = 3;

        Scanner s = new Scanner(System.in);

        //while(!bloqueado && !logueado && intentos>0){
            System.out.print("Bienvenido, introduzca su usuario: ");
            String entradaUsuario = s.nextLine();
            System.out.print("Introduzca su contraseña: ");
            String entradaPass = s.nextLine();

            //if(entradaUsuario.equals(usuario) && entradaPass.equals(pass)){
                logueado = true;
            //}else{
                intentos--;
                System.out.printf("\nDatos incorrectos. Le quedan %d intentos.\n", intentos);
                if(intentos == 0) bloqueado = true;
          //  }
        //}

       // if(logueado) System.out.println("Bienvenido " + usuario);
        //if(bloqueado) System.out.println("Su usuario ha sido bloqueado");

    }
}