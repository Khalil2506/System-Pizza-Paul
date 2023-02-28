package DAO;
//libreria
import Modelo.Al_Producto;
import Formatos.Mensajes;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import Formatos.ManejadorTablas;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
public class CRUDproductos extends ConectarBD{
    public CRUDproductos(){ }
    //metodo para mostrar datos en la tabla
    public void MostrarProductoEnTabla(JTable tabla,JLabel etiqueta){
        String[] TitulosTabla={"Num","Codigo Producto","Nombre Producto","Precio","Stock","Categoria","Tamaño"};
        DefaultTableModel modelo =  new DefaultTableModel(null,TitulosTabla);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT a.cod_prod, a.nombre_pro, a.precio, s.tipo_stock,c.nombre_categoria,t.proporcion FROM productos a INNER JOIN stock s ON a.cod_stock=s.cod_stock \n" +
"INNER JOIN categoria c ON a.cod_categoria=c.cod_categoria JOIN tamano t ON a.cod_tamano=t.cod_tamano");
            int contreg=0;
       while(rs.next()){
                contreg++;
                Al_Producto prod = new Al_Producto();
                prod.setCod_Producto(rs.getString(1));
                prod.setNombre_P(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setStock(rs.getString(4));
                prod.setCategoria(rs.getString(5));
                prod.setTamano(rs.getString(6));
                modelo.addRow(prod.RegistroDatos(contreg));
            }//fin while
            etiqueta.setText("Cantidad de Productos : "+contreg);
            conexion.close();            
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de productos.."+ex);
        }       
    }//fin del metodo
//metodo que inserta en registro a la tabla productos
public void InsertarRegistroProd(Al_Producto pro){
    try{
       ps = conexion.prepareStatement("INSERT INTO productos(cod_prod, nombre_pro, precio, cod_stock, cod_categoria,cod_tamano) VALUES (?,?,?,?,?,?);");
      ps.setString(1,pro.getCod_Producto());
      ps.setString(2,pro.getNombre_P());
      ps.setDouble(3,pro.getPrecio());
      ps.setString(4,pro.getStock());
      ps.setString(5,pro.getCategoria());
      ps.setString(6,pro.getTamano());
      ps.executeUpdate();
      ps.close();
      Mensajes.M1(" registrado correctamente!!!");
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede resgistrar.."+ex);
    }    
}    
  //metodo para obtener datos mediente el codigo del producto  
 public Al_Producto ObtenerRegistroProducto(String codpro){
        Al_Producto codpo=null;
        try{
            rs =  st.executeQuery("SELECT cod_prod, nombre_pro, precio, cod_stock, cod_categoria,cod_tamano FROM productos where cod_prod='"+codpro+"'");
            if(rs.next()){
                codpo = new Al_Producto();
               codpo.setCod_Producto(rs.getString(1));
                codpo.setNombre_P(rs.getString(2));
                codpo.setPrecio(rs.getDouble(3));
                codpo.setStock(rs.getString(4));
                codpo.setCategoria(rs.getString(5));
                codpo.setTamano(rs.getString(6));
            }            
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede recuperar el registro de la factura.."+ex);
        }
        return codpo;              
    }//fin metodo
    //metodo para actualizar productos
    public void ActualizarProducto(Al_Producto pro){
        try{
            ps = conexion.prepareStatement("UPDATE productos SET nombre_pro=?,precio=?,cod_stock=?,cod_categoria=?,cod_tamano=? WHERE cod_prod=?;");
            ps.setString(1,pro.getNombre_P());
         ps.setDouble(2,pro.getPrecio());
         ps.setString(3,pro.getStock());
         ps.setString(4,pro.getCategoria());
         ps.setString(5,pro.getTamano());
          ps.setString(6,pro.getCod_Producto()); 
            ps.executeUpdate();
            Mensajes.M1("Registro Actualizado");
            ps.close();
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede actualizar el registro del producto.."+ex);
        }
    }
    //metodo eliminar datos de la tabla productos
    public void EliminarFactura(Al_Producto pro){
        try{
            ps = conexion.prepareStatement("DELETE from productos WHERE cod_prod=?;");
            ps.setString(1,pro.getCod_Producto());
            ps.executeUpdate();
            Mensajes.M1("Registro elimado de la tabla Producto");
            ps.close();
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede elimnar el Producto.."+ex);
        }
    }
    //metodo para filtrar la categoria en tabla
    public void MostrarcategoriaEnTabla(JTable tabla,String codpro){
        String[] TitulosTabla={"Num","Codigo Producto","Nombre Producto","Precio","Stock","Categoria","Tamaño"};
        DefaultTableModel modelo =  new DefaultTableModel(null,TitulosTabla);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT cod_prod, nombre_pro, precio, cod_stock, cod_categoria,cod_tamano FROM productos WHERE cod_categoria ='"+codpro+"';");
            int contreg=0;
       while(rs.next()){
                contreg++;
                Al_Producto prod = new Al_Producto();
                prod.setCod_Producto(rs.getString(1));
                prod.setNombre_P(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setStock(rs.getString(4));
                prod.setCategoria(rs.getString(5));
                prod.setTamano(rs.getString(6));
                modelo.addRow(prod.RegistroDatos(contreg));
            }//fin while
            conexion.close();            
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de productos.."+ex);
        }       
    }
     //metodo para busccar producto
    public Al_Producto BuscarProducto(String pro){
         Al_Producto prod = new Al_Producto();
        try{
            ps = conexion.prepareStatement("SELECT cod_prod, nombre_pro, precio FROM productos where cod_prod = ? ");
            ps.setString(1, pro);
            rs = ps.executeQuery();
            if(rs.next()){
                prod.setNombre_P(rs.getString("nombre_pro"));
                prod.setPrecio(rs.getDouble("precio"));
                 
            }
           
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede buscar producto.."+ex);
        }
        return prod;
    }
}
