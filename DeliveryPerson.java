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
    public DeliveryCompany company;   //TODO cambiar a private
    // Where the person is.
    public Location location;     //TODO cambiar a private
    // Where the person is headed.
    public  Location targetLocation;   //TODO cambiar a private
    // Record how often the person has nothing to do.
    public int idleCount;       //TODO cambiar a private
    //name of the delivery person
    public String name; //TODO cambiar a private
    //TODO añadir campos necesarios

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
        targetLocation = null;
        idleCount = 0;
        //TODO resto de inicializaciones pendientes
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
        return getClass().getName() + " " +getName()+" at " + getLocation();
    }

    /**
     * Is the delivery person free?
     * @return Whether or not this delivery person is free.
     */
    public boolean isFree()
    {
        //TODO  implementar este método
        return true;
    }

    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        //TODO  implementar este método
    }

    /**
     * Notify the company of our arrival at an order's destination.
     */
    public void notifyOrderArrival(Order order)
    {
        //TODO  implementar este método
    }

    /**
     * Receive an order.
     * Set order's destination as its target location.
     * @param order The order.
     */
    public void pickup(Order order)
    {
        //TODO  implementar este método

    }

    /**
     * Deliver the order.
     */
    public void deliverOrder()
    {
        //TODO  implementar este método
    }

    /**
     * @return how many orders this delivery person has delivered.
     */
    public int ordersDelivered()
    {
        //TODO  implementar este método
        return 1;
    }

    /**
     * Increment the number of orders this delivery person has delivered.
     */
    protected void incrementOrdersDelivered()
    {
        //TODO  implementar este método
    }

    /**
     * Get the distance to the target location from the current location.
     * @return distance to target location.
     */
    public int distanceToTheTargetLocation()
    {
        //TODO  implementar este método
        return 1;

    }

    /**
     * Carry out a delivery person's actions.
     */
    public void act()
    {
        //TODO  implementar este método
    }
 
    /**
     * Return details of the delivery person, such as the name, the location,
     * number of delivered orders and time (steps) without moving.
     * @return A string representation of the delivery person.
     */
    public String showFinalInfo()
    {
        //TODO  implementar este método
        return "";

    }

}
