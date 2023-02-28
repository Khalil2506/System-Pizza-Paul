
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Empleado;
import vista.MenuPrincipal;
import Modelo.*;

import DAO.*;
import Formatos.*;
public class ControladorEmpleado implements ActionListener{
    //atributos
        Empleado vista;
        MenuPrincipal menu;
        Empleado1 emp;
      CRUDempleado crud;
      FormatoEmpleado fm;
     //constructor
    public ControladorEmpleado(Empleado em){
        this.vista = em;
        vista.jbtnAgregarE.addActionListener(this);
        vista.jbtnConsultarE.addActionListener(this);
        vista.jbtnModificarE.addActionListener(this);
        vista.jbtnEliminarE1.addActionListener(this);
        vista.setVisible(true);
        crud = new CRUDempleado();
        crud.MostrarEmpleadoEnTabla(vista.jtblListaEmpleado,vista.jlbListaEmpleado);
        vista.setTitle("Empleado"); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource() == vista.jbtnAgregarE){
            emp = FormatoEmpleado.LeerProducto(vista);
              crud = new CRUDempleado(); 
              crud.InsertarRegistroEmpleado(emp);
             crud.MostrarEmpleadoEnTabla(vista.jtblListaEmpleado,vista.jlbListaEmpleado);
              FormatoEmpleado.LimpiarEntradas(vista);

            }
           try{
            if(e.getSource() == vista.jbtnModificarE){
            emp = FormatoEmpleado.LeerProducto(vista);
              crud = new CRUDempleado(); 
              crud.ActualizarEmpleado(emp);
             crud.MostrarEmpleadoEnTabla(vista.jtblListaEmpleado,vista.jlbListaEmpleado);
              FormatoEmpleado.LimpiarEntradas(vista);

            }
            }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede modificar .."+ex);
                   }
           try{
           if(e.getSource() == vista.jbtnEliminarE1){
             int respuesta = Mensajes.M3("Confirmar!!!","¿Deseas eliminar al empleado?");
             if(respuesta==0){
                 emp = FormatoEmpleado.LeerProducto(vista);
                  crud = new CRUDempleado(); 
              crud.EliminarEmpleado(emp);
             crud.MostrarEmpleadoEnTabla(vista.jtblListaEmpleado,vista.jlbListaEmpleado);
              FormatoEmpleado.LimpiarEntradas(vista);
             }
         }}catch (Exception ex){
                   Mensajes.M1("ERROR no se puede eliminar .."+ex);
                   }
              if(e.getSource() == vista.jbtnConsultarE){
               String cod_emp = Mensajes.M2("Ingrese el codigo del empleado a buscar ");
             crud = new CRUDempleado();
             emp = crud.ObtenerRegistroEmp(cod_emp);
             if(emp==null){
                 Mensajes.M1("El ID "+emp+" no existe en la tabla Empleado..");
             }else{
                 vista.jtxtCodigoE.setText(emp.getCod_emp());
                 vista.jtxtNombreE.setText(emp.getNombre());
                 vista.jtxtApellidoE.setText(emp.getApellido());
                 vista.jtxtDireccionE.setText(emp.getDireccion());
                 vista.jtxtTelefonoE.setText(emp.getTelefono());
                 vista.jtxtEdadE.setText(Integer.toString(emp.getEdad()));
                 vista.jtxtSueldoE.setText(Double.toString(emp.getSueldo()));
                 vista.jspnDiasTrabajoE.setValue(Integer.toString((emp.getDias_Trabajo()))); 
             }
         }
    
}  
}
