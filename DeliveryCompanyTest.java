

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DeliveryCompanyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DeliveryCompanyTest
{
    DeliveryCompany company;
    DeliveryPerson dp1;
    DeliveryPerson dp2;
    DeliveryPerson dp3;
    DeliveryPerson dp4;
    Order order1;
    Order order2;
    Order order3;
    Order order4;
    /**
     * Default constructor for test class DeliveryCompanyTest
     */
    public DeliveryCompanyTest()
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
        company = new DeliveryCompany("Compañía DP Delivery Cáceres");
        dp1 = new DeliveryPerson(company, new Location(10, 13),"DP2");
        dp2 = new DeliveryPerson(company, new Location(0, 0),"DP1");
        dp3 = new DeliveryPerson(company, new Location(16, 18),"DP3");
        dp4 = new DeliveryPerson(company, new Location(11, 1),"DP5");
        company.addDeliveryPerson(dp1);
        company.addDeliveryPerson(dp2);
        company.addDeliveryPerson(dp3);
        company.addDeliveryPerson(dp4);
        order1 = new Order("Kevin", new Location(2, 2),
                new Location(10, 10),10, 1.2, "Decathon Cáceres");
        order2 = new Order("Margo", new Location(4, 16),
                new Location(19,0),10, 1.2, "Pintores");
        order3 = new Order("Edith", new Location(10, 10),
                new Location(2,2),11, 1.2, "Ruta de la Plata");
        order4 = new Order("Stuart", new Location(15, 3),
                new Location(7,1),11, 1.2, "Cruz de los caídos");
        company.addOrder(order1);
        company.addOrder(order2);
        company.addOrder(order3);
        company.addOrder(order4);
        dp1.setOrder (order1);
        dp3.setOrder (order2);
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
    
    /**
     * Test de getDeliveryPerson
     */
    @Test
    public void getDeliveryPersonTest (){
        assertEquals (company.getDeliveryPerson(), dp2);
        assertFalse (company.getDeliveryPerson()==dp1);
    }
    
    /**
     * Test requestPickup
     */
    @Test
    public void requestPickupTest (){
        DeliveryPerson nextFreePerson = company.getDeliveryPerson();
        Location beforeTargetLocation = nextFreePerson.getTargetLocation();
        assertTrue (company.requestPickup (order3));
        assertNotEquals(beforeTargetLocation,nextFreePerson.getTargetLocation());
    }
    
    /**
     * Test arrivedAtPickup
     */
    @Test
    public void arrivedAtPickupTest (){
        // Test si no ha llegado a la posicion del wareHouse
        Location companyLocation=company.getlocationWareHouse();
        dp4.setLocation(companyLocation);
        Location beforeTargetLocation = dp4.getTargetLocation();
        company.arrivedAtPickup(dp4);
        assertEquals(beforeTargetLocation,dp4.getTargetLocation());
        
        // Test si ha llegado a la posicion del wareHouse
        // y obtiene la pos más cercana y si no por nombre
        dp4.setTargetLocation(companyLocation);
        beforeTargetLocation = dp4.getTargetLocation();
        company.arrivedAtPickup(dp4);
        assertTrue (dp4.getOrder().equals(order1));
        assertNotEquals(beforeTargetLocation,dp4.getTargetLocation());
    }
}
