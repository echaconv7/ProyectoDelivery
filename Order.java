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
    //nombre de la persona o empresa que envia el pedido
    private String sendingName;
    //localizacion en la que esta actualmente el pedido
    private Location location;
    //localizacion en la que debe ser entregado el pedido
    private Location destination;
    //hora aproximada en la que se estima que se entregara el pedido
    private int deliveryTime;
    //peso del pedido
    private double weigth;
    //datos de la persona o empresa que recibe el pedido
    private String destinationName;
    //nombre de la persona que reparte el pedido
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
    double weigth, String destinationName)
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
        this.sendingName = sendingName;
        this.deliveryTime = deliveryTime;
        this.weigth = weigth;
        this.destinationName = destinationName;
        this.deliveryPersonName = null;
    }

    /**
     * @return el nombre de la persona o empresa que envia el pedido
     */
    public String getSendingName (){
        return sendingName;
    }
    
    /**
     * @return la hora estimada en la que llegara el pedido
     */
    public int getDeliveryTime (){
        return deliveryTime;
    }
    
    /**
     * @return el peso del pedido
     */
    public double getWeigth (){
        return weigth;
    }
    
    /**
     * @return el nombre de la persona o empresa que envia el pedido
     */
    public Location getLocation (){
        return location;
    }
    
    /**
     * @return el nombre de la persona o empresa a la que se envia el pedido
     */
    public String getDestinationName (){
        return destinationName;
    }
    
    /**
     * @return The name of the delivery person.
     */
    public String getDeliveryPersonName()
    {
        return deliveryPersonName;
    }

    /**
     * Set the new name of the delivery person.
     * @param The new name of the delivery person.
     */
    public void setDeliveryPersonName(String deliveryPersonName)
    {
        this.deliveryPersonName = deliveryPersonName;
    }

    /**
     * @return The destination location.
     */
    public Location getDestination()
    {
        return destination;
    }

    /**
     * Return a short detail of representation of order
     * @return A string representation of the order.
     */
    public String getStringShortDetail()
    {
        return "Order at: "+getDeliveryTime()+" from: "+getSendingName()+" to: "+getDestinationName();
    }
    
    /**
     * Return details of the passenger, such as where it is.
     * @return A string representation of the passenger.
     */
    public String toString()
    {
        return "Order from: "+ sendingName + " to: " +
        destinationName+" at: "+deliveryTime+
        " weigth: " + weigth +" from: " +
        location.getStringConcatenateLocation()+ " to: " + destination.getStringConcatenateLocation();
    }

    /**
     * Show the final information about the order, including the sender's name, the 
     * destination and name of the deliveryPerson who delivers it.
     */
    public String showFinalInfo()
    {
        return "Order delivered at: "+getDeliveryTime()+" by: "+getDeliveryPersonName()+" to: "+getDestinationName()+" from: "+getSendingName();
    }

}
