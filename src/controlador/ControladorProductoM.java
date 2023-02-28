package controlador;
//libreria
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import vista.Productos;
import Modelo.Al_Producto;
import DAO.*;
import Formatos.FormatoProductos;
import Formatos.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
public class ControladorProductoM implements ActionListener{
    //atributos
    Productos vista;
    Al_Producto prod;
    CRUDproductos crud;
    CargarCombos cc;
    FormatoProductos fpro;
       //constructor
    public ControladorProductoM(Productos p){
        this.vista = p;
        vista.jbtnConsultarP.addActionListener(this);
        vista.jbtnEliminarP.addActionListener(this);
        vista.jbtnModificarP.addActionListener(this);
        vista.jbtnAgregarP1.addActionListener(this);
        cc = new CargarCombos();
        cc.CargarCategoriasEnCombo(vista.jCategoriaP);
        cc.CargarstockEnCombo(vista.jtxtStockP);
        cc.CargartamanoEnCombo(vista.jcbcTamañoP);
        crud = new CRUDproductos();
        crud.MostrarProductoEnTabla(vista.jtblListaProductos,vista.jlblProductos);
        vista.setTitle("Productos"); 
        vista.setVisible(true);
    } 
    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource() == vista.jbtnAgregarP1){
           prod = FormatoProductos.LeerProducto(vista);
              crud = new CRUDproductos(); 
              crud.InsertarRegistroProd(prod);
             crud.MostrarProductoEnTabla(vista.jtblListaProductos,vista.jlblProductos);
              FormatoProductos.LimpiarEntradas(vista);   
          }
           try{
            if(e.getSource() == vista.jbtnModificarP){
            prod = FormatoProductos.LeerProducto(vista);
              crud = new CRUDproductos(); 
              crud.ActualizarProducto(prod);
              crud.MostrarProductoEnTabla(vista.jtblListaProductos,vista.jlblProductos);
              FormatoProductos.LimpiarEntradas(vista);  
            }
           }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede modificar .."+ex);
                   }
           try{
           if(e.getSource() == vista.jbtnEliminarP){
             int respuesta = Mensajes.M3("Confirmar!!!","¿Deseas eliminar el producto?");
             if(respuesta==0){
                  prod = FormatoProductos.LeerProducto(vista);
                 crud = new CRUDproductos(); 
              crud.EliminarFactura(prod);
              crud.MostrarProductoEnTabla(vista.jtblListaProductos,vista.jlblProductos);
              FormatoProductos.LimpiarEntradas(vista);  
             }
         }}catch (Exception ex){
                   Mensajes.M1("ERROR no se puede eliminar .."+ex);
                   }
              if(e.getSource() == vista.jbtnConsultarP){
               String cod_pro = Mensajes.M2("Ingrese el codigo del producto a buscar ");
             crud = new CRUDproductos(); 
             prod = crud.ObtenerRegistroProducto(cod_pro);
             if(prod==null){
                 Mensajes.M1("El ID "+prod+" no existe en la tabla Factura..");
             }else{
                       vista.jtxtCodigoProducto.setText(prod.getCod_Producto());
                       vista.jtxtNombrePro.setText(prod.getNombre_P());
                       vista.jtxtPrecioP.setText(Double.toString(prod.getPrecio()));
                       ManejadorIdForaneos mif =  new ManejadorIdForaneos();
                       vista.jtxtStockP.setSelectedItem(mif.Recuperarstock(prod.getStock()));
                       vista.jCategoriaP.setSelectedItem(mif.RecuperarCategoria(prod.getCategoria()));
                       vista.jcbcTamañoP.setSelectedItem(mif.Recuperartamano(prod.getTamano()));
             }
         }
}
}