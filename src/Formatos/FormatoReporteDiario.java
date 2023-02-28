package Formatos;
import vista.Reporte_Diario;
import java.util.*;
import Modelo.ReporteDiario;
import java.text.SimpleDateFormat;
import DAO.*;

public class FormatoReporteDiario {
    public static void LimpiarEntradas(Reporte_Diario red){
   red.jtxNReporte.setText("");
   red.jtxtEmpleadoR.setSelectedIndex(0);
   red.jtxtPizzaVendida.setText("");
   red.jtxtPastasVendida.setText("");
    red.jtxtBebidasVendidas.setText("");
     red.jtxtPiqueoVendido.setText("");
      red.jtxtPlatosVendidos.setText("");
   Calendar cal =  new GregorianCalendar();
    red.jtxtFechaR.setCalendar(cal);
   red.jtxtDineroInicialRD.setText("");
   red.jtxtTotalRD.setText("");
   red.jtxtEmpleadoR.requestFocus();    
}
 
 
}
