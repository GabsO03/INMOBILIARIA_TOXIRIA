package CodigoFuente;

public class GestionInversiones {

    private Inversor inversor;
    private Inversion[] inversiones;
    private int cantidadInversiones;
    private int cantidadInversionesCreadas = 0;


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
