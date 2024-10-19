import java.util.Comparator;

/**
 * Write a description of class ComparadorOrderDeliveryPersonName here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorOrderDeliveryPersonName implements Comparator <Order>
{
        public int compare (Order order1, Order order2){
        return order1.getSendingName().compareTo(order2.getSendingName());
    }
}
