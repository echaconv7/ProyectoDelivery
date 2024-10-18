import java.util.*; 

/**
 * Compare delivery persons by name in ascending order.
 * 
 * @author DP Clasess
 * @version 2024.10.07 DP classes
 */
public class ComparadorTimeAndSendingNameOrder implements Comparator<Order>
{
    public int compare(Order order1, Order order2){  
        if(order1.getDeliveryTime()<order2.getDeliveryTime()){
            return -1;
        }else if(order1.getDeliveryTime()>order2.getDeliveryTime()){
            return 1;
        }
        // Si es igual el tiempo
        return order1.getSendingName().compareTo(order2.getSendingName());
    }
}
