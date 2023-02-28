package controlador;
//librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ComponentListener;
import Formatos.*;
import javax.swing.JFrame;
public class ControladorMenuEmpleado implements ActionListener {
    //atributos
   MenuEmpleado menu;
    Empleado emple;
    Productos pro;
    ControladorLogin lo;
    //constructor
    public ControladorMenuEmpleado(MenuEmpleado emp){
        menu = emp;
        this.menu.buttonFacturasE.addActionListener(this);
        this.menu.buttonReporteDiarioE.addActionListener(this);
        this.menu.VisualizarE.addActionListener(this);
        this.menu.jSalirE.addActionListener(this);
        this.menu.meRegistrarFactura.addActionListener(this);
         this.menu.DetalleFactura.addActionListener(this);
        emp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        emp.setDefaultCloseOperation(emp.EXIT_ON_CLOSE);
        emp.setVisible(true);
        emp.setTitle("Menu Empleado"); 
        emp.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
             if(e.getSource() == menu.jSalirE){
                 try{
                 Login log = new Login();
                 ControladorLogin controlLo = new ControladorLogin(log);
                 log.setVisible(true);
                 this.menu.dispose(); 
                 }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede registrar .."+ex);
                   }
                 }
              if(e.getSource() == menu.buttonFacturasE){
               Facturas fac = new Facturas();
                menu.jescritorio.add(fac);
                ControladorFactura fa = new ControladorFactura(fac);
                CentrarFormas.CPanel(menu.jescritorio,fac);
             } 
               if(e.getSource() == menu.meRegistrarFactura){
               DetalleFactura defac = new DetalleFactura();
                menu.jescritorio.add(defac);
               ControladorDetalleFactura cfac = new ControladorDetalleFactura(defac);
                CentrarFormas.CPanel(menu.jescritorio,defac);
             }
                if(e.getSource() == menu.DetalleFactura){
               ConsultaDetalle defac = new  ConsultaDetalle();
                menu.jescritorio.add(defac);
                ControladorConsultaDetalle cdf = new ControladorConsultaDetalle(defac);
                CentrarFormas.CPanel(menu.jescritorio,defac);
             }
                 if(e.getSource() == menu.VisualizarE){
                Visualizar vis = new Visualizar();
                 ControladorVisualizar visu = new ControladorVisualizar(vis);
                 menu.jescritorio.add(vis);
                  CentrarFormas.CPanel(menu.jescritorio,vis);
             }
             if(e.getSource() == menu.buttonReporteDiarioE){
                 Reporte_Diario re = new Reporte_Diario();
                 ControladorReporteDiario crd = new ControladorReporteDiario(re);
                 menu.jescritorio.add(re);
                  CentrarFormas.CPanel(menu.jescritorio,re);  
             }
    }
}