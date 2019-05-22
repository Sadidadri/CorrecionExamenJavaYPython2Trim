package almacen;

public class ArticuloNoExistenteException extends Exception {
  ArticuloNoExistenteException(String msj){
    super(msj);
  }
}
