/**
 * Model an order to be delivered from one
 * location to another.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class Order
{
    //declarar campo sendingName
    private Location location;
    private Location destination;
    //declarar campo deliveryTime
    //declarar campo weight
    //declarar campo destinationName
    private String deliveryPersonName;
    
    /**
     * Constructor for objects of class Order
     * @param sendingName The sender's name.
     * @param location The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param deliveryTime The hour of delivery.
     * @param weight  The order's weight
     * @param destinationName The name of the person receiving the order.
     * @throws NullPointerException If either location is null.
     */
    public Order(String sendingName, Location location, Location destination, int deliveryTime, 
    double weight, String destinationName)
    {
        //TODO modificar el constructor o crear otro constructor si necesario
        if(location == null) {
            throw new NullPointerException("Location location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.location = location;
        this.destination = destination;
        //incluir inicialización del resto de campos
    }

    /**
     * @return The name of the delivery person.
     */
    public String getDeliveryPersonName()
    {
    //TODO Debe poder devolver el nombre de la persona de reparto.
    return "";
    }

    /**
     * Set the new name of the delivery person.
     * @param The new name of the delivery person.
     */
    public void setDeliveryPersonName(String deliveryPersonName)
    {
    //TODO Debe poder modificarse el nombre de la persona de reparto.
    }

    /**
     * @return The destination location.
     */
    public Location getDestination()
    {
     //TODO Debe poder devolver la localización donde hay que llevar el Order.
        return null;
    }

    /**
     * Return details of the passenger, such as where it is.
     * @return A string representation of the passenger.
     */
    public String toString()
    {
        return "Order "+"info a decidir"+" travelling from " +
        location + " to " + destination;
    }

    /**
     * Show the final information about the order, including the sender's name, the 
     * destination and name of the deliveryPerson who delivers it.
     */
    public String showFinalInfo()
    {
        // TODO
        return "";
    }

}
