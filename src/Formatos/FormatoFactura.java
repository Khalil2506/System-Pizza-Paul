
package Formatos;
import vista.Facturas;
import vista.DetalleFactura;
import java.util.*;
import Modelo.Factura;
import java.text.SimpleDateFormat;
import DAO.*;

public class FormatoFactura {
    public static void LimpiarEntradas(Facturas fac){
   fac.jtxtCod_Factura.setText("");
   fac.jtxtDNIF.setText("");
   fac.jtxtCodigo_Empleado.setSelectedIndex(0);
   Calendar cal =  new GregorianCalendar();
    fac.jFechaFl.setCalendar(cal);
   fac.jtxtTotalF.setText("");
   fac.jtxtDNIF.requestFocus();    
}
public static Factura LeerProducto(Facturas fact){
     Factura fa = new Factura();
     fa.setCod_factura(Integer.parseInt(fact.jtxtCod_Factura.getText()));
     fa.setDNI_Cliente(fact.jtxtDNIF.getText());
     ManejadorIdForaneos mif = new ManejadorIdForaneos();
     fa.setCod_emp(mif.RecuperarCodEmp(fact.jtxtCodigo_Empleado.getSelectedItem().toString()));
     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
     fa.setFecha(sf.format(fact.jFechaFl.getDate()));
     fa.setTotal(Double.parseDouble(fact.jtxtTotalF.getText()));
     return fa;
}  
}
