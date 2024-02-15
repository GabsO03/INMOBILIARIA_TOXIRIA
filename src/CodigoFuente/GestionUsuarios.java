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

//ADSFDGFHGJFHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
//ADSFDGFHGJFHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
//ADSFDGFHGJFHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
//ADSFDGFHGJFHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
//ADSFDGFHGJFHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
//ADSFDGFHGJFHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
//ADSFDGFHGJFHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
//ADSFDGFHGJFHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
//ADSFDGFHGJFHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
    public void muestraUsuarios (int clase) {
        int i = 1;
        System.out.println("Lista de usuarios:");
        System.out.println("===============================");
        for (Usuario u : arrayUsuarios) {
            if (u != null) System.out.println(i++ + ") " + u);
        }
        /*
                                if (p != null && p.getClass().getSimpleName().equals("Alumno")) {
                            p.asiste();
                            //Esto para poder ejecutar métodos que solo tiene alumnos
                            Alumno aux = (Alumno) p;
                        }
         */
    }

    public Usuario devuelveUsuario (int pos) {
        if (arrayUsuarios[pos] != null) return arrayUsuarios[pos];
        return null;
    }

    public void insertarUsuarioAdmin(String nombre, String user, String contrasenia, String email){
        arrayUsuarios[numeroUsuariosInsertados++] = new Admin(nombre, user, contrasenia, email);
        aum
    }
    public void insertarUsuarioGestor ( String nombre, String user, String contrasenia, String email) {
        arrayUsuarios[numeroUsuariosInsertados++] = new Gestor (nombre, user, contrasenia, email);
        aumentaTamanio();
    }
    public void insertarUsuarioInversor ( String nombre, String user, String contrasenia, String email) {
        arrayUsuarios[numeroUsuariosInsertados++] = new Inversor (nombre, user, contrasenia, email, 0);
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
        arrayUsuarios[pos].setContrasenia(contrasenia);
        arrayUsuarios[pos].setEmail(email);
    }
    public int buscarUsuario(String atributo, String valor) {
        atributo = atributo.toLowerCase();
        valor = valor.toLowerCase();
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

    public int existeUsuario (String username, String contrasenia) {
        int posUsuario = buscarUsuario("nombre de usuario", username);
        int posContrasenia = buscarUsuario("contraseña", contrasenia);
        if ((posUsuario >= 0 && posContrasenia >= 0) && posUsuario==posContrasenia) return posUsuario;
        return -1;
    }

    public String averiguarClase (int pos) {
        Usuario aux = devuelveUsuario(pos);
        return aux.getClass().getSimpleName();
    }

}
