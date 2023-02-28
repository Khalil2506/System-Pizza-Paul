package DAO;
//libreria
import Modelo.RegistroUsuario;
import Formatos.Mensajes;
public class CRUDregistro extends ConectarBD{
    public CRUDregistro(){ }
    
//metodo que inserta en registro de datos
public void InsertarRegistroProd(RegistroUsuario re){
    try{
       ps = conexion.prepareStatement(
            "INSERT INTO registro(Usuario, NombreUsuario, ApellidoUsuario, Email, contrasena,cod_tipo)" +
            " values(?,?,?,?,?,'1');");
      ps.setString(1,re.getUsuario());
      ps.setString(2,re.getNombre_u());
      ps.setString(3,re.getApellido_u());
      ps.setString(4,re.getEmail_u());
      ps.setString(5,re.getPassword());
      ps.executeUpdate();
      ps.close();
      Mensajes.M1(" registrado correctamente!!!");
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede resgistrar.."+ex);
    }    
}   
}

