import java.util.Comparator;

/**
 * Compare delivery persons by numbers of orders delivered or name.
 * 
 * @author Jose Antonio y Elena 
 * @version 1.0.0
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
