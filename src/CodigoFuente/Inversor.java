package CodigoFuente;

public class Inversor extends Usuario{
    //ATRIBUTOS
    private double saldo;
    private boolean bloqueado;


    //MÉTODOS
    public Inversor(String nombre, String usuario, String contrasenia, String email, double saldo) {
        super(nombre, usuario, contrasenia, email);
        this.saldo = saldo;
        bloqueado = false;
    }

    //setters
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setBloqueado (boolean noEntry) { bloqueado = true; }

    public boolean paga(double cantidad) {
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

}
