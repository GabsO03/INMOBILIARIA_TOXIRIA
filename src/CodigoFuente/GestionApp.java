package CodigoFuente;

import com.google.gson.Gson;

import java.io.*;

public class GestionApp {

    private GestionProyectos gestionProyectos;
    private GestionUsuarios gestionUsuarios;
    private GestionInversiones gestionInversiones;

    public GestionApp(GestionProyectos gestionProyectos, GestionUsuarios gestionUsuarios, GestionInversiones gestionInversiones) {
        this.gestionProyectos = gestionProyectos;
        this.gestionUsuarios = gestionUsuarios;
        this.gestionInversiones = gestionInversiones;
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
