package CodigoFuente;

public class Usuario {
    //ATRIBUTOS
    private int codigo;
    private String nombre;
    private String apellidos;
    private String username;
    private String contrasenia;
    private String email;
    private int usuariosRegistrados = 8450;

    //MÉTODOS


    public Usuario(String nombre, String usuario, String contrasenia, String email) {
        this.codigo = usuariosRegistrados++;
        this.nombre = nombre;
        this.username = usuario;
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
    public void setApellidos (String apellidos) { this.apellidos = apellidos; }
    public void setCodigo (int codigo) { this.codigo = codigo; }

    //getters
    public String getNombre () { return nombre; }
    public String getUsername() { return username; }
    public String getContrasenia () { return contrasenia; }
    public String getEmail () { return email; }
    public String getApellidos () { return apellidos; }
    public int getCodigo () { return codigo; }
}
