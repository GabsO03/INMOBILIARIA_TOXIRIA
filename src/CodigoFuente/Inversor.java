package CodigoFuente;

public class Inversor extends Usuario implements Bloqueable {
    //ATRIBUTOS
    private double saldo;
    private boolean bloqueado;


    //MÉTODOS
    public Inversor(String nombre, String usuario, String contrasenia, String email) {
        super(nombre, usuario, contrasenia, email);
        this.saldo = 0;
        bloqueado = false;
    }

    //setters
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    /**
     * Funcion para comprobar si el inversor puede invertir en un proyecto con cierta cantidad o no
     * @param cantidad como double
     * @return true si si puede invertir o false si no
     */
    public boolean paga (double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }



    //getters
    public double getSaldo() {
        return saldo;
    }
    public boolean getBloqueado() { return bloqueado; }
    @Override
    public void bloqueo() {
        this.bloqueado = true;
    }
    @Override
    public void desbloqueo() {
        this.bloqueado = false;
    }


    public String toString () {
        return super.toString() + (bloqueado?"Bloqueado":"");
    }
}
