import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test implementation of the Location class.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class LocationTest
{
    private Location startLocation;
    private Location destination;
    
    private Location startLocationExample1;
    private Location destinationExample1;
    
    private Location startLocationExample2;
    private Location destinationExample2;
    
    private Location startLocationExample3;
    private Location destinationExample3;

    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest()
    {
    }
    
    /**
     * Test basic creation of an Location.
     * Ensure that the location throws error if is overflow
     */
    @Test
    public void testCreation()
    {
        /*COMRPOBAR QUE SALTA EXCEPCION EN EL CONSTRUCTOR*/
        assertThrows(IllegalArgumentException.class,()->{
            new Location(-1,0);
        });
        
        assertThrows(IllegalArgumentException.class,()->{
            new Location(0,-1);
        });
        
        assertThrows(IllegalArgumentException.class,()->{
            new Location(-10,-10);
        });
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        startLocation = new Location(1, 2);
        destination = new Location(2, 2);
        
        startLocationExample1 = new Location(0,0);
        destinationExample1 = new Location(1,5);
        
        startLocationExample2 = new Location(6,6);
        destinationExample2 = new Location(5,2);
        
        startLocationExample3 = new Location(0,0);
        destinationExample3 = new Location(3,4);
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
     * Test the distance method of the Location class.
     */
    @Test
    public void testDistance()
    {
        assertEquals(startLocation.distance(new Location(5, 7)), 5);
        assertEquals(startLocation.distance(destination), 1);
        //Misma prueba utilizando otra aserción:
        assertTrue(startLocation.distance(destination) == 1);
        
        /*MIS TEST*/
        int expectedDistance=5;
        assertEquals(expectedDistance,startLocationExample1.distance(destinationExample1));
        
        expectedDistance=4;
        assertEquals(expectedDistance,startLocationExample2.distance(destinationExample2));
        
        expectedDistance=4;
        assertEquals(expectedDistance,startLocationExample3.distance(destinationExample3));
        
    }

    /**
     * Run tests of the nextLocation method of the Location class.
     */
    @Test
    public void testAdjacentLocations()
    {
        int expectedX=2;
        int expectedY=2;
        Location nextLocation=startLocation.nextLocation(destination);
        assertEquals(expectedX,nextLocation.getX());
        assertEquals(expectedY,nextLocation.getY());
        //Comprobamos que es adyacente
        int distanceAdyacent = 1;
        assertEquals(distanceAdyacent,startLocation.distance(destination));
        
        
        
        expectedX=1;
        expectedY=1;
        nextLocation=startLocationExample1.nextLocation(destinationExample1);
        assertEquals(expectedX,nextLocation.getX());
        assertEquals(expectedY,nextLocation.getY());
        //Comprobamos que no es adyacente
        assertNotEquals(distanceAdyacent,startLocationExample1.distance(destinationExample1));
        
        expectedX=5;
        expectedY=5;
        nextLocation=startLocationExample2.nextLocation(destinationExample2);
        assertEquals(expectedX,nextLocation.getX());
        assertEquals(expectedY,nextLocation.getY());
        //Comprobamos que no es adyacente
        assertNotEquals(distanceAdyacent,startLocationExample2.distance(destinationExample2));
        
        expectedX=1;
        expectedY=1;
        nextLocation=startLocationExample3.nextLocation(destinationExample3);
        assertEquals(expectedX,nextLocation.getX());
        assertEquals(expectedY,nextLocation.getY());
        //Comprobamos que no es adyacente
        assertNotEquals(distanceAdyacent,startLocationExample3.distance(destinationExample3) );

    }
}
