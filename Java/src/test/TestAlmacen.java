package test;

import almacen.ArticuloNoExistenteException;
import almacen.Gestisimal;
import almacen.Iva;
import almacen.IvaInvalidoException;
import almacen.MercanciaNegativaException;
import almacen.PNegativoException;
import almacen.StockNegativoException;
import utiles.*;

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
      try {
        opcion = menu.gestionar(); // Pide al usuario introducir un numero para escoger la opcion
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
          break;
        case 4: // Modifica un elemento de la lista
          modificarArticulo();
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

    opcion = menuIva.gestionar();

    // Pide al usuario introducir un numero para escoger la opcion
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
  public static void mostrarLista() {
    System.out.println(almacen);
  }

  /**
   * Registra un articulo nuevo al almacen pidiendole los datos al usuario
   * 
   * @throws PNegativoException
   * @throws StockNegativoException
   * @throws IvaInvalidoException
   */
  public static void annadirArticulo() throws PNegativoException {
    try {
      almacen.annadirNuevoArticulo(Teclado.leerCadena("Introduzca nombre del producto:"), Teclado.leerDecimal("Precio de Compra:")
          , Teclado.leerDecimal("Precio de Venta:"), Teclado.leerEntero("Stock"), elegirIva());
      System.out.println("##Articulo agnadido satisfactoriamente.##");
    }catch(IvaInvalidoException | StockNegativoException e) {
      System.err.println(e.getMessage()+" No ha sido posible agnadir el articulo.");
    }

  }

  /**
   * Borra un articulo mediante el codigo indicado por el usuario
   * @throws ArticuloNoExistenteException 
   * 
   * @throws CodigoNoEncontradoException
   * @throws AlmacenVacioException
   */
  public static void borrarArticulo() throws ArticuloNoExistenteException {

      int code = Teclado.leerEntero("Introduzca el codigo del articulo a borrar:");
      if(almacen.get(code) != null) {
        almacen.borrarArticulo(code);
        System.out.println("##Borrado finalizado##");
      }else {
        System.err.println("Ese articulo no existe.");
      }

  }

  /**
   * Modifica el contenido de un articulo ya existente
   * @throws ArticuloNoExistenteException 
   * 
   * @throws AlmacenVacioException
   * @throws CodigoNoEncontradoException
   * @throws StockNegativoException
   * @throws PNegativoException
   * @throws IvaInvalidoException
   */
  public static void modificarArticulo() throws ArticuloNoExistenteException, PNegativoException{
    try {
      int code = Teclado.leerEntero("Introduzca el codigo del articulo a modificar:");
      System.out.println(almacen.get(code));
      almacen.modificar(almacen.get(code),Teclado.leerCadena("Descripcion:"), Teclado.leerDecimal("Precio de Compra:"), 
          Teclado.leerDecimal("Precio de Venta:"), Teclado.leerEntero("Stock"), elegirIva());
      System.out.println("##Modificado satisfactoriamente##");
    }catch(StockNegativoException |IvaInvalidoException e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * Aumenta el stock de un articulo cuyo codigo es indicado por el usuario
   * @throws ArticuloNoExistenteException 
   * 
   * @throws AlmacenVacioException
   * @throws CodigoNoEncontradoException
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   */
  public static void entraMercancia() throws StockNegativoException, ArticuloNoExistenteException{
    try {
      almacen.entraMercancia(Teclado.leerEntero("Vamos a aumentar el stock, indique el codigo del articulo:"), 
          Teclado.leerEntero("Cuantas unidades entran?:"));
      System.out.println("##Stock aumentado##");
    }catch(MercanciaNegativaException e){
      System.err.println(e.getMessage());
    }
  }

  /**
   * Decrementa el stock de un articulo cuyo codigo es indicado por el usuario
   * @throws ArticuloNoExistenteException 
   * 
   * @throws AlmacenVacioException
   * @throws CodigoNoEncontradoException
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   */
  public static void saleMercancia() throws StockNegativoException,ArticuloNoExistenteException {
    try {
      almacen.saleMercancia(Teclado.leerEntero("Vamos a disminuir el stock, indique el codigo del articulo:"),
          Teclado.leerEntero("Cuantas unidades salen?:"));
      System.out.println("##Stock disminuido##");
    }catch(MercanciaNegativaException e){
      System.err.println(e.getMessage());
    }
  }
}
