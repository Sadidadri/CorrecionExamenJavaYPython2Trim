package almacen;
/**
 * Programa que se encarga de crear los articulos y que luego seran registrados
 * dentro de la lista del almacen
 * 
 * @author d18momoa
 *
 */
public class Articulo {
  // Atributos
  private static int contador = 0;
  private int codigo;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int stock;
  private Iva iva;

  // Constructor principal
  public Articulo(String descripcion, double precioCompra, double precioVenta, int stock, Iva iva)
      throws PNegativoException, StockNegativoException, IvaInvalidoException {
    this.codigo = generarCodigo();
    this.descripcion = descripcion;
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setStock(stock);
    setIva(iva);
  }

  // Constructor para comparar codigo
  Articulo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * Aumenta una unidad del contador y la devuelve.
   * 
   * @return la unidad aumentada.
   */
  private int generarCodigo() {
    contador++;
    return contador;
  }

  /**
   * Devuelve el valor actual del iva
   * 
   * @return
   */
  public Iva getIva() {
    return iva;
  }

  /**
   * Establece el valor del IVA, controla que este no sea null
   * @param iva: valor de iva
   * @throws IvaInvalidoException: Excepcion lanzada si este es null
   */
  private void setIva(Iva iva) throws IvaInvalidoException {
    if (iva == null) {
      throw new IvaInvalidoException("Error, el iva no puede ser null");
    }
    this.iva = iva;
  }

  /**
   * Obtiene valor de codigo
   * 
   * @return valor de codigo
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * Obtiene el contenido de la descripcion
   * 
   * @return cadena de descripcion
   */
  private String getDescripcion() {
    return descripcion;
  }

  /**
   * Obtiene valor del precio de compra
   * 
   * @return valor del precio de compra
   */
  private double getPrecioCompra() {
    return precioCompra;
  }

  /**
   * Obtiene valor del precio de venta
   * 
   * @return valor del precio de venta
   */
  public double getPrecioVenta() {
    return precioVenta;
  }

  /**
   * Obtiene la cantidad de stock
   * 
   * @return cuanto hay de stock
   */
  public int getStock() {
    return stock;
  }

  /**
   * Establece el valor del precio de compra, controla que no sea negativo, en ese
   * caso lanza una excepcion
   * 
   * @param pv
   * @throws PVentaNegativoException
   */
  private void setPrecioVenta(double pv) throws PNegativoException {
    if (pv < 0) {
      throw new PNegativoException("Error, el precio de venta no puede ser negativo");
    } 
    this.precioVenta = pv;
  }

  /**
   * Establece el valor del precio de venta, controla que no sea negativo, en ese
   * caso lanza una excepcion
   * 
   * @param pc
   */
  private void setPrecioCompra(double pc) throws PNegativoException {
    if (pc < 0) {
      throw new PNegativoException("Error, el precio de compra no puede ser negativo");
    }
    this.precioCompra = pc;
  }

  /**
   * Establece la cantidad de stock, controla que no sea negativo, en ese caso
   * lanza una excepcion
   * 
   * @param s
   * @throws StockNegativoException
   */
  private void setStock(int s) throws StockNegativoException {
    if (s < 0) {
      throw new StockNegativoException("Error, el stock no puede ser inferior a 0");
    }
    this.stock = s;
  }

  /**
   * Entra mercancia, el stock del articulo aumenta en las unidades especificadas
   * 
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   */
  public void entraMercancia(int cantidad) throws StockNegativoException, MercanciaNegativaException {
    if (cantidad <= 0) {
      throw new MercanciaNegativaException("Error, no puedes agnadir un stock negativo");  
    }
    setStock(getStock() + cantidad);
  }

  /**
   * Sale mercancia, el stock del articulo decrementa en las unidades
   * especificadas
   * 
   * @throws StockNegativoException
   * @throws MercanciaNegativaException
   */
  public void saleMercancia(int cantidad) throws StockNegativoException, MercanciaNegativaException {
    if (cantidad <= 0)
      throw new MercanciaNegativaException("Error, no puede salir mercancia negativa");
    else
    setStock(getStock() - cantidad);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
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
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  /**
   * Modifica los atributos del articulo excepto el codigo
   * 
   * @param descripcionIntroducido
   * @param precioCompraIntroducido
   * @param precioVentaIntroducido
   * @param stockIntroducido
   * @param ivaIntroducido
   * @throws StockNegativoException
   * @throws PNegativoException
   * @throws IvaInvalidoException 
   */
  void modifica(String descripcionIntroducido, double precioCompraIntroducido, double precioVentaIntroducido,
      int stockIntroducido,Iva ivaIntroducido) throws StockNegativoException, PNegativoException, IvaInvalidoException {
    this.descripcion = descripcionIntroducido;
    setPrecioCompra(precioCompraIntroducido);
    setPrecioVenta(precioVentaIntroducido);
    setStock(stockIntroducido);
    setIva(ivaIntroducido);
  }

  /**
   * Metodo toString de articulo
   */
  public String toString() {
    return getDescripcion() + ": Codigo: " + getCodigo() + " | Precio Compra: " + getPrecioCompra() + " euro/s | PVP: "
        + getPrecioVenta() + " euro/s | Stock: " + getStock() + " | Iva: "+getIva()+" |\n";
  }
}
