package DAO;
//libreria
import Formatos.*;
import Modelo.Factura;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
public class CRUDfacturas extends ConectarBD {
    //constructor
    public CRUDfacturas(){ }
    //metodo para oteber datos en la tabla
    public void MostrarFacturasEnTabla(JTable tabla,JLabel etiqueta){
        String titulos[]={"num","codigo Factura","DNI Cliente","Codigo empleado","Fecha","Total"};
        DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT cod_factura, dni_cliente, cod_emp,fecha,total FROM facturas;");
            int contreg=0;
while(rs.next()){
                contreg++;
                Factura fa = new Factura();
                fa.setCod_factura(rs.getInt(1));
                fa.setDNI_Cliente(rs.getString(2));
                fa.setCod_emp(rs.getString(3));
                fa.setFecha(rs.getString(4));
                fa.setTotal(rs.getDouble(5));               
                modelo.addRow(fa.RegistroDatos(contreg));
            }//fin while
           etiqueta.setText("Cantidad de Facturas : "+contreg);
           conexion.close();  
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de empleado.."+ex);
        }       
    }//fin del metodo
    //metodo para insertar datos
//    public void InsertarRegistroFactura(Factura fac){
//        try{
//         ps = conexion.prepareStatement("INSERT INTO facturas(dni_cliente, cod_emp, fecha, Total) VALUES (?,?,?,?)");
//         //actualizando los parametros
//         ps.setString(1,fac.getDNI_Cliente());
//         ps.setString(2,fac.getCod_emp());
//         ps.setString(3,fac.getFecha());
//         ps.setDouble(4,fac.getTotal());
//         ps.executeUpdate(); 
//         ps.close();
//        }catch(SQLException ex){
//            Mensajes.M1("ERROR no se puede insertar la Factura .."+ex);
//        }  
//    }
    //metodo para obtener el resgistro mediante el codigo de factura
 public Factura ObtenerRegistroFactura(String codfac){
        Factura codfa=null;
        try{
            rs =  st.executeQuery("SELECT cod_factura, dni_cliente, cod_emp,fecha,total FROM facturas where cod_factura ='"+codfac+"'");
            if(rs.next()){
                codfa = new Factura();
                codfa.setCod_factura(rs.getInt(1));
                 codfa.setDNI_Cliente(rs.getString(2));
                codfa.setCod_emp(rs.getString(3));
                codfa.setFecha(rs.getString(4));
                codfa.setTotal(rs.getDouble(5));
            }            
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede recuperar el registro de la factura.."+ex);
        }
        return codfa;              
    }//fin metodo
    //metodo para actualizar datos
    public void ActualizarFactura(Factura fac){
        try{
            ps = conexion.prepareStatement("UPDATE facturas SET dni_cliente=? ,cod_emp=?,fecha=?,total=? WHERE cod_factura=?;");
            ps.setString(1,fac.getDNI_Cliente());
         ps.setString(2,fac.getCod_emp());
         ps.setString(3,fac.getFecha());
         ps.setDouble(4,fac.getTotal());
          ps.setInt(5,fac.getCod_factura()); 
            ps.executeUpdate();
            Mensajes.M1("Registro Actualizado");
            ps.close();
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede actualizar el registro del empleado.."+ex);
        }
    }
    
    //metodo para eliminar datos
    public void EliminarFactura(Factura fac){
        try{
            ps = conexion.prepareStatement("DELETE from facturas WHERE cod_factura=?;");
            ps.setInt(1,fac.getCod_factura());
            ps.executeUpdate();
            Mensajes.M1("Registro elimado de la tabla factura");
            ps.close();
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede elimnar el Empleado.."+ex);
        }
    }
     public void EliminarDetalleFactura(Factura fac){
        try{
            ps = conexion.prepareStatement("DELETE from detallefactura WHERE cod_factura=?;");
            ps.setInt(1,fac.getCod_factura());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede elimnar el Empleado.."+ex);
        }
    }
     public void MostrarCodFactura(JTable tabla,String cod_factura){
        String titulos[]={"num","codigo Factura","DNI Cliente","Codigo empleado","Fecha","Total"};
        DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT cod_factura, dni_cliente, cod_emp,fecha,total FROM facturas WHERE cod_factura like '%"+cod_factura+"%'");
            int contreg=0;
while(rs.next()){
                contreg++;
                Factura fa = new Factura();
                fa.setCod_factura(rs.getInt(1));
                fa.setDNI_Cliente(rs.getString(2));
                fa.setCod_emp(rs.getString(3));
                fa.setFecha(rs.getString(4));
                fa.setTotal(rs.getDouble(5));               
                modelo.addRow(fa.RegistroDatos(contreg));
            }//fin while
           rs.close();  
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de Factura.."+ex);
        }       
    }
}
