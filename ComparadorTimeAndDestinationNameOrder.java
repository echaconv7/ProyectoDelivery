import java.util.*; 

/**
 * Compare Orders by time and destionation name.
 * 
 * @author Jose Antonio y Elena
 * @version 2024.10.07 DP classes
 */
public class ComparadorTimeAndDestinationNameOrder implements Comparator<Order>
{
    public int compare(Order order1, Order order2){  
        if(order1.getDeliveryTime()<order2.getDeliveryTime()){
            return -1;
        }else if(order1.getDeliveryTime()>order2.getDeliveryTime()){
            return 1;
        }
        // Si es igual el tiempo
        return order1.getDestinationName().compareTo(order2.getDestinationName());
    }
}
