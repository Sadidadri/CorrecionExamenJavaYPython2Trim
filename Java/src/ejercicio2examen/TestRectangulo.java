package ejercicio2examen;
/**
 * Clase para llevar a cabo las pruebas con la clase Rectangulo.
 * @author d18momoa
 *
 */
public class TestRectangulo {

  public static void main(String[] args) {
    try {
      Rectangulo r1 = new Rectangulo(); //Constructor por defecto: un rectangulo de 4x3
      Rectangulo r2 = new Rectangulo(3,10);
      //Descomentando r3, comprobamos que funciona bien la captura de la excepcion.
      //Rectangulo r3 = new Rectangulo(11,5);
      
      System.out.println("Datos de r1: \nAncho: "+r1.getAncho()+"\nAlto: "+r1.getAlto());
      System.out.println("Pintamos el primer rectangulo:");
      System.out.println(r1);
      System.out.println("------------------------------\n");
      System.out.println("Datos de r2: \nAncho: "+r2.getAncho()+"\nAlto: "+r2.getAlto());
      System.out.println("Pintamos el segundo rectangulo:");
      System.out.println(r2);
      System.out.println("------------------------------\n");
    //System.out.println(r3);
    //System.out.println("\n------------------------------\n");
    } catch (ArithmeticException e) {
      System.err.println("Error, los valores del alto y ancho deben estar comprendidos entre 1 y 10");
    }
  }
}
