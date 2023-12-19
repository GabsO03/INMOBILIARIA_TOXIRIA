package Biblioteca;

import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;

public class Proyectos {
    public static void mostrarProyectosNoAdmin (String[] nombresProyectos, String[] tiposProyectos,
                                                double[] cantidadesNecesariasProyectos, double[] cantidadesFinanciadasProyectos){

        System.out.println("\t\t\t\tProyecto 1 \t\t\t Proyecto 2 \t\t\t Proyecto 3");
        System.out.println("Nombre: \t"+nombresProyectos[0]+nombresProyectos[1]+nombresProyectos[2]);
        System.out.println("Tipo: \t\t"+tiposProyectos[0]+tiposProyectos[1]+tiposProyectos[2]);
        System.out.printf("Cantidad Necesaria: %.2f\t %.2f\t %.2f\n",cantidadesNecesariasProyectos[0],cantidadesNecesariasProyectos[1],cantidadesNecesariasProyectos[2]);
        System.out.printf("Cantidad Financiada: %.2f\t %.2f\t %.2f\n",cantidadesFinanciadasProyectos[0],cantidadesFinanciadasProyectos[1],cantidadesFinanciadasProyectos[2]);
    }

    public static void mostrarProyectosAdmin(String[] nombresProyectos, String[] tiposProyectos,
                                             double[] cantidadesNecesariasProyectos, double[] cantidadesFinanciadasProyectos){

        System.out.println("\t\t\t\tProyecto 1 \t\t\t Proyecto 2 \t\t\t Proyecto 3");
        System.out.println("Nombre: \t"+nombresProyectos[0] +"\t\t\t"+ nombresProyectos[1] +"\t\t\t"+ nombresProyectos[2]);
        System.out.println("Tipo: \t\t"+tiposProyectos[0] +"\t\t\t"+ tiposProyectos[1] +"\t\t\t"+ tiposProyectos[2]);
        System.out.printf("Cantidad Necesaria: %.2f\t\t %.2f\t\t %.2f\n",cantidadesNecesariasProyectos[0],cantidadesNecesariasProyectos[1],cantidadesNecesariasProyectos[2]);
        System.out.printf("Cantidad Financiada: %.2f\t\t %.2f\t\t %.2f\n",cantidadesFinanciadasProyectos[0],cantidadesFinanciadasProyectos[1],cantidadesFinanciadasProyectos[2]);

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
    public static String crearNombreProyecto(int posicion){
        System.out.print("Introduzca el nombre del proyecto "+posicion+": ");
        return leerOpcionLiteral();
    }
    public static String crearDescripcionProyecto(int posicion){
        System.out.print("Introduzca la descripción del proyecto"+posicion+": ");
        return leerOpcionLiteral();
    }
    public static String crearTipoProyecto(int posicion){
        System.out.print("Introduzca el Tipo del proyecto (Préstamo, Plusvalía o Alquiler)"+posicion+": ");
        return leerOpcionLiteral();
    }
    public static double crearCNecesariaProyecto(int posicion){
        System.out.print("Introduzca la cantidad necesaria del proyecto"+posicion+": ");
        return leerOpcionDouble();
    }
    public static double crearCFinanciadaProyecto(int posicion){
        System.out.print("Introduzca la cantidad financiada hasta el momento del proyecto"+posicion+": ");
        return leerOpcionDouble();
    }
    public static String crearFInicioProyecto(int posicion){
        System.out.print("Introduzca la fecha de inicio del proyecto (dd/mm/aaaa)"+posicion+": ");
        return leerOpcionLiteral();
    }
    public static String crearFFinProyecto(int posicion){
        System.out.print("Introduzca la fecha final del proyecto (dd/mm/aaaa)"+posicion+": ");
        return leerOpcionLiteral();
    }
    public static void crearGrafico(double cantidadNecesaria,double cantidadFinanciada){
        int porcentaje= (int) ((int) (cantidadFinanciada*100)/cantidadNecesaria);
        String caracterLleno="#";
        String caracterVacio="_";
        System.out.println("Cantidad financiada hasta el momento: ");
        System.out.print(caracterLleno.repeat(porcentaje));
        System.out.print(caracterVacio.repeat((100-porcentaje)));

    }

    public static void proyectosDetallados(String[] nombresProyectos, String[] descripcionesProyectos, String[] tiposProyectos,
                                           double[] cantidadesNecesariasProyecto, double[] cantidadesFinanciadasProyectos,
                                           String[] fechasIniciosProyectos, String[] fechasFinProyectos){
        System.out.println("Proyecto 1: ");
        System.out.println("Nombre: "+nombresProyectos[0]+"\nDescripción: "+descripcionesProyectos[0]+"\nTipo: "+tiposProyectos[0]+"\nCantidad Necesaria: "+cantidadesNecesariasProyecto[0]+"\nCantidad Financiada: "+cantidadesFinanciadasProyectos[0]+"\nFecha Inicial: "+fechasIniciosProyectos[0]+"\nFecha Final: "+fechasFinProyectos[0]);
        System.out.println("Gráfico:");
        crearGrafico(cantidadesFinanciadasProyectos[0],cantidadesFinanciadasProyectos[0]);
        System.out.println("\nProyecto 2: ");
        System.out.println("Nombre: "+nombresProyectos[1]+"\nDescripción: "+descripcionesProyectos[1]+"\nTipo: "+tiposProyectos[1]+"\nCantidad Necesaria: "+cantidadesNecesariasProyecto[1]+"\nCantidad Financiada: "+cantidadesFinanciadasProyectos[1]+"\nFecha Inicial: "+fechasIniciosProyectos[1]+"\nFecha Final: "+fechasFinProyectos[1]);
        System.out.println("Gráfico:");
        crearGrafico(cantidadesFinanciadasProyectos[1],cantidadesFinanciadasProyectos[1]);
        System.out.println("\nProyecto 3: ");
        System.out.println("Nombre: "+nombresProyectos[2]+"\nDescripción: "+descripcionesProyectos[2]+"\nTipo: "+tiposProyectos[2]+"\nCantidad Necesaria: "+cantidadesNecesariasProyecto[2]+"\nCantidad Financiada: "+cantidadesFinanciadasProyectos[2]+"\nFecha Inicial: "+fechasIniciosProyectos[2]+"\nFecha Final: "+fechasFinProyectos[2]);
        System.out.println("Gráfico:");
        crearGrafico(cantidadesFinanciadasProyectos[2],cantidadesFinanciadasProyectos[2]);
        System.out.println();
    }
}
