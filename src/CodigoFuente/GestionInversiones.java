package CodigoFuente;

public class GestionInversiones {

    private Inversor inversor;
    private Inversion[] inversiones;
    private int cantidadInversiones;
    private int cantidadInversionesCreadas = 0;

    public Inversor getInversor() {
        return inversor;
    }

    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }

    public Inversion[] getInversiones() {
        return inversiones;
    }

    public void setInversiones(Inversion[] inversiones) {
        this.inversiones = inversiones;
    }

    public int getCantidadInversiones() {
        return cantidadInversiones;
    }

    public void setCantidadInversiones(int cantidadInversiones) {
        this.cantidadInversiones = cantidadInversiones;
    }

    public int getCantidadInversionesCreadas() {
        return cantidadInversionesCreadas;
    }

    public void setCantidadInversionesCreadas(int cantidadInversionesCreadas) {
        this.cantidadInversionesCreadas = cantidadInversionesCreadas;
    }

    public GestionInversiones (Inversor inversor, int cantidadInversiones) {
        this.inversor = inversor;
        this.inversiones = new Inversion[cantidadInversiones];
    }

    public void nuevaInversion (Proyecto proyecto, double primerIngreso) {
        inversiones[cantidadInversionesCreadas++] = new Inversion(inversor, proyecto);
        inversiones[cantidadInversionesCreadas].financiarProyecto(primerIngreso);
        aumentaTamanio();
    }

    public void aumentaTamanio () {
        if (cantidadInversionesCreadas == inversiones.length) {
            Inversion[] arrayAux = new Inversion[inversiones.length + 15];
            for (int i = 0; i < inversiones.length; i++) {
                arrayAux[i] = inversiones[i];
            }
            inversiones = arrayAux;
        }
    }

    public void actualizarInversion (int pos, double cantidadEntrante) {
        inversiones[pos].financiarProyecto(cantidadEntrante);
    }



}
