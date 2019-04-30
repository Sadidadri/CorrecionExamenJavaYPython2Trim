package almacen;

import java.util.ArrayList;

import excepciones.AlmacenVacioException;
import excepciones.CodigoNoEncontradoException;
import excepciones.IvaInvalidoException;
import excepciones.MercanciaNegativaException;
import excepciones.PNegativoException;
import excepciones.StockNegativoException;

/**
 * Programa que crea y controla la lista de articulos del almacen
 * 
 * @author d18momoa
 *
 */
public class Gestisimal {
  // Creacion de la lista de articulos que alberga el almacen
  private ArrayList<Articulo> lista = new ArrayList<Articulo>();

  /**
   * Agnade un articulo a la lista
   * 
   * @throws StockNegativoException
   * @throws PNegativoException
   * @throws IvaInvalidoException 
   * @throws @throws
   *           arraylistObjetos.StockNegativoException
   */
  void annadirNuevoArticulo(String descripcion, double pC, double pV, int stock,Iva iva)
      throws PNegativoException, StockNegativoException, IvaInvalidoException {
    lista.add(new Articulo(descripcion, pC, pV, stock,iva));
  }

  /**
   * Borra un articulo de la lista
   * 
   * @param codigo
   * @throws CodigoNoEncontradoException
   */
  void borrarArticulo(int codigo) throws CodigoNoEncontradoException {
    if (compruebaCodigo(codigo)) {
      lista.remove(obtenerIndice(codigo));
    }
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
      double precioVentaIntroducido, int stockIntroducido,Iva ivaIntroducido)
      throws CodigoNoEncontradoException, StockNegativoException, PNegativoException, IvaInvalidoException {
    articulo.modifica(descripcionIntroducido, precioCompraIntroducido, precioVentaIntroducido, stockIntroducido,ivaIntroducido);
  }

  /**
   * Aumenta el stock de un articulo de la lista
   * 
   * @param codigo
   * @param cantidad
   * @throws CodigoNoEncontradoException
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   */
  void entraMercancia(int codigo, int cantidad)
      throws CodigoNoEncontradoException, StockNegativoException, MercanciaNegativaException {
    if (compruebaCodigo(codigo)) {
      Articulo articulo = lista.get(obtenerIndice(codigo));
      articulo.entraMercancia(cantidad);
    }
  }

  /**
   * Decrementa el stock de un articulo de la lista
   * 
   * @param codigo
   * @param cantidad
   * @throws CodigoNoEncontradoException
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   */
  void saleMercancia(int codigo, int cantidad)
      throws CodigoNoEncontradoException, StockNegativoException, MercanciaNegativaException {
    if (compruebaCodigo(codigo)) {
      Articulo articulo = lista.get(obtenerIndice(codigo));
      articulo.saleMercancia(cantidad);
    }
  }

  /**
   * Devuelve el articulo que contenga el codigo introducido por parametro.
   * 
   * @param codigoIntroducido
   * @return
   */
  public Articulo get(int codigoIntroducido) {
    Articulo articulo = lista.get(lista.indexOf(new Articulo(codigoIntroducido)));
    return articulo;
  }

  /**
   * Obtiene el indice del articulo cuyo codigo es introducido por parametro.
   * 
   * @param codigo
   * @return
   */
  int obtenerIndice(int codigo) {
    int indice = -1;
    for (Articulo a : lista) {
      if (a.getCodigo() == codigo) {
        indice = lista.indexOf(a);
      }
    }
    return indice;
  }

  /**
   * Metodo que recibe un codigo por parametro y comprueba si esta en la lista de
   * articulos.
   * 
   * @param code
   * @return
   * @throws CodigoNoEncontradoException
   */
  boolean compruebaCodigo(int code) throws CodigoNoEncontradoException {
    boolean codigoEncontrado = false;
    for (Articulo a : lista) {
      if (a.getCodigo() == code) {
        codigoEncontrado = true;
      }
    }
    if (!codigoEncontrado) {
      throw new CodigoNoEncontradoException("El codigo introducido no existe");
    }
    return codigoEncontrado;
  }

  /**
   * Metodo que comprueba si la lista esta vacia
   * 
   * @return
   * @throws AlmacenVacioException 
   */
  void compruebaSiEstaVacio() throws AlmacenVacioException {
    if(lista.isEmpty()) {
      throw new AlmacenVacioException("El almacen esta vacio, no hay elementos a mostrar");
    }
  }

  /**
   * Muestra el contenido de la lista.
   */
  @Override
  public String toString() {
    String cadena = "";
    for (Articulo a : lista) {
      cadena += "-" + a + "\n";
    }
    return cadena;
  }
}
