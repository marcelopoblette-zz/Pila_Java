package datos;

import java.util.Scanner;
import negocio.Negocio;

public class Pantalon {// creacion de TDA Objeto.
    int i;
    public int codigo;
    private String marca;
    private String talla;
    private String cantidad;
    private String precio;
    
    //Encapsulamiento de datos
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getTalla() {
        return talla;
    }
    
    public void setTalla(String talla) {
        this.talla = talla;
    }
    
    public String getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getPrecio() {
        return precio;
    }
    
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
public void leer(int n){//método para leer datos ingresados por el usuario
        boolean boolIterador = false;
        this.codigo=n;
        do{
        Scanner lee = new Scanner(System.in);
        System.out.println("Ingrese la marca del pantalón código "+this.codigo+".");
        setMarca(Negocio.solicitaDato()); 
        System.out.println("Ingrese la talla del pantalón código "+this.codigo+".");
        setTalla(Negocio.solicitaDato());
        System.out.println("Ingrese la cantidad de pantalones código "+this.codigo+".");
        setCantidad(Negocio.solicitaNumero());
        System.out.println("Ingrese el precio del pantalón código "+this.codigo+".");
        setPrecio(Negocio.solicitaNumero()) ;
        System.out.println("=================================================================================");
        System.out.println();
        }while(boolIterador);
    }
    
    public void mostrar(){//Metodo para mostrar datos ingresados por el usuario
        System.out.println("El código del pantalón ingresado es "+this.codigo +"."+
                "\nLa marca del código de pantalón "+this.codigo+" es: "+getMarca()+"."+
                "\nLa talla del código de pantalón "+this.codigo+"  es: "+getTalla()+"."+
                "\nLa cantidad de pantalón(es) ingresados con el código "+codigo+" es: "+getCantidad()+"."+
                "\nEl precio del código de pantalón "+this.codigo+" es: $"+getPrecio()+".");
        System.out.println();
   System.out.println("=================================================================================");
    }
}

