package DAO;
//libreria
import Modelo.Al_Producto;
import Formatos.Mensajes;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
public class CRUDvisualizar extends ConectarBD{
    public CRUDvisualizar(){ }
    //metodo para mostrar datos en la tabla
    public void MostrarStockEnTabla(JTable tabla,String jcbcStockV){
        String[] TitulosTabla={"Num","Codigo Producto","Nombre Producto","Precio","Stock","Categoria","Tamaño"};
        DefaultTableModel modelo =  new DefaultTableModel(null,TitulosTabla);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT a.cod_prod, a.nombre_pro, a.precio, s.tipo_stock,c.nombre_categoria,t.proporcion FROM productos a INNER JOIN stock s ON a.cod_stock=s.cod_stock \n" +
"INNER JOIN categoria c ON a.cod_categoria=c.cod_categoria JOIN tamano t ON a.cod_tamano=t.cod_tamano WHERE s.tipo_stock ='"+jcbcStockV+"';");
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
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de productos.."+ex);
        }       
    }//fin del metodo
      public void MostrarCategoriaEnTabla(JTable tabla,String jcbcCategoriaV){
        String[] TitulosTabla={"Num","Codigo Producto","Nombre Producto","Precio","Stock","Categoria","Tamaño"};
        DefaultTableModel modelo =  new DefaultTableModel(null,TitulosTabla);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT a.cod_prod, a.nombre_pro, a.precio, s.tipo_stock,c.nombre_categoria,t.proporcion FROM productos a INNER JOIN stock s ON a.cod_stock=s.cod_stock \n" +
"INNER JOIN categoria c ON a.cod_categoria=c.cod_categoria JOIN tamano t ON a.cod_tamano=t.cod_tamano WHERE c.nombre_categoria ='"+jcbcCategoriaV+"';");
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
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de productos.."+ex);
        }       
    }
        public void MostrarTamanoEnTabla(JTable tabla,String jFiltroTamano){
        String[] TitulosTabla={"Num","Codigo Producto","Nombre Producto","Precio","Stock","Categoria","Tamaño"};
        DefaultTableModel modelo =  new DefaultTableModel(null,TitulosTabla);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT a.cod_prod, a.nombre_pro, a.precio, s.tipo_stock,c.nombre_categoria,t.proporcion FROM productos a INNER JOIN stock s ON a.cod_stock=s.cod_stock \n" +
"INNER JOIN categoria c ON a.cod_categoria=c.cod_categoria JOIN tamano t ON a.cod_tamano=t.cod_tamano WHERE t.proporcion ='"+jFiltroTamano+"';");
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
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de productos.."+ex);
        }       
    }
             public void MostrarProductoEnTabla(JTable tabla,String jFiltroproducto){
        String[] TitulosTabla={"Num","Codigo Producto","Nombre Producto","Precio","Stock","Categoria","Tamaño"};
        DefaultTableModel modelo =  new DefaultTableModel(null,TitulosTabla);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT a.cod_prod, a.nombre_pro, a.precio, s.tipo_stock,c.nombre_categoria,t.proporcion FROM productos a INNER JOIN stock s ON a.cod_stock=s.cod_stock \n" +
"INNER JOIN categoria c ON a.cod_categoria=c.cod_categoria JOIN tamano t ON a.cod_tamano=t.cod_tamano WHERE a.nombre_pro like '%"+jFiltroproducto+"%'");
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
            rs.close();            
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de productos.."+ex);
        }       
    }

}
