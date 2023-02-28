package controlador;
//libreria
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import vista.Reporte_Diario;
import Modelo.*;
import DAO.*;
import Formatos.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorReporteDiario implements ActionListener{
    //atributos
    Reporte_Diario vista;
    DefaultTableModel modelotabla;
    CRUDreporteDiario crud;
      FormatoReporteDiario red;
       CargarCombos cc;
       ReporteDiario re;
       //constructor
    public ControladorReporteDiario(Reporte_Diario rd){
        this.vista = rd;
        vista.jbtnConsultarRD.addActionListener(this);
        vista.jbtnEliminarRD.addActionListener(this);
        vista.jbtnModificarRD.addActionListener(this);
        vista.jbtnRegistrarRD1.addActionListener(this);
        Calendar cal =  new GregorianCalendar();
        vista.jtxtFechaR.setCalendar(cal);
       cc = new CargarCombos();
        cc.CargarNombreEmpleado(vista.jtxtEmpleadoR);
        crud = new CRUDreporteDiario();
        crud.MostrarReporteEnTabla(vista.jtblReporteDiaRB,vista.jblCRD);
         vista.jtxNReporte.setEnabled(false);
        vista.setTitle("Reporte Diario"); 
        vista.setVisible(true); 
    }
 void LeerCategoria(){
   re = new ReporteDiario();
            ManejadorIdForaneos mif = new ManejadorIdForaneos();
            re.setCod_emp(mif.RecuperarCodEmp(vista.jtxtEmpleadoR.getSelectedItem().toString()));
            re.setPizzav(Integer.parseInt(vista.jtxtPizzaVendida.getText().toString()));
              re.setPastav(Integer.parseInt(vista.jtxtPastasVendida.getText().toString()));
            re.setBebidav(Integer.parseInt(vista.jtxtBebidasVendidas.getText().toString()));
            re.setPiqueosv(Integer.parseInt(vista.jtxtPiqueoVendido.getText().toString()));
            re.setPlatoscv(Integer.parseInt(vista.jtxtPlatosVendidos.getText().toString()));
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            re.setFecha(sf.format(vista.jtxtFechaR.getDate()));                      
            re.setDinero_i(Double.parseDouble(vista.jtxtDineroInicialRD.getText()));
            re.setTotal_D(Double.parseDouble(vista.jtxtTotalRD.getText()));
            re.Sobrante(); 
           
 }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
           if(e.getSource() == vista.jbtnRegistrarRD1){
            LeerCategoria();
             CRUDreporteDiario crud =  new CRUDreporteDiario();
             crud.InsertarRegistroReporteDiario(re);
             crud.MostrarReporteEnTabla(vista.jtblReporteDiaRB,vista.jblCRD);
            FormatoReporteDiario.LimpiarEntradas(vista);
            }
           }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede registrar .."+ex);
                   }
                try{
            if(e.getSource() == vista.jbtnModificarRD){
           LeerCategoria();
             re.setNfactura(Integer.parseInt(vista.jtxNReporte.getText()));
              CRUDreporteDiario crud =  new CRUDreporteDiario();
              crud.ActualizarReporte(re);
             crud.MostrarReporteEnTabla(vista.jtblReporteDiaRB,vista.jblCRD);
            FormatoReporteDiario.LimpiarEntradas(vista);

            }
            }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede modificar .."+ex);
                   }
           try{
           if(e.getSource() == vista.jbtnEliminarRD){
             int respuesta = Mensajes.M3("Confirmar!!!","¿Deseas eliminar el reporte?");
             if(respuesta==0){
                 int idcat = Integer.parseInt(vista.jtxNReporte.getText());
              CRUDreporteDiario crud =  new CRUDreporteDiario();
              crud.EliminarReporte(idcat);
            crud.MostrarReporteEnTabla(vista.jtblReporteDiaRB,vista.jblCRD);
            FormatoReporteDiario.LimpiarEntradas(vista);

             }
         }}catch (Exception ex){
                   Mensajes.M1("ERROR no se puede eliminar .."+ex);
                   }
              if(e.getSource() == vista.jbtnConsultarRD){
               String repo = Mensajes.M2("Ingrese el codigo del reporte a buscar ");
            crud =  new CRUDreporteDiario();
             re = crud.ObtenerRegistroReporte(repo);
             if(re==null){
                 Mensajes.M1("El ID "+re+" no existe en la tabla Empleado..");
             }else{
                   try {
                       int fecha = vista.jtblReporteDiaRB.getSelectedRow();
                       DefaultTableModel model = (DefaultTableModel)vista.jtblReporteDiaRB.getModel();
                       vista.jtxNReporte.setText(Integer.toString(re.getNfactura()));
                       vista.jtxtPizzaVendida.setText(Integer.toString(re.getPizzav()));
                       vista.jtxtPastasVendida.setText(Integer.toString(re.getPastav()));
                       vista.jtxtBebidasVendidas.setText(Integer.toString(re.getBebidav()));
                       vista.jtxtPiqueoVendido.setText(Integer.toString(re.getPiqueosv()));
                       vista.jtxtPlatosVendidos.setText(Integer.toString(re.getPlatoscv()));
                       ManejadorIdForaneos mif =  new ManejadorIdForaneos();
                       vista.jtxtEmpleadoR.setSelectedItem(mif.RecuperarNomEmp(re.getCod_emp()));
                       SimpleDateFormat  df =  new SimpleDateFormat("yyyy-MM-dd");
                       Date fec = (Date) df.parse(re.getFecha());
                       vista.jtxtFechaR.setDate(fec);
                       vista.jtxtDineroInicialRD.setText(Double.toString(re.getDinero_i()));
                       vista.jtxtTotalRD.setText(Double.toString(re.getTotal_D()));
                   } catch (ParseException ex) {
                       Logger.getLogger(ControladorReporteDiario.class.getName()).log(Level.SEVERE, null, ex);
                   }                
             }
         }  
}
}
