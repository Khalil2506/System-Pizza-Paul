
package Modelo;

public class RegistroFactura extends Factura {
    //atributos
          private int cod_detalle;
    private String cod_pro;
    private String Descripcion;
    private int Cantidad;
    private double PrecioUni;
    public RegistroFactura(){
            }
   //getter y setter
    public int getCod_detalle() {return cod_detalle;}
    public void setCod_detalle(int cod_detalle) {this.cod_detalle = cod_detalle; }
    public String getCod_pro() {return cod_pro;}
    public void setCod_pro(String cod_pro) {this.cod_pro = cod_pro;}
    public String getDescripcion() { return Descripcion;}
    public void setDescripcion(String Descripcion) {this.Descripcion = Descripcion;}
    public int getCantidad() { return Cantidad;}
    public void setCantidad(int Cantidad) {this.Cantidad = Cantidad;}
    public double getPrecioUni() {return PrecioUni;}
    public void setPrecioUni(double PrecioUni) {this.PrecioUni = PrecioUni;}
    
    //metodo
     public double PrecTotal(){ return PrecioUni*Cantidad;}
     
      public Object[] RegistroDatosDetalle(int nume) {
       Object[] fila = {nume,this.getCod_detalle(),this.getCod_pro(),this.getDescripcion(),this.getCantidad(),this.getPrecioUni(),this.PrecTotal(),super.getCod_factura()};
       return fila;
    }

   
    
    
   
}
