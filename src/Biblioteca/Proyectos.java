package Biblioteca;

import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class Proyectos {
    public static void mostrarProyectosNoAdmin(String nombreProyecto1, String nombreProyecto2, String nombreProyecto3, String tipoProyecto1, String tipoProyecto2, String tipoProyecto3,
                                               double cantidadNecesariaProyecto1, double cantidadNecesariaProyecto2, double cantidadNecesariaProyecto3,
                                               double cantidadFinanciadaProyecto1, double cantidadFinanciadaProyecto2, double cantidadFinanciadaProyecto3){
        System.out.println("\t\t\t\tProyecto 1 \t\t\t Proyecto 2 \t\t\t Proyecto 3");
        System.out.println("Nombre: \t" + nombreProyecto1 + nombreProyecto2 + nombreProyecto3);
        System.out.println("Tipo: \t\t" + tipoProyecto1 + tipoProyecto2 + tipoProyecto3);
        System.out.printf("Cantidad Necesaria: %.2f\t %.2f\t %.2f\n",cantidadNecesariaProyecto1,cantidadNecesariaProyecto2,cantidadNecesariaProyecto3);
        System.out.printf("Cantidad Financiada: %.2f\t %.2f\t %.2f\n",cantidadFinanciadaProyecto1,cantidadFinanciadaProyecto2,cantidadFinanciadaProyecto3);
    }
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

    public static String cambiarNombreProyecto(){
        System.out.println("Escriba el nuevo nombre del proyecto: ");
        return leerOpcionLiteral();
    }
    public static String cambiarDescripcionProyecto(){
        System.out.println("Escriba la nueva descripción del proyecto: ");
        return leerOpcionLiteral();
    }
    public static String cambiarTipoProyecto(){
        System.out.println("Escriba el nuevo tipo del proyecto");
        return leerOpcionLiteral();
    }
    public static double cambiarCantidadNecesaria (){
        System.out.println("Escriba la nueva cantidad necesaria");
        return leerOpcionDouble();
    }
    public static double cambiarCantidadFinanciada (){
        System.out.println("Escriba la nueva cantidad financiada");
        return leerOpcionDouble();
    }
    public static String cambiarFechaInicio(){
        System.out.println("Escriba la nueva fecha de inicio");
        return leerOpcionLiteral();
    }
    public static String cambiarFechaFin(){
        System.out.println("Escriba la nueva fecha de fin");
        return leerOpcionLiteral();
    }

    //
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
    public static void crearGrafico(double cantidadNecesaria,double cantidadFinanciada){
        int porcentaje= (int) ((int) (cantidadFinanciada*100)/cantidadNecesaria);
        String caracterLleno="#";
        String caracterVacio="_";
        System.out.println("Cantidad financiada hasta el momento: ");
        System.out.print(caracterLleno.repeat(porcentaje));
        System.out.print(caracterVacio.repeat((100-porcentaje)));

    }
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
