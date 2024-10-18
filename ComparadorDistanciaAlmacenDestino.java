import java.util.*;

/**
 * Write a description of class ComparadorDistanciaAlmacenDestino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorDistanciaAlmacenDestino implements Comparator <DeliveryPerson>
{
    public int compare (DeliveryPerson dp1, DeliveryPerson dp2){
        Integer distancia1= dp1.getLocation().distance(dp1.getTargetLocation());
        Integer distancia2= dp2.getLocation().distance(dp1.getTargetLocation());
        int resultadoDistancia = (distancia1.compareTo(distancia2));
        if (resultadoDistancia==0){
            return dp1.getName().compareTo(dp2.getName());
        }
        return resultadoDistancia;
    }
}
