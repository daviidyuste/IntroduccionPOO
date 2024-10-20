package model;

public class Autor {
    String nombre,apellido;
    boolean premioPlaneta;


    //Establecemos un autor predeterminado desconocido.
    public Autor(){
        this.apellido="Desconocido";
        this.nombre="Desconocido";
        this.premioPlaneta=false;
    }


    public Autor(String nombre,String apellido, boolean premio){
        this.premioPlaneta=premio;
        this.nombre=nombre;
        this.apellido=apellido;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public boolean isPremioPlaneta() {
        return premioPlaneta;
    }

}
