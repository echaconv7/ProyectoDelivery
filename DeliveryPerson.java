/**
 * Model the common elements of delivery persons.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class DeliveryPerson 
{
    // The Delivery Company of this DeliveryPerson.
    private DeliveryCompany company;
    // Where the person is.
    private Location location;
    // Where the person is headed.
    private  Location targetLocation;
    // Record how often the person has nothing to do.
    private int idleCount;
    //name of the delivery person
    private String name;
    // pedido de la persona
    private Order order;
    // pedidos entregados
    private int ordersDelivered;

    /**
     * Constructor of class DeliveryPerson
     * @param company The delivery person's company. Must not be null.
     * @param location The delivery person's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public DeliveryPerson(DeliveryCompany company, Location location, String name)
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
        this.company = company;
        this.location = location;
        this.name=name;
        this.order=null;
        targetLocation = null;
        idleCount = 0;
        ordersDelivered=0;
    }

    /**
     * @return the name of the delivery person
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the location.
     * @return Where this delivery person is currently located.
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Get the order
     * @return Obtiene el pedido
     */
    public Order getOrder()
    {
        return order;
    }
    
    /**
     * Borra el pedido
     */
    private void clearOrder()
    {
        this.order=null;
    }
    
    /**
     * Set Order
     *  @param order
     */
    public void setOrder(Order order)
    {
        this.order=order;
    }
    

    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Get the target location.
     * @return Where this delivery person is currently headed, or null
     *         if it is idle.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }

    /**
     * Set the required target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }
    
    /**
     * Comprueba que la posicion en la cual estoy sea igual a la de destino
     * @return devuelve si la posicion en la cual estoy sea igual a la de destino
     */
    public boolean hasArriveToLocationTarget(){
        return getLocation().equals(targetLocation);
    }

    /**
     * Receive a pickup location. This becomes the
     * target location.
     * @param location The pickup location.
     */
    public void setPickupLocation(Location location)
    {   
        setTargetLocation(location);
    }

    /**
     * Has the delivery person a target Location?
     * @return Whether or not this delivery person has a target Location.
     */
    public boolean hasTargetLocation(){
        return getTargetLocation() != null;
    }

    /**
     * Clear the target location.
     */
    public void clearTargetLocation()
    {
        targetLocation = null;
    }

    /**
     * @return on how many steps this delivery person has been idle.
     */
    public int getIdleCount()
    {
        return idleCount;
    }

    /**
     * Increment the number of steps on which this delivery person
     * has been idle.
     */
    public void incrementIdleCount()
    {
        idleCount++;
    }

    /**
     * Return details of the delivery person, such as where he/she is.
     * @return A string representation of the delivery person.
     */
    public String toString()
    {
        return "DeliveryPerson "+getName()+" at location "+getLocation().getX()+","+getLocation().getY();
    }

    /**
     * Is the delivery person free?
     * @return Whether or not this delivery person is free.
     */
    public boolean isFree()
    {
        return getOrder()==null;
    }

    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        company.arrivedAtPickup(this);
    }

    /**
     * Notify the company of our arrival at an order's destination.
     */
    public void notifyOrderArrival(Order order)
    {
        company.arrivedAtDestination(this,order);
    }

    /**
     * Receive an order.
     * Set order's destination as its target location.
     * @param order The order.
     */
    public void pickup(Order order)
    {
        this.order=order;        
        order.setDeliveryPersonName(getName());
        setTargetLocation(order.getDestination());
    }

    /**
     * Deliver the order.
     */
    public void deliverOrder()
    {
        clearTargetLocation();
        clearOrder();
        ordersDelivered++;
    }

    /**
     * @return how many orders this delivery person has delivered.
     */
    public int ordersDelivered()
    {
        return ordersDelivered;
    }

    /**
     * Increment the number of orders this delivery person has delivered.
     */
    protected void incrementOrdersDelivered()
    {
       ordersDelivered++;
    }

    /**
     * Get the distance to the target location from the current location.
     * @return distance to target location.
     */
    public int distanceToTheTargetLocation()
    {
        return getLocation().distance(getTargetLocation());
    }

    /**
     * Move to next location
     */
    public void moveToNextLocation(){
        Location nextLocation = getLocation().nextLocation(getTargetLocation());
        setLocation(nextLocation);
        System.out.println("@@@  DeliveryPerson: "+getName()+" moving to: "+getLocation().getStringConcatenateLocation());
    }
    
    /**
     * Carry out a delivery person's actions.
     */
    public void act()
    {
        if(getTargetLocation()==null){
            incrementIdleCount();
        }else{
            moveToNextLocation();
            
            if(hasArriveToLocationTarget() && isFree()){
                notifyPickupArrival();
            }else if(hasArriveToLocationTarget() && !isFree()){
                notifyOrderArrival(this.getOrder());
                deliverOrder();
            }
        }
    }
 
    /**
     * Return details of the delivery person, such as the name, the location,
     * number of delivered orders and time (steps) without moving.
     * @return A string representation of the delivery person.
     */
    public String showFinalInfo()
    {
        return "DeliveryPerson "+getName()+" at location "+location.getX()+","+location.getY()+" - orders delivered: "+ordersDelivered()+" - non active for: "+getIdleCount()+" times";

    }
    
}
