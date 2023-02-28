
package Formatos;
//librerias
import vista.Empleado;
import java.util.*;
import Modelo.Empleado1;
import java.text.SimpleDateFormat;
import DAO.*;
public class FormatoEmpleado {
public static void LimpiarEntradas(Empleado emp){
   emp.jtxtCodigoE.setText("");
   emp.jtxtNombreE.setText("");
   emp.jtxtApellidoE.setText("");
   emp.jtxtDireccionE.setText("");
   emp.jtxtTelefonoE.setText("");
   emp.jtxtSueldoE.setText("");
   emp.jtxtEdadE.setText("");
   emp.jspnDiasTrabajoE.setValue(0);
   emp.jtxtCodigoE.requestFocus();    
}
public static Empleado1 LeerProducto(Empleado re){
     Empleado1 empl = new Empleado1();
     empl.setCod_emp(re.jtxtCodigoE.getText());
     empl.setNombre(re.jtxtNombreE.getText());
     empl.setApellido(re.jtxtApellidoE.getText());
     empl.setDireccion(re.jtxtDireccionE.getText());
     empl.setTelefono(re.jtxtTelefonoE.getText());
     empl.setSueldo(Double.parseDouble(re.jtxtSueldoE.getText()));
     empl.setEdad(Integer.parseInt(re.jtxtEdadE.getText()));
     empl.setDias_Trabajo(Integer.parseInt(re.jspnDiasTrabajoE.getValue().toString()));
    
     return empl;
}    
}
