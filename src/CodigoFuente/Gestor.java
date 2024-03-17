package CodigoFuente;

import com.google.gson.Gson;

import java.io.*;

public class Gestor extends Usuario implements Bloqueable {
    //ATRIBUTOS
    private boolean bloqueado;

    //MÉTODOS
    public Gestor(String nombre, String usuario, String contrasenia, String email) {
        super(nombre, usuario, contrasenia, email);
        bloqueado = false;
    }
    //getters
    public boolean isBloqueado() { return bloqueado; }
    public String toString () {
        return super.toString() + (bloqueado?"Bloqueado":"");
    }

    @Override
    public void bloqueo() {
        this.bloqueado = true;
    }
    @Override
    public void desbloqueo() {
        this.bloqueado = false;
    }

    /**
     * Funcion para crear un Json
     * @return
     */
    public String crearJSON(){
        Gson gson=new Gson();
        return gson.toJson(this);
    }

    /**
     * Funcion para guardar un Json creado
     */
    public void guardarAJSON(){
        String jsonCreado = crearJSON();
        try{
            FileWriter fichero = new FileWriter("G" + getNombre()+".json");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(jsonCreado);
            fichero.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Funcion para recuperar el Json de los Gestores
     * @param nombre como String
     * @return Json creado para la clase Gestor
     * @throws FileNotFoundException
     */
    public static Gestor recuperarJSON(String nombre) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader buffer = new BufferedReader(new FileReader(nombre + ".json"));
        return gson.fromJson(buffer, Gestor.class);
    }
}