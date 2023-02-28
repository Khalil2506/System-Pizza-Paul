package DAO;
//librerias
import javax.swing.JComboBox;
import Formatos.*;
import java.sql.*;
public class CargarCombos extends ConectarBD{
    public CargarCombos(){}
    //metodo que carga los nombres de las categorias en un combo
    public void CargarCategoriasEnCombo(JComboBox combo){
        try{
            rs =  st.executeQuery("SELECT nombre_categoria FROM categoria  ORDER BY 1;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no puede cargar categorias en el combo..."+ex);
        }
    }
      public void CargarcodCategoriaEnCombo(JComboBox combo){
        try{
            rs =  st.executeQuery("SELECT cod_categoria FROM categoria  ORDER BY 1;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no puede cargar categorias en el combo..."+ex);
        }
    }
//metodo que carga los nombres de la compañia de los proveedores en un combo
    public void CargarstockEnCombo(JComboBox combo){
        try{
            rs =  st.executeQuery("SELECT tipo_stock FROM stock  ORDER BY 1;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no puede cargar proveedores en el combo..."+ex);
        }
    }
    //metodo que carga los nombres de la compañia de los proveedores en un combo
    public void CargaridtsockEnCombo(JComboBox combo){
        try{
            rs =  st.executeQuery("SELECT cod_stock FROM stock  ORDER BY 1;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no puede cargar proveedores en el combo..."+ex);
        }
    }
//metodo que carga los nombres de la compañia de los proveedores en un combo
    public void CargartamanoEnCombo(JComboBox combo){
        try{
            rs =  st.executeQuery("SELECT proporcion FROM tamano  ORDER BY 1;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no puede cargar proveedores en el combo..."+ex);
        }
    }
    //metodo que carga los nombres de la compañia de los proveedores en un combo
    public void CargarcodtamanoEnCombo(JComboBox combo){
        try{
            rs =  st.executeQuery("SELECT cod_tamano FROM tamano  ORDER BY 1;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no puede cargar proveedores en el combo..."+ex);
        }
    }
public void CargarUsuarioCombo (JComboBox combo){
    try{
            rs =  st.executeQuery("SELECT tipoUsuar FROM tipousuario ORDER BY 1;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no puede cargar los tipos de usuario..."+ex);
        }
}
public void CargarNombreEmpleado (JComboBox combo){
    try{
            rs =  st.executeQuery("SELECT apellido FROM empleado ORDER BY 1;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no puede cargar los tipos de usuario..."+ex);
        }
}
public void CargarProducto (JComboBox combo){
    try{
            rs =  st.executeQuery("SELECT apellido FROM empleado ORDER BY 1;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no puede cargar los tipos de usuario..."+ex);
        }
}
}