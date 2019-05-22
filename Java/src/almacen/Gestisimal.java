package almacen;

import java.util.ArrayList;

/**
 * Programa que crea y controla la lista de articulos del almacen
 * 
 * @author d18momoa
 *
 */
public class Gestisimal {
  // Creacion de la lista de articulos que alberga el almacen
  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();

  /**
   * Agnade un articulo a la lista
   * 
   * @throws StockNegativoException
   * @throws PNegativoException
   * @throws IvaInvalidoException
   * @throws @throws
   *           arraylistObjetos.StockNegativoException
   */
  public void annadirNuevoArticulo(String descripcion, double pC, double pV, int stock, Iva iva)
      throws PNegativoException, StockNegativoException, IvaInvalidoException {
    almacen.add(new Articulo(descripcion, pC, pV, stock, iva));
  }

  /**
   * Borra un articulo de la lista
   * 
   * @param codigo
   * @throws CodigoNoEncontradoException
   */
  public void borrarArticulo(int codigo) throws CodigoNoEncontradoException {
    almacen.remove(new Articulo(codigo));
  }

  /**
   * Modifica un articulo de la lista
   * 
   * @param articulo
   * @param descripcionIntroducido
   * @param precioCompraIntroducido
   * @param precioVentaIntroducido
   * @param stockIntroducido
   * @throws CodigoNoEncontradoException
   * @throws StockNegativoException
   * @throws PNegativoException
   * @throws IvaInvalidoException
   */
  public void modificar(Articulo articulo, String descripcionIntroducido, double precioCompraIntroducido,
      double precioVentaIntroducido, int stockIntroducido, Iva ivaIntroducido)
      throws CodigoNoEncontradoException, StockNegativoException, PNegativoException, IvaInvalidoException {
    articulo.modifica(descripcionIntroducido, precioCompraIntroducido, precioVentaIntroducido, stockIntroducido,
        ivaIntroducido);
  }

  /**
   * Aumenta el stock de un articulo de la lista
   * 
   * @param codigo
   * @param cantidad
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   * @throws ArticuloNoExistenteException 
   */
  public void entraMercancia(int codigo, int cantidad) throws StockNegativoException, MercanciaNegativaException, ArticuloNoExistenteException {
    get(codigo).entraMercancia(cantidad);
  }

  /**
   * Decrementa el stock de un articulo de la lista
   * 
   * @param codigo
   * @param cantidad
   * @throws ArticuloNoExistenteException 
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   */
  public void saleMercancia(int codigo, int cantidad) throws StockNegativoException, MercanciaNegativaException, ArticuloNoExistenteException{
    get(codigo).saleMercancia(cantidad);
  }

  /**
   * Devuelve el articulo que contenga el codigo introducido por parametro.
   * 
   * @param codigoIntroducido
   * @return
   * @throws ArticuloNoExistenteException 
   */
  public Articulo get(int codigoIntroducido) throws ArticuloNoExistenteException {
    try {
      return almacen.get(almacen.indexOf(new Articulo(codigoIntroducido)));
    }catch(IndexOutOfBoundsException e) {
      throw new ArticuloNoExistenteException("El articulo no existe.");
    }
  }
  /**
   * Muestra el contenido de la lista.
   */
  @Override
  public String toString() {
    //String cadena = "";
    //for (Articulo a : almacen) {
    //  cadena += "-" + a + "\n";
    //}
    //return cadena;
    return ""+almacen;
  }
}
