package CodigoFuente;
import static Biblioteca.Lectura_De_Datos.*;

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
    public void mostrarYAniadirSaldo(){
        String respuesta;
        double cantidad;
        System.out.println("Tu saldo actual es de "+ getSaldo() );
        System.out.println("¿Quieres añadir saldo?");
        respuesta=leerOpcionLiteral();
        if(respuesta.equalsIgnoreCase("Si")){
            System.out.println("Introduce cuanto saldo quieres añadir");
            cantidad=leerOpcionDouble();
            setSaldo(getSaldo()+cantidad);
            System.out.println("Tu saldo ahora es de "+getSaldo());
        }
    }

    //getters
    public double getSaldo() {
        return saldo;
    }
    public boolean getBloqueado() { return bloqueado; }

}
