package CodigoFuente;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class GestionApp {

    private GestionProyectos gestionProyectos;
    private GestionUsuarios gestionUsuarios;
    private ArrayList<GestionInversiones> gestionInversiones;

    public GestionApp(GestionProyectos gestionProyectos, GestionUsuarios gestionUsuarios) {
        this.gestionProyectos = gestionProyectos;
        this.gestionUsuarios = gestionUsuarios;
        this.gestionInversiones = new ArrayList<>();
    }
    public GestionApp() {
        this.gestionProyectos = new GestionProyectos();
        this.gestionUsuarios = new GestionUsuarios();
        this.gestionInversiones = new ArrayList<>();
    }

    public  String crearJSON(GestionApp gestionApp){
        Gson gson=new Gson();
        return gson.toJson(gestionApp);
    }
    public  void guardarAJSON(GestionApp gestionApp){
        String jsonCreado=crearJSON(gestionApp);
        try{
            FileWriter fichero = new FileWriter("GestionApp.json");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(jsonCreado);
            fichero.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public GestionApp recuperarJSON(String nombreArchivo) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader buffer = new BufferedReader(new FileReader(nombreArchivo+".json"));
        return gson.fromJson(buffer, this.getClass());
    }
}
