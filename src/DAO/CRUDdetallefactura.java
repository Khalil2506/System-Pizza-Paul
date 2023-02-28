package DAO;
import Formatos.*;
import Modelo.Factura;
import Modelo.RegistroFactura;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.Date;
public class CRUDdetallefactura extends ConectarBD {
    int r;
    //constructor
    public CRUDdetallefactura(){ }
     //metodo para insertar datos
    public boolean InsertarRegistroFactura(String dni, String cod_em,String fecha,double total){
        try{
         ps = conexion.prepareStatement("INSERT INTO facturas(dni_cliente, cod_emp, fecha, Total) VALUES (?,?,?,?)");
         //actualizando los parametros
         ps.setString(1,dni);
         ps.setString(2,cod_em);
         ps.setString(3,fecha);
         ps.setDouble(4,total);
         ps.executeUpdate(); 
         ps.close();
         Mensajes.M1("Registro Insertado");
         return true;
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede insertar la Factura .."+ex);
            return false;
        }  
        
    }
     public boolean InsertardetalleFactura(String pro,String des,int cant, double preu,double total,int cof_fa){
        try{
         ps = conexion.prepareStatement("INSERT INTO detallefactura(cod_prod, descripcion, cantidad, PrecioUni, PrecioTotal, cod_factura) VALUES (?,?,?,?,?,?)");
         //actualizando los parametros
         ps.setString(1,pro);
         ps.setString(2,des);
         ps.setInt(3,cant);
         ps.setDouble(4,preu);
         ps.setDouble(5,total);
         ps.setInt(6,cof_fa);
         ps.executeUpdate(); 
         ps.close();
         return true;
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede insertar la Factura .."+ex);
            return false;
        }
    }
      public void MostrarCodDetalleFactura(JTable tabla,String cod_factura){
        String titulos[]={"num","codigo detalle","Codigo producto","Descripcion","Cantidad","Precio Unitario","Precio Total","Codigo Factura"};
        DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT * FROM detallefactura WHERE cod_factura like '%"+cod_factura+"%'");
            int contreg=0;
while(rs.next()){
                contreg++;
               RegistroFactura fa = new RegistroFactura();
                fa.setCod_detalle(rs.getInt(1));
                fa.setCod_pro(rs.getString(2));
                fa.setDescripcion(rs.getString(3));
                fa.setCantidad(rs.getInt(4));
                fa.setPrecioUni(rs.getDouble(5));
                fa.PrecTotal();
                fa.setCod_factura(rs.getInt(7));
                    
                modelo.addRow(fa.RegistroDatosDetalle(contreg));
            }//fin while
           rs.close();  
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de Factura.."+ex);
        }       
    }
}
