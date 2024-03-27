package CodigoFuente;

//MENUS
import java.io.FileNotFoundException;

import static Biblioteca.AccountSettings.registroUsuarioNuevo;

//LEER TEXTO
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;
import static Biblioteca.Lectura_De_Datos.leerOpcionNumerica;

//PROYECTOS
import static Biblioteca.Menus.*;

public class Inmobiliaria_toxiria {

    public static void main(String[] args) throws FileNotFoundException {

        //Menus
        int seleccionInicial;

        //REGISTRO
        String tipoNuevoUsuario;
        boolean registroCorrecto;
        //INICIO DE SESION
        String nombreUsuario,contrasenia;

        //GUARDAR ARCHIVO JSON
        GestionApp aplicacion = new GestionApp();
        aplicacion.recuperarJSON();
        GestionUsuarios usuarios= aplicacion.getGestionUsuarios();
        GestionProyectos proyectos = aplicacion.getGestionProyectos();
        /*/USUARIOS
        usuarios.insertarUsuarioAdmin("Adrian","AdrianCB27","AdrianCon123@","contrerasbuenoadrian@gmail.com");
        usuarios.insertarUsuarioGestor("Alex","AlexGB","AlexGB123@","Alexito@gmail.com");
        usuarios.insertarUsuarioInversor("Gabriela","GabsOP","GabsOP123@","polloto@gmail.com");
        //PROYECTOS
        proyectos.crearProyecto("Villa verde", "La villa más fea","Plusvalía", "01/01/2003", "01/01/2024", 4521.56f, 521.56f);
        proyectos.crearProyecto("Villa azul", "La villa más bonita", "Préstamo", "26/06/2003", "26/06/2024", 85112.54, 5112.54);
        proyectos.crearProyecto("Villa morada", "La villa más morada", "Alquiler", "04/03/2004", "04/03/2024", 7650, 32);
        aplicacion.devuelveGestionInversiones().add(new GestionInversiones(((Inversor)usuarios.devuelveUsuario("GabsOP"))));*/


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
                        registroCorrecto = registroUsuarioNuevo(tipoNuevoUsuario, usuarios, aplicacion.devuelveGestionInversiones());
                        if (registroCorrecto)
                            System.out.println("Usuario registrado correctamente");
                        else System.out.println("Hubo un error, intente de nuevo.");
                    } while (!registroCorrecto);
                }
                case 2 -> {
                    int intentos=3;
                    do {
                        System.out.print("Nombre de usuario: ");
                        nombreUsuario = leerOpcionLiteral();
                        System.out.print("Contraseña: ");
                        contrasenia = leerOpcionLiteral();

                        if (!usuarios.existeNombreUsuario(nombreUsuario)) System.out.println("Ese usuario no existe.");
                        if (usuarios.existeNombreUsuario(nombreUsuario) && !usuarios.correspondeUsuyContrasenia(nombreUsuario, contrasenia)) {
                            System.out.println("El usuario o contraseña no es correcto. Intentos restantes: " + --intentos);
                        }
                    } while (!(usuarios.existeNombreUsuario(nombreUsuario)) || (usuarios.existeNombreUsuario(nombreUsuario) && !usuarios.correspondeUsuyContrasenia(nombreUsuario, contrasenia) && intentos > 0));

                    String claseUsuario = usuarios.averiguarClase(nombreUsuario);
                    switch (claseUsuario) {
                        case "Admin" -> menuAdmin(nombreUsuario, usuarios, proyectos);
                        case "Gestor" ->{
                            Gestor aux=(Gestor) usuarios.devuelveUsuario(nombreUsuario);
                           if (!usuarios.correspondeUsuyContrasenia(nombreUsuario, contrasenia)) {
                                aux.bloqueo();
                                System.out.println("Demasiados intentos fallidos, tu usuario está bloqueado");
                            }
                            else {
                                if (!aux.isBloqueado()) menuGestor(nombreUsuario, usuarios, proyectos, aplicacion);
                                else System.out.println("No puedes iniciar sesión porque tu usuario está bloqueado");
                            }
                        }
                        case "Inversor" -> {
                            Inversor aux=(Inversor) usuarios.devuelveUsuario(nombreUsuario);
                            if (!usuarios.correspondeUsuyContrasenia(nombreUsuario, contrasenia)) {
                                aux.bloqueo();
                                System.out.println("Demasiados intentos fallidos, tu usuario está bloqueado");
                            } else {
                                if (!aux.getBloqueado())
                                    menuInversor(nombreUsuario, usuarios, proyectos, aplicacion.devuelveGestionInversiones());
                                else System.out.println("No puedes iniciar sesión porque tu usuario está bloqueado");
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Saliendo de la operación.");
                    aplicacion.guardarAJSON();
                }
                default -> System.out.println("Invalid response");
            }
        }while(seleccionInicial!=3);
    }
}