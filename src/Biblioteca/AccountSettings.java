package Biblioteca;

import CodigoFuente.GestionInversiones;
import CodigoFuente.GestionUsuarios;
import CodigoFuente.Inversor;

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

    /* ----------------------------------------------------Change----------------------------------------------------- */
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
    public static String cambiarEmail(){
        System.out.println("Escriba el nuevo email");
        return leerOpcionLiteral();
    }
    public static void modificarCuenta (int pos, GestionUsuarios usuarios) {
        int opcion;
        do {
            menuConfiguracion();
            opcion = leerOpcionNumerica();
            switch (opcion) {
                case 1 -> usuarios.modificarUsuario(pos, cambiarUsuario(), null, null);
                case 2 -> usuarios.modificarUsuario(pos, null, cambiarcontrasenia(), null);
                case 3 -> usuarios.modificarUsuario(pos, null, null, cambiarEmail());
            }
        } while (opcion != 4);
    }


    public static boolean registroUsuarioNuevo(String tipo, GestionUsuarios usuarios, GestionInversiones[] megaGestionInversiones, int cantidadInversiones) {
        System.out.println("Escriba su nombre completo: ");
        String nombre = leerOpcionLiteral();
        System.out.println("Escriba su nombre de usuario: ");
        String nuevoUsuario = leerOpcionLiteral(), passNuevoUsuario, passRepetidaNuevoUsuario, correoNuevoUsuario;
        do {
            System.out.println("Escriba su contraseña: ");
            passNuevoUsuario = leerOpcionLiteral();
            System.out.println("Vuelva a escribir su contraseña: ");
            passRepetidaNuevoUsuario = leerOpcionLiteral();
            if (!passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario))
                System.out.println("Error, las contraseñas deben de ser iguales\nVuelva a intentarlo");
        } while (!comprobarFortalezaPass(passNuevoUsuario) && !passNuevoUsuario.equalsIgnoreCase(passRepetidaNuevoUsuario));
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
        if (tipo.equalsIgnoreCase("G")) usuarios.insertarUsuarioGestor(nombre, nuevoUsuario, passNuevoUsuario, correoNuevoUsuario);
        else {
            Inversor aux = new Inversor(nombre, nuevoUsuario, passNuevoUsuario, correoNuevoUsuario);
            usuarios.insertarUsuarioInversor(aux);
            megaGestionInversiones[cantidadInversiones] = new GestionInversiones(aux, 50);
        }
        return true;
    }
}
