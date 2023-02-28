package DAO;
//librerias
import java.sql.*;
import Formatos.Mensajes;
public class ConectarBD implements Parametros{
    Connection conexion;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    public ConectarBD(){
        try{
            Class.forName(DRIVER);
            conexion =  DriverManager.getConnection(RUTA,USUARIO,CLAVE);
            st =  conexion.createStatement();            
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede conectar a la BD.."+ex);
        }
    }    
}//fin del class
