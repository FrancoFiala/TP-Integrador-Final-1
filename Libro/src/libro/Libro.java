/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libro;

import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Libro {

    private String titulo;
    private String autor;
    private int ejemplares;
    private int prestados;
    
//constructor por defecto
   
public Libro(){

}

// contructor con parametros

public Libro(String titulo, String autor, int ejemplares, int prestados){
    this.titulo = titulo;
    this.autor = autor;
    this.ejemplares = ejemplares;
    this.prestados = prestados;
}

// getters y setters

public String getAutor() {
     return autor;
}

public void setAutor(String autor){
    this.autor = autor;
}

public int getEjemplares(){
     return ejemplares;
}

public void setEjemplares(int ejemplares){
    this.ejemplares = ejemplares;
}

public int getPrestados(){
    return prestados;
}

public void setPrestados(int prestados){
   this.prestados = prestados;
}

public String getTitulo(){
    return titulo;
}

public void setTitulo(String titulo){
    this.titulo = titulo;
}

// Método para realizar el prestamo de un libro

  public boolean prestamo(){
    boolean prestado = true;
    if(prestados<ejemplares){
       prestados++;
       ejemplares--;
    } else {
       prestado = false;
    }
     return prestado;
}

  // Método para realizar la devolución de un libro
  
  public boolean devolucion(){
     boolean devuelto = true;
     if (prestados == 0){
        devuelto = false;
     }else {
          prestados--;
          ejemplares++;
     }
     return devuelto;
}
 
  
  // Método toString sobreescrito para mostrar los datos de la clase libro
  
  @Override
   public String toString(){
    return "titulo: "+ titulo + "\nautor: " + autor + "\nejemplares: " + ejemplares +
           "\nprestados: " + prestados;
}
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      String titulo, autor;
      int ejemplares;

    // se crea el objeto libro1 utilizando el constructor con parámetros

    Libro libro1 = new Libro("El quijote", "Cervantes", 1, 0);
    
     // se crea el objeto libro2 utilizando el constructor por defecto
   
    Libro libro2 = new Libro();
    
    System.out.println("Introduce titulo: ");
    titulo = sc.nextLine();
    System.out.println("Introduce autor: ");
    autor = sc.nextLine();
    System.out.println("Numero de ejemplares: ");
    ejemplares = sc.nextInt();

    //se asigna a libro2 los datos pedidos por teclado.
    //para ello se utilizan los métodos setters.
    
    libro2.setTitulo(titulo);
    libro2.setAutor(autor);
    libro2.setEjemplares(ejemplares);
    
        //se muestra por pantalla los datos del objeto libro1
    //se utilizan los métodos getters para acceder al valor de los atributos
    
    System.out.println("Libro 1:");
   System.out.println("Titulo: " + libro1.getTitulo());
   System.out.println("Autor: "+ libro1.getAutor());
   System.out.println("Ejemplares: "+ libro1.getEjemplares());
   System.out.println("Prestados: "+libro1.getPrestados());
   System.out.println();
   
   //se realiza un préstamo de libro1. El método devuelve true si se ha podido
   //realizar el préstamo y false en caso contrario.
   
    if (libro1.prestamo()){
     System.out.println("Se ha prestado el libro "+ libro1.getTitulo());
  }else {
      System.out.println("No quedan ejemplares del libro "+ libro1.getTitulo() + "para prestar");
  }
    
      //se realiza una devolución de libro1. El método devuelve true si se ha podido
  // realizar la devolución y false en caso contrario.

  if (libro1.devolucion()){
      System.out.println("Se ha devuelto el libro "+ libro1.getTitulo());
  }else {
      System.out.println("No quedan ejemplares del libro "+ libro1.getTitulo() + " prestados");
  }
  
  //se realiza otro prestamo del libro 1

  if (libro1.prestamo()){
      System.out.println("Se ha prestadoo el libro "+ libro1.getTitulo());
  }else {
      System.out.println("No quedan ejemplares del libro "+ libro1.getTitulo() + "para prestar");
  }

   //se realiza otro prestamo de libro1. En este caso no se podra realizar ya que 
   //solo hay un ejemplar de este libro y ya esta prestado. Se mostrará por
   //pantalla el mensaje No quedan ejemplares del libro...
   
      if (libro1.prestamo()){
      System.out.println("Se ha prestado el libro "+ libro1.getTitulo());
   }else {
      System.out.println("No quedan ejemplares del libro "+ libro1.getTitulo() + "para prestar");
   }
    
    
    System.out.println();

   System.out.println(libro1.toString());
   System.out.println(libro2.toString());
   
   
    }
    
}
