import java.util.*;

/**
 * Almacen de orders WareHouse
 * 
 * @author Jose Antonio Ramos Barragan
 * @version 1.0.0
 */
public class WareHouse
{
    private Location location;
    private List<Order> orders;

    /**
     * Constructor for objects of class WareHouse
     */
    public WareHouse()
    {
        location = new Location(5,5); // FIJA PARA PRIMERA ENTREGA
        orders=new ArrayList<>();
    }
    
    /**
     * Constructor for objects of class WareHouse
     */
    public WareHouse(List<Order> orders)
    {
        this();
        this.orders=orders;
        orders.sort(new ComparadorTimeAndSendingName());
    }
    
   /**
     * Annade una nueva order y ordena la lista
     */
    public void addOrder(Order order){
        orders.add(order);
        orders.sort(new ComparadorTimeAndSendingName());
    }
    
    /**
     * Obtiene la order por indice de un WareHouse
     * @param      indice
     * @return     la order
     */
    public Order getOrder(int index)
    {
        return this.orders.get(index);
    }
    
    /**
     * Obtiene la lista entera del wareHouse
     * @return     la lista de orders
     */
    public List<Order> getOrders()
    {
        return this.orders;
    }
    
     /**
     * Borra un pedido
     */
    public void removeOrder(Order order){
        orders.remove(order);
    }
    
    /**
     * Obtiene la localizacion
     * 
     * @return     la localizacion
     */
    public Location getLocation()
    {
        return this.location;
    }
}
