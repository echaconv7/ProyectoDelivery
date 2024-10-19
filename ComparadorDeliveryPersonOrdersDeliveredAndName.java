import java.util.Comparator;

/**
 * Write a description of class ComparadorDeliveryPersonOrdersDeliveredAndName here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorDeliveryPersonOrdersDeliveredAndName implements Comparator <DeliveryPerson>
{
    public int compare (DeliveryPerson dp1, DeliveryPerson dp2){
        Integer deliveredNumber1= dp1.ordersDelivered();
        Integer deliveredNumber2= dp2.ordersDelivered();
        int resultadoDistancia = (deliveredNumber1.compareTo(deliveredNumber2));
        if (resultadoDistancia==0){
            return dp1.getName().compareTo(dp2.getName());
        }
        return resultadoDistancia;
    }

}
