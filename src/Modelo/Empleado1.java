package Modelo;

import java.text.DecimalFormat;

public class Empleado1 extends Empleado_abs{
    //atributos
       
       private String Direccion;
       private String telefono;
       private double sueldo;
       private int edad;
        private int Dias_Trabajo;
        private String indicador;
    //Constructor
    public Empleado1 (){}
   //getter y setter    
    public String getDireccion() {return Direccion;}
    public void setDireccion(String Direccion) {this.Direccion = Direccion;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public double getSueldo() {return sueldo;}
    public void setSueldo(double sueldo) {this.sueldo = sueldo;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public int getDias_Trabajo() {return Dias_Trabajo;}
    public void setDias_Trabajo(int Dias_Trabajo) {this.Dias_Trabajo = Dias_Trabajo;}
     public String getIndicador() {return indicador;}
    public void setIndicador(String indicador) {this.indicador = indicador;}
   //metodo
    public Object[] RegistroDato(int numero) {
        DecimalFormat df = new DecimalFormat("S/ #0.00");
       Object[] fila = {numero,super.getCod_emp(),super.getNombre(),super.getApellido(),
                        this.getDireccion(),this.getTelefono(),df.format(this.getSueldo()),this.getEdad(),this.getDias_Trabajo()};
       return fila;
    }

    @Override
    public Object[] RegistroDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

   
   


    
}

