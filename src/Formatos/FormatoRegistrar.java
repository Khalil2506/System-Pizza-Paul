
package Formatos;
//librerias
import vista.REGISTRAR_USUARIO;
import java.util.*;
import Modelo.RegistroUsuario;
import java.text.SimpleDateFormat;
import DAO.*;
public class FormatoRegistrar {
public static void LimpiarEntradas(REGISTRAR_USUARIO re){
    re.jtxtNombreUsuario.setText("");
    re.jtxtNombre.setText("");
    re.jtxtApellido.setText("");
    re.jtxtEmail.setText("");
    re.jtxtContrasenaR.setText("");
    re.jtxtNombreUsuario.requestFocus();    
}
public static RegistroUsuario LeerProducto(REGISTRAR_USUARIO re){
     RegistroUsuario reu = new RegistroUsuario();
     reu.setUsuario(re.jtxtNombreUsuario.getText());
     reu.setNombre_u(re.jtxtNombre.getText());
     reu.setApellido_u(re.jtxtApellido.getText());
     reu.setEmail_u(re.jtxtEmail.getText());
     reu.setPassword(re.jtxtContrasenaR.getText());
    
     return reu;
}    
}