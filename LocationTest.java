import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test implementation of the Location class.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class LocationTest
{
    Location startLocation;
    Location destination;
    Location location1;
    Location location2;
    Location location3;

    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest(){
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        startLocation = new Location(1, 2);
        destination = new Location(2, 2);
        
        location1 = new Location(0, 0);
        location2 = new Location(1, 0);
        location3 = new Location(4, 4);

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
        startLocation= null;
        destination= null;
        
        location1= null;
        location2= null;
        location3= null;
        
    }

    /**
     * Test the distance method of the Location class.
     */
    @Test
    public void testDistance()
    {
        //Comprueba la distancia entre start location y otro destino
        assertEquals(startLocation.distance(new Location(5, 7)), 5);
        assertEquals(startLocation.distance(destination), 1);
        
        assertTrue(startLocation.distance(destination) == 1);
    }

    /**
     * Run tests of the nextLocation method of the Location class.
     */
    @Test
    public void testAdjacentLocations()
    {
        //Son adyaccentes
        Location next;
        next= location1.nextLocation(location2);
        assertTrue(location1.areAdjacent(location1, next));
        
        //No son adyaccentes
        next= location1.nextLocation(location3);
        assertFalse(location1.areAdjacent(location1, next));

    }
}
