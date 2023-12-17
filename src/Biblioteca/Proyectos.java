package Biblioteca;

import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class Proyectos {
    /**
     * Función para poder mostrar los proyectos a aquellos usuario que no sean los administradores
     * @author Adrian Contreras Bueno y Alex Godino Bailen
     * @param nombreProyecto1 como cadena
     * @param nombreProyecto2 como cadena
     * @param nombreProyecto3 como cadena
     * @param tipoProyecto1 como cadena
     * @param tipoProyecto2 como cadena
     * @param tipoProyecto3 como cadena
     * @param cantidadNecesariaProyecto1 como numero real
     * @param cantidadNecesariaProyecto2 como numero real
     * @param cantidadNecesariaProyecto3 como numero real
     * @param cantidadFinanciadaProyecto1 como numero real
     * @param cantidadFinanciadaProyecto2 como numero real
     * @param cantidadFinanciadaProyecto3 como numero real
     */
    public static void mostrarProyectosNoAdmin(String nombreProyecto1, String nombreProyecto2, String nombreProyecto3, String tipoProyecto1, String tipoProyecto2, String tipoProyecto3,
                                               double cantidadNecesariaProyecto1, double cantidadNecesariaProyecto2, double cantidadNecesariaProyecto3,
                                               double cantidadFinanciadaProyecto1, double cantidadFinanciadaProyecto2, double cantidadFinanciadaProyecto3){
        System.out.println("\t\t\t\tProyecto 1 \t\t\t Proyecto 2 \t\t\t Proyecto 3");
        System.out.println("Nombre: \t" + nombreProyecto1 + nombreProyecto2 + nombreProyecto3);
        System.out.println("Tipo: \t\t" + tipoProyecto1 + tipoProyecto2 + tipoProyecto3);
        System.out.printf("Cantidad Necesaria: %.2f\t %.2f\t %.2f\n",cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3);
        System.out.printf("Cantidad Financiada: %.2f\t %.2f\t %.2f\n",cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);
    }

    /**
     * Función para poder mostrar los proyectos al administrador
     * @author Adrian Contreras Bueno y Alex Godino Bailen
     * @param nombreProyecto1 como cadena
     * @param nombreProyecto2 como cadena
     * @param nombreProyecto3 como cadena
     * @param tipoProyecto1 como cadena
     * @param tipoProyecto2 como cadena
     * @param tipoProyecto3 como cadena
     * @param cantidadNecesariaProyecto1 como numero real
     * @param cantidadNecesariaProyecto2 como numero real
     * @param cantidadNecesariaProyecto3 como numero real
     * @param cantidadFinanciadaProyecto1 como numero real
     * @param cantidadFinanciadaProyecto2 como numero real
     * @param cantidadFinanciadaProyecto3 como numero real
     */
    public static void mostrarProyectosAdmin(String nombreProyecto1, String nombreProyecto2, String nombreProyecto3, String tipoProyecto1, String tipoProyecto2, String tipoProyecto3,
                                             double cantidadNecesariaProyecto1, double cantidadNecesariaProyecto2, double cantidadNecesariaProyecto3,
                                             double cantidadFinanciadaProyecto1, double cantidadFinanciadaProyecto2, double cantidadFinanciadaProyecto3){
        System.out.println("\t\t\t\t\tProyecto 1 \t\t\t Proyecto 2 \t\t\t Proyecto 3");
        System.out.println("Nombre: \t\t" + nombreProyecto1 +"\t\t"+ nombreProyecto2 +"\t\t"+ nombreProyecto3);
        System.out.println("Tipo: \t\t\t" + tipoProyecto1+"\t\t" + tipoProyecto2 +"\t\t"+ tipoProyecto3);
        System.out.printf("Cantidad Necesaria: %.2f\t\t\t %.2f\t\t\t %.2f\n",cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3);
        System.out.printf("Cantidad Financiada: %.2f\t\t\t %.2f\t\t\t %.2f\n",cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);

        System.out.println("Elija cual quiere eliminar o modificar: \n1. Proyecto 1\n2. Proyecto 2\n3. Proyecto 3\n4.Ver más detalles\n5. Ninguno");
    }

    /**
     * Función para cambiar el nombre de algún proyecto
     * @author Alex Godino Bailen y Adrián Contreras Bueno
     * @return una cadena con el nuevo nombre del proyecto introducido por consola
     */

    public static String cambiarNombreProyecto(){
        System.out.println("Escriba el nuevo nombre del proyecto: ");
        return leerOpcionLiteral();
    }
    /**
     * Función para cambiar la descripcion de algún proyecto
     * @author Alex Godino Bailen y Adrián Contreras Bueno
     * @return una cadena con la nueva descripción del proyecto introducida por consola
     */
    public static String cambiarDescripcionProyecto(){
        System.out.println("Escriba la nueva descripción del proyecto: ");
        return leerOpcionLiteral();
    }
    /**
     * Función para cambiar el tipo de algún proyecto
     * @author Alex Godino Bailen y Adrián Contreras Bueno
     * @return una cadena con el nuevo tipo del proyecto introducido por consola
     */
    public static String cambiarTipoProyecto(){
        System.out.println("Escriba el nuevo tipo del proyecto");
        return leerOpcionLiteral();
    }
    /**
     * Función para cambiar la cantidad necesaria de algún proyecto
     * @author Alex Godino Bailen y Adrián Contreras Bueno
     * @return un número real con la nueva cantidad necesaria del proyecto introducida por consola
     */
    public static double cambiarCantidadNecesaria (){
        System.out.println("Escriba la nueva cantidad necesaria");
        return leerOpcionDouble();
    }
    /**
     * Función para cambiar la cantidad financiada hasta el momento de algún proyecto
     * @author Alex Godino Bailen y Adrián Contreras Bueno
     * @return un número real con la nueva cantidad financiada hasta el momento del proyecto introducida por consola
     */
    public static double cambiarCantidadFinanciada (){
        System.out.println("Escriba la nueva cantidad financiada");
        return leerOpcionDouble();
    }
    /**
     * Función para cambiar la fecha inicial de algún proyecto
     * @author Alex Godino Bailen y Adrián Contreras Bueno
     * @return una cadena con la nueva fecha inicial del proyecto introducida por consola
     */
    public static String cambiarFechaInicio(){
        System.out.println("Escriba la nueva fecha de inicio");
        return leerOpcionLiteral();
    }
    /**
     * Función para cambiar la fecha final de algún proyecto
     * @author Alex Godino Bailen y Adrián Contreras Bueno
     * @return una cadena con la nueva fecha final del proyecto introducida por consola
     */
    public static String cambiarFechaFin(){
        System.out.println("Escriba la nueva fecha de fin");
        return leerOpcionLiteral();
    }

    /**
     * Función para crear un proyecto en donde leemos el nombre, que es introducido por consola
     * @author Adrián Contreras Bueno y Alex Godino Bailen
     */
    public static void crearNombreProyecto(){
        System.out.print("Introduzca el nombre del proyecto: ");
    }

    /**
     * Función para crear un proyecto en donde leemos la descripción, que es introducido por consola
     * @author Adrián Contreras Bueno y Alex Godino Bailen
     */
    public static void crearDescripcionProyecto(){
        System.out.print("Introduzca la descripción del proyecto: ");
    }

    /**
     * Función para crear un proyecto en donde leemos el tipo, que es introducido por consola
     * @author Adrián Contreras Bueno y Alex Godino Bailen
     */
    public static void crearTipoProyecto(){
        System.out.print("Introduzca el Tipo del proyecto (Préstamo, Plusvalía o Alquiler): ");
    }

    /**
     * Función para crear un proyecto en donde leemos la cantidad necesaria, que es introducido por consola
     * @author Adrián Contreras Bueno y Alex Godino Bailen
     */
    public static void crearCNecesariaProyecto(){
        System.out.print("Introduzca la cantidad necesaria del proyecto: ");
    }
    /**
     * Función para crear un proyecto en donde leemos la cantidad financiada hasta el momento, que es introducido por consola
     * @author Adrián Contreras Bueno y Alex Godino Bailen
     */
    public static void crearCFinanciadaProyecto(){
        System.out.print("Introduzca la cantidad financiada hasta el momento del proyecto: ");
    }
    /**
     * Función para crear un proyecto en donde leemos su fecha inicial, que es introducido por consola
     * @author Adrián Contreras Bueno y Alex Godino Bailen
     */
    public static void crearFInicioProyecto(){
        System.out.print("Introduzca la fecha de inicio del proyecto (dd/mm/aaaa): ");
    }
    /**
     * Función para crear un proyecto en donde leemos su fecha final, que es introducido por consola
     * @author Adrián Contreras Bueno y Alex Godino Bailen
     */
    public static void crearFFinProyecto(){
        System.out.print("Introduzca la fecha final del proyecto (dd/mm/aaaa): ");
    }

    /**
     * Función para calcular y mostrar el gráfico de las inversiones que se realizan para cada proyecto
     * @author Adrián Contreras Bueno
     * @param cantidadNecesaria como número real
     * @param cantidadFinanciada como número real
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
     * Función para mostrar todos los detalles que tiene un proyecto
     * @author Adrián Contreras Bueno y Alex Godino Bailen
     * @param nombreProyecto1 como cadena
     * @param nombreProyecto2 como cadena
     * @param nombreProyecto3 como cadena
     * @param descripcionProyecto1 como cadena
     * @param descripcionProyecto2 como cadena
     * @param descripcionProyecto3 como cadena
     * @param tipoProyecto1 como cadena
     * @param tipoProyecto2 como cadena
     * @param tipoProyecto3 como cadena
     * @param cantidadNecesariaProyecto1 como número real
     * @param cantidadNecesariaProyecto2 como número real
     * @param cantidadNecesariaProyecto3 como número real
     * @param cantidadFinanciadaProyecto1 como número real
     * @param cantidadFinanciadaProyecto2 como número real
     * @param cantidadFinanciadaProyecto3 como número real
     * @param fechaInicioProyecto1 como cadena
     * @param fechaInicioProyecto2 como cadena
     * @param fechaInicioProyecto3 como cadena
     * @param fechaFinProyecto1 como cadena
     * @param fechaFinProyecto2 como cadena
     * @param fechaFinProyecto3 como cadena
     */
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
}
