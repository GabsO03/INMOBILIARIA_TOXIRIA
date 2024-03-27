package CodigoFuente;

import java.util.ArrayList;

public class GestionInversiones {

    private Inversor inversor;
    private ArrayList<Inversion> inversiones;

    public Inversor getInversor() {
        return inversor;
    }

    public GestionInversiones (Inversor inversor) {
        this.inversor = inversor;
        this.inversiones = new ArrayList<>();
    }

    /**
     * Funcion para realizar una nueva inversion
     * @param proyecto inversor como objeto de la clase Proyecto
     * @param primerIngreso como double
     */
    public boolean nuevaInversion (Proyecto proyecto, double primerIngreso) {
        if (inversor.paga(primerIngreso)) {
            inversiones.add(new Inversion(proyecto, primerIngreso));
            return true;
        }
        return false;
    }

    /**
     * Actualiza una inversion ya realizada
     * @param pos como entero
     * @param cantidadEntrante como double
     */
    public boolean actualizarInversion (int pos, double cantidadEntrante) {
        if (inversor.paga(cantidadEntrante)) {
            inversiones.get(pos).aumentaInversion(cantidadEntrante);
            return true;
        }
        return false;
    }


    /**
     * Funcion para mostrar las inversiones por un inversor
     */
    public String devuelveMisInversiones() {
        String cadena = "Mis inversiones:\n================";
        for (Inversion inversion : inversiones) cadena = cadena.concat("\n" + inversion);
        return cadena;
    }

    /**
     * Funcion para mostrar los proyectos en los que aún no se han invertido
     * @param todosLosProyectos como objeto de la clase GestionProyectos
     */
    public void proyectosAunNoInvertidos (GestionProyectos todosLosProyectos) {
        boolean esta;
        String cadena = "Proyectos aún no invertidos:\n============================";
        for (int i = 0; i < todosLosProyectos.getCantidadProyectos(); i++) {
            esta = false;
            for (Inversion inversiones : inversiones) {
                if (todosLosProyectos.devuelveProyecto(i).getNombre().equals(inversiones.getProyecto().getNombre()))
                    esta = true;
            }
            if (!esta) cadena = cadena.concat("\n" + todosLosProyectos.devuelveProyecto(i));
        }
    }
}
