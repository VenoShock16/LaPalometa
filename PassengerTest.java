import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PassengerTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class PassengerTest
{
    private String name;
    private Location pickup;
    private Location destination;
    private String taxiName;
    private Passenger passenger;

  
    /**
     * Default constructor for test class PassengerTest
     */
    public PassengerTest(){  
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        name= "Leo Xian Li";
        pickup= new Location(1,1);
        destination=new Location(2,2);
        taxiName="FakeTaxi";
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        name= "";
        pickup=null;
        destination=null;
        taxiName="";
        passenger=null;
        
    }

    /**
     * Test basic creation of a passenger.
     * Ensure that the pickup and destination locations
     * have been set.
     */
    @Test
    public void testCreation()
    {
        passenger = new Passenger(pickup, destination, name, taxiName);      
        assertEquals(name, passenger.getName());
        assertEquals(pickup, passenger.getPickup());
        assertEquals(destination, passenger.getDestination());
        assertEquals(taxiName, passenger.getTaxiName());
    }

    /**
     * Test of the getTaxiName method.
     * Ensure that this method gets and returns the name of the taxi correctly.
     */
    @Test
    public void testGetTaxiName(){
        passenger = new Passenger(pickup, destination, name, taxiName);
        assertEquals(taxiName, passenger.getTaxiName());    
    }

    /**
     * Test of the getPickupLocation method.
     * Ensure that this method gets and returns the pickup location correctly.
     */
    @Test
    public void testGetPickupLocation (){
        passenger = new Passenger(pickup, destination, name, taxiName);
        assertEquals(pickup, passenger.getPickup());
    }
}
