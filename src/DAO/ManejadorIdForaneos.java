package DAO;
import Formatos.*;
public class ManejadorIdForaneos extends ConectarBD{
public ManejadorIdForaneos(){}
//metodo que recuperar el Id del nombre de la categoria
public String RecuperarIdCategoria(String nomcat){
    String idcat = null;
    try{
         rs = st.executeQuery("SELECT cod_categoria FROM categoria WHERE nombre_categoria='"+nomcat+"'");
        if(rs.next()){
            idcat = rs.getString(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el IDcategoria.."+ex);
    }
    return idcat;}
//metodo que recuperar el Id del nombre de la categoria
public String RecuperarCategoria(String nomcat){
    String idcat = null;
    try{
         rs = st.executeQuery("SELECT  nombre_categoria  FROM categoria WHERE cod_categoria='"+nomcat+"'");
        if(rs.next()){
            idcat = rs.getString(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el IDcategoria.."+ex);
    }
    return idcat;}
//metodo que recupera el codigo del stock por medio de su nombre
public String RecuperarIdstock(String nomcom){
    String idstock = null;
    try{
          rs = st.executeQuery("SELECT cod_stock FROM stock WHERE tipo_stock='"+nomcom+"'");
        if(rs.next()){
            idstock = rs.getString(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el codigo del stock.."+ex);
    }
    return idstock;
}
//metodo que recupera el codigo del stock por medio de su nombre
public String Recuperarstock(String nomcom){
    String idstock = null;
    try{
          rs = st.executeQuery("SELECT tipo_stock FROM stock WHERE cod_stock='"+nomcom+"'");
        if(rs.next()){
            idstock = rs.getString(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el codigo del stock.."+ex);
    }
    return idstock;
}
//metodo que recupera el codigo del tamaño por medio de su nombre
public String RecuperarIdtamano(String nomtamo){
    String idtamano = null;
    try{
          rs = st.executeQuery("SELECT cod_tamano FROM tamano WHERE proporcion='"+nomtamo+"'");
        if(rs.next()){
            idtamano = rs.getString(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el codigo del tamaño.."+ex);
    }
    return idtamano;
}
//metodo que recupera el codigo del tamaño por medio de su nombre
public String Recuperartamano(String nomtamo){
    String idtamano = null;
    try{
          rs = st.executeQuery("SELECT proporcion FROM tamano WHERE cod_tamano='"+nomtamo+"'");
        if(rs.next()){
            idtamano = rs.getString(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el codigo del tamaño.."+ex);
    }
    return idtamano;
}
//metodo que recupera el codigo del cod del tipo por medio de su nombre
public int RecuperarTipoU(String nomtipo){
    int tipou=0;
    try{
          rs = st.executeQuery("SELECT cod_tipo FROM tipousuario WHERE tipoUsuar='"+nomtipo+"'");
        if(rs.next()){
            tipou = rs.getInt(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el codigo del tamaño.."+ex);
    }
    return tipou;
}
//metodo que recupera el codigo del codigo del empleado por medio de su apellido
public String RecuperarCodEmp(String codempl){
    String coemp = null;
    try{
          rs = st.executeQuery("SELECT cod_emp FROM empleado WHERE apellido='"+codempl+"';");
        if(rs.next()){
           coemp= rs.getString(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el codigo del empleado.."+ex);
    }
    return coemp;
}

public String RecuperarNomEmp(String codemp){
    String nomemp = null;
    try{
          rs = st.executeQuery("SELECT apellido FROM empleado WHERE cod_emp='"+codemp+"';");
        if(rs.next()){
           nomemp= rs.getString(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el codigo del empleado.."+ex);
    }
    return nomemp;
}

public int RecuperarIdFactura(){
    int cofac = 0;
    try{
          rs = st.executeQuery("SELECT MAX(cod_factura) FROM facturas");
        if(rs.next()){
           cofac= rs.getInt(1);
        }
    }catch(Exception ex){
        Mensajes.M1("ERROR no se puede recuperar el codigo del empleado.."+ex);
    }
    return cofac;
}
}
