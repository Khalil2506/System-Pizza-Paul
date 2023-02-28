package DAO;
//libreria
import Formatos.*;
import Modelo.ReporteDiario;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import Formatos.ManejadorTablas;
import Modelo.Empleado1;
import java.sql.SQLException;
import java.util.Date;
public class CRUDreporteSemanal extends ConectarBD {
    public CRUDreporteSemanal(){ }
    //metodo para mostrar datos en la tabla
    public void MostrarReporteEnTabla(JTable tabla,JLabel etiqueta){
        String titulos[]={"num","NºReporte","Codigo empleado","Pizza Vendidas","Pastas Vendidas","Bebidas Vendidas","Piqueos Vendidas","Platos Criollos Vendidos","Fecha","Dinero Inicial","Dinero Final","Dinero Sobrante"};
        DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT N_reporte,cod_emp, pizzavendidas, pastasvendidas, bebidasvendidas, piqueosvendidas, platosCvendidos, fecha, dineroInicial, dineroFinal, dineroSobrante FROM ReporteDiario;");
            int contreg=0;
while(rs.next()){
                contreg++;
                 ReporteDiario red = new ReporteDiario();
                red.setNfactura(rs.getInt(1));
                red.setCod_emp(rs.getString(2));
                red.setPizzav(rs.getInt(3));
                red.setPastav(rs.getInt(4));
                 red.setBebidav(rs.getInt(5));
                  red.setPiqueosv(rs.getInt(6));
                   red.setPlatoscv(rs.getInt(7));
                red.setFecha(rs.getString(8));
                red.setDinero_i(rs.getDouble(9));
               red.setTotal_D(rs.getDouble(10));
                modelo.addRow(red.RegistroDatos(contreg)); 
            }//fin while     
           etiqueta.setText("Cantidad de Reporte Diario : "+contreg);
         rs.close();                 
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los Reporte Diario.."+ex);
        }       
    }//meotod para filtrar por fecha
   public void MostrarNreporteEnTabla(JTable tabla,String nrp){
        String titulos[]={"num","NºReporte","Codigo empleado","Pizza Vendidas","Pastas Vendidas","Bebidas Vendidas","Piqueos Vendidas","Platos Criollos Vendidos","Fecha","Dinero Inicial","Dinero Final","Dinero Sobrante"};
        DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT N_reporte,cod_emp, pizzavendidas, pastasvendidas, bebidasvendidas, piqueosvendidas, platosCvendidos, fecha, dineroInicial, dineroFinal, dineroSobrante FROM ReporteDiario WHERE N_reporte LIKE '%"+nrp+"%';");
            int contreg=0;
while(rs.next()){
                contreg++;
                 ReporteDiario red = new ReporteDiario();
                red.setNfactura(rs.getInt(1));
                red.setCod_emp(rs.getString(2));
                red.setPizzav(rs.getInt(3));
                red.setPastav(rs.getInt(4));
                 red.setBebidav(rs.getInt(5));
                  red.setPiqueosv(rs.getInt(6));
                   red.setPlatoscv(rs.getInt(7));
                red.setFecha(rs.getString(8));
                red.setDinero_i(rs.getDouble(9));
               red.setTotal_D(rs.getDouble(10));
                modelo.addRow(red.RegistroDatos(contreg)); 
            }//fin while
           rs.close();  
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los Reporte Diario.."+ex);
        }       
    }//fin del metodo
   public void MostrarfechaEnTabla(JTable tabla,String nrp){
        String titulos[]={"num","NºReporte","Codigo empleado","Pizza Vendidas","Pastas Vendidas","Bebidas Vendidas","Piqueos Vendidas","Platos Criollos Vendidos","Fecha","Dinero Inicial","Dinero Final","Dinero Sobrante"};
        DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT N_reporte,cod_emp, pizzavendidas, pastasvendidas, bebidasvendidas, piqueosvendidas, platosCvendidos, fecha, dineroInicial, dineroFinal, dineroSobrante FROM ReporteDiario WHERE fecha LIKE '%"+nrp+"%';");
            int contreg=0;
while(rs.next()){
                contreg++;
                 ReporteDiario red = new ReporteDiario();
                red.setNfactura(rs.getInt(1));
                red.setCod_emp(rs.getString(2));
                red.setPizzav(rs.getInt(3));
                red.setPastav(rs.getInt(4));
                 red.setBebidav(rs.getInt(5));
                  red.setPiqueosv(rs.getInt(6));
                   red.setPlatoscv(rs.getInt(7));
                red.setFecha(rs.getString(8));
                red.setDinero_i(rs.getDouble(9));
               red.setTotal_D(rs.getDouble(10));
                modelo.addRow(red.RegistroDatos(contreg)); 
            }//fin while
           rs.close();  
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los Reporte Diario.."+ex);
        }       
    }//fin del metodo
}

      