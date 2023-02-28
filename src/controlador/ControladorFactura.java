
package controlador;
//libreria
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import Modelo.*;
import DAO.*;
import Formatos.*;
import DAO.CRUDfacturas;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ControladorFactura implements ActionListener{
    //atributos
        Facturas vista;
        Factura fa;
        CRUDfacturas crud;
      FormatoFactura fac;
       CargarCombos cc;
     //constructor
    public ControladorFactura(Facturas fac){
        this.vista = fac;
       vista.jConsultaFactura.addActionListener(this);
       vista.jbtnConsultarF.addActionListener(this);
       vista.jtbnModificarF.addActionListener(this);
       vista.jbtnEliminarF.addActionListener(this);
       Calendar cal =  new GregorianCalendar();
        vista.jfechaFConsultra.setCalendar(cal);
        vista.jFechaFl.setCalendar(cal);
       cc = new CargarCombos();
        cc.CargarNombreEmpleado(vista.jtxtCodigo_Empleado);
        crud = new CRUDfacturas();
        crud.MostrarFacturasEnTabla(vista.jtblFacturasF,vista.jtxtCFacturas);
        vista.setTitle("Factura"); 
        vista.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == vista.jtbnModificarF){
            fa = FormatoFactura.LeerProducto(vista);
              crud = new CRUDfacturas(); 
              crud.ActualizarFactura(fa);
             crud.MostrarFacturasEnTabla(vista.jtblFacturasF,vista.jtxtCFacturas);
              FormatoFactura.LimpiarEntradas(vista);

            }
            }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede modificar .."+ex);
                   }
           try{
           if(e.getSource() == vista.jbtnEliminarF){
             int respuesta = Mensajes.M3("Confirmar!!!","¿Deseas eliminar al empleado?");
             if(respuesta==0){
                 fa = FormatoFactura.LeerProducto(vista);
                  crud = new CRUDfacturas(); 
              crud.EliminarFactura(fa);
              crud.EliminarDetalleFactura(fa);
             crud.MostrarFacturasEnTabla(vista.jtblFacturasF,vista.jtxtCFacturas);
              FormatoFactura.LimpiarEntradas(vista);
             }
         }}catch (Exception ex){
                   Mensajes.M1("ERROR no se puede eliminar .."+ex);
                   }
              if(e.getSource() == vista.jbtnConsultarF){
               String cod_fa = Mensajes.M2("Ingrese el codigo del empleado a buscar ");
             crud = new CRUDfacturas(); 
             fa = crud.ObtenerRegistroFactura(cod_fa);
             if(fa==null){
                 Mensajes.M1("El ID "+fa+" no existe en la tabla Factura..");
             }else{
                   try {
                       int fecha = vista.jtblFacturasF.getSelectedRow();
                       DefaultTableModel model = (DefaultTableModel)vista.jtblFacturasF.getModel();
                       vista.jtxtCod_Factura.setText(Integer.toString(fa.getCod_factura()));
                       vista.jtxtDNIF.setText(fa.getDNI_Cliente());
                        ManejadorIdForaneos mif =  new ManejadorIdForaneos();
                       vista.jtxtCodigo_Empleado.setSelectedItem(mif.RecuperarNomEmp(fa.getCod_emp()));
                       SimpleDateFormat  df =  new SimpleDateFormat("yyyy-MM-dd");
                       Date fec = (Date) df.parse(fa.getFecha());
                       vista.jFechaFl.setDate(fec);
                       vista.jtxtTotalF.setText(Double.toString(fa.getTotal()));
                   } catch (ParseException ex) {
                       Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);
                   }
             }
         }

    }  
}