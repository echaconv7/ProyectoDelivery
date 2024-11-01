import java.util.*;

/**
 * Compare delivery persons by distance betweenTarget or by name deliveryPerson.
 * 
 * @author Jose Antonio y Elena
 * @version 1.0.0
 */
public class ComparadorDistanciaTargetBetweenDeliveriesPersonsAndName implements Comparator <DeliveryPerson>
{
    private Location targetLocation;
    
    /**
    * Constructor for objects of class ComparadorDistanciaAlmacenDestino
    */
    public ComparadorDistanciaTargetBetweenDeliveriesPersonsAndName(Location targetLocation){
        this.targetLocation=targetLocation;
    }
    
    public int compare (DeliveryPerson dp1, DeliveryPerson dp2){
        Integer distancia1= dp1.getLocation().distance(targetLocation);
        Integer distancia2= dp2.getLocation().distance(targetLocation);
        int resultadoDistancia = (distancia1.compareTo(distancia2));
        if (resultadoDistancia==0){
            return dp1.getName().compareTo(dp2.getName());
        }
        return resultadoDistancia;
    }
}
