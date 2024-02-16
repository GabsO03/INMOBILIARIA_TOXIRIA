package CodigoFuente;


//COLORES
import java.time.LocalDate;

import static Biblioteca.Colores.RED;
import static Biblioteca.Colores.GREEN;
import static Biblioteca.Colores.RESET;

//MENUS
import static Biblioteca.AccountSettings.enviarCorreo;

//LEER TEXTO
import static Biblioteca.Lectura_De_Datos.leerOpcionDouble;
import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;
import static Biblioteca.Lectura_De_Datos.leerOpcionNumerica;

//LOGIN
import static Biblioteca.AccountSettings.login;
import static Biblioteca.AccountSettings.modificarCuenta;
import static Biblioteca.AccountSettings.entry;
import static Biblioteca.funcionesCadenas.comprobarFortalezaPass;

//PROYECTOS
import static Biblioteca.Menus.*;
import static Biblioteca.Proyectos.cambiarDescripcionProyecto;
import static Biblioteca.Proyectos.cambiarCantidadNecesaria;
import static Biblioteca.Proyectos.cambiarNombreProyecto;
import static Biblioteca.Proyectos.cambiarCantidadFinanciada;
import static Biblioteca.Proyectos.cambiarFechaFin;
import static Biblioteca.Proyectos.cambiarFechaInicio;
import static Biblioteca.Proyectos.cambiarTipoProyecto;

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

        //INVERSOR
        double[] dineroInversores = new double[cantidadInversores];
        double respuestaDouble;
        String respuesta;

        //Menus
        int seleccionTipoUsuario,seleccionInicial,codigoUsuario = 0;
        int primerSubmenu,segundoSubmenu,tercersubmenu, contadorProyectos = 0;
        //REGISTRO
        String nombre, nuevoUsuario, correoNuevoUsuario,passNuevoUsuario,passRepetidaNuevoUsuario,tipoNuevoUsuario;
        boolean registroCorrecto=false;
        //INICIO DE SESION
        String nombreUsuario,contrasenia;
        boolean existeUsuario=false;



        do {
            menuInicio();
            seleccionInicial=leerOpcionNumerica();
            if (seleccionInicial==1){
                do {
                    do {
                        System.out.println("Escriba su tipo de usuario (I)Inversor (G)Gestor: ");
                        tipoNuevoUsuario = leerOpcionLiteral();
                        if (!tipoNuevoUsuario.equalsIgnoreCase("G") && !tipoNuevoUsuario.equalsIgnoreCase("I")) {
                            System.out.println("Error, tiene que escribir 'G' o 'I'");
                        }
                    } while (!tipoNuevoUsuario.equalsIgnoreCase("G") && !tipoNuevoUsuario.equalsIgnoreCase("I"));


                } while (!registroCorrecto);
                if (tipoNuevoUsuario.equalsIgnoreCase("G")){
                    System.out.println("Escriba su nombre comlpeto: ");
                    nombre=leerOpcionLiteral();
                    System.out.println("Escriba su nombre de usuario: ");
                    nuevoUsuario=leerOpcionLiteral();
                    do {
                        System.out.println("Escriba su contraseña: ");
                        passNuevoUsuario=leerOpcionLiteral();
                        System.out.println("Vuelva a escribir su contraseña: ");
                        passRepetidaNuevoUsuario=leerOpcionLiteral();
                        if (!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario)) System.out.println("Error, las contraseñas deben de ser iguales\nVuelva a intentarlo");
                    }while (!comprobarFortalezaPass(passNuevoUsuario)&&!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario));
                    System.out.println("Escriba su email: ");
                    correoNuevoUsuario=leerOpcionLiteral();

                        int codigoEnviado = (int) (Math.random() * 99999) + 10000;
                        System.out.println("Se está enviando un código de verificacion...");
                        enviarCorreo(correoNuevoUsuario,"Correo de verificación","Su código de verificación es: "+ codigoEnviado);
                        System.out.println("Revise su bandeja de entrada y escriba el código");
                        codigoUsuario=leerOpcionNumerica();
                        if (codigoEnviado!=codigoUsuario) System.out.println("ERROR, el código no es correcto");
                        else{
                            usuarios.insertarUsuarioGestor(nombre,nuevoUsuario,passNuevoUsuario,correoNuevoUsuario);
                            System.out.println("Usuario registrado correctamente");
                        }



                }else {
                    System.out.println("Escriba su nombre completo: ");
                    nombre=leerOpcionLiteral();
                    System.out.println("Escriba su nombre de usuario: ");
                    nuevoUsuario=leerOpcionLiteral();
                    do {
                        System.out.println("Escriba su contraseña: ");
                        passNuevoUsuario=leerOpcionLiteral();
                        System.out.println("Vuelva a escribir su contraseña: ");
                        passRepetidaNuevoUsuario=leerOpcionLiteral();
                        if (!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario)) System.out.println("Error, las contraseñas deben de ser iguales\nVuelva a intentarlo");
                    }while (!comprobarFortalezaPass(passNuevoUsuario)&&!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario));
                    System.out.println("Escriba su email: ");
                    correoNuevoUsuario=leerOpcionLiteral();

                    int codigoEnviado = (int) (Math.random() * 99999) + 10000;
                    System.out.println("Se está enviando un código de verificacion...");
                    enviarCorreo(correoNuevoUsuario,"Correo de verificación","Su código de verificación es: "+ codigoEnviado);
                    System.out.println("Revise su bandeja de entrada y escriba el código");
                    codigoUsuario=leerOpcionNumerica();
                    if (codigoEnviado!=codigoUsuario) System.out.println("ERROR, el código no es correcto");
                    else{
                        usuarios.insertarUsuarioInversor(nombre,nuevoUsuario,passNuevoUsuario,correoNuevoUsuario);
                        System.out.println("Usuario registrado correctamente");
                    }

                }
            }

            if (seleccionInicial==2){
                do {
                    System.out.print("Nombre de usuario: ");
                    nombreUsuario = leerOpcionLiteral();
                    System.out.print("Contraseña: ");
                    contrasenia = leerOpcionLiteral();
                    int posicionLogin=usuarios.existeUsuario(nombreUsuario, contrasenia);

                    if ( posicionLogin>= 0) {
                        //ADMINISTRADOR
                        String claseUsuario = usuarios.averiguarClase(posicionLogin);
                        switch (claseUsuario) {
                            case "Admin" -> menuAdmin(usuarios, proyectos);

                            case "Gestor" -> menuGestor(posicionLogin, usuarios, proyectos);

                            case "Inversor" -> menuInversor(posicionLogin, usuarios, proyectos, inversiones,(Inversor) usuarios.devuelveUsuario(posicionLogin));
                        }
                    }else System.out.println("El usuario o contraseña no es correcto");
            }
        }while(seleccionInicial!=3);
    }
}