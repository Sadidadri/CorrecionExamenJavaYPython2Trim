package excepciones;
/**
 * Excepcion que es lanzada cuando el iva es nulo. Muestra el mensaje de error con
 * la cadena implementada por parametro.
 * @author d18momoa
 *
 */
public class IvaInvalidoException extends Exception {
  public IvaInvalidoException(String msj){
    super(msj);
  }
}
