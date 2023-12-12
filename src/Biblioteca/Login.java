package Biblioteca;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;


public class Login {

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
     * @param usu como cadena
     * @param con como cadena
     * @return true si el usuario y la contraseña son correctos o false si el usuario y la contraseña no son correctos
     */
    public static boolean verification (String usu, String con) {
        System.out.println("Introduzca su usuario:");
        String user = leerOpcionLiteral();
        System.out.println("Introduzca su contraseña");
        String password = leerOpcionLiteral();
        return user.equals(usu) && password.equals(con);
    }

    /**
     * Sistema de login del administrador
     * @author Gabriela Oria Pinto
     * @param user como cadena
     * @param con como cadena
     * @return true si ha conseguido entrar al sistema
     */
    public static boolean loginAdmin (String user, String con) {
        while (!(verification(user, con))) System.out.println("Usuario o contraseña incorrecta.");
        System.out.println("Bienvenid@ " + user);
        return true;
    }

    /**
     * Sistema de login del Gestor
     * @author Gabriela Oria Pinto
     * @param user como cadena
     * @param pass como cadena
     * @return true si ha conseguido entrar al sistema o false si no ha conseguido entrar al sistema porque su usuario ha sido bloqueado
     */
    public static boolean loginGestor (String user, String pass) {
        int intentos = 3;
        while (intentos > 0 && !(verification(user, pass))) {
            intentos--;
            System.out.println("Contraseña incorrecta, Te quedan " + intentos + " intentos.");
        }
        if (intentos > 0) System.out.println();
        else {
            System.out.println("Acceso denegado, tu cuenta ha sido bloqueada, espera a que el administrador te desbloquee.");
            return false;
        }
        System.out.println("Se va a enviar un código de verificacion a tu correo electronico, un momento...");
        int codigoRandom = (int) (Math.random()*9999)+1000;
        String codigoString=String.valueOf(codigoRandom);
        String destinatario="gestorinmobiliaria@yopmail.com";
        String asunto="Código de verificación inmobiliaria";
        String cuerpo="Su código de verificación es: "+codigoString+"\nNo comparta este código con nadie";
        enviarCorreo(destinatario,asunto,cuerpo);

        System.out.println("Escriba su código de verificación que se le ha enviado al correo electrónico: ");
        String codigo=leerOpcionLiteral();
        if (codigo.equals(codigoString)) {
            System.out.println("Código correcto.");
            return true;
        }
        else{
            System.out.println("Error, código no valido.");
            return false;
        }


    }

    /**
     * Sistema de login de ambos inversores
     * @author Gabriela Oria Pinto
     * @param user como cadena
     * @param pass como cadena
     * @return true si ha conseguido entrar al sistema o false si no ha conseguido entrar al sistema porque su usuario ha sido bloqueado
     */

    public static boolean loginInversor(String user, String pass) {
        int intentos = 3;
        while (intentos > 0 && !(verification(user, pass))) {
            intentos--;
            System.out.println("Contraseña incorrecta, Te quedan " + intentos + " intentos.");
        }
        if (intentos > 0) System.out.println();
        else {
            System.out.println("Acceso denegado, tu cuenta ha sido bloqueada, espera a que el administrador te desbloquee.");
            return false;
        }
        System.out.println("Se va a enviar un código de verificacion a tu correo electronico, un momento...");
        int codigoRandom = (int) (Math.random()*9999)+1000;
        if (user.equals("inversor1")){
            String codigoString=String.valueOf(codigoRandom);
            String destinatario="inversor1inmobiliaria@yopmail.com";
            String asunto="Código de verificación inmobiliaria";
            String cuerpo="Su código de verificación es: "+codigoString+"\nNo comparta este código con nadie";
            enviarCorreo(destinatario,asunto,cuerpo);

            System.out.println("Escriba su código de verificación que se le ha enviado al correo electrónico: ");
            String codigo=leerOpcionLiteral();
            if (codigo.equals(codigoString)) {
                System.out.println("Código correcto.");
                return true;
            }
            else{
                System.out.println("Error, código no valido.");
                return false;
            }
        }
        if (user.equals("inversor2")){
            String codigoString=String.valueOf(codigoRandom);
            String destinatario="inversor2inmobiliaria@yopmail.com";
            String asunto="Código de verificación inmobiliaria";
            String cuerpo="Su código de verificación es: "+codigoString+"\nNo comparta este código con nadie";
            enviarCorreo(destinatario,asunto,cuerpo);

            System.out.println("Escriba su código de verificación que se le ha enviado al correo electrónico: ");
            String codigo=leerOpcionLiteral();
            if (codigo.equals(codigoString)) {
                System.out.println("Código correcto.");
                return true;
            }
            else{
                System.out.println("Error, código no valido.");
                return false;
            }
        }else return false;


    }

    /**
     * Función que utiliza las otras funciones de login para acceder al sistema. Esta se usa en el main
     * @author Gabriela Oria Pinto
     * @param opcion1 como entero
     * @param adminUser como cadena
     * @param adminPass como cadena
     * @param gestorUser como cadena
     * @param gestorPass como cadena
     * @param inversor1User como cadena
     * @param inversor1Pass como cadena
     * @param inversor2User como cadena
     * @param inversor2Pass como cadena
     * @return true si ha conseguido entrar al sistema
     */

    public static boolean logged (int opcion1, String adminUser, String adminPass,  String gestorUser, String gestorPass,  String inversor1User, String inversor1Pass,  String inversor2User, String inversor2Pass) {
        switch (opcion1) {
            case 1 : {
                if (loginAdmin(adminUser, adminPass)) return true;
                break;
            }
            case 2 : {
                if (loginGestor(gestorUser, gestorPass)) return true;
                break;
            }
            case 3 : {
                if (loginInversor(inversor1User, inversor1Pass)) return true;
                break;
            }
            case 4: {
                if (loginInversor(inversor2User, inversor2Pass)) return true;
                break;
            }
        }
        return false;
    }
}
