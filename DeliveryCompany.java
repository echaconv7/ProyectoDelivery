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
    private WareHouse wareHouse;

    /**
     * Constructor for objects of class DeliveryCompany
     */
    public DeliveryCompany(String name)
    {
        this.name = name;
        this.deliveryPersons = new ArrayList <DeliveryPerson>();
        this.wareHouse = new WareHouse();
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
        return this.wareHouse.getOrders();
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
        wareHouse.addOrder(order); 
    }

    /**
     * Find a the most closed free delivery person to the whare house's location, if any.
     * @return A free delivery person, or null if there is none.
     */
    public DeliveryPerson getDeliveryPerson()
    {
        boolean encontrado=false;
        DeliveryPerson libre=null;
        Collections.sort(deliveryPersons, new ComparadorDistanciaTargetBetweenDeliveriesPersonsAndName(getlocationWareHouse()));
        for (int i=0; i<deliveryPersons.size() && !encontrado; i++){
            DeliveryPerson actualDeliveryPerson=deliveryPersons.get(i);
            if (actualDeliveryPerson.isFree() && !actualDeliveryPerson.hasTargetLocation()){
                libre = deliveryPersons.get(i);
                encontrado=true;
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
        DeliveryPerson personaLibre = getDeliveryPerson();
        boolean request;
        if (personaLibre != null){
            Location locationAlmacen = getlocationWareHouse();
            personaLibre.setPickupLocation(locationAlmacen);
            
            System.out.println("<<<< DeliveryPerson "+personaLibre.getName()+
            " at location "+personaLibre.getLocation().getX()+","+personaLibre.getLocation().getY()+
            " go to pick up order from "+order.getSendingName()+" at location "+personaLibre.getTargetLocation().getX()
            +","+personaLibre.getTargetLocation().getY());

            request = true;
        }
        else {
            request=false;
        }
        return request;
    }

    /**
     * A delivery person has arrived at a pickup point.
     * @param dp The delivery person at the pickup point.
     */
    public void arrivedAtPickup(DeliveryPerson dp)
    {
        //Obtiene el primer envio que no esté ocupado
        Order order = getOrders().stream().filter(orderIteration->orderIteration.getDeliveryPersonName()==null).findFirst().orElse(null);
        if (dp.hasArriveToLocationTarget()){
            dp.pickup (order);
            //wareHouse.removeOrder(order);
            System.out.println("<<<< "+dp + " picks up Order from "+dp.getOrder().getSendingName()+" to: " + dp.getTargetLocation());
        }
        
    }

    /**
     * A delivery person has arrived at a orders's destination.
     * @param dp The delivery person at the destination.
     * @param order The order being dropped off.
     */
    public void arrivedAtDestination(DeliveryPerson dp, Order order) {
        if (dp.hasArriveToLocationTarget()){
            System.out.println("<<<< DeliveryPerson "+dp.getName()+" at location "+dp.getLocation().getX()+","+dp.getLocation().getY()+" delivers Order at: "+order.getDeliveryTime()
            +" from: "+order.getSendingName()+" to: "+order.getDestinationName());
        }
    }
    
     /**
     * obtener la localizacion del wareHouse
     * @return localizacion del wareHouse
     */
    public Location getlocationWareHouse(){
        return this.wareHouse.getLocation();
    }
    
}