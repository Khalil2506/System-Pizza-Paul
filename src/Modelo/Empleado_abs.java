
package Modelo;


public abstract class Empleado_abs {
    //atributos
    private String cod_emp;
     private String Nombre;
     private String Apellido;
     //metodo
     public Empleado_abs(){}

   //getter
     public String getCod_emp() {return cod_emp;}
    public void setCod_emp(String cod_emp) {this.cod_emp = cod_emp;}
    public String getNombre() {return Nombre;}
    public void setNombre(String Nombre) {this.Nombre = Nombre;}
    public String getApellido() {return Apellido;}
    public void setApellido(String Apellido) {this.Apellido = Apellido;}
    //metodo
    public abstract Object[] RegistroDatos();
     
}
