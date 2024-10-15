import java.util.Scanner;

import model.Libros;
import model.Autor;
import model.Almacen;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new scanner(System.in);

        System.out.println("|--------------------------------------|");
        System.out.println("| MIS LIBROS                           |");
        System.out.println("|--------------------------------------|");
        System.out.println("     1) Nuevo almacén de libros");
        System.out.println("     2) Establecer ritmo de lectura (páginas por minuto)");
        System.out.println("     3) Añadir nuevo libro al almacén");
        System.out.println("     4) Mostrar información actual de libros");
        System.out.println("     5) Salir (Se borrará toda la información)");

        System.out.printf("Seleccione una opción: (1-4): ");
        int numero;
        numero = sc.nextInt();

        switch(numero){
            case 1:
                System.out.println("Cuantos libros desea: ");
                int cantidad;
                cantidad = sc.nextInt();
                break;
            case 2: 

        }




    }
}
