package CodigoFuente;
import static Biblioteca.Lectura_De_Datos.*;

public class Inversor extends Usuario{
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

    @Override
    public void bloqueo() {
        this.bloqueado = true;
    }
    @Override
    public void desbloqueo() {
        this.bloqueado = false;
    }

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

    public String toString () {
        return super.toString() + (bloqueado?"Bloqueado":"");
    }
}
