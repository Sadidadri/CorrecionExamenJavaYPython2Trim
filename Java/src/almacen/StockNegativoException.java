package almacen;

public class StockNegativoException extends Exception {
  StockNegativoException(String msj){
    super(msj);
  }
}
