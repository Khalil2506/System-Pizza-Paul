 package controlador;
//libreria
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import Modelo.Al_Producto;
import DAO.*;
import Formatos.Mensajes;
public class ControladorVisualizar implements ActionListener{
    //atributos
    Visualizar vista;
    Al_Producto prod;
    CRUDproductos crud;
    CargarCombos cc;
    CRUDvisualizar crudv;
       //constructor
    public ControladorVisualizar(Visualizar pro){
        this.vista = pro;
        vista.jbtnFCategoria.addActionListener(this);
        vista.jbtnFProducto.addActionListener(this);
        vista.jbtnFStock.addActionListener(this);
        vista.jbtnFiltrar.addActionListener(this);
        vista.jbtnRestaurar.addActionListener(this);
        cc = new CargarCombos();
        cc.CargarCategoriasEnCombo(vista.jcbcCategoriaV);
        cc.CargarstockEnCombo(vista.jcbcStockV);
        cc.CargartamanoEnCombo(vista.jFiltroTamano);
        crud = new CRUDproductos();
        crud.MostrarProductoEnTabla(vista.jtblVisualizar,vista.JCDP);
        vista.setTitle("Visualizar"); 
        vista.setVisible(true);  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource() == vista.jbtnFStock){
           try{
           crudv = new CRUDvisualizar(); 
           crudv.MostrarStockEnTabla(vista.jtblVisualizar,vista.jcbcStockV.getSelectedItem().toString());
            }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede Filtrar .."+ex);
                   }
    } 
                 if(e.getSource() == vista.jbtnFCategoria){
           try{
           crudv = new CRUDvisualizar(); 
           crudv.MostrarCategoriaEnTabla(vista.jtblVisualizar,vista.jcbcCategoriaV.getSelectedItem().toString());
            }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede filtrar .."+ex);
                   }
    } 
                       if(e.getSource() == vista.jbtnFProducto){
           try{
           crudv = new CRUDvisualizar(); 
           crudv.MostrarTamanoEnTabla(vista.jtblVisualizar,vista.jFiltroTamano.getSelectedItem().toString());
            }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede filtrar .."+ex);
                   }
                } 
             if(e.getSource() == vista.jbtnRestaurar){
           try{
           crud = new CRUDproductos();
        crud.MostrarProductoEnTabla(vista.jtblVisualizar,vista.JCDP);
            }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede mostrar datos .."+ex);
                   }
    } 
              if(e.getSource() == vista.jbtnFiltrar){
           try{
           crudv = new CRUDvisualizar(); 
           crudv.MostrarProductoEnTabla(vista.jtblVisualizar,vista.jcbcProductoV.getText());
            }catch (Exception ex){
                   Mensajes.M1("ERROR no se puede filtrar .."+ex);
                   }
                } 
}
}