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

    public String crearJSONInversiones (){
        Gson gson=new Gson();
        return gson.toJson(gestionesInversiones);
    }
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

    public ArrayList<GestionInversiones> recuperarJSONInversiones() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader buffer = new BufferedReader(new FileReader("GestionesInversiones.json"));
        return gson.fromJson(buffer, new TypeToken<ArrayList<GestionInversiones>>(){}.getType());
    }

    public void guardarAJSON(){
        gestionProyectos.guardarAJSON();
        gestionUsuarios.guardarUsuariosJson();
        guardarJSONInversiones();
    }
    public void recuperarJSON() throws FileNotFoundException {
        gestionProyectos = GestionProyectos.recuperarJSON();
        gestionesInversiones = recuperarJSONInversiones();
        gestionUsuarios.recuperarUsuariosJson();
    }

}
