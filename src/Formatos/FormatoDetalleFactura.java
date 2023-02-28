
package Formatos;

import DAO.ManejadorIdForaneos;
import Modelo.Factura;
import java.text.SimpleDateFormat;
import vista.DetalleFactura;
import Modelo.RegistroFactura;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FormatoDetalleFactura {
        public static void LimpiarEntradas(DetalleFactura fac){
   fac.txtDNIFac.setText("");
   fac.cbcEmpleadoFac.setSelectedIndex(0);
   Calendar cal =  new GregorianCalendar();
    fac.jdataFactura.setCalendar(cal);
   fac.TotalFac.setText("");
   fac.txtCodProFac.requestFocus();    
}
public static Factura LeerProducto(DetalleFactura fact){
     Factura fa = new Factura();
     fa.setDNI_Cliente(fact.txtDNIFac.getText());
     ManejadorIdForaneos mif = new ManejadorIdForaneos();
     fa.setCod_emp(mif.RecuperarCodEmp(fact.cbcEmpleadoFac.getSelectedItem().toString()));
     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
     fa.setFecha(sf.format(fact.jdataFactura.getDate()));
     fa.setTotal(Double.parseDouble(fact.TotalFac.getText()));
     return fa;
}  
}
