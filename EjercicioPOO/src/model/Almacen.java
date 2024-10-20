package model;

import model.Libro;

public class Almacen {
    public Libro[] arrayAlmacen;  

    public void setTamaño(int tam) {
        arrayAlmacen = new Libro[tam];  
    }

    public int getTamaño() {
        return arrayAlmacen.length;
    }
}
