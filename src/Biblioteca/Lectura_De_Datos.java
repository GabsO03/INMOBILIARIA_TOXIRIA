package Biblioteca;

import java.util.Scanner;

public class Lectura_De_Datos {
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
}
