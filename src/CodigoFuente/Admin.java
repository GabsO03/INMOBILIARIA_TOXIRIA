package CodigoFuente;

import com.google.gson.Gson;

import java.io.*;

public class Admin extends Usuario {

    //MÉTODOS
    //constructor
    public Admin(String nombre, String usuario, String contrasenia, String email) {
        super(nombre, usuario, contrasenia, email);
    }

    public String crearJSON(){
        Gson gson=new Gson();
        return gson.toJson(this);
    }
    public void guardarAJSON(){
        String jsonCreado = crearJSON();
        try{
            FileWriter fichero = new FileWriter("A" + getNombre() + ".json");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(jsonCreado);
            fichero.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Admin recuperarJSON(String nombre) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader buffer = new BufferedReader(new FileReader(nombre + ".json"));
        return gson.fromJson(buffer, Admin.class);
    }
}
