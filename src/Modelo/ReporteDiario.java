package Modelo;
//libreria
import vista.Reporte_Diario;
import vista.*;
import java.text.DecimalFormat;
public class ReporteDiario extends Empleado_abs implements Producto,Categoria{
    //atributos
     private int Nfactura;
        private int Pizzav;
        private int pastav;
        private int bebidav;
        private int piqueosv;
        private int platoscv;
     private String Fecha;
     private double dinero_i;
     private double Total_D;
     Reporte_Diario vista;
     //constructor
     public ReporteDiario(){}
   //getter y setter
   public int getNfactura() {return Nfactura;}
    public void setNfactura(int Nfactura) {this.Nfactura = Nfactura;}
    public int getPizzav() {return Pizzav;}
    public void setPizzav(int Pizzav) {this.Pizzav = Pizzav;}
    public int getPastav() {return pastav;}
    public void setPastav(int pastav) {this.pastav = pastav;}
    public int getBebidav() {return bebidav;}
    public void setBebidav(int bebidav) {this.bebidav = bebidav;}
    public int getPiqueosv() {return piqueosv;}
    public void setPiqueosv(int piqueosv) {this.piqueosv = piqueosv;}
    public int getPlatoscv() {return platoscv;}
    public void setPlatoscv(int platoscv) {this.platoscv = platoscv;}
    public String getFecha() {return Fecha;}
    public void setFecha(String Fecha) {this.Fecha = Fecha;}
    public double getDinero_i() {return dinero_i;}
    public void setDinero_i(double dinero_i) {this.dinero_i = dinero_i;}
    public double getTotal_D() {return Total_D;}
    public void setTotal_D(double Total_D) {this.Total_D = Total_D;}
  //metodo
    public double Sobrante(){ return Total_D - dinero_i;}
     public Object[] RegistroDatos(int numero) {
                     DecimalFormat df = new DecimalFormat("S/ #0.00");
         double Sobrante=0;
       Object[] fila = {numero,this.getNfactura(),super.getCod_emp(),this.getPizzav(),this.getPastav(),this.getBebidav(),this.getPiqueosv(),this.getPlatoscv()
                        ,this.getFecha(),df.format(this.getDinero_i()),df.format(this.getTotal_D()),df.format(Sobrante())};
       return fila;
    }
    @Override
    public Object[] RegistroDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

   
  

  
    

  
   
    
     
             }
