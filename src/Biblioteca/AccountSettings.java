package Biblioteca;

import CodigoFuente.GestionApp;
import CodigoFuente.GestionInversiones;
import CodigoFuente.GestionUsuarios;
import CodigoFuente.Inversor;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

import static Biblioteca.Lectura_De_Datos.leerOpcionLiteral;
import static Biblioteca.Lectura_De_Datos.leerOpcionNumerica;
import static Biblioteca.Menus.menuConfiguracion;
import static Biblioteca.funcionesCadenas.comprobarFortalezaPass;


public class AccountSettings {

    /* ----------------------------------------------------Login----------------------------------------------------- */
    /**
     * Enviamos el correo a la dirección del destinatario con el asunto y cuerpo que deseemos
     * @param destinatario como una cadena
     * @param asunto como una cadena
     * @param cuerpo como una cadena
     */
    public static void enviarCorreo(String destinatario, String asunto,String cuerpo) {
        String remitente = "adrian.contreras.2706@fernando3martos.com";
        String clave = "chksotcvupynairz";
        // Propiedades de la conexion
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //Servidor de google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }

    }


    /* ----------------------------------------------------Change----------------------------------------------------- */

    /**
     * Funcion para cambiar el nombre de usuario del Usuario
     * @return una cadena con el nuevo nombre
     */
    public static String cambiarUsuario (){
        System.out.println("Escriba el nuevo usuario");
        return leerOpcionLiteral();
    }

    /**
     * Funcion para cambiar la contraseña del Usuario
     * @return una cadena con la nueva contraseña
     */
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
    /**
     * Funcion para cambiar el email del Usuario
     * @return una cadena con el nuevo email
     */
    public static String cambiarEmail(){
        System.out.println("Escriba el nuevo email");
        return leerOpcionLiteral();
    }

    /**
     * Funcion para modificar algún atributo de la cuenta del usuario
     * @param userName como cadena
     * @param usuarios como un objeto de la clase GestionUsuarios
     */
    public static void modificarCuenta (String userName, GestionUsuarios usuarios) {
        int opcion;
        do {
            menuConfiguracion();
            opcion = leerOpcionNumerica();
            switch (opcion) {
                case 1 -> usuarios.modificarUsuario(userName,  cambiarcontrasenia(), null);
                case 2 -> usuarios.modificarUsuario(userName, null,  cambiarEmail());
            }
        } while (opcion != 3);
    }

    /**
     * Funcion para poder registrar a un nuevo Usuario
     * @param tipo como cadena
     * @param usuarios como un objeto de la clase GestionUsuarios
     * @param megaGestionInversiones un array de un objeto de la clase GestionInversiones
     * @return true si se ha conseguido registrar correctamente o false si no se ha podido registrar correctamente
     */
    public static boolean registroUsuarioNuevo(String tipo, GestionUsuarios usuarios, ArrayList<GestionInversiones> gestionInversiones){
        System.out.println("Escriba su nombre completo: ");
        String nombre = leerOpcionLiteral(), passNuevoUsuario, passRepetidaNuevoUsuario, correoNuevoUsuario, nuevoUsuario;
        do {
            System.out.println("Escriba su nombre de usuario: ");
            nuevoUsuario = leerOpcionLiteral();
            if (usuarios.existeNombreUsuario(nuevoUsuario)) System.out.println("Ese nombre de usuario ya existe");
        } while (usuarios.existeNombreUsuario(nuevoUsuario));
        do {
            System.out.println("Escriba su contraseña: ");
            passNuevoUsuario = leerOpcionLiteral();
            if (comprobarFortalezaPass(passNuevoUsuario)) {
                System.out.println("Vuelva a escribir su contraseña: ");
                passRepetidaNuevoUsuario = leerOpcionLiteral();
                if (!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario))
                    System.out.println("Error, las contraseñas deben de ser iguales\nVuelva a intentarlo");
            }
        } while (!comprobarFortalezaPass(passNuevoUsuario));
        System.out.println("Escriba su email: ");
        correoNuevoUsuario = leerOpcionLiteral();
        int codigoEnviado, codigoUsuario;
        do {
            codigoEnviado = (int) (Math.random() * 99999) + 10000;
            System.out.println(codigoEnviado);
            System.out.println("Se está enviando un código de verificacion...");
            enviarCorreo(correoNuevoUsuario, "Correo de verificación", "Su código de verificación es: " + codigoEnviado);
            System.out.println("Revise su bandeja de entrada y escriba el código");
            codigoUsuario = leerOpcionNumerica();
            if (codigoEnviado != codigoUsuario) System.out.println("ERROR, el código no es correcto");
        } while (codigoEnviado != codigoUsuario);
        if (tipo.equalsIgnoreCase("G"))
            usuarios.insertarUsuarioGestor(nombre, nuevoUsuario, passNuevoUsuario, correoNuevoUsuario);
        else {
            Inversor aux = new Inversor(nombre, nuevoUsuario, passNuevoUsuario, correoNuevoUsuario);
            usuarios.insertarUsuarioInversor(aux);
            gestionInversiones.add(new GestionInversiones(aux));
        }
        return true;
    }
}
