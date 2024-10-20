import java.util.Scanner;
import model.Libro;
import model.Autor;
import model.Almacen;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);

        String tituloLibro, nombreAutor, apellidoAutor, ganadorPremio;
        int seleccion = 0, tamañoAlmacen = 0, añoPublicacion, totalPaginas, minutosLectura, velocidadLectura = 1, totalMinutosLectura = 0;
        boolean esPremioPlaneta;
        float costoLibro, costoTotal = 0.0f;
        Almacen libreria = null;

        System.out.println("|----------------------------------------|");
        System.out.println("| MIS LIBROS                             |");
        System.out.println("|----------------------------------------|");
        System.out.println("   1) Crear nuevo almacén de libros       ");
        System.out.println("   2) Definir velocidad de lectura        ");
        System.out.println("   3) Añadir un nuevo libro al almacén    ");
        System.out.println("   4) Mostrar información de libros       ");
        System.out.println("   5) Salir                               ");
        System.out.println("|----------------------------------------|");

        do {
            System.out.printf("Seleccione una opción (1-5): ");
            seleccion = entrada.nextInt();
            entrada.nextLine();  

            switch (seleccion) {
                case 1:
                    System.out.printf("Introduzca cuántos libros desea añadir: ");
                    tamañoAlmacen = entrada.nextInt();
                    entrada.nextLine(); 
                    libreria = new Almacen();
                    libreria.setTamaño(tamañoAlmacen);
                    System.out.println("Almacén de libros creado");
                    break;

                case 2:
                    System.out.printf("¿Cuál es su velocidad de lectura (páginas por minuto)?: ");
                    velocidadLectura = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Velocidad de lectura establecida en: " + velocidadLectura + " páginas por minuto.");
                    break;

                case 3:
                    if (libreria == null) {
                        System.out.println("No se ha creado un almacén de libros. Seleccione la opción 1 para crearlo.");
                        break;
                    }
                    int indice = 0;
                    while ((indice < libreria.getTamaño()) && (libreria.arrayAlmacen[indice] != null)) {
                        indice++;
                    }
                    
                    if (indice >= libreria.getTamaño()) {
                        System.out.println("El almacén está lleno.");
                    } else {
                        libreria.arrayAlmacen[indice] = new Libro();

                        System.out.printf("Introduzca el título del libro: ");
                        tituloLibro = entrada.nextLine();
                        libreria.arrayAlmacen[indice].setNombre(tituloLibro);

                        System.out.printf("Introduzca el año de publicación del libro: ");
                        añoPublicacion = entrada.nextInt();
                        entrada.nextLine();  
                        libreria.arrayAlmacen[indice].setYear(añoPublicacion);

                        System.out.printf("Introduzca el número de páginas del libro: ");
                        totalPaginas = entrada.nextInt();
                        entrada.nextLine();  
                        libreria.arrayAlmacen[indice].setPaginas(totalPaginas);

                        System.out.printf("Introduzca el costo del libro: ");
                        costoLibro = entrada.nextFloat();
                        entrada.nextLine();  
                        libreria.arrayAlmacen[indice].setPrecio(costoLibro);

                        System.out.printf("Introduzca el nombre del autor: ");
                        nombreAutor = entrada.nextLine();

                        System.out.printf("Introduzca el apellido del autor: ");
                        apellidoAutor = entrada.nextLine();

                        System.out.printf("¿Ha ganado el premio Planeta? (y/n): ");
                        ganadorPremio = entrada.nextLine();
                        esPremioPlaneta = ganadorPremio.equals("y");

                        Autor escritor = new Autor(nombreAutor, apellidoAutor, esPremioPlaneta);
                        libreria.arrayAlmacen[indice].setAutor(escritor);
                        
                        System.out.println("Libro añadido correctamente.");
                    }
                    break;

                case 4:
                    if (libreria == null) {
                        System.out.println("No hay ningún almacén de libros creado. Por favor seleccione la opción 1 para crearlo.");
                    } else {
                        System.out.println("|---------------------------------------------------------------------------------------------------------------------------|");
                        System.out.println("| LIBROS EN EL ALMACÉN                                                                                                       |");
                        System.out.println("|---------------------------------------------------------------------------------------------------------------------------|");
                        System.out.printf("| Título\t| Año de Publicación | Autor\t\t| Premio Planeta | Páginas | Tiempo de lectura en minutos |     Precio |\n");
                        System.out.println("|---------------------------------------------------------------------------------------------------------------------------|");
                        for (int j = 0; j < libreria.getTamaño(); j++) {
                            if (libreria.arrayAlmacen[j] == null) {
                                System.out.println("Ya se han leído todos los libros en el almacén. Quedan espacios vacíos.");
                                break;
                            } else {
                                minutosLectura = libreria.arrayAlmacen[j].getPaginas() / velocidadLectura;
                                System.out.printf("| %s\t| %d            | %s\t%s\t| %b           |   %d   |                       %d |    %.2f € |\n",
                                    libreria.arrayAlmacen[j].getNombre(), libreria.arrayAlmacen[j].getYear(),
                                    libreria.arrayAlmacen[j].getAutor().getNombre(), libreria.arrayAlmacen[j].getAutor().getApellido(),
                                    libreria.arrayAlmacen[j].getAutor().isPremioPlaneta(), libreria.arrayAlmacen[j].getPaginas(),
                                    minutosLectura, libreria.arrayAlmacen[j].getPrecio());
                                totalMinutosLectura += minutosLectura;
                                costoTotal += libreria.arrayAlmacen[j].getPrecio();
                            }
                        }
                        System.out.println("|---------------------------------------------------------------------------------------------------------------------------|");
                        System.out.printf("| Tiempo total de lectura del almacén:                                                                  %d min |           |\n", totalMinutosLectura);
                        System.out.printf("| Valor total del almacén:                                                                                           %.2f € |\n", costoTotal);
                        System.out.println("|---------------------------------------------------------------------------------------------------------------------------|");

                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (seleccion != 5);

        entrada.close(); 
    }
}
