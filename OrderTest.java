import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrderTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class OrderTest
{
    Order order1;
    Order order2;
    /**
     * Default constructor for test class OrderTest
     */
    public OrderTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        order1 = new Order("Lucy", new Location(0, 0),
                new Location(2, 6),10, 1.2, "Decathon Cáceres");
        order2 = new Order("Gru", new Location(6, 6),
                new Location(5,2),10, 1.5, "Pintores");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test basic creation of an order.
     * Ensure that the location and destination locations
     * have been set.
     */
    @Test
    public void testCreation()
    {
        assertEquals (order1.getLocation(), new Location (0,0));
        assertEquals (order2.getLocation(), new Location(6,6));
        assertTrue (order1.getSendingName () == "Lucy");
        assertFalse (order2.getDeliveryTime () == 11);
        assertTrue (order2.getWeigth () == 1.5);
        assertFalse (order1.getDestinationName () == "Pintores");
        
        /*COMRPOBAR QUE SALTA EXCEPCION EN EL CONSTRUCTOR*/
        assertThrows(NullPointerException.class,()->{
        new Order("Lucy", null,
                new Location(2, 6),10, 1.2, "Decathon Cáceres");
        });
        
        assertThrows(NullPointerException.class,()->{
        new Order("Lucy", new Location(2, 6),
                null,10, 1.2, "Decathon Cáceres");
        });
        
        assertThrows(NullPointerException.class,()->{
        new Order("Lucy", null,
                null,10, 1.2, "Decathon Cáceres");
        });
    }

    /**
     * Test of the getDeliveryPersonName method.
     * Ensure that this method gets and returns the name of the delivery person correctly.
     */
    @Test
    public void testGetDeliveryPersonName()
    {
        order1.setDeliveryPersonName ("Gru");
        order2.setDeliveryPersonName ("Stevan");
        
        assertTrue (order1.getDeliveryPersonName() == "Gru");
        assertTrue (order2.getDeliveryPersonName() == "Stevan");
        assertFalse (order2.getDeliveryPersonName() == "Gru");
        assertFalse (order1.getDeliveryPersonName() == "Stevan");
    }

    /**
     * Test of the getDestination method.
     * Ensure that this method gets and returns the destination location correctly.
     */
    @Test
    public void testGetDestination ()
    {
        assertEquals (order1.getDestination(), new Location (2,6));
        assertEquals (order2.getDestination(), new Location(5,2));
    }
}
