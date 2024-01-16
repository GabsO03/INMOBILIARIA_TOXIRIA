package Biblioteca;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;
import static Biblioteca.Lectura_De_Datos.leerOpcionNumerica;
import static Biblioteca.Menus.menuConfiguracion;
import static Biblioteca.funcionesCadenas.comprobarFortalezaPass;


public class AccountSettings {

    /* ----------------------------------------------------Login----------------------------------------------------- */
    /**
     * Enviamos el correo a la dirección del destinatario con el asunto y cuerpo que deseemos
     * @author Adrián Contreras Bueno
     * @param destinatario como una cadena
     * @param asunto como una cadena
     * @param cuerpo como una cadena
     */
    public static void enviarCorreo(String destinatario, String asunto,String cuerpo){
        String remitente="adrian.contreras.2706@fernando3martos.com";
        String clave="chksotcvupynairz";
        // Propiedades de la conexion
        Properties props =System.getProperties();
        props.put("mail.smtp.host","smtp.gmail.com"); //Servidor de google
        props.put("mail.smtp.user",remitente);
        props.put("mail.smtp.clave",clave);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.port","587");

        Session session=Session.getDefaultInstance(props);
        try {
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport=session.getTransport("smtp");
            transport.connect("smtp.gmail.com",remitente,clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }catch (MessagingException me){
            me.printStackTrace();
        }

    }

    /**
     * Nos indica si el usuario y la contraseña que estamos introduciendo son correctos o no
     * @author Gabriela Oria Pinto
     * @return true si el usuario y la contraseña son correctos o false si el usuario y la contraseña no son correctos
     */
    public static boolean tokenVerified(String[][] datosNoAdmin, int pos) {
        System.out.println("Se va a enviar un código de verificacion a tu correo electronico, un momento...");
        int codigoRandom = (int) (Math.random()*9999)+1000;
        String codigoString=String.valueOf(codigoRandom);
        String destinatario=datosNoAdmin[3][pos];
        String asunto="Código de verificación inmobiliaria";
        String cuerpo="Su código de verificación es: "+codigoString+"\nNo comparta este código con nadie";
        enviarCorreo(destinatario,asunto,cuerpo);

        System.out.println("Escriba su código de verificación que se le ha enviado al correo electrónico: ");
        String codigo=leerOpcionLiteral();
        return codigo.equals(codigoString);

    }

    /**
     * Sistema de login del administrador
     * @author Gabriela Oria Pinto
     * @return true si ha conseguido entrar al sistema
     */


    public static int loginAdmin (String[][] datosAdmins) {
        boolean correcto = false, userFound = false;
        int i;
        do {
            i = 0;
            System.out.println("Usuario");
            String usuarioAdmin = leerOpcionLiteral();
            System.out.println("Contraseña");
            String contraAdmin = leerOpcionLiteral();
            while (!userFound && i < datosAdmins[0].length) {
                if (usuarioAdmin.equals(datosAdmins[1][i])) userFound=true;
                else i++;
            }
            if (userFound&&(contraAdmin.equals(datosAdmins[2][i]))) {
                System.out.printf("Bienvenid@ %s.\n", datosAdmins[0][i]);
                correcto=true;
            }
            else System.out.println("Usuario o contraseña incorrectos, vuelva a intentarlo.");
        } while (!correcto);
        return i;
    }

    /**
     * Sistema de login del Gestor
     * @author Gabriela Oria Pinto
     * @return true si ha conseguido entrar al sistema o false si no ha conseguido entrar al sistema porque su usuario ha sido bloqueado
     */
    public static int loginNoAdmin (String[][] datosNoAdmins, boolean[] usuariosBloqueados) {
        boolean correcto = false, userFound = false;
        int i = 0, intentos = 3;
        do {
            intentos--;
            System.out.println("Usuario");
            String usuarioAdmin = leerOpcionLiteral();
            System.out.println("Contraseña");
            String contraAdmin = leerOpcionLiteral();
            while (!userFound && i < datosNoAdmins[0].length) {
                if (usuarioAdmin.equals(datosNoAdmins[1][i])) userFound=true;
                else i++;
            }
            if (userFound&&(contraAdmin.equals(datosNoAdmins[2][i]))) {
                while (!tokenVerified(datosNoAdmins, i)) System.out.println("Error, código incorrecto");
                System.out.printf("Bienvenid@ %s.\n", datosNoAdmins[0][i]);
                correcto=true;
            }
            else System.out.println("Usuario o contraseña incorrectos, le quedan " + intentos + " intentos.");
            if (intentos==0) {
                System.out.println("Acceso denegado, tu cuenta ha sido bloqueada, espera a que el administrador te desbloquee.");
                usuariosBloqueados[i] = true;
                return -1;
            }
        } while (!correcto && intentos > 0);
        return i;
    }
    /**
     * Función que utiliza las otras funciones de login para acceder al sistema. Esta se usa en el main
     * @author Gabriela Oria Pinto, Adrián Contreras Bueno y Alex Godino Bailen
     * @return true si ha conseguido entrar al sistema
     */

    public static int login(int tipo, String[][] datosAdmin, String[][] datosGestores, String[][] datosInversores, boolean[] inversoresBloqueados, boolean[] gestoresBloqueados) {
        return switch (tipo) {
            case 1 -> loginAdmin(datosAdmin);
            case 2 -> loginNoAdmin(datosGestores, gestoresBloqueados);
            case 3 -> loginNoAdmin(datosInversores, inversoresBloqueados);
            default -> throw new IllegalStateException("Unexpected value: " + tipo);
        };
    }
    public static boolean entry (int tipoUsuario, int posicion, int cantidadGestores, int cantidadInversore) {
        return switch (tipoUsuario) {
            case 2 -> posicion >= 0 && posicion < cantidadGestores;
            case 3 -> posicion >= 0 && posicion < cantidadInversore;
            default -> true;
        };
    }


    /* ----------------------------------------------------Change----------------------------------------------------- */

    public static int posicionUsuario (String[][] datosAdmins) {
        boolean correcto = false, userFound = false;
        int i = 0;
        do {
            System.out.println("Introduzca su usuario y contraseña actuales.");
            System.out.println("Usuario");
            String usuarioAdmin = leerOpcionLiteral();
            System.out.println("Contraseña");
            String contraAdmin = leerOpcionLiteral();
            while (!userFound && i < datosAdmins[0].length) {
                if (usuarioAdmin.equals(datosAdmins[1][i])) userFound=true;
                else i++;
            }
            if (userFound&&(contraAdmin.equals(datosAdmins[2][i]))) {
                correcto=true;
            }
            else System.out.println("Usuario o contraseña incorrectos, vuelva a intentarlo.");
        } while (!correcto);
        return i;
    }
    public static String cambiarUsuario (){
        System.out.println("Escriba el nuevo usuario");
        return leerOpcionLiteral();
    }
    public static String cambiarcontrasenia (){
        String passNuevoUsuario, passRepetidaNuevoUsuario;
        do {
            System.out.println("Escriba su contraseña: ");
            passNuevoUsuario = leerOpcionLiteral();
        }while(!comprobarFortalezaPass(passNuevoUsuario));
        do {
            System.out.println("Escriba su contraseña de nuevo: ");
            passRepetidaNuevoUsuario = leerOpcionLiteral();
            if (!passNuevoUsuario.equals(passRepetidaNuevoUsuario)) System.out.println("Las contraseñas no coinciden");
        }while(!passRepetidaNuevoUsuario.equals(passNuevoUsuario));
        return passNuevoUsuario;
    }
    public static void modificarCuenta (String[][] datosUsuario){
        int pos = posicionUsuario(datosUsuario), opcion;
        do {
            menuConfiguracion();
            opcion = leerOpcionNumerica();
            switch (opcion) {
                case 1 -> datosUsuario[1][pos] = cambiarUsuario();
                case 2 -> datosUsuario[2][pos] = cambiarcontrasenia();
            }
        } while (opcion!=3);
    }


}
