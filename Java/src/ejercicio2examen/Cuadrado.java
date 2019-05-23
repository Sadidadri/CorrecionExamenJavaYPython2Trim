package ejercicio2examen;

/**
 * Clase Cuadrado, heredada de la clase Rectangulo.
 * 
 * @author d18momoa
 *
 */
public class Cuadrado extends Rectangulo implements Comparable<Cuadrado> {
  /**
   * Constructor de la clase cuadrado, solo necesita un lado que se le envia por
   * parametro y controla que este este comprendido entre 1 y 10
   * 
   * @param l: lado que se le envia por parametro
   *          
   */
  public Cuadrado(int l) {
    super(l, l);
  }

  /**
   * Constructor por defecto de la clase cuadrado, crea un cuadrado de 5x5
   */
  public Cuadrado() {
    super(5,5);
  }

  /**
   * Devuelve el valor del lado que forma al cuadrado.
   * 
   * @return lado del cuadrado
   */
  public int getLado() {
    return this.getAncho(); //Aprovechamos los getters del rectangulo(padre), por ejemplo el ancho
                            //ya que tanto ancho como alto tienen el mismo valor en el cuadrado.
  }

  /**
   * Devuelve una cadena que dibuja el cuadrado al ser imprimido en pantalla.
   */
  public String toString() {
    return super.toString();
  }

  /**
   * Clase establecida para poder comparar 2 cuadrados, e indicar cual de ellos es
   * mayor o si son iguales Devuelve un numero positivo en caso de que la instancia sea mayor.
   * Devuelve 0 si ambos cuadrados son iguales. Devuelve un numero negativo si la instancia es
   * menor.
   */
  @Override
  public int compareTo(Cuadrado other) {
    return this.getLado() - other.getLado();                          
}
