package ejercicio2examen;

/**
 * Clase para llevar a cabo las pruebas con la clase Cuadrado.
 * 
 * @author d18momoa
 *
 */
public class TestCuadrado {

  public static void main(String[] args) {
    try {
      Cuadrado c1 = new Cuadrado(10);
      Cuadrado c2 = new Cuadrado(); //Constructor por defecto, crea un cuadrado de 5x5
      Cuadrado c4 = new Cuadrado(5);
      //Cuadrado c3 = new Cuadrado(11);
      System.out.println("Datos de c1: \nLado: "+c1.getLado());
      System.out.println("Pintamos el primer cuadrado:");
      System.out.println(c1);
      System.out.println("\n------------------------------\n");
      System.out.println("Datos de c2: \nLado: "+c2.getLado());
      System.out.println("Pintamos el segundo cuadrado:");
      System.out.println(c2);
      System.out.println("\n------------------------------\n");
      //System.out.println(c3);
      // System.out.println("\n------------------------------\n");
      
      //c1 es mas grande que c2, compareTo devolvera un 1
      System.out.println("c1 comparado con c2 = "+c1.compareTo(c2));
      //c2 es mas pequegno que c1, compareTo devolvera un -1
      System.out.println("c2 comparado con c1 = "+c2.compareTo(c1));
      //c2 es igual que c4, por lo que compareTo devolvera un 0
      System.out.println("c2 comparado con c4 = "+c2.compareTo(c4));
    } catch (ArithmeticException e) {
      System.err.println("Error, el valor del lado debe estar comprendidos entre 1 y 10");
    }
  }
}
