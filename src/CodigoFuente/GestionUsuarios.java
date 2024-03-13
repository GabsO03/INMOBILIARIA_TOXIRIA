package CodigoFuente;

import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {
    //La clave será el nombre de usuario y el valor el propio usuario
    private HashMap<String,Usuario> hashMapUsuarios;

    public GestionUsuarios() {
        this.hashMapUsuarios = new HashMap<>();
    }

    /**
     * Muestra todos los usuarios del programa
     */
    public void muestraUsuarios () {
        int i = 1;
        System.out.println("Lista de usuarios:");
        System.out.println("===============================");
        for (Map.Entry<String, Usuario> entry : hashMapUsuarios.entrySet()) {
            Usuario u = entry.getValue();
            if (u.getClass().getSimpleName().equalsIgnoreCase("Gestor")) {
                System.out.println(i++ + ") " + u + " - Gestor");
            }
            if (u.getClass().getSimpleName().equalsIgnoreCase("Inversor")) {
                System.out.println(i++ + ") " + u + " - Inversor");
            }
        }

    }

    public Usuario devuelveUsuario (String username ) {
        return hashMapUsuarios.get(username);
    }

    /**
     * Funcion para insertar un nuevo usuario
     * @param nombre como cadena
     * @param user como cadena
     * @param contrasenia como cadena
     * @param email como cadena
     */
    public void insertarUsuarioGestor (String nombre, String user, String contrasenia, String email) {
        hashMapUsuarios.put(user,new Gestor (nombre, user, contrasenia, email));
    }
    /**
     * Funcion para insertar un nuevo admin
     * @param nombre como cadena
     * @param user como cadena
     * @param contrasenia como cadena
     * @param email como cadena
     */
    public void insertarUsuarioAdmin ( String nombre, String user, String contrasenia, String email) {
        hashMapUsuarios.put(user, new Admin (nombre, user, contrasenia, email));
    }
    /**
     * Funcion para insertar un nuevo inversor
     * @param nombre como cadena
     * @param user como cadena
     * @param contrasenia como cadena
     * @param email como cadena
     */
    public void insertarUsuarioInversor ( String nombre, String user, String contrasenia, String email) {
        hashMapUsuarios.put(user,new Inversor (nombre, user, contrasenia, email));
    }

    /**
     * Funcion para insertar un nuevo inversor
     * @param inversor como un objeto de la clase Inversor
     */
    public void insertarUsuarioInversor (Inversor inversor) {
        hashMapUsuarios.put(inversor.getUsername(), inversor);
    }

    /**
     * Funcion para modificar un usuario que ya existe
     * @param userName como cadena
     * @param contrasenia como cadena
     * @param email como cadena
     */
    public void modificarUsuario (String userName, String contrasenia, String email) {
       if (userName!=null) hashMapUsuarios.get(userName).setUsername(userName);
       if (contrasenia!=null) hashMapUsuarios.get(userName).setContrasenia(contrasenia);
       if (email!=null) hashMapUsuarios.get(userName).setEmail(email);
    }

    /**
     * Funcion para comprobar si el nombre del usuario y la contraseña corresponden con el usuario que inicia sesion
     * @param username como cadena
     * @param contrasenia como cadena
     * @return true si si corresponde o false si no corresponde
     */
    public boolean correspondeUsuyContrasenia(String username, String contrasenia) {
        return hashMapUsuarios.get(username).getContrasenia().equals(contrasenia);
    }

    /**
     * Funcion que comprueba si el nombre de usuario introducido ya existe o no
     * @param username como cadena
     * @return la posicion del usuario con ese nombre o -1 si no existe
     */
    public boolean existeNombreUsuario (String username) {
        return hashMapUsuarios.containsKey(username);
    }

    /**
     * Funcion para averiguar la clase a la que pertenece un objeto
     * @param userName como cadena
     * @return una cadena con el nombre de la clase
     */
    public String averiguarClase (String userName) {
        Usuario aux = devuelveUsuario(userName);
        return aux.getClass().getSimpleName();
    }

    /**
     * Funcion para bloquear o desbloqueaar usuarios
     * @param opcion como entero
     * @param pos como entero
     */

    public void bloquearDesbloquearUsuario (int opcion, int pos) {
        //switch 1 para bloquear y 2 para desbloquear
        switch (opcion){
            case 1 -> hashMapUsuarios.get(pos).bloqueo();
            case 2 -> hashMapUsuarios.get(pos).desbloqueo();
        }
    }

}
