package negocio;

import datos.Pantalon;//extension de clase Pantalón.
import java.util.Scanner;

public class Negocio extends Pantalon{//extension de clase Pantalón.
    
    int max =50;
    Pantalon[]arregloPantalon = new Pantalon[max];
    int tope;
    void Pila(){
        tope=0;
    }

//Método para saber si aux está vacía
    public boolean estaVacia(){//método para saber si la pila está vacía.this
        if(tope==0)
            return true;
        return false;
    }
      //Método para saber si aux está llena.
    public boolean estaLlena(){ //método para saber si la pila está llena.
         if(tope==max){
            return true;
         }
        return false;
    }
    public void adicionar(Pantalon pantalon){//método para agregar los objetos a la pila.
    if(estaLlena()){
        System.out.println("La pila está vacía; por favor, intente otra opción.");//Mensaje de continuidad al usuario.
    }else{
        tope++;
        arregloPantalon[tope]= pantalon;
    }
    }
    
    public void llenarPila(int n){//metodo para llenar los indices
        for (int i = 1; i <= n; i++) {
            Pantalon pant = new Pantalon();
            codigo+=i;
            pant.leer(codigo*10);
            adicionar(pant);
        }
    }
    
    public Pantalon eliminar(){ //método para eliminar cima de la pila
        Pantalon pant = new Pantalon();
        if (!estaVacia()) {
            pant = arregloPantalon[tope];
            tope--;
            System.out.println("Se eliminó el último código ingresado a la pila.");
        }else{
            System.out.println("La pila está vacía; por favor, intente otra opción.");//Mensaje de continuidad al usuario.
        }
        return pant;
    }
    public Pantalon eliminarAuxiliar(){//Método auxiliar para mostrar la pila.
        Pantalon pant = new Pantalon();
        if (!estaVacia()) {
            pant = arregloPantalon[tope];
            tope--;
        }return pant;
    }
    
    public void mostrarPila(){//Método para mostrar la pila.
        Negocio aux = new Negocio();
        while(!estaVacia()){
            Pantalon pant = eliminarAuxiliar();
            pant.mostrar();
            aux.adicionar(pant);
        }
        while (!aux.estaVacia()) {            
            adicionar(aux.eliminarAuxiliar());
        }
        }
    
    public static void sleep(int time) { //Metodo sleep que retrasa el hilo(thread) de ejecucion en la cantidad de milisegundos que se indique como parámetro de tipo int(time).
        try {// Se implementa una estructura de seguridad( try & catch), en caso que el usuario ingrese un tipo de dato que no corresponda,para evitar la caída del método.
            Thread.sleep(time); // Para este caso  basa en la clase Thread y toma el parametro de milisegundos configurados(time).
        } catch (Exception e) { }//En caso de error, este se "captura con la excepción, para este caso la genérica "e").
        
    }
    public static int seguirIntentando(int menu) { //Este método toma la respuesta del usuario si quiere volver al programa para probar otros valores o ir al menú principal.
    boolean seguir = false;// Se define valor booleano para condicionar la salida del ciclo Do-While.
        Scanner entrada = new Scanner(System.in);
        do {//Ciclo Do-While que solicitará valores al usuario mientras se cumpla que el valor booleano establecido (!seguir).
            System.out.println("                 Presione 1 para realizar otra prueba.");// se le solicita al usuario que ingrese un valor entero sea 1 o 2.       
            System.out.println("                 Presione 2 para ir al menú.");
            System.out.println("=================================================================================");
            System.out.println();
            String salida = entrada.next();// Se almacena el valor ingresado por el usuario.
            if (validaInt(salida)==true) {//se valida que el valor ingresado sea entero.
                menu = Integer.parseInt(salida);//Una vez validado se asigna el valor a la variable menu.
                if (menu == 1 || menu == 2) {//Se reducen las opciones para continuar a 2 y 1
                    seguir = true;// Sólo continúa si el valor ingresado es 1 o 2.
                } else {//si el valor está fuera de las opciones posibles se imprime pro pantalla el mensaje: "Favor ingrese sólo 1 o 2.".
                    System.out.println("Favor ingrese sólo 1 o 2. ");
                    System.out.println();
                    System.out.println("Volvamos a intentar!"); //Si el valor ingresado no es un enterose imprime pro pantalla el mensaje :"Volvamos a intentar!".
                    System.out.println();
                    seguir = false;}//si el valor ingresado por el usuario está fuera de las opciones posibles 1 ó 2 se vuelve al comienzo del ciclo.
            } else {
                seguir = false;}//si el valor ingresado por el usuario no es un entero, se vuelve al comienzo del ciclo.
        } while (!seguir); //condición establecida para el ciclo Ciclo Do-While.
        return menu;//se retorna al main el valor ingresado por el usuario luego de atravesar  las validaciones.
    }
        
