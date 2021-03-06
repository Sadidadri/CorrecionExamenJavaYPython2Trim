package ejercicio2examen;
/**
 * Clase Rectangulo del Ejercicio 2 del examen de Java. Crea un rectangulo con
 * dimensiones entre 1 y 10, y con el metodo toString se dibuja.
 * 
 * @author d18momoa
 *
 */
public class Rectangulo{
  private int ancho;
  private int alto;
  /**
   * Constructor que crea la clase rectangulo.
   * @param anc el ancho que recibe por parametro
   * @param alt el alto que recibe por parametro
   */
  public Rectangulo(int anc, int alt) {
    setAncho(anc);
    setAlto(alt);
  }
  /**
   * Constructor por defecto, crea un rectangulo con base 4 y altura 3
   */
  public Rectangulo() {
    setAncho(4);
    setAlto(3);
  }
  /**
   * Devuelve el valor actual del ancho del rectangulo
   * @return ancho del rectangulo
   */
  public int getAncho() {
    return ancho;
  }
  /**
   * Establece el valor del ancho, controla que estos valores esten comprendidos 
   * entre 1 y 10, en caso contrario lanzara la excepcion ArithmeticException.
   * @param ancho
   */
  protected void setAncho(int ancho) {
    if (ancho <= 0 || ancho > 10) {
      throw new ArithmeticException();
    } else {
      this.ancho = ancho;
    }
  }
  /**
   * Devuelve el valor actual del alto del rectangulo
   * @return alto del rectangulo
   */
  public int getAlto() {
    return alto;
  }
 /**
  * Establece el valor del alto, controla que estos valores esten comprendidos 
  * entre 1 y 10, en caso contrario lanzara la excepcion ArithmeticException.
  * @param ancho
  */
  protected void setAlto(int alto) {
    if (alto <= 0 || alto > 10) {
      throw new ArithmeticException();
    } else {
      this.alto = alto;
    }
  }
  /**
   * Devuelve en una cadena de texto el rectangulo pintado, de manera que al mostrarlo
   * en pantalla, muestre esa representacion grafica.
   */
  public String toString() {
    int i, espacios;
    String resultado = "";
    for (i = 0; i < this.ancho; i++) {
      resultado += "*";
    }
    resultado += "\n";
    for (i = 1; i < this.alto - 1; i++) {
      resultado += "*";
      for (espacios = 1; espacios < this.ancho - 1; espacios++) {
        resultado += " ";
      }
      resultado += "*\n";
    }
    for (i = 0; i < this.ancho; i++) {
      resultado += "*";
    }
    resultado += "\n";
    return resultado;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + alto;
    result = prime * result + ancho;
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Rectangulo other = (Rectangulo) obj;
    if (alto != other.alto)
      return false;
    if (ancho != other.ancho)
      return false;
    return true;
  }
}
