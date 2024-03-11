package CodigoFuente;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionInversiones {

    private Inversor propietario;
    private ArrayList<Inversion> inversiones;

    public Inversor getPropietario() {
        return propietario;
    }


    public GestionInversiones (Inversor inversor) {
        this.propietario = inversor;
        this.inversiones = new ArrayList<>();
    }

    /**
     * Funcion para realizar una nueva inversion
     * @param inversor como objeto de la clase Inversor
     * @param proyecto inversor como objeto de la clase Proyecto
     * @param primerIngreso como double
     * @param fechaInversion como una fecha
     */
    public void nuevaInversion (int pos,Inversor inversor, Proyecto proyecto, double primerIngreso, LocalDate fechaInversion) {
        inversiones.add(new Inversion(inversor, proyecto));
        if (inversiones.get(pos).financiarProyecto(primerIngreso, fechaInversion)) {
            System.out.println("Inversión existosa, los detalles están disponibles para revisión.");
        } else {
            System.out.println("No cuentas con saldo suficiente para realizar esta transacción.");
            inversiones.remove(pos);
        }
    }

    /**
     * Actualiza una inversion ya realizada
     * @param pos como entero
     * @param cantidadEntrante como double
     * @param fechaActualizacion como una fecha
     */
    public void actualizarInversion (int pos, double cantidadEntrante, LocalDate fechaActualizacion) {
        inversiones.get(pos).financiarProyecto(cantidadEntrante, fechaActualizacion);
    }

    /**
     * Funcion para mostrar las inversiones por un inversor
     */
    public void mostrarMisInversiones () {
        System.out.println("Mis inversiones: ");
        System.out.println("================");
        for (Inversion inversion : inversiones) {
                System.out.println(inversion);
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
            for (int j = 0; j < inversiones.size(); j++) {
                if ((todosLosProyectos.devuelveProyecto(i) != null && inversiones.get(j) != null) && (todosLosProyectos.devuelveProyecto(i).getNombre().equals(inversiones.get(j).getProyecto().getNombre()))) esta = true;
            }
            if (!esta) System.out.println(todosLosProyectos.devuelveProyecto(i));
        }
    }


}
