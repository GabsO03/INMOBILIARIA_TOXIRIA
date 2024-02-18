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
        usuarios.insertarUsuarioGestor("Alex","AlexGB","AlexGB123@","Alexito@gmail.com");
     //   usuarios.insertarUsuarioInversor("Gabi","GabiOP","Usu1234-","Gabisita@gmail.com");
        //BLOQUEOS

        //PROYECTOS
        GestionProyectos proyectos = new GestionProyectos(20);
        proyectos.crearProyecto("Villa verde", "La villa más fea","Plusvalía", LocalDate.now(), LocalDate.now().plusMonths(5), 4521.56f, 521.56f);
        proyectos.crearProyecto("Villa azul", "La villa más bonita", "Préstamo", LocalDate.now().plusDays(5), LocalDate.now().plusMonths(9), 85112.54, 5112.54);
        proyectos.crearProyecto("Villa morada", "La villa más morada", "Alquiler", LocalDate.now().plusDays(5), LocalDate.now().plusMonths(9), 7650, 32);

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
                    int posicionLogin, intentos=3;
                    do {
                        System.out.print("Nombre de usuario: ");
                        nombreUsuario = leerOpcionLiteral();
                        System.out.print("Contraseña: ");
                        contrasenia = leerOpcionLiteral();
                        posicionLogin = usuarios.existeNombreUsuario(nombreUsuario);
                        if (posicionLogin < 0 /* Si está poniendo cualquier cosa*/) System.out.println("Ese usuario no existe.");
                        if (posicionLogin >= 0 && !usuarios.correspondeUsuyContrasenia(posicionLogin, contrasenia)) { //Esto por si existe pero no corresponde la contraseña
                            System.out.println("El usuario o contraseña no es correcto. Intentos restantes: " + --intentos);
                        }

                    } while ((posicionLogin < 0) /*No existe ese usuario*/ || (posicionLogin >= 0 && !usuarios.correspondeUsuyContrasenia(posicionLogin, contrasenia) && intentos > 0)/*Existe,pero no corresponde y se van restnado los intantos */);

                    String claseUsuario = usuarios.averiguarClase(posicionLogin);
                    switch (claseUsuario) {
                        case "Admin" -> menuAdmin(posicionLogin, usuarios, proyectos);
                        case "Gestor" ->{Gestor aux=(Gestor) usuarios.devuelveUsuario(posicionLogin);
                           if (!usuarios.correspondeUsuyContrasenia(posicionLogin, contrasenia)) {
                                aux.bloqueo();
                                System.out.println("Demasiados intentos fallidos, tu usuario está bloqueado");
                            }
                            else {
                                if (!aux.getBloqueado()) menuGestor(posicionLogin, usuarios, proyectos);
                                else System.out.println("No puedes iniciar sesión porque tu usuario está bloqueado");
                            }
                        }
                        case "Inversor" -> {
                            Inversor aux=(Inversor) usuarios.devuelveUsuario(posicionLogin);
                            if (!usuarios.correspondeUsuyContrasenia(posicionLogin, contrasenia)) {
                                aux.bloqueo();
                                System.out.println("Demasiados intentos fallidos, tu usuario está bloqueado");
                            } else {
                                if (!aux.getBloqueado())
                                    menuInversor(posicionLogin, usuarios, proyectos, megaGestionInversiones);
                                else System.out.println("No puedes iniciar sesión porque tu usuario está bloqueado");
                            }
                        }
                    }
                }
                case 3 -> System.out.println("Saliendo de la operación.");
                default -> System.out.println("Invalid response");
            }
        }while(seleccionInicial!=3);
    }
}