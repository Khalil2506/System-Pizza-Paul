
package controlador;
//librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import Modelo.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JFrame;
import Formatos.*;
import Principal.PrincipalControlador;
public class ControladorMenuPrincipal implements ActionListener {
    //atributos
   MenuPrincipal menu;
    Empleado emple;
    ControladorLogin lo;
    //constructor
    public ControladorMenuPrincipal(MenuPrincipal me){
        menu = me;
        this.menu.jbtnEmpleadosM.addActionListener(this);
        this.menu.jbtnProductosM.addActionListener(this);
        this.menu.jbtnFacturaM.addActionListener(this);
        this.menu.meRegistrarFactura.addActionListener(this);
        this.menu.jbtnReporteDiarioM.addActionListener(this);
        this.menu.jbtnReporteMensualM.addActionListener(this);
        this.menu.jbtnReporteSemanalM.addActionListener(this);
        this.menu.jbtnVisualizarM.addActionListener(this);
        this.menu.jSalirM.addActionListener(this);
        this.menu.DetalleFactura.addActionListener(this);
        me.setExtendedState(JFrame.MAXIMIZED_BOTH);
        me.setDefaultCloseOperation(me.EXIT_ON_CLOSE);
        me.setVisible(true);
        me.setTitle("Menu Principal"); 
        me.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
             if(e.getSource() == menu.jSalirM){
                 Login log = new Login();
                 ControladorLogin controlLo = new ControladorLogin(log);
                 log.setVisible(true);
                 this.menu.dispose();   
             }
             if(e.getSource() == menu.jbtnFacturaM){
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
               if(e.getSource() == menu.jbtnReporteMensualM){
                Reporte_Mensual rm = new Reporte_Mensual();
                 ControladorReporteMensual crm = new ControladorReporteMensual(rm);
                 menu.jescritorio.add(rm);
                  CentrarFormas.CPanel(menu.jescritorio,rm);
             }
                if(e.getSource() == menu.jbtnReporteSemanalM){
                 Reporte_semanal rs = new Reporte_semanal();
                 ControladorReporteSemanal crs = new ControladorReporteSemanal(rs);
                 menu.jescritorio.add(rs);
                  CentrarFormas.CPanel(menu.jescritorio,rs);
             }
                 if(e.getSource() == menu.jbtnVisualizarM){
                 Visualizar vis = new Visualizar();
                 ControladorVisualizar visu = new ControladorVisualizar(vis);
                 menu.jescritorio.add(vis);
                  CentrarFormas.CPanel(menu.jescritorio,vis);
             }
             if(e.getSource() == menu.jbtnEmpleadosM){
                Empleado em = new Empleado();
                menu.jescritorio.add(em);
                ControladorEmpleado emp = new ControladorEmpleado(em);
                CentrarFormas.CPanel(menu.jescritorio,em);
            }
             if(e.getSource() == menu.jbtnReporteDiarioM){
                 Reporte_Diario re = new Reporte_Diario();
                 ControladorReporteDiario crd = new ControladorReporteDiario(re);
                 menu.jescritorio.add(re);
                  CentrarFormas.CPanel(menu.jescritorio,re); 
             }
             if(e.getSource() == menu.jbtnProductosM){
                 PrincipalControlador.f1 = new Productos();
                 PrincipalControlador.controlf1 = new ControladorProductoM(PrincipalControlador.f1);
                 menu.jescritorio.add(PrincipalControlador.f1);
                 CentrarFormas.CPanel(menu.jescritorio,PrincipalControlador.f1);
             }
    }
}
