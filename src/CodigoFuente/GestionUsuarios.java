package CodigoFuente;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import  java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {
    //La clave será el nombre de usuario y el valor el propio usuario
    private HashMap<String,Usuario> hashMapUsuarios;
    private ArrayList<String> nombresFicheros;

    public GestionUsuarios() {
        this.hashMapUsuarios = new HashMap<>();
        this.nombresFicheros = new ArrayList<>();
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
                Gestor aux = (Gestor) u;
                System.out.println(i++ + ") " + aux + " - Gestor");
            }
            if (u.getClass().getSimpleName().equalsIgnoreCase("Inversor")) {
                Inversor aux = (Inversor) u;
                System.out.println(i++ + ") " + aux + " - Inversor");
            }
        }
    }

    /**
     * Funcion para devolver un objeto de la clase Usuario
     * @param username como String
     * @return un objeto de la clase Usuario
     */
    public Usuario devuelveUsuario (String username ) {
        return hashMapUsuarios.get(username);
    }

    /**
     * Funcion para insertar un nuevo usuario gestor
     * @param nombre como cadena
     * @param user como cadena
     * @param contrasenia como cadena
     * @param email como cadena
     */
    public void insertarUsuarioGestor (String nombre, String user, String contrasenia, String email) {
        hashMapUsuarios.put(user,new Gestor (nombre, user, contrasenia, email));
        nombresFicheros.add("G" + nombre);
    }
    public void insertarUsuarioGestor (Gestor gestor) {
        hashMapUsuarios.put(gestor.getUsername(), gestor);
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
        nombresFicheros.add("A" + nombre);
    }
    public void insertarUsuarioAdmin (Admin admin) {
        hashMapUsuarios.put(admin.getUsername(), admin);
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
        nombresFicheros.add("I" + nombre);
    }

    /**
     * Funcion para insertar un nuevo inversor
     * @param inversor como un objeto de la clase Inversor
     */
    public void insertarUsuarioInversor (Inversor inversor) {
        hashMapUsuarios.put(inversor.getUsername(), inversor);
        //nombresFicheros.add("I" + inversor.getNombre());
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
     * @return true or false dependiendo de si existe o no el nombre del usuario
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
     * @param username como cadena
     */
    public void bloquearDesbloquearUsuario (int opcion, String username) {
        String clase = hashMapUsuarios.get(username).getClass().getSimpleName();
        switch (clase) {
            case "Inversor" -> {
                Inversor aux = (Inversor) hashMapUsuarios.get(username);
                switch (opcion) {
                    case 1 -> aux.bloqueo();
                    case 2 -> aux.desbloqueo();
                }
            }
            case "Gestor" -> {
                Gestor aux = (Gestor) hashMapUsuarios.get(username);
                switch (opcion) {
                    case 1 -> aux.bloqueo();
                    case 2 -> aux.desbloqueo();
                }
            }
        }
    }

    /**
     * Funcion para crear un Json con los nombres de los ficheros
     * @return una cadena con los nombres de los ficheros
     */
    public String crearJSONNombresFicheros(){
        Gson gson=new Gson();
        return gson.toJson(nombresFicheros);
    }

    /**
     * Funcion para guardar a Json los nombres de ficheros creados
     */
    public void guardarAJSONNombresFicheros(){
        String jsonCreado = crearJSONNombresFicheros();
        try{
            FileWriter fichero = new FileWriter("ListaNombresUsuarios.json");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(jsonCreado);
            fichero.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Funcion para guardar un Usuario a Json
     */
    public void guardarUsuariosJson () {
        for (Map.Entry usuario: hashMapUsuarios.entrySet()) {
            String clase = usuario.getValue().getClass().getSimpleName();
            switch (clase) {
                case "Admin" -> {
                    Admin aux = (Admin) usuario.getValue();
                    aux.guardarAJSON();
                }
                case "Gestor" -> {
                    Gestor aux = (Gestor) usuario.getValue();
                    aux.guardarAJSON();
                }
                case "Inversor" -> {
                    Inversor aux = (Inversor) usuario.getValue();
                    aux.guardarAJSON();
                }
            }
        }
        guardarAJSONNombresFicheros();
    }

    /**
     * Funcion para recuperar el Json creado con los nombres de Usuario
     * @return una coleccion de cadena con los nombres de los ficheros del Json
     * @throws FileNotFoundException
     */
    public static ArrayList<String> recuperarListaNombresUsuarios() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader buffer = new BufferedReader(new FileReader( "ListaNombresUsuarios.json"));
        return gson.fromJson(buffer, new TypeToken<ArrayList<String>>(){}.getType());

    }

    /**
     * Funcion para recuperar el Json de Usuarios creado
     * @throws FileNotFoundException
     */
    public void recuperarUsuariosJson () throws FileNotFoundException {
        this.nombresFicheros = recuperarListaNombresUsuarios();
        for (int i = 0; i < nombresFicheros.size(); i++) {
            if (nombresFicheros.get(i).startsWith("A")) insertarUsuarioAdmin(Admin.recuperarJSON(nombresFicheros.get(i)));
            if (nombresFicheros.get(i).startsWith("G")) insertarUsuarioGestor(Gestor.recuperarJSON(nombresFicheros.get(i)));
            if (nombresFicheros.get(i).startsWith("I")) insertarUsuarioInversor(Inversor.recuperarJSON(nombresFicheros.get(i)));
        }
    }
    
}
