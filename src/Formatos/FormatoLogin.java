
package Formatos;
//librerias
import vista.Login;
import java.util.*;
import Modelo.RegistroUsuario;
import java.text.SimpleDateFormat;
import DAO.*;
import DAO.CRUDlogin;
public class FormatoLogin {
public static void LimpiarEntradas(Login lo){
    lo.jcbcTipoUsuario.setSelectedIndex(0);
    lo.jtxtUsuario.setText("");
    lo.jtxtContraseña.setText("");
    lo.jtxtUsuario.requestFocus();    
}
public static RegistroUsuario LeerProducto(Login lo){
     RegistroUsuario log = new RegistroUsuario();
     ManejadorIdForaneos mif = new ManejadorIdForaneos();
     log.setTipoUsuario(mif.RecuperarTipoU(lo.jcbcTipoUsuario.getSelectedItem().toString()));
     log.setUsuario(lo.jtxtUsuario.getText());
     log.setPassword(lo.jtxtContraseña.getText());
     return log;
}    
}