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
    private int credit;
    private Reliable reliable;

  
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
        credit= 5000;
        reliable.setValor(8);
        
        
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
        credit= 0;
        
    }

    /**
     * Test basic creation of a passenger.
     * Ensure that the pickup and destination locations
     * have been set.
     */
    @Test
    public void testCreation()
    {

    {
                    passenger = new PassengerNoVip(pickup, destination,  name, 15
        ,credit , reliable) ;   
        assertEquals(name, passenger.getName());
        assertEquals(pickup, passenger.getPickup());
        assertEquals(destination, passenger.getDestination());
        assertEquals(taxiName, passenger.getTaxiName());
        assertEquals(credit, passenger.getcreditCard());
    }
}

    @Test
    public void testCreation2()
    {

    {
                    passenger = new PassengerVip(pickup, destination,  name, 15
        ,credit , reliable) ;   
        assertEquals(name, passenger.getName());
        assertEquals(pickup, passenger.getPickup());
        assertEquals(destination, passenger.getDestination());
        assertEquals(taxiName, passenger.getTaxiName());
        assertEquals(credit, passenger.getcreditCard());
    }
}

    /**
     * Test of the getTaxiName method.
     * Ensure that this method gets and returns the name of the taxi correctly.
     */
    @Test
    public void testGetTaxiName(){
        passenger = new PassengerNoVip(pickup, destination, name, taxiName);
        assertEquals(taxiName, passenger.getTaxiName());    
    }

    /**
     * Test of the getPickupLocation method.
     * Ensure that this method gets and returns the pickup location correctly.
     */
    @Test
    public void testGetPickupLocation(){
        passenger = new PassengerNoVip(pickup, destination, name, taxiName);
        assertEquals(pickup, passenger.getPickup());
    }
}