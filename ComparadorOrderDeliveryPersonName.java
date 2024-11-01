import java.util.Comparator;

/**
 * Compare Orders by sendingName.
 * 
 * @author Jose Antonio y Elena 
 * @version 1.0.0
 */
public class ComparadorOrderDeliveryPersonName implements Comparator <Order>
{
        public int compare (Order order1, Order order2){
        return order1.getSendingName().compareTo(order2.getSendingName());
    }
}
