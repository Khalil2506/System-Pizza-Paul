
package Principal;
import controlador.ControladorLogin;
import controlador.ControladorMenuPrincipal;
import controlador.*;
import vista.Login;
import vista.MenuPrincipal;
import vista.*;
public class PrincipalControlador {
   public static ControladorLogin log;
    public static Login lo;
    public static Productos f1;
    public static ControladorProductoM controlf1;
    public static ControladorMenuPrincipal cmp;
    public static MenuPrincipal menu;
    public static void main(String[] args) {
          //ControladorReporteDiario lo = new ControladorReporteDiario();
          //lo.iniciar();
          lo = new Login();
          log = new ControladorLogin(lo);
//          menu = new MenuPrincipal();
//          cmp = new ControladorMenuPrincipal(menu);
          
    }
    
}
