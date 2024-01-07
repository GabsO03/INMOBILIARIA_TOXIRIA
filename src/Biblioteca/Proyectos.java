package Biblioteca;

import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class Proyectos {

    /**
     * Funcion para mostrar los proyectos para los no admin
     * @author Gabriela Oria Pinto
     * @param proyectsStringData array de dos dimensiones como cadena
     * @param proyectsFinantialData array de dos dimensiones como números decimales
     * @param contadorProyectos como entero
     */
    public static void mostrarProyectosNoAdmin (String[][] proyectsStringData, double[][] proyectsFinantialData, int contadorProyectos) {
        System.out.println();
        System.out.print("Posición: \t\t\t\t");
        for (int i = 0; i < proyectsStringData[0].length; i++) if (proyectsStringData[0][i] != null) System.out.print("Proyecto " + (i+1) + "\t\t\t\t");
        System.out.println();
        System.out.print("Nombre: \t\t\t\t");
        for (int i = 0; i < proyectsStringData[0].length; i++) if (proyectsStringData[0][i] != null) System.out.print(proyectsStringData[0][i] + "\t\t\t\t");
        System.out.println();
        System.out.print("Tipo: \t\t\t\t\t");
        for (int i = 0; i < proyectsStringData[2].length; i++) if (proyectsStringData[2][i] != null) System.out.print(proyectsStringData[2][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.print("Cantidad Necesaria:\t\t");
        for (int i = 0; i < proyectsFinantialData[0].length; i++) if (proyectsFinantialData[0][i] != 0) System.out.print(proyectsFinantialData[0][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.print("Cantidad Financiada:\t");
        for (int i = 0; i < proyectsFinantialData[1].length; i++) if (proyectsFinantialData[1][i] != 0) System.out.print(proyectsFinantialData[1][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.println("Existen " + contadorProyectos + " habilitados.");
    }

    /**
     * Función para mostrar los proyectos de los admins
     * @param proyectsStringData array de dos dimensiones como cadena
     * @param proyectsFinantialData array de dos dimensiones como numero decimal
     */
    public static void mostrarProyectosAdmin(String[][] proyectsStringData, double[][] proyectsFinantialData){
        System.out.println();
        System.out.print("Posición: \t\t\t\t");
        for (int i = 0; i < proyectsStringData[0].length; i++) if (proyectsStringData[0][i] != null) System.out.print("Proyecto " + (i+1) + "\t\t\t\t");
        System.out.println();
        System.out.print("Nombre: \t\t\t\t");
        for (int i = 0; i < proyectsStringData[0].length; i++) if (proyectsStringData[0][i] != null) System.out.print(proyectsStringData[0][i] + "\t\t\t\t");
        System.out.println();
        System.out.print("Tipo: \t\t\t\t\t");
        for (int i = 0; i < proyectsStringData[2].length; i++) if (proyectsStringData[2][i] != null) System.out.print(proyectsStringData[2][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.print("Cantidad Necesaria:\t\t");
        for (int i = 0; i < proyectsFinantialData[0].length; i++) if (proyectsFinantialData[0][i] != 0) System.out.print(proyectsFinantialData[0][i] + "\t\t\t\t\t");
        System.out.println();
        System.out.print("Cantidad Financiada:\t");
        for (int i = 0; i < proyectsFinantialData[1].length; i++) if (proyectsFinantialData[1][i] != 0) System.out.print(proyectsFinantialData[1][i] + "\t\t\t\t\t");
        System.out.println();

        System.out.println("Escriba 0 para ver más detalles.\nEscriba -1 para salir.\nO digite la posición del proyecto que quiere eliminar o modificar");
    }

    /**
     * Funcion para cambiar el nombre a los proyectos
     * @author Gabriela Oria Pinto
     * @return el nuevo nombre del proyecto
     */
    public static String cambiarNombreProyecto(){
        System.out.println("Escriba el nuevo nombre del proyecto: ");
        return leerOpcionLiteral();
    }
    /**
     * Funcion para cambiar la descripción a los proyectos
     * @author Gabriela Oria Pinto
     * @return la nueva descripcion del proyecto
     */
    public static String cambiarDescripcionProyecto(){
        System.out.println("Escriba la nueva descripción del proyecto: ");
        return leerOpcionLiteral();
    }
    /**
     * Funcion para cambiar el tipo a los proyectos
     * @author Gabriela Oria Pinto
     * @return el nuevo tipo del proyecto
     */
    public static String cambiarTipoProyecto(){
        System.out.println("Escriba el nuevo tipo del proyecto");
        return leerOpcionLiteral();
    }
    /**
     * Funcion para cambiar la cantidad necesaria a los proyectos
     * @author Gabriela Oria Pinto
     * @return la nueva cantidad del proyecto
     */
    public static double cambiarCantidadNecesaria (){
        System.out.println("Escriba la nueva cantidad necesaria");
        return leerOpcionDouble();
    }
    /**
     * Funcion para cambiar la cantidad financiada de los proyectos
     * @author Gabriela Oria Pinto
     * @return la nueva cantidad financiada del proyecto
     */
    public static double cambiarCantidadFinanciada (){
        System.out.println("Escriba la nueva cantidad financiada");
        return leerOpcionDouble();
    }
    /**
     * Funcion para cambiar la fecha inicial a los proyectos
     * @author Gabriela Oria Pinto
     * @return la nueva fecha inicial del proyecto
     */
    public static String cambiarFechaInicio(){
        System.out.println("Escriba la nueva fecha de inicio");
        return leerOpcionLiteral();
    }
    /**
     * Funcion para cambiar la fecha final a los proyectos
     * @author Gabriela Oria Pinto
     * @return la nueva fecha final del proyecto
     */
    public static String cambiarFechaFin(){
        System.out.println("Escriba la nueva fecha de fin");
        return leerOpcionLiteral();
    }
    /**
     * Funcion para crear el nombre del proyecto
     * @author Gabriela Oria Pinto
     * @param posicion como entero
     * @return el nombre introducido del proyecto
     */
    public static String crearNombreProyecto(int posicion){
        System.out.print("Introduzca el nombre del proyecto "+posicion+": ");
        return leerOpcionLiteral();
    }
    /**
     * Funcion para crear la descripcion del proyecto
     * @author Gabriela Oria Pinto
     * @param posicion como entero
     * @return la descripcion introducida del proyecto
     */
    public static String crearDescripcionProyecto(int posicion){
        System.out.print("Introduzca la descripción del proyecto"+posicion+": ");
        return leerOpcionLiteral();
    }
    /**
     * Funcion para crear el tipo del proyecto
     * @author Gabriela Oria Pinto
     * @param posicion como entero
     * @return el tipo introducido del proyecto
     */
    public static String crearTipoProyecto(int posicion){
        System.out.print("Introduzca el Tipo del proyecto (Préstamo, Plusvalía o Alquiler)"+posicion+": ");
        return leerOpcionLiteral();
    }
    /**
     * Funcion para crear la cantidad necesaria del proyecto
     * @author Gabriela Oria Pinto
     * @param posicion como entero
     * @return la cantidad necesaria introducido del proyecto
     */
    public static double crearCNecesariaProyecto(int posicion){
        System.out.print("Introduzca la cantidad necesaria del proyecto"+posicion+": ");
        return leerOpcionDouble();
    }
    /**
     * Funcion para crear la cantidad financiada del proyecto
     * @author Gabriela Oria Pinto
     * @param posicion como entero
     * @return la cantidad financiada introducido del proyecto
     */
    public static double crearCFinanciadaProyecto(int posicion){
        System.out.print("Introduzca la cantidad financiada hasta el momento del proyecto"+posicion+": ");
        return leerOpcionDouble();
    }
    /**
     * Funcion para crear la fecha inicial del proyecto
     * @author Gabriela Oria Pinto
     * @param posicion como entero
     * @return la fecha inicial introducido del proyecto
     */
    public static String crearFInicioProyecto(int posicion){
        System.out.print("Introduzca la fecha de inicio del proyecto (dd/mm/aaaa)"+posicion+": ");
        return leerOpcionLiteral();
    }
    /**
     * Funcion para crear la fecha final del proyecto
     * @author Gabriela Oria Pinto
     * @param posicion como entero
     * @return la fecha final introducido del proyecto
     */
    public static String crearFFinProyecto(int posicion){
        System.out.print("Introduzca la fecha final del proyecto (dd/mm/aaaa)"+posicion+": ");
        return leerOpcionLiteral();
    }

    /**
     * Función para crear el Gráfico de los proyectos
     * @param cantidadNecesaria como número decimal
     * @param cantidadFinanciada como número decimal
     */
    public static void crearGrafico(double cantidadNecesaria,double cantidadFinanciada){
        int porcentaje= (int) ((int) (cantidadFinanciada*100)/cantidadNecesaria);
        String caracterLleno="#";
        String caracterVacio="_";
        System.out.println("Cantidad financiada hasta el momento: ");
        System.out.print(caracterLleno.repeat(porcentaje));
        System.out.print(caracterVacio.repeat((100-porcentaje)));

    }

    /**
     * Función para mostrar los detalles de los proyectos
     * @param proyectsStringData array de dos dimensiones como cadena
     * @param proyectsFinantialData array de dos dimensiones como número decimal
     */
    public static void proyectosDetallados(String[][] proyectsStringData, double[][] proyectsFinantialData){
        for (int i = 0; i < proyectsStringData[0].length; i++) {
            if (proyectsStringData[0][i] != null) {
                System.out.println("Proyecto "+(i+1));
                System.out.println("Nombre: " + proyectsStringData[0][i] + "\nDescripción: " + proyectsStringData[1][i] +"\nTipo: " + proyectsStringData[2][i]  + "\nFecha Inicial: " + proyectsStringData[3][i] + "\nFecha Final: " + proyectsStringData[4][i] + "\nCantidad Necesaria: " + proyectsFinantialData[0][i] + "\nCantidad Financiada: " + proyectsFinantialData[1][i]);
                System.out.println("Gráfico:");
                crearGrafico(proyectsFinantialData[0][i], proyectsFinantialData[1][i]);
                System.out.println();
            }
        }
    }
}
