package CodigoFuente;

import java.io.PushbackInputStream;

public abstract class Usuario {
    //ATRIBUTOS
    private String nombre;
    private String username;
    private String contrasenia;
    private String email;

    //CONSTRUCTORES
    public Usuario(String nombre, String username, String contrasenia, String email) {
        this.nombre = nombre;
        this.username = username;
        this.contrasenia = contrasenia;
        this.email = email;
    }
    public Usuario (Usuario u) {
        this.nombre = u.getNombre();
        this.username = u.getUsername();
        this.contrasenia = u.getContrasenia();
        this.email = u.getEmail();
    }

    //setters
    public void setNombre (String nombre) { this.nombre = nombre; }
    public void setUsername(String username) { this.username = username; }
    public void setContrasenia (String contrasenia) { this.contrasenia = contrasenia; }
    public void setEmail (String email) { this.email = email; }


    //getters
    public String getNombre () { return nombre; }
    public String getUsername() { return username; }
    public String getContrasenia () { return contrasenia; }
    public String getEmail () { return email; }


    public String toString () {
        return "Nombre de usuario: " + username + " | Nombre: " + nombre;
    }

}
