package DAO;
//libreria
import Modelo.RegistroUsuario;
import Formatos.Mensajes;
import vista.MenuPrincipal;
import vista.MenuEmpleado;
import controlador.ControladorMenuPrincipal;
import controlador.ControladorMenuEmpleado;
import java.sql.SQLException;
import java.util.ArrayList;
import vista.*;
public class CRUDlogin extends ConectarBD{
    //constructor
    public CRUDlogin(){}
    MenuPrincipal menu = new MenuPrincipal();
    MenuEmpleado menu2 = new MenuEmpleado();
    RegistroUsuario lo = new RegistroUsuario();
    Login login = new Login();
//metodo que ingresar al sistema
public void IngresarSistema(String usuario,String contrasena,int codtipo){   
     String sql ="SELECT Usuario, contrasena FROM registro WHERE Usuario='"+usuario+"' AND contrasena='"+contrasena+"' and cod_tipo ="+codtipo;
             try{     
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            usuario = rs.getString("usuario");
            contrasena = rs.getString("contrasena");
            if (codtipo == 2) {
                ControladorMenuPrincipal cmp = new ControladorMenuPrincipal(menu);
                menu.setVisible(true);
                Mensajes.M1("Bienvenido al Sistema");
                login.setVisible(false);
            }
            if(codtipo==1){
                ControladorMenuEmpleado cme = new ControladorMenuEmpleado(menu2);
                menu2.setVisible(true);
                Mensajes.M1("Bienvenido al Sistema");
                login.setVisible(false);
            }
        } else {
            Mensajes.M1("Usuario o Contraseña incorrecto");
        }
    } catch (SQLException ex) {
        Mensajes.M1("ERROR no se puede Ingresar al Sistema.." + ex);
    }
    }

}   
 