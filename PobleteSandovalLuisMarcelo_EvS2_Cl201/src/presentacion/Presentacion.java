package presentacion;
import datos.Pantalon;
import java.util.Scanner;
import negocio.Negocio;

public class Presentacion {
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Negocio pila =new Negocio();
        Scanner entrada = new Scanner(System.in);
        int opciones;
        int eleccionUsuario = 0;
        boolean menu;
        int salida =0;
        do{
        System.out.println("                        Elija una opción para evaluar.");//Título de introducción al manú de opciones. 
        System.out.println("=================================================================================");
        System.out.println(" ");         
        System.out.println("1- Ingresar un Elemento Pantalon a la Pila");
        System.out.println("2- Quitar un Elemento Pantalon de la Pila");
        System.out.println("3- Ver la Pila");
        System.out.println("4- Salir");
        System.out.println("=================================================================================");
        opciones = entrada.nextInt();
        switch (opciones) {
            case 1:
                do{
                    String cantidad;
                    System.out.println("¿Cuántos códigos de pantalones quiere ingresar?");//Solicitud de datos al usuario para definir cantidad de objetos a completar
                    cantidad = Negocio.solicitaNumero();
                    int cant = Integer.parseInt(cantidad);
                    pila.llenarPila(cant);
                    eleccionUsuario = Negocio.seguirIntentando(salida); // hago la llamada al procedimiento seguirIntentando
                    if (eleccionUsuario == 1) { //aca consulto si es igual a 1 para seguir consultando otros numeros
                        menu = true;
                    } else { //sino sale al menú principal
                        menu = false;
                    }
                    } while (menu != false);//condición establecida en false para continuar el programa o detenerlo.
                break;
            
            case 2:
               do{
               pila.eliminar();
               System.out.println();
               eleccionUsuario = Negocio.seguirIntentando(salida); // hago la llamada al procedimiento seguirIntentando
                    if (eleccionUsuario == 1) { //aca consulto si es igual a 1 para seguir consultando otros numeros
                        menu = true;
                    } else { //sino sale al menú principal
                        menu = false;
                    }
                    } while (menu != false);//condición establecida en false para continuar el programa o detenerlo.
               break;
                
            case 3:
                do{
                 if (!pila.estaVacia()) {System.out.println("               Códigos de pantalón ingresados y su detalle:");
                                         System.out.println("=================================================================================");
                                         System.out.println("");
                     pila.mostrarPila();
                 }else{
                     System.out.println("La pila está vacía;por favor, intente otra opción.");//Mensaje de continuidad al usuario.
                     System.out.println();
                 }
                 eleccionUsuario = Negocio.seguirIntentando(salida); // hago la llamada al procedimiento seguirIntentando
                    if (eleccionUsuario == 1) { //aca consulto si es igual a 1 para seguir consultando otros numeros
                        menu = true;
                    } else { //sino sale al menú principal
                        menu = false;
                    }
                    } while (menu != false);//condición establecida en false para continuar el programa o detenerlo.
                
                break;
                
            case 4:
                System.out.println("Gracias por su evaluación! ");// mensaje de despedida al elegir salir del programa en el menú de opciones.
                System.out.println();
                System.out.println();
                Negocio.sleep(2000);
                break;
            
            default:
                System.out.println("LA OPCIÓN INGRESADA ES INCORRECTA ");// se imprime mensaje por pantalla en caso de que la opción ingresada este fuera de las ofrecidas en el menú.
                System.out.println();
                System.out.println();
                Negocio.sleep(2000);
                break;
        }
        }while(opciones!=4);
    }
}
