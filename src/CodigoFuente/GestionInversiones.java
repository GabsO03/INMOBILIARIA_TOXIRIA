package CodigoFuente;

import java.time.LocalDate;

public class GestionInversiones {

    private Inversor propietario;
    private Inversion[] inversiones;
    private int cantidadInversiones;
    private int cantidadInversionesCreadas = 0;

    public Inversor getPropietario() {
        return propietario;
    }

    public void setPropietario(Inversor propietario) {
        this.propietario = propietario;
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
        this.propietario = inversor;
        this.inversiones = new Inversion[cantidadInversiones];
    }

    /**
     * Funcion para realizar una nueva inversion
     * @param inversor como objeto de la clase Inversor
     * @param proyecto inversor como objeto de la clase Proyecto
     * @param primerIngreso como double
     * @param fechaInversion como una fecha
     */
    public void nuevaInversion (Inversor inversor, Proyecto proyecto, double primerIngreso, LocalDate fechaInversion) {
        inversiones[cantidadInversionesCreadas] = new Inversion(inversor, proyecto);
        if (inversiones[cantidadInversionesCreadas++].financiarProyecto(primerIngreso, fechaInversion)) {
            System.out.println("Inversión existosa, los detalles están disponibles para revisión.");
            aumentaTamanio();
        } else {
            System.out.println("No cuentas con saldo suficiente para realizar esta transacción.");
            inversiones[cantidadInversionesCreadas--] = null;
        }
    }

    /**
     * Funcion para aumentar el tamaño del array
     */
    public void aumentaTamanio () {
        if (cantidadInversionesCreadas == inversiones.length) {
            Inversion[] arrayAux = new Inversion[inversiones.length + 15];
            for (int i = 0; i < inversiones.length; i++) {
                arrayAux[i] = inversiones[i];
            }
            inversiones = arrayAux;
        }
    }

    /**
     * Actualiza una inversion ya realizada
     * @param pos como entero
     * @param cantidadEntrante como double
     * @param fechaActualizacion como una fecha
     */
    public void actualizarInversion (int pos, double cantidadEntrante, LocalDate fechaActualizacion) {
        inversiones[pos].financiarProyecto(cantidadEntrante, fechaActualizacion);
    }

    /**
     * Funcion para mostrar las inversiones por un inversor
     */
    public void mostrarMisInversiones () {
        System.out.println("Mis inversiones: ");
        System.out.println("================");
        for (Inversion inversion : inversiones) {
            if (inversion != null) {
                System.out.println(inversion);
            }
        }
    }

    /**
     * Funcion para mostrar los proyectos en los que aún no se han invertido
     * @param todosLosProyectos como objeto de la clase GestionProyectos
     */
    public void proyectosAunNoInvertidos (GestionProyectos todosLosProyectos) {
        boolean esta;
        System.out.println("Proyectos aún no invertidos: ");
        System.out.println("============================");
        for (int i = 0; i < todosLosProyectos.getCantidadProyectos(); i++) {
            esta = false;
            for (int j = 0; j < inversiones.length; j++) {
                if ((todosLosProyectos.devuelveProyecto(i) != null && inversiones[i] != null) && (todosLosProyectos.devuelveProyecto(i).getNombre().equals(inversiones[j].getProyecto().getNombre()))) esta = true;
            }
            if (!esta) System.out.println(todosLosProyectos.devuelveProyecto(i));
        }
    }


}
