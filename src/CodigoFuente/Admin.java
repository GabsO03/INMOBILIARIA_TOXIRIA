package CodigoFuente;

public class Admin extends Usuario {

    //MÉTODOS
    //constructor
    public Admin(String nombre, String usuario, String contrasenia, String email) {
        super(nombre, usuario, contrasenia, email);
    }

    @Override
    public void bloqueo() {}

    @Override
    public void desbloqueo() {}


}
