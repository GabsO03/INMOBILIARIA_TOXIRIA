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
    public void actualizarInversion (int pos, double cantidadEntrante) {
        if (inversor.paga(cantidadEntrante)) {
            inversiones.get(pos).financiarProyecto(cantidadEntrante);
            System.out.println("Inversión existosa, los detalles están disponibles para revisión.");
        } else {
            System.out.println("No cuentas con saldo suficiente para realizar esta transacción.");
        }
    }

    /**
     * Funcion para mostrar las inversiones por un inversor
     */
    public void mostrarMisInversiones () {
        System.out.println("Mis inversiones: ");
        System.out.println("================");
        for (Inversion inversion : inversiones) System.out.println(inversion);
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
            for (Inversion inversiones : inversiones) {
                if (todosLosProyectos.devuelveProyecto(i).getNombre().equals(inversiones.getProyecto().getNombre()))
                    esta = true;
            }
            if (!esta) System.out.println(todosLosProyectos.devuelveProyecto(i));
        }
    }
}
