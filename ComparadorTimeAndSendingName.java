import java.util.*; 

/**
 * Compare Orders by time and sending name.
 * 
 * @author Jose Antonio y Elena
 * @version 2024.10.07 DP classes
 */
public class ComparadorTimeAndSendingName implements Comparator<Order>
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
