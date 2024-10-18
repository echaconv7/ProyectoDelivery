import java.util.*;
import java.util.List;

/**
 * Model the operation of a taxi company, operating different
 * delivery persons. This version operates a single type of delivery person.
 * 
 * @author Elena Chacon y Jose Antonio
 * @version 2024.10.07 DP classes
 */
public class DeliveryCompany  
{
    //nombre de la compañía
    private String name;
    
    //objetos de tipo DeliveryPerson que almacena la compañia
    private ArrayList <DeliveryPerson> deliveryPersons;
    
    //almacen de la compañia donde se almacenan los orders
    private ArrayList <Order> wareHouse;

    /**
     * Constructor for objects of class DeliveryCompany
     */
    public DeliveryCompany(String name)
    {
        this.name = name;
        this.deliveryPersons = new ArrayList <DeliveryPerson>();
        this.wareHouse = new ArrayList <Order> ();
    }

    /**
     * @return The name of the company.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The list of delivery persons.
     */
    public List<DeliveryPerson> getDeliveryPersons()
    {        
        return this.deliveryPersons;
    }

    /**
     * @return The list of orders.
     */
    public List<Order> getOrders()
    {
        return this.wareHouse;
    }

    /**
     * @param Add a new delivery person.
     */
    public void addDeliveryPerson(DeliveryPerson dp)
    {
        deliveryPersons.add(dp);
    }

    /**
     * Add a new order in the whare house of the company.
     * @param order The new order.
     */
    public void addOrder(Order order)
    {
        wareHouse.add(order); 
    }

    /**
     * Find a the most closed free delivery person to the whare house's location, if any.
     * @return A free delivery person, or null if there is none.
     */
    private DeliveryPerson getDeliveryPerson()
    {
        DeliveryPerson libre=null;
        Collections.sort(deliveryPersons, new ComparadorDistanciaAlmacenDestino());
        for (DeliveryPerson dp : deliveryPersons){
            if (dp.isFree()){
                libre = dp;
            }
        }

        return libre;
    }

    /**
     * Request a pickup for the given order.
     * @param order The order to be delivered.
     * @return Whether a free delivery person is available.
     */
    public boolean requestPickup(Order order)
    {
        //TODO implementar el método 
        return true;
    }

    /**
     * A delivery person has arrived at a pickup point.
     * @param dp The delivery person at the pickup point.
     */
    public void arrivedAtPickup(DeliveryPerson dp)
    {
        //TODO implementar el método
        //TODO Descomentar siguiente línea cuando esté el método completamente implementado
        //System.out.println("<<<< "+dp + " picks up order to " + order.getDestinationName());
        //TODO el order debe guardar el nombre de la persona de reparto que le ha recogido
        //TODO la persona de reparto debe recoger el pedido
    }

    /**
     * A delivery person has arrived at a orders's destination.
     * @param dp The delivery person at the destination.
     * @param order The order being dropped off.
     */
    public void arrivedAtDestination(DeliveryPerson dp, Order order) {
        System.out.println(dp + " delivers " + order);
    }
}