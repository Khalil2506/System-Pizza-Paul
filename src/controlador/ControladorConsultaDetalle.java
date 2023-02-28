
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
public class ControladorConsultaDetalle implements ActionListener{
    //atributos
        ConsultaDetalle vista;
        RegistroFactura fact;
        CRUDdetallefactura cruda;
        DefaultTableModel modelotabla;
        double totalPagar;
    String[] TitulosTabla={"codigo Producto","Descripcion","Cantidad","Precio Unitario","Precio Total"};
     //constructor
    public ControladorConsultaDetalle(ConsultaDetalle fac){
        this.vista = fac;
       vista.jConsultaFactura.addActionListener(this); 
        vista.setTitle("Detalle Factura"); 
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
