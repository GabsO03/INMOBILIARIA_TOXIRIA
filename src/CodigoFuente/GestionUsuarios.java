package CodigoFuente;

public class GestionUsuarios {

    private int numeroUsuariosInsertados;
    private Usuario[] arrayUsuarios;


    public GestionUsuarios() {
        this.arrayUsuarios = new Usuario[15];
    }

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


    public void muestraUsuarios () {
        int i = 1;
        System.out.println("Lista de usuarios:");
        System.out.println("===============================");
        for (Usuario u : arrayUsuarios) {
            if (u != null )System.out.println(i++ + ") " + u);
        }
    }

    public Usuario devuelveUsuario (int pos) {
        if (arrayUsuarios[pos] != null) return arrayUsuarios[pos];
        return null;
    }

    public void insertarUsuarioGestor ( String nombre, String apellidos, String contrasenia, String email) {
        arrayUsuarios[numeroUsuariosInsertados++] = new Gestor (nombre, apellidos, contrasenia, email);
        aumentaTamanio();
    }
    public void insertarUsuarioGestor ( String nombre, String apellidos, String contrasenia, String email, double saldo) {
        arrayUsuarios[numeroUsuariosInsertados++] = new Inversor (nombre, apellidos, contrasenia, email, saldo);
        aumentaTamanio();
    }
    public void aumentaTamanio () {
        if (numeroUsuariosInsertados == arrayUsuarios.length) {
            Usuario[] arrayAux = new Usuario[arrayUsuarios.length + 15];
            for (int i = 0; i < arrayUsuarios.length; i++) {
                arrayAux[i] = arrayUsuarios[i];
            }
            arrayUsuarios = arrayAux;
        }
    }

    public void modificarUsuario (int pos, String nombre, String apellidos, String contrasenia, String email) {
        arrayUsuarios[pos].setNombre(nombre);
        arrayUsuarios[pos].setApellidos(apellidos);
        arrayUsuarios[pos].setContrasenia(contrasenia);
        arrayUsuarios[pos].setEmail(email);
    }
    public int buscarUsuario(String atributo, String valor) {
        return buscarUsuario(atributo, valor, 0);
    }
    public int buscarUsuario(String atributo, String valor, int posicion) {
        int entero;
        atributo = atributo.toLowerCase();
        valor = valor.toLowerCase();
        switch (atributo) {
            case "código" -> {
                entero = Integer.parseInt(valor);
                for (int i = posicion; i < arrayUsuarios.length; i++) {
                    if (arrayUsuarios[i] != null && arrayUsuarios[i].getCodigo() == entero) return i;
                }
            }
            case "nombre" -> {
                for (int i = posicion; i < arrayUsuarios.length; i++) {
                    if (arrayUsuarios[i] != null && arrayUsuarios[i].getNombre().equalsIgnoreCase(valor)) return i;
                }
            }
            case "apellidos" -> {
                for (int i = posicion; i < arrayUsuarios.length; i++) {
                    if (arrayUsuarios[i] != null && arrayUsuarios[i].getApellidos().equalsIgnoreCase(valor)) return i;
                }
            }
            case "nombre de usuario" -> {
                for (int i = posicion; i < arrayUsuarios.length; i++) {
                    if (arrayUsuarios[i] != null && arrayUsuarios[i].getUsername().equalsIgnoreCase(valor)) return i;
                }
            }
            default -> System.out.println("Ese parámetro no está disponible.");
        }
        return -1;
    }

    public boolean eliminarAlumno (int pos) {
        if (arrayUsuarios[pos]!=null){
            arrayUsuarios[pos]=null;
            reorganizaArray(pos);
        }
        return false;
    }
    public void reorganizaArray (int pos) {
        for (int i = pos; i < arrayUsuarios.length-1; i++) {
            arrayUsuarios[i] = arrayUsuarios[i+1];
        }
        arrayUsuarios[arrayUsuarios.length-1]=null;
    }

    public void intercambiaUsarios(int pos1, int pos2) {
        Usuario aux = arrayUsuarios[pos1];
        arrayUsuarios[pos1] = arrayUsuarios[pos2];
        arrayUsuarios[pos2] = aux;
    }

    public void ordenaUsuarios(String atributo) {
        atributo = atributo.toLowerCase();

        switch (atributo) {
            case "nombre" -> {
                for (int j = 0; j < arrayUsuarios.length-1; j++) {
                    for (int i = 0; i < arrayUsuarios.length - (1 + j); i++) {
                        if (arrayUsuarios[i]!=null && arrayUsuarios[i + 1]!=null){
                            if (arrayUsuarios[i].getNombre().compareTo(arrayUsuarios[i + 1].getNombre()) > 0) {
                                intercambiaUsarios(i, i + 1);
                            }
                        }
                    }
                }
            }
            case "apellidos" -> {
                for (int j = 0; j < arrayUsuarios.length-1; j++) {
                    for (int i = 0; i < arrayUsuarios.length - (1 + j); i++) {
                        if (arrayUsuarios[i]!=null && arrayUsuarios[i + 1]!=null){
                            if (arrayUsuarios[i].getApellidos().compareTo(arrayUsuarios[i + 1].getApellidos()) > 0) {
                                intercambiaUsarios(i, i + 1);
                            }
                        }
                    }
                }
            }
            case "nombre de usuario" -> {
                for (int j = 0; j < arrayUsuarios.length; j++) {
                    for (int i = 0; i < arrayUsuarios.length - (1 + j); i++) {
                        if (arrayUsuarios[i]!=null && arrayUsuarios[i + 1]!=null){
                            if (arrayUsuarios[i].getUsername().equalsIgnoreCase(arrayUsuarios[i + 1].getUsername())) {
                                intercambiaUsarios(i, i + 1);
                            }
                        }
                    }
                }
            }
            default -> System.out.println("Ese parámetro no está disponible.");
        }
    }
}
