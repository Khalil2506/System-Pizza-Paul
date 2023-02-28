package controlador;
//libreria
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import vista.REGISTRAR_USUARIO;
import vista.Login;
import Modelo.*;
import DAO.*;
import Formatos.FormatoRegistrar;
public class ControladorRegistrar implements ActionListener {
    //atributos
    REGISTRAR_USUARIO vista;
    CRUDregistro crud;
    RegistroUsuario regis;
    Login lo;
    //constructor
    public ControladorRegistrar(REGISTRAR_USUARIO re){
        vista=re;
        vista.jbtnRegistrarR.addActionListener(this);
        vista.jbtnCancelar.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()== vista.jbtnRegistrarR){
              regis = FormatoRegistrar.LeerProducto(vista);
              crud = new CRUDregistro(); 
              crud.InsertarRegistroProd(regis);
              FormatoRegistrar.LimpiarEntradas(vista);              
          }
          if(e.getSource()== vista.jbtnCancelar){
              Login log = new Login();
            ControladorLogin controlLo = new ControladorLogin(log);
            log.setVisible(true);
            this.vista.dispose();            
          }
    } 
}