    public static boolean validaInt(String num) { //Este metodo valida que el valor que ingrese el usuario sea un entero.
        try {// Se implementa una estructura de seguridad( try & catch), en caso que el usuario ingrese un tipo de dato que no corresponda,para evitar la caída del método.
            Integer.parseInt(num);// El proceso se hace a través de un "parseo" o conversion de datos en este caso desde texto(String) a entero (Int).
        } catch (Exception e) {//En caso de error, este se "captura con la excepción, para este caso la genérica "e").
            return false;}// Valor booleano que retorna en caso de error.
        return true;//Valor booleano que retorna en caso que la validación sea exitosa.
    }
    public static String solicitaNumero(){
        String Numero; //definine variable tipo String para el primerNumero numero ingresado por el usuario.
        Scanner entrada = new Scanner(System.in);// se llama la clase Scanner para tomar los datos ingresados por el usuario.
        boolean boolIterador = false; // se define variable boolIterador  con valor "false" para controlar la salida del ciclo Do-while que contendrá el menú de opciones en una estructura Switch.
        do {//ciclo Do-While que contiene el desarrollo del programa.
            do {//ciclo Do-While que contiene el procesamiento del primerNumero numero.
                //System.out.println("Introduce un número; ");//solicitud al usuario que ingrese un valor numerico.
                Numero = entrada.nextLine();//asignación de valor ingresado por el usuario a la variable "primerNumero".
                if (validaInt(Numero) == true) {//validación del dato ingresado por usuario si es o no numerico (tipo int).
                    boolIterador = false;}// se mantiene el valor false para boolIterador si el valor ingresado es numerico y continua el flujo del progarama.
                else {// si el valor no es numerico se imprime por pantalla el mensaje :"El dato ingresado NO es un numero" y se define boolIterador con valor true para volver al inicio del ciclo Do-While.
                    System.out.println("El dato ingresado NO es un numero.");//Mensaje de continuidad al usuario.
                    boolIterador = true;}
            } while (boolIterador);//condición establecida en false para continuar el programa si los datos ingresados pasan las validaciones. 
        } while (boolIterador);
        return Numero;
    }
    public static String solicitaDato(){//Método que valida el ingreso de un dato válido.
        String dato; //definine variable tipo String para el primerNumero numero ingresado por el usuario.
        Scanner entrada = new Scanner(System.in);// se llama la clase Scanner para tomar los datos ingresados por el usuario.
        boolean boolIterador = false; // se define variable boolIterador  con valor "false" para controlar la salida del ciclo Do-while que contendrá el menú de opciones en una estructura Switch.
        do {//ciclo Do-While que contiene el desarrollo del programa.
            do {//ciclo Do-While que contiene el procesamiento del primerNumero numero.
                //System.out.println("Introduce un número; ");//solicitud al usuario que ingrese un valor numerico.
                dato = entrada.nextLine();//asignación de valor ingresado por el usuario a la variable "primerNumero".
                if (dato.length()<1) {
                    System.out.println("Por favor, ingrese la informacion solicitada.");
                    boolIterador = true;
                } else {
                    boolIterador = false;}// se mantiene el valor false para boolIterador si el valor ingresado es numerico y continua el flujo del progarama.
            } while (boolIterador);//condición establecida en false para continuar el programa si los datos ingresados pasan las validaciones. 
        } while (boolIterador);
        return dato;
    }
}