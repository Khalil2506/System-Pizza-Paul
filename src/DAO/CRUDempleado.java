package DAO;
//libreria
import Formatos.Mensajes;
import Modelo.Empleado1;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
public class CRUDempleado extends ConectarBD {
    //constructor
    public CRUDempleado(){ }
    //metodo
    public void MostrarEmpleadoEnTabla(JTable tabla,JLabel etiqueta){
        String titulos[]={"num","codigo empleado","Nombre","Apellido","Direccion","Telefono","Sueldo","Edad","Dias Trabajados"};
        DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        try{
            rs = st.executeQuery("SELECT cod_emp, nombre, apellido, direccion, telefono, sueldo, edad, dias_trabajado,indicador FROM empleado WHERE indicador='S'");
            int contreg=0;
while(rs.next()){
                contreg++;
                Empleado1 em = new Empleado1();
                em.setCod_emp(rs.getString(1));
                em.setNombre(rs.getString(2));
                em.setApellido(rs.getString(3));
                em.setDireccion(rs.getString(4));
                em.setTelefono(rs.getString(5));
                em.setSueldo(rs.getDouble(6));
                em.setEdad(rs.getInt(7));
                em.setDias_Trabajo(rs.getInt(8));
                em.setIndicador(rs.getString(9));
                modelo.addRow(em.RegistroDato(contreg));            
            }//fin while       
           etiqueta.setText("Cantidad de Empleados : "+contreg);
           rs.close();                      
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede mostrar los registros de empleado.."+ex);
        }       
    }//fin del metodo    
    // metodo para insertar datos
    public void InsertarRegistroEmpleado(Empleado1 emp){
        try{       
         ps = conexion.prepareStatement("INSERT INTO empleado(cod_emp, nombre, apellido, direccion, telefono, sueldo, edad, dias_trabajado, indicador) VALUES (?,?,?,?,?,?,?,?,'S');");
         //actualizando los parametros
         ps.setString(1,emp.getCod_emp()); 
         ps.setString(2,emp.getNombre());
         ps.setString(3,emp.getApellido());
         ps.setString(4,emp.getDireccion());
         ps.setString(5,emp.getTelefono());
         ps.setDouble(6,emp.getSueldo());
         ps.setInt(7,emp.getEdad());
         ps.setInt(8,emp.getDias_Trabajo());
         ps.executeUpdate(); 
         ps.close();
         Mensajes.M1("Registro Insertado");        
        }catch(SQLException ex){
            Mensajes.M1("ERROR no se puede insertar la categoria .."+ex);
        }  
    }
    //metodo para obtener el resgistro
    public Empleado1 ObtenerRegistroEmp(String codemp){
        Empleado1 codem=null;
        try{
            rs =  st.executeQuery("SELECT cod_emp, nombre, apellido, direccion, telefono, sueldo, edad, dias_trabajado,indicador FROM empleado where cod_emp ='"+codemp+"'");
            if(rs.next()){
                codem = new Empleado1();
                codem.setCod_emp(rs.getString(1));
                codem.setNombre(rs.getString(2));
                codem.setApellido(rs.getString(3));
                codem.setDireccion(rs.getString(4));
                codem.setTelefono(rs.getString(5));
                codem.setSueldo(rs.getDouble(6));
                codem.setEdad(rs.getInt(7));
                codem.setDias_Trabajo(rs.getInt(8));
                codem.setIndicador(rs.getString(9));
            }            
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede recuperar el registro de empleados.."+ex);
        }
        return codem;              
    }//fin metodo
    //metodo que reciber un empleado y actualiza al empleado
    public void ActualizarEmpleado(Empleado1 emp){
        try{
            ps = conexion.prepareStatement("UPDATE empleado SET nombre=? ,apellido=?,direccion=?,telefono=?,sueldo=?,edad=?,dias_trabajado=? WHERE cod_emp=?;");
            ps.setString(1,emp.getNombre());
         ps.setString(2,emp.getApellido());
         ps.setString(3,emp.getDireccion());
         ps.setString(4,emp.getTelefono());
         ps.setDouble(5,emp.getSueldo());
         ps.setInt(6,emp.getEdad());
         ps.setInt(7,emp.getDias_Trabajo());
          ps.setString(8,emp.getCod_emp()); 
            ps.executeUpdate();
            Mensajes.M1("Registro Actualizado");
            ps.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede actualizar el registro del empleado.."+ex);
        }
    }
    //metodo eliminar datos
    public void EliminarEmpleado(Empleado1 emp){
        try{
            ps = conexion.prepareStatement("DELETE from empleado WHERE cod_emp=?;");
            ps.setString(1,emp.getCod_emp());
            ps.executeUpdate();
            Mensajes.M1("Registro elimado de la tabla Empleado");
            ps.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede elimnar el Empleado.."+ex);
        }
    }   
}