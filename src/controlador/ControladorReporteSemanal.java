package controlador;
//librearia
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import vista.Reporte_Diario;
import Modelo.*;
import DAO.*;
import Formatos.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class ControladorReporteSemanal implements ActionListener{
    //atributos
    Reporte_semanal vista;
    DefaultTableModel modelotabla;
    CRUDreporteSemanal crud;
       CargarCombos cc;
         ReporteDiario re;
    Reporte_Diario rvista;
       //constructor
    public ControladorReporteSemanal(Reporte_semanal rs){
        this.vista = rs;
        vista.jbuscarRS.addActionListener(this);
        vista.RestauraraRS.addActionListener(this);
        crud = new CRUDreporteSemanal();
        crud.MostrarReporteEnTabla(vista.jtblRsemanal,vista.jbCDP);
        vista.setTitle("Reporte Semanal"); 
        vista.setVisible(true); 
    }
        

        @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()== vista.jbuscarRS){
             CRUDreporteSemanal crud =  new CRUDreporteSemanal(); 
          }
          if(e.getSource()== vista.RestauraraRS){
                     crud = new CRUDreporteSemanal();
        crud.MostrarReporteEnTabla(vista.jtblRsemanal,vista.jbCDP);   
          }
    } 
}
