
package Modelo;

public  abstract class Producto_abs {
     private String  cod_Producto;
     private String Nombre_P;
      private double Precio;
      public Producto_abs(){}
      // getter y setter
    public String getCod_Producto() {return cod_Producto;}
    public void setCod_Producto(String cod_Producto) {this.cod_Producto = cod_Producto;}
    public String getNombre_P() {return Nombre_P;}
    public void setNombre_P(String Nombre_P) {this.Nombre_P = Nombre_P;}
    public double getPrecio() {return Precio;}
    public void setPrecio(double Precio) {this.Precio = Precio;}
    //metodo
    public abstract Object[] RegistroDatos();
}
