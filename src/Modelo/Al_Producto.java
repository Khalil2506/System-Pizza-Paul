
package Modelo;
import java.text.DecimalFormat;

public class Al_Producto extends Producto_abs implements Stock,tamano,Categoria {
    private String Stock;
    private String Categoria;
    private String tamano;
//Metodo
    public Al_Producto(){}
    // getter y setter
    public String getStock() {return Stock;}
    public void setStock(String Stock) {this.Stock = Stock;}
    public String getCategoria() {return Categoria;}
    public void setCategoria(String Categoria) {this.Categoria = Categoria;}
    public String getTamano() {return tamano;}
    public void setTamano(String tamano) {this.tamano = tamano;}
    //metodo
    public Object[] RegistroDatos(int numeracion) {
        DecimalFormat df = new DecimalFormat("S/ #0.00");
        Object[] fila = {numeracion,super.getCod_Producto(),super.getNombre_P(),df.format(super.getPrecio())
                        ,this.getStock(),this.getCategoria(),this.getTamano()};
       return fila;
    }
    @Override
    public Object[] RegistroDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
