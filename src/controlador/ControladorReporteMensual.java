package controlador;
//libreria
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import vista.Reporte_Diario;
import Modelo.*;
import DAO.*;
import javax.swing.table.DefaultTableModel;
public class ControladorReporteMensual implements ActionListener{
    //atributos
 Reporte_Mensual vista;
    DefaultTableModel modelotabla;
    CRUDreporteMensual crud;
       CargarCombos cc;
       ReporteDiario re;
    Reporte_Diario rvista;
       //constructor
    public ControladorReporteMensual(Reporte_Mensual rm){
        this.vista = rm;
        vista.Restaurar.addActionListener(this);
        crud = new CRUDreporteMensual();
        crud.MostrarReporteEnTabla(vista.jbtlRmensual,vista.jCDR);
        vista.setTitle("Reporte Mensual"); 
        vista.setVisible(true); 
    }
        @Override
    public void actionPerformed(ActionEvent e) {
         
          if(e.getSource()== vista.Restaurar){
          crud = new CRUDreporteMensual();
        crud.MostrarReporteEnTabla(vista.jbtlRmensual,vista.jCDR);           
          }
    } 
}