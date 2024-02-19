package CodigoFuente;

public  class Gestor extends Usuario {
    //ATRIBUTOS
    private boolean bloqueado;

    //MÉTODOS
    public Gestor(String nombre, String usuario, String contrasenia, String email) {
        super(nombre, usuario, contrasenia, email);
        bloqueado = false;
    }
    //getters
    public boolean getBloqueado () { return bloqueado; }
    public String toString () {
        return super.toString() + (bloqueado?"Bloqueado":"");
    }

    @Override
    public void bloqueo() {
        this.bloqueado = true;
    }
    @Override
    public void desbloqueo() {
        this.bloqueado = false;
    }

}
