package CodigoFuente;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class GestionApp {

    private GestionProyectos gestionProyectos;
    private GestionUsuarios gestionUsuarios;
    private ArrayList<GestionInversiones> gestionesInversiones;

    public GestionApp(GestionProyectos gestionProyectos, GestionUsuarios gestionUsuarios) {
        this.gestionProyectos = gestionProyectos;
        this.gestionUsuarios = gestionUsuarios;
        this.gestionesInversiones = new ArrayList<>();
    }
    public GestionApp() {
        this.gestionProyectos = new GestionProyectos();
        this.gestionUsuarios = new GestionUsuarios();
        this.gestionesInversiones = new ArrayList<>();
    }

    public ArrayList<GestionInversiones> devuelveGestionInversiones() {
        return gestionesInversiones;
    }

    public GestionUsuarios getGestionUsuarios () {
        return gestionUsuarios;
    }

    public GestionProyectos getGestionProyectos () {
        return gestionProyectos;
    }

    /**
     * Funcion para crear un Json de los Inversores
     * @return una cadena con el Json creado
     */
    public String crearJSONInversiones (){
        Gson gson=new Gson();
        return gson.toJson(gestionesInversiones);
    }

    /**
     * Funcion para guardar un Json creado para las Inversiones
     */
    public void guardarJSONInversiones () {
        String jsonCreado = crearJSONInversiones();
        try{
            FileWriter fichero = new FileWriter("GestionesInversiones.json");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(jsonCreado);
            fichero.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Funcion para recuperar el Json de los Inversores
     * @return un Json de una coleccion de objetos de la clase GestionInversiones
     * @throws FileNotFoundException
     */
    public ArrayList<GestionInversiones> recuperarJSONInversiones() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader buffer = new BufferedReader(new FileReader("GestionesInversiones.json"));
        return gson.fromJson(buffer, new TypeToken<ArrayList<GestionInversiones>>(){}.getType());
    }

    /**
     * Funcion para guardar un Json creado
     */
    public void guardarAJSON(){
        gestionProyectos.guardarAJSON();
        gestionUsuarios.guardarUsuariosJson();
        guardarJSONInversiones();
    }

    /**
     * Funcion para recuperar el Json creado
     * @throws FileNotFoundException
     */
    public void recuperarJSON() throws FileNotFoundException {
        gestionProyectos = GestionProyectos.recuperarJSON();
        gestionesInversiones = recuperarJSONInversiones();
        gestionUsuarios.recuperarUsuariosJson();
    }

}
