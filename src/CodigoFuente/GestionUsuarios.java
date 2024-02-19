package CodigoFuente;

public class GestionUsuarios {

    private int numeroUsuariosInsertados;
    private Usuario[] arrayUsuarios;


    public GestionUsuarios(int cantidadUsuarios) {
        this.arrayUsuarios = new Usuario[cantidadUsuarios];
    }


    public int getNumeroUsuariosInsertados() {
        return numeroUsuariosInsertados;
    }
    public Usuario[] getArrayUsuarios() {
        return arrayUsuarios;
    }

    public void setNumeroUsuariosInsertados(int numeroUsuariosInsertados) {
        this.numeroUsuariosInsertados = numeroUsuariosInsertados;
    }
    public void setArrayUsuarios (Usuario[] arrayUsuarios) {
        this.arrayUsuarios = arrayUsuarios;
    }

    /**
     * Muestra todos los usuarios del programa
     */
    public void muestraUsuarios () {
        int i = 1;
        System.out.println("Lista de usuarios:");
        System.out.println("===============================");
        for (Usuario u : arrayUsuarios) {
            if (u != null ) {
                if (u.getClass().getSimpleName().equalsIgnoreCase("Gestor")) System.out.println(i++ + ") " + u + " - Gestor");
                    if (u.getClass().getSimpleName().equalsIgnoreCase("Inversor")) System.out.println(i++ + ") " + u + " - Inversor");
            }
        }
    }

    public Usuario devuelveUsuario (int pos) {
        if (arrayUsuarios[pos] != null) return arrayUsuarios[pos];
        return null;
    }

    /**
     * Funcion para insertar un nuevo usuario
     * @param nombre como cadena
     * @param user como cadena
     * @param contrasenia como cadena
     * @param email como cadena
     */
    public void insertarUsuarioGestor ( String nombre, String user, String contrasenia, String email) {
        arrayUsuarios[numeroUsuariosInsertados++] = new Gestor (nombre, user, contrasenia, email);
        aumentaTamanio();
    }
    /**
     * Funcion para insertar un nuevo admin
     * @param nombre como cadena
     * @param user como cadena
     * @param contrasenia como cadena
     * @param email como cadena
     */
    public void insertarUsuarioAdmin ( String nombre, String user, String contrasenia, String email) {
        arrayUsuarios[numeroUsuariosInsertados++] = new Admin (nombre, user, contrasenia, email);
        aumentaTamanio();
    }
    /**
     * Funcion para insertar un nuevo inversor
     * @param nombre como cadena
     * @param user como cadena
     * @param contrasenia como cadena
     * @param email como cadena
     */
    public void insertarUsuarioInversor ( String nombre, String user, String contrasenia, String email) {
        arrayUsuarios[numeroUsuariosInsertados++] = new Inversor (nombre, user, contrasenia, email);
        aumentaTamanio();
    }

    /**
     * Funcion para insertar un nuevo inversor
     * @param inversor como un objeto de la clase Inversor
     */
    public void insertarUsuarioInversor (Inversor inversor) {
        arrayUsuarios[numeroUsuariosInsertados++] = inversor;
        aumentaTamanio();
    }

    /**
     * Funcion para aumentar el tamaño del array
     */
    public void aumentaTamanio () {
        if (numeroUsuariosInsertados == arrayUsuarios.length) {
            Usuario[] arrayAux = new Usuario[arrayUsuarios.length + 15];
            for (int i = 0; i < arrayUsuarios.length; i++) {
                arrayAux[i] = arrayUsuarios[i];
            }
            arrayUsuarios = arrayAux;
        }
    }

    /**
     * Funcion para modificar un usuario que ya existe
     * @param pos como entero
     * @param userName como cadena
     * @param contrasenia como cadena
     * @param email como cadena
     */
    public void modificarUsuario (int pos, String userName, String contrasenia, String email) {
       if (userName!=null)arrayUsuarios[pos].setUsername(userName);
       if (contrasenia!=null)arrayUsuarios[pos].setContrasenia(contrasenia);
       if (email!=null)arrayUsuarios[pos].setEmail(email);
    }

    /**
     * Funcion para buscar a un usuario que ya existe mediante un atributo
     * @param atributo como cadena
     * @param valor como cadena
     * @return un entero con la posicion donde se encuentra ese usuario o -1 si no lo encuentra
     */
    public int buscarUsuario(String atributo, String valor) {
        atributo = atributo.toLowerCase();
       // valor = valor.toLowerCase();
        switch (atributo) {
            case "contraseña" -> {
                for (int i = 0; i < arrayUsuarios.length; i++) {
                    if (arrayUsuarios[i] != null && arrayUsuarios[i].getContrasenia().equals(valor)) return i;
                }
            }
            case "nombre" -> {
                for (int i = 0; i < arrayUsuarios.length; i++) {
                    if (arrayUsuarios[i] != null && arrayUsuarios[i].getNombre().equalsIgnoreCase(valor)) return i;
                }
            }
            case "nombre de usuario" -> {
                for (int i = 0; i < arrayUsuarios.length; i++) {
                    if (arrayUsuarios[i] != null && arrayUsuarios[i].getUsername().equalsIgnoreCase(valor)) return i;
                }
            }
            default -> System.out.println("Ese parámetro no está disponible.");
        }
        return -1;
    }

    /**
     * Funcion para comprobar si el nombre del usuario y la contraseña corresponden con el usuario que inicia sesion
     * @param posicion como entero
     * @param contrasenia como cadena
     * @return true si si corresponde o false si no corresponde
     */
    public boolean correspondeUsuyContrasenia(int posicion, String contrasenia) {
        return arrayUsuarios[posicion].getContrasenia().equals(contrasenia);
    }

    /**
     * Funcion que comprueba si el nombre de usuario introducido ya existe o no
     * @param username como cadena
     * @return la posicion del usuario con ese nombre o -1 si no existe
     */
    public int existeNombreUsuario (String username) {
        int posUsuario = buscarUsuario("nombre de usuario", username);
        if ((posUsuario >= 0)) return posUsuario;
        return -1;
    }

    /**
     * Funcion para averiguar la clase a la que pertenece un objeto
     * @param pos como entero
     * @return una cadena con el nombre de la clase
     */
    public String averiguarClase (int pos) {
        Usuario aux = devuelveUsuario(pos);
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
            case 1 -> arrayUsuarios[pos].bloqueo();
            case 2 -> arrayUsuarios[pos].desbloqueo();
        }
    }

}
