package Biblioteca;

public class Menus {
    /**
     * Función la cual nos muestra el menu inicial, el menú para iniciar sesión
     * @author Alex Godino Bailen
     */
    public static void menuUser () {
        System.out.println("Seleccione su tipo de usuario\n1. Administrador.\n2. Gestor.\n3. Inversor1.\n4. Inversor2\n5. Salir");
    }

    /**
     * Función para mostrar el menú de los proyectos realizados por el gestor.
     * @author Alex Godino Bailen
     */
    public static void menuProyectosGestor(){
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Configuración.\n4. Salir");
    }

    /**
     * Función para mostrar el menú del administrador
     * @author Alex Godino Bailen
     */
    public static void menuAdministrador(){
        System.out.println("Seleccione dónde quiere acceder: \n1.Panel de control\n2.Proyectos\n3.Configuración\n4.Salir");
    }

    /**
     * Función para mostrar el menú de para que el administrador pueda modificar los proyectos creados por el gestor
     * @author Gabriela Oria Pinto
     */
    public static void menuModificarProyecto(){
        System.out.println("Elija qué quiere modificar:\n1.Nombre\n2.Descripcion\n3.Tipo\n4.Cantidad necesaria\n5.Cantidad Financiada" +
                "\n6.Fecha inicio\n7.Fecha fin\n8.Nada");
    }

    /**
     * Función para mostrar el menu del inversor
     * @author Gabriela Oria Pinto
     */
    public static void menuInversor(){
        System.out.println("Seleccione donde quiere acceder: \n1. Panel de Control\n2. Mis inversiones\n3. Proyectos\n4. Cartera Virtual\n5. Configuración\n6. Salir");
    }

    /**
     * Función para mostrar el menú de cambio de usuario y cambio de contraseña
     * @author Adrian Contreras Bueno
     */
    public static void menuConfiguracion(){
        System.out.println("Seleccione qué quiere hacer:");
        System.out.println("1. Cambiar usuario\n2. Cambiar contraseña\n3.Salir");
    }

    /**
     * Función para mostrar el menú de las inversiones realizadas por los inversores
     * @author Adrian Contreras Bueno
     * @param nombreProyecto1 como cadena
     * @param nombreProyecto2 como cadena
     * @param nombreProyecto3 como cadena
     */
    public static void menuInversiones(String nombreProyecto1,String nombreProyecto2,String nombreProyecto3){
        System.out.println("Seleccione en qué proyecto quiere invertir: ");
        System.out.printf("1.%s\n2.%s\n3.%s\n4.Salir\n",nombreProyecto1,nombreProyecto2,nombreProyecto3);
    }


}
