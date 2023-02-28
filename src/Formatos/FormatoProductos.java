package Formatos;
//librerias
import vista.Productos;
import java.util.*;
import Modelo.Al_Producto;
import java.text.SimpleDateFormat;
import DAO.*;
public class FormatoProductos {
public static void LimpiarEntradas(Productos pro){
    pro.jtxtCodigoProducto.setText("");
    pro.jtxtNombrePro.setText("");
    pro.jtxtPrecioP.setText("");
    pro.jtxtStockP.setSelectedIndex(0);
    pro.jCategoriaP.setSelectedIndex(0);
    pro.jcbcTamañoP.setSelectedIndex(0);
    pro.jtxtCodigoProducto.requestFocus();    
}
public static Al_Producto LeerProducto(Productos pro){
     Al_Producto prod = new Al_Producto();
     prod.setCod_Producto(pro.jtxtCodigoProducto.getText());
     prod.setNombre_P(pro.jtxtNombrePro.getText());
     prod.setPrecio(Double.parseDouble(pro.jtxtPrecioP.getText()));
       ManejadorIdForaneos mif = new ManejadorIdForaneos();
     prod.setStock(mif.RecuperarIdstock(pro.jtxtStockP.getSelectedItem().toString()));
     prod.setCategoria(mif.RecuperarIdCategoria(pro.jCategoriaP.getSelectedItem().toString()));
     prod.setTamano(mif.RecuperarIdtamano(pro.jcbcTamañoP.getSelectedItem().toString()));
    
     return prod;
}    
}
