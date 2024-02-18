package CodigoFuente;


//COLORES
import java.time.LocalDate;

//MENUS
import static Biblioteca.AccountSettings.registroUsuarioNuevo;

//LEER TEXTO
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;
import static Biblioteca.Lectura_De_Datos.leerOpcionNumerica;

//PROYECTOS
import static Biblioteca.Menus.*;

public class Inmobiliaria_toxiria {

    public static void main(String[] args) {
        //USUARIOS
        GestionUsuarios usuarios=new GestionUsuarios(50);
        usuarios.insertarUsuarioAdmin("Adrian","AdrianCB27","AdrianCon123@","contrerasbuenoadrian@gmail.com");
        //BLOQUEOS

        //PROYECTOS
        GestionProyectos proyectos = new GestionProyectos(20);
        proyectos.crearProyecto("Villa verde", "La villa más fea","Plusvalía", LocalDate.now(), LocalDate.now().plusMonths(5), 4521.56f, 521.56f);
        proyectos.crearProyecto("Villa azul", "La villa más bonita", "Préstamo", LocalDate.now().plusDays(5), LocalDate.now().plusMonths(9), 85112.54, 5112.54);

        //INVERSIONES
        GestionInversiones[] megaGestionInversiones = new GestionInversiones[50];
        int cantidadGestionInversiones = 0;

        //Menus
        int seleccionInicial;

        //REGISTRO
        String tipoNuevoUsuario;
        boolean registroCorrecto;
        //INICIO DE SESION
        String nombreUsuario,contrasenia;



        do {
            menuInicio();
            seleccionInicial=leerOpcionNumerica();
            switch (seleccionInicial) {
                case 1 -> {
                    do {
                        do {
                            System.out.println("Escriba su tipo de usuario (I)Inversor (G)Gestor: ");
                            tipoNuevoUsuario = leerOpcionLiteral();
                            if (!tipoNuevoUsuario.equalsIgnoreCase("G") && !tipoNuevoUsuario.equalsIgnoreCase("I"))
                                System.out.println("Error, tiene que escribir 'G' o 'I'");
                        } while (!tipoNuevoUsuario.equalsIgnoreCase("G") && !tipoNuevoUsuario.equalsIgnoreCase("I"));
                        registroCorrecto = registroUsuarioNuevo(tipoNuevoUsuario, usuarios, megaGestionInversiones, cantidadGestionInversiones++);
                        if (registroCorrecto) System.out.println("Usuario registrado correctamente");
                        else System.out.println("Hubo un error, intente de nuevo.");
                    } while (!registroCorrecto);
                }
                case 2 -> {
                    int posicionLogin;
                    do {
                        System.out.print("Nombre de usuario: ");
                        nombreUsuario = leerOpcionLiteral();
                        System.out.print("Contraseña: ");
                        contrasenia = leerOpcionLiteral();
                        posicionLogin = usuarios.existeUsuario(nombreUsuario, contrasenia);
                        if (posicionLogin < 0)  System.out.println("El usuario o contraseña no es correcto");
                    } while (posicionLogin < 0);
                    String claseUsuario = usuarios.averiguarClase(posicionLogin);
                    switch (claseUsuario) {
                        case "Admin" -> menuAdmin(posicionLogin, usuarios, proyectos);
                        case "Gestor" -> menuGestor(posicionLogin, usuarios, proyectos);
                        case "Inversor" -> menuInversor(posicionLogin, usuarios, proyectos, megaGestionInversiones);
                    }
                }
                case 3 -> System.out.println("Saliendo de la operación.");
                default -> System.out.println("Invalid response");
            }
        }while(seleccionInicial!=3);
    }
}