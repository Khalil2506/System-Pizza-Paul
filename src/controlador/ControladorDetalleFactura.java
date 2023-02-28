
package controlador;
//libreria
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import Modelo.*;
import DAO.*;
import Formatos.*;
import DAO.CRUDfacturas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class ControladorDetalleFactura implements ActionListener{
    //atributos
        DetalleFactura vista;
        Factura fa;
        RegistroFactura fact;
        CRUDdetallefactura cruda;
        CRUDfacturas crud;
      FormatoFactura fac;
       CargarCombos cc;
       ManejadorIdForaneos mif;
        DefaultTableModel modelotabla;
        double totalPagar;
    String[] TitulosTabla={"codigo Producto","Descripcion","Cantidad","Precio Unitario","Precio Total"};
     //constructor
    public ControladorDetalleFactura(DetalleFactura fac){
        this.vista = fac;
       vista.btnRegisFac.addActionListener(this);
       vista.botAgreProFac.addActionListener(this);
       cc = new CargarCombos();
        cc.CargarNombreEmpleado(vista.cbcEmpleadoFac);
        modelotabla = new DefaultTableModel(null,TitulosTabla);
        this.vista.TablaDetalle.setModel(modelotabla);    
        vista.setTitle("Registro Factura"); 
        vista.setVisible(true);
    }
     void LimpiarEntradas(){
        vista.txtCodProFac.setText("");
        vista.txtNomProFac.setText("");
        vista.txtCantidadFac.setText("");
        vista.txtPrecioFac.setText("");
        vista.txtCodProFac.requestFocus();
    }
     void TotalPagar(){
        totalPagar = 0;
        int numFila = vista.TablaDetalle.getRowCount();
        for ( int i = 0;i<numFila;i++){
         double cal = Double.parseDouble(String.valueOf(vista.TablaDetalle.getModel().getValueAt(i, 4)));
           totalPagar = totalPagar + cal;
        }
        vista.TotalFac.setText(Double.toString(totalPagar));
     }
   void LimpiarTablaDetalle(){
      for(int i = 0 ;i < modelotabla.getRowCount() ; i++){
          modelotabla.removeRow(i);
          i = i-1;
      
      }
   }
     void InsertarCompra(){
      mif = new ManejadorIdForaneos();
      SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
      cruda = new CRUDdetallefactura();
      String dni = vista.txtDNIFac.getText();
      String cod = mif.RecuperarCodEmp(vista.cbcEmpleadoFac.getSelectedItem().toString());
      String fecha = sf.format(vista.jdataFactura.getDate());
      Double Total = Double.parseDouble(vista.TotalFac.getText());
      if(cruda.InsertarRegistroFactura(dni, cod, fecha, Total)){
           for(int i = 0 ;i < vista.TablaDetalle.getRowCount() ; i++){
            int id = mif.RecuperarIdFactura();
            String cod_pro = vista.TablaDetalle.getValueAt(i, 0).toString();
            String des = vista.TablaDetalle.getValueAt(i, 1).toString();
            int cant = Integer.parseInt(vista.TablaDetalle.getValueAt(i, 2).toString());
            double preu = Double.parseDouble(vista.TablaDetalle.getValueAt(i, 3).toString());
            double total = cant*preu;
            cruda.InsertardetalleFactura(cod_pro, des, cant, preu,total, id);
           }
      }
      
     }
    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource() == vista.botAgreProFac){
          RegistroFactura m = new RegistroFactura();
          int cant = Integer.parseInt(vista.txtCantidadFac.getText());
          String cod = vista.txtCodProFac.getText();
          String des = vista.txtNomProFac.getText();
          double pre = Double.parseDouble(vista.txtPrecioFac.getText());
            ArrayList lista = new ArrayList();
            int item = 1;
            lista.add(item);
            lista.add(cod);
            lista.add(des);
            lista.add(cant);
            lista.add(pre);
            lista.add(pre*cant);
            Object[] obj = new Object[5];
            obj[0] = lista.get(1);
            obj[1] = lista.get(2);
            obj[2] = lista.get(3);
            obj[3] = lista.get(4);
            obj[4] = lista.get(5);      
            modelotabla.addRow(obj);
            vista.TablaDetalle.setModel(modelotabla);
            LimpiarEntradas();
            TotalPagar();
           }
           try{
           if(e.getSource() == vista.btnRegisFac){
               InsertarCompra();
               FormatoDetalleFactura.LimpiarEntradas(vista);
               LimpiarTablaDetalle();
           }
            }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede modificar .."+ex);
                   }
       
    }
}