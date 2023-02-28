
package Modelo;


public class RegistroUsuario implements TipoUsuario {

    //atributos
    private int TipoUsuario;
    private String Usuario;
    private String Nombre_u;
    private String Apellido_u;
    private String Email_u;
    private String password;
    //constructor
    public RegistroUsuario (){}
    //getter y setter
     public int getTipoUsuario() {return TipoUsuario;}
    public void setTipoUsuario(int TipoUsuario) {this.TipoUsuario = TipoUsuario;}
    public String getUsuario() {return Usuario;}
    public void setUsuario(String Usuario) {this.Usuario = Usuario;}
     public String getNombre_u() {return Nombre_u;}
    public void setNombre_u(String Nombre_u) {this.Nombre_u = Nombre_u;}
    public String getApellido_u() {return Apellido_u;}
    public void setApellido_u(String Apellido_u) {this.Apellido_u = Apellido_u;}
    public String getEmail_u() {return Email_u;}
    public void setEmail_u(String Email_u) {this.Email_u = Email_u;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}   
}
