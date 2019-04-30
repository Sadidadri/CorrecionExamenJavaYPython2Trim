package almacen;

import excepciones.AlmacenVacioException;
import excepciones.CodigoNoEncontradoException;
import excepciones.IvaInvalidoException;
import excepciones.MercanciaNegativaException;
import excepciones.PNegativoException;
import excepciones.StockNegativoException;
import utiles.Menu;
import utiles.Teclado;

/**
 * Programa que se encarga de la gestion de un almacen
 * 
 * @author d18momoa
 *
 */
public class TestAlmacen {
  // Creacion de los elementos estaticos de la clase Test
  static Gestisimal almacen = new Gestisimal();

  public static void main(String[] args) {
    Menu menu = new Menu("Bienvenido al menu Gestisimal:",
        new String[] { "Listado", "Alta", "Baja", "Modificacion", "Entrada de mercancia", "Salida de mercancia" });

    int opcion = 0;
    do {
      opcion = menu.gestionar(); // Pide al usuario introducir un numero para escoger la opcion
      try {
        switch (opcion) {
        case 1: // Muestra el almacen
          mostrarLista();
          break;
        case 2: // Agnade un elemento a la lista
          System.out.println("Vamos a dar de alta un articulo, rellene los siguientes datos:");
          annadirArticulo();
          break;
        case 3: // borra un elemento de la lista
          borrarArticulo();
          System.out.println("##Borrado finalizado##");
          break;
        case 4: // Modifica un elemento de la lista
          modificarArticulo();
          System.out.println("##Modificado satisfactoriamente##");
          break;
        case 5: // Aumenta el stock de un elemento de la lista
          entraMercancia();
          break;
        case 6: // Decrementa el stock de un elemento de la lista
          saleMercancia();
          break;
        default:
          System.out.println("Saliendo...");// 7.Salir
          break;
        }
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
    } while (opcion != menu.getSalir());

  }

  /**
   * Mediante un menu, el usuario elige el tipo de Iva que asignara al producto,
   * en caso de pulsar salir, el iva sera null y lanzara una excepcion que lo
   * mandara al menu principal
   * 
   * @return tipo de iva elegido.
   */
  public static Iva elegirIva() {
    Menu menuIva = new Menu("Elija el tipo de iva:", new String[] { "General", "Reducido", "Superreducido" });
    int opcion = 0;
    Iva ivaElegido;

    opcion = menuIva.gestionar(); // Pide al usuario introducir un numero para escoger la opcion
    switch (opcion) {
    case 1:
      ivaElegido = Iva.GENERAL;
      break;
    case 2:
      ivaElegido = Iva.REDUCIDO;
      break;
    case 3:
      ivaElegido = Iva.SUPERREDUCIDO;
      break;
    default:
      ivaElegido = null;
      System.out.println("Volviendo al menu principal...");
      break;
    }

    return ivaElegido;
  }

  /**
   * Muestra el contenido del almacen
   * 
   * @throws AlmacenVacioException
   */
  public static void mostrarLista() throws AlmacenVacioException {
    almacen.compruebaSiEstaVacio();
    System.out.println("Tenemos:");
    System.out.println(almacen);
  }

  /**
   * Registra un articulo nuevo al almacen pidiendole los datos al usuario
   * 
   * @throws PNegativoException
   * @throws StockNegativoException
   * @throws IvaInvalidoException
   */
  public static void annadirArticulo() throws PNegativoException, StockNegativoException, IvaInvalidoException {
    String descripcion = Teclado.leerCadena("Introduzca nombre del producto:");
    double pC = Teclado.leerDecimal("Precio de Compra:");
    double pV = Teclado.leerDecimal("Precio de Venta:");
    int stock = Teclado.leerEntero("Stock");
    Iva iva = elegirIva();
    almacen.annadirNuevoArticulo(descripcion, pC, pV, stock, iva);
  }

  /**
   * Borra un articulo mediante el codigo indicado por el usuario
   * 
   * @throws CodigoNoEncontradoException
   * @throws AlmacenVacioException
   */
  public static void borrarArticulo() throws CodigoNoEncontradoException, AlmacenVacioException {
    almacen.compruebaSiEstaVacio();
    int code = Teclado.leerEntero("Introduzca el codigo del articulo a borrar:");
    almacen.borrarArticulo(code);
  }

  /**
   * Modifica el contenido de un articulo ya existente
   * 
   * @throws AlmacenVacioException
   * @throws CodigoNoEncontradoException
   * @throws StockNegativoException
   * @throws PNegativoException
   * @throws IvaInvalidoException
   */
  public static void modificarArticulo() throws AlmacenVacioException, CodigoNoEncontradoException,
      StockNegativoException, PNegativoException, IvaInvalidoException {
    almacen.compruebaSiEstaVacio();

    System.out.println("Introduzca el codigo del articulo a modificar:");
    int code = Teclado.leerEntero();

    if (almacen.compruebaCodigo(code)) {
      Articulo articulo = almacen.get(code);
      // Muestra el articulo a modificar
      System.out.println("Este es el articulo a modificar:");
      System.out.println(articulo);
      System.out.println("Introduzca los datos del producto.");
      String descripcionNueva = Teclado.leerCadena("Descripcion:");
      double pCompraNuevo = Teclado.leerDecimal("Precio de Compra:");
      double pVentaNuevo = Teclado.leerDecimal("Precio de Venta:");
      int stockNuevo = Teclado.leerEntero("Stock");
      Iva ivaNuevo = elegirIva();
      almacen.modificar(articulo, descripcionNueva, pCompraNuevo, pVentaNuevo, stockNuevo, ivaNuevo);

    }
  }

  /**
   * Aumenta el stock de un articulo cuyo codigo es indicado por el usuario
   * 
   * @throws AlmacenVacioException
   * @throws CodigoNoEncontradoException
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   */
  public static void entraMercancia()
      throws AlmacenVacioException, CodigoNoEncontradoException, StockNegativoException, MercanciaNegativaException {
    almacen.compruebaSiEstaVacio();

    int code = Teclado.leerEntero("Vamos a aumentar el stock, indique el codigo del articulo:");
    if (almacen.compruebaCodigo(code)) {
      int cantidad = Teclado.leerEntero("Indique la cantidad a aumentar:");
      almacen.entraMercancia(code, cantidad);

    }
  }

  /**
   * Decrementa el stock de un articulo cuyo codigo es indicado por el usuario
   * 
   * @throws AlmacenVacioException
   * @throws CodigoNoEncontradoException
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   */
  public static void saleMercancia()
      throws AlmacenVacioException, CodigoNoEncontradoException, StockNegativoException, MercanciaNegativaException {
    almacen.compruebaSiEstaVacio();
    int code = Teclado.leerEntero("Vamos a disminuir el stock, indique el codigo del articulo:");
    if (almacen.compruebaCodigo(code)) {
      int cantidad = Teclado.leerEntero("Indique la cantidad a disminuir:");
      almacen.saleMercancia(code, cantidad);
    }
  }
}
