
package Modelo;
public class Factura extends Empleado_abs{
    //atributos
    private int cod_factura;
    private String DNI_Cliente;
    private String Fecha;
    private double Total;
    //constructor
    public Factura(){}
    //getter y setter
    public int getCod_factura() {return cod_factura;}
    public void setCod_factura(int cod_factura) {this.cod_factura = cod_factura;}
    public String getDNI_Cliente() {return DNI_Cliente;}
    public void setDNI_Cliente(String DNI_Cliente) {this.DNI_Cliente = DNI_Cliente;}
    public String getFecha() {return Fecha;}
    public void setFecha(String Fecha) {this.Fecha = Fecha;}
    public double getTotal() {return Total;}
    public void setTotal(double Total) {this.Total = Total;}
    //metodo
    public Object[] RegistroDatos(int nume) {
       Object[] fila = {nume,this.getCod_factura(),this.getDNI_Cliente(),super.getCod_emp(),this.getFecha(),this.getTotal()};
       return fila;
    }

    @Override
    public Object[] RegistroDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
