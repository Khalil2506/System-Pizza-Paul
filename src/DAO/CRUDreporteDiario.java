package DAO;
//libreria
import Formatos.*;
import Modelo.ReporteDiario;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.Date;
public class CRUDreporteDiario extends ConectarBD {
    public CRUDreporteDiario(){ }
    //metodo para insertar datos en la tabla
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
           conexion.close();  
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los Reporte Diario.."+ex);
        }       
    }//fin del metodo
       //metodo para insertar datos en la base de datos
    public void InsertarRegistroReporteDiario(ReporteDiario rep){
        try{ 
         ps = conexion.prepareStatement("INSERT INTO ReporteDiario(cod_emp, pizzavendidas, pastasvendidas, bebidasvendidas, piqueosvendidas, platosCvendidos, fecha, dineroInicial, dineroFinal, dineroSobrante) VALUES (?,?,?,?,?,?,?,?,?,?)");
         //actualizando los parametros
         ps.setString(1,rep.getCod_emp()); 
         ps.setInt(2,rep.getPizzav());
         ps.setInt(3,rep.getPastav());
         ps.setInt(4,rep.getBebidav());
         ps.setInt(5,rep.getPiqueosv());
         ps.setInt(6,rep.getPlatoscv());
         ps.setString(7,rep.getFecha());
         ps.setDouble(8,rep.getDinero_i());
         ps.setDouble(9,rep.getTotal_D());
         ps.setDouble(10,rep.Sobrante() );
         ps.executeUpdate(); 
         ps.close();
         Mensajes.M1("Registro Insertado");
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede insertar el Reporte Diario .."+ex);
        }  
    }
    //metodo para obtener el registro mediante el Numero de repote
 public ReporteDiario ObtenerRegistroReporte(String codrept){
        ReporteDiario codrd=null;
        try{
            rs =  st.executeQuery("SELECT N_reporte,cod_emp, pizzavendidas, pastasvendidas, bebidasvendidas, piqueosvendidas, platosCvendidos, fecha, dineroInicial, dineroFinal, dineroSobrante FROM ReporteDiario where N_reporte ='"+codrept+"'");
            if(rs.next()){
              codrd= new ReporteDiario();
                codrd.setNfactura(rs.getInt(1));
                codrd.setCod_emp(rs.getString(2));
                codrd.setPizzav(rs.getInt(3));
                codrd.setPastav(rs.getInt(4));
                 codrd.setBebidav(rs.getInt(5));
                  codrd.setPiqueosv(rs.getInt(6));
                   codrd.setPlatoscv(rs.getInt(7));
                   
                codrd.setFecha(rs.getString(8));
                codrd.setDinero_i(rs.getDouble(9));
               codrd.setTotal_D(rs.getDouble(10));
            }            
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede recuperar el registro de reporte.."+ex);
        }
        return codrd;              
    }//fin metodo
    //metodo que recibe una reporte y lo actualiza
    public void ActualizarReporte(ReporteDiario nrd){
        try{
            ps = conexion.prepareStatement("UPDATE ReporteDiario SET cod_emp=? ,pizzavendidas=?, pastasvendidas=?, bebidasvendidas=?, piqueosvendidas=?, platosCvendidos=?,fecha=?,dineroInicial=?, dineroFinal=? WHERE N_reporte=?;");
            ps.setString(1,nrd.getCod_emp());
         ps.setInt(2,nrd.getPizzav());
         ps.setInt(3,nrd.getPastav());
         ps.setInt(4,nrd.getBebidav());
         ps.setInt(5,nrd.getPiqueosv());
         ps.setInt(6,nrd.getPlatoscv());
         ps.setString(7,nrd.getFecha());
         ps.setDouble(8,nrd.getDinero_i());
         ps.setDouble(9,nrd.getTotal_D());
          ps.setInt(10,nrd.getNfactura()); 
            ps.executeUpdate();
            Mensajes.M1("Registro Actualizado");
            ps.close();
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede actualizar el registro del reporte.."+ex);
        }
    }
    //metodo elimina un reporte
    public void EliminarReporte(int nrp){
        try{
            ps = conexion.prepareStatement("DELETE from ReporteDiario WHERE N_reporte=?;");
            ps.setInt(1,nrp);
            ps.executeUpdate();
            Mensajes.M1("Registro elimado del Reporte");
            ps.close();
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede elimnar el n de reporte.."+ex);
        }
    }
}
