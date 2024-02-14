package Biblioteca;
import static Biblioteca.Lectura_De_Datos.leerOpcionNumerica;

public class Menus {
    public static void menuInicio(){
        System.out.println("Seleccione qué quiere hacer: \n1. Registro\n2. Iniciar sesión\n3. Salir");
    }
    public static void menuUser () {
        System.out.println("Seleccione su tipo usuario:\n1. Administrador.\n2. Gestor.\n3. Inversor.\n4. Para Salir.");
    }
    public static void menuProyectosGestor(){
        System.out.println("Seleccione que desea realizar con los proyectos: \n1. Mostrar proyectos creados.\n2. Crear nuevo proyecto.\n3. Configuración.\n4. Salir");
    }
    public static void menuAdministrador(){
        System.out.println("Seleccione dónde quiere acceder: \n1. Panel de control\n2. Proyectos\n3. Configuración\n4. Salir");
    }
    public static void menuModificarProyecto(){
        System.out.println("Elija qué quiere modificar:\n1.Nombre\n2.Descripcion\n3.Tipo\n4.Cantidad necesaria\n5.Cantidad Financiada" +
                "\n6.Fecha inicio\n7.Fecha fin\n8.Nada");
    }
    public static void menuInversor(){
        System.out.println("Seleccione donde quiere acceder: \n1. Panel de Control\n2. Mis inversiones\n3. Proyectos\n4. Cartera Virtual\n5. Configuración\n6. Salir");
    }
    public static void menuConfiguracion(){
        System.out.println("Seleccione qué quiere hacer:");
        System.out.println("1. Cambiar usuario\n2. Cambiar contraseña\n3.Salir");
    }

    public static void mostrarListaUsuarios (int opcion, String[][] datosGestores, String[][] datosInversores, boolean[] gestoresBloqueados,boolean[] inversoresBloqueados) {
        switch (opcion) {
            case 1 -> {
                for (int i = 0; i < datosGestores[0].length; i++) {
                    if (datosGestores[0][i]!=null) System.out.println(i + ". " + datosGestores[0][i] + " - " + (gestoresBloqueados[i] ? "Bloqueado" : "Habilitado"));
                }
            }
            case 2 -> {
                for (int i = 0; i < datosInversores[0].length; i++) {
                    if (datosInversores[0][i]!=null) System.out.println(i + ". " + datosInversores[0][i] + " - " + (inversoresBloqueados[i] ? "Bloqueado" : "Habilitado"));
                }
            }
            case 3 -> System.out.println("");
            default -> System.out.println("Opción no disponible");
        }
    }
    public static void bloquearDesbloquearUsuario (int opcion, int posicion, String[][] datosGestores, String[][] datosInversores, boolean[] gestoresBloqueados,boolean[] inversoresBloqueados) {
        switch (opcion) {
            case 1 -> {
                if ((posicion >= 0 && posicion<gestoresBloqueados.length) && datosGestores[0][posicion]!=null) {
                    if (!gestoresBloqueados[posicion]) gestoresBloqueados[posicion] = true;
                    else gestoresBloqueados[posicion]=false;
                }
                else System.out.println("Este usuario no existe.");
            }
            case 2 -> {
                if ((posicion >= 0 && posicion<inversoresBloqueados.length) && datosInversores[0][posicion]!=null) {
                    if (!inversoresBloqueados[posicion]) inversoresBloqueados[posicion] = true;
                    else inversoresBloqueados[posicion]=false;
                }
                else System.out.println("Este usuario no existe.");
            }
            default -> System.out.println("");
        }
    }
    public static void panelControlAdmin(String[][] datosGestores, String[][] datosInversores, boolean[] gestoresBloqueados,boolean[] inversoresBloqueados){
        int opcion;
        do {
            System.out.println("Menú del panel de control de usuarios, estos son los usuarios del sistema.");
            System.out.println("Seleccione que tipo de usuario desea administrar.\n1. Gestor.\n2. Inversor.\n3. Salir");
            opcion = leerOpcionNumerica();
            if (opcion != 3) {
                mostrarListaUsuarios(opcion, datosGestores, datosInversores, gestoresBloqueados, inversoresBloqueados);
                System.out.println("Seleccione el usuario que desea bloquear/habilitar:");
                int posicion = leerOpcionNumerica();
                bloquearDesbloquearUsuario(opcion, posicion, datosGestores, datosInversores, gestoresBloqueados, inversoresBloqueados);
            }
        } while (opcion != 3);
    }

}
