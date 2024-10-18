

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WareHouseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WareHouseTest
{
    
    WareHouse wareHouse;
    
    /**
     * Default constructor for test class WareHouseTest
     */
    public WareHouseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        Order order1 = new Order("Antonio", new Location(0, 0),
                new Location(2, 6),10, 1.2, "Decathon Cáceres");
        Order order2 = new Order("Luis", new Location(0, 0),
                new Location(2, 6),10, 1.2, "Decathon Cáceres");
        Order order3 = new Order("Lucy", new Location(0, 0),
                new Location(2, 6),6, 1.2, "Decathon Cáceres");
        Order order4 = new Order("Melany", new Location(0, 0),
                new Location(2, 6),3, 1.2, "Decathon Cáceres");
        
        wareHouse = new WareHouse();
                
        wareHouse.addOrder(order1);
        wareHouse.addOrder(order2);
        wareHouse.addOrder(order3);
        wareHouse.addOrder(order4);
    }
    
    /**
     * Comprueba que ordena la lista
     */
    @Test
    public void sortedListInAdd(){
        //Test1
        String nameExpected="Melany";
        int timeExpected=3;
        int position=0;
        Order orderInPositionTesting = wareHouse.getOrders(position);
        
        assertEquals(nameExpected,orderInPositionTesting.getSendingName());
        assertTrue(orderInPositionTesting.getDeliveryTime()==timeExpected);
        
        //Test2
        nameExpected="Lucy";
        timeExpected=6;
        position=1;
        orderInPositionTesting = wareHouse.getOrders(position);
        
        assertEquals(nameExpected,orderInPositionTesting.getSendingName());
        assertTrue(orderInPositionTesting.getDeliveryTime()==timeExpected);
        
        //Test3
        nameExpected="Antonio";
        timeExpected=10;
        position=2;
        orderInPositionTesting = wareHouse.getOrders(position);
        
        assertEquals(nameExpected,orderInPositionTesting.getSendingName());
        assertTrue(orderInPositionTesting.getDeliveryTime()==timeExpected);
        
    }
    
    /**
     * Comprueba la localizacion
     */
    @Test
    public void getLocation(){
        //EL FIJADO EN ESTA ENTREGA
        assertTrue(wareHouse.getLocation().getX()==5);
        assertTrue(wareHouse.getLocation().getY()==5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
