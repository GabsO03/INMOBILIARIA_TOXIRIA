package Biblioteca;

public class Menus {
    public static void menuUser () {
        System.out.println("Seleccione su tipo de usuario\n1. Administrador.\n2. Gestor.\n3. Inversor1.\n4. Inversor2\n5. Salir");
    }
    public static void menuProyectosGestor(){
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Configuración.\n4. Salir");
    }
    public static void menuAdministrador(){
        System.out.println("Seleccione dónde quiere acceder: \n1.Panel de control\n2.Proyectos\n3.Configuración\n4.Salir");
    }
    public static void menuModificarProyecto(){
        System.out.println("Elija qué quiere modificar: \n1.Nombre\n2.Descripcion\n3.Tipo\n4.Cantidad necesaria\n5.Cantidad Financiada" +
                "\n6.Fecha inicio\n7.Fecha fin\n8.Nada");
    }
    public static void menuInversor(){
        System.out.println("Seleccione donde quiere acceder: \n1. Panel de Control\n2. Mis inversiones\n3. Proyectos\n4. Cartera Virtual\n5. Configuración\n6. Salir");
    }
    public static void menuConfiguracion(){
        System.out.println("Seleccione qué quiere hacer:");
        System.out.println("1. Cambiar usuario\n2. Cambiar contraseña\n3.Salir");
    }
}
