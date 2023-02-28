
package controlador;
//librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import vista.Login;
import Modelo.RegistroUsuario;
import DAO.*;
import Formatos.*;
public class ControladorLogin implements ActionListener{
    //atributos
    Login vista;
    REGISTRAR_USUARIO re;
    CRUDlogin crud;
    RegistroUsuario regis;
    FormatoLogin forlo;
    MenuPrincipal menu = new MenuPrincipal();
    CargarCombos cc;
    //constructor
    public ControladorLogin(Login lo){
        vista=lo;
        vista.jbtnIniciar.addActionListener(this);
        vista.jbtnRegistrar.addActionListener(this); 
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Ingrese Usuario");
        cc = new CargarCombos();
        cc.CargarUsuarioCombo(vista.jcbcTipoUsuario); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.jbtnIniciar){
            RegistroUsuario log = new RegistroUsuario();
            CRUDlogin crud = new CRUDlogin();
            String usu = vista.jtxtUsuario.getText();
           String contra = vista.jtxtContraseña.getText();
           ManejadorIdForaneos id =  new ManejadorIdForaneos();
           int codtipo = id.RecuperarTipoU(vista.jcbcTipoUsuario.getSelectedItem().toString());
           crud.IngresarSistema(usu, contra,codtipo);
              FormatoLogin.LimpiarEntradas(vista); 
              vista.setVisible(false);
        }
        if(e.getSource() == vista.jbtnRegistrar){
            REGISTRAR_USUARIO ventana = new REGISTRAR_USUARIO();
            ControladorRegistrar controlre = new ControladorRegistrar(ventana);
            ventana.setVisible(true);
            this.vista.dispose();
        }   
    }
}
 

 