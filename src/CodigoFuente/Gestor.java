package CodigoFuente;

public class Gestor extends Usuario {
    //ATRIBUTOS
    private boolean bloqueado;

    //MÉTODOS
    public Gestor(String nombre, String usuario, String contrasenia, String email) {
        super(nombre, usuario, contrasenia, email);
        bloqueado = false;
    }
    //setters
    public void setBloqueado (boolean noEntry) { bloqueado = true; }


    //getters
    public boolean getBloqueado () { return bloqueado; }
}
