import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TaxiTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class TaxiTest
{
    private Taxi taxi;
    private Passenger passenger;
    //TODO
    //crear más campos (si es necesario) 
    /**
     * Default constructor for test class TaxiTest
     */
    public TaxiTest()
    {
    }

    /**
     * Create a taxi.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        TransportCompany company = new TransportCompany("Compañía Taxis Cáceres");
        // Starting position for the taxi.
        Location taxiLocation = new Location(0, 0);
        // Locations for the passenger.
        Location pickup = new Location(1, 2);
        Location destination = new Location(5, 6);

        passenger = new Passenger(pickup, destination,"Kevin");
        taxi = new Taxi(company, taxiLocation,"T1");
        //TODO
        //Completar (si es necesario) este método
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
     * Test creation and the initial state of a taxi.
     */
    @Test
    public void testCreation()
    {
        assertEquals(true, taxi.isFree());
    }

    /**
     * Test that a taxi is no longer free after it has
     * picked up a passenger.
     */
    @Test
    public void testPickup()
    {
        //TODO implementar este método
    }

    /**
     * Test that a taxi becomes free again after offloading
     * a passenger.
     */
    public void testOffload()
    {
        //TODO implementar este método
    }

    /**
     * Test that a taxi picks up and delivers a passenger within
     * a reasonable number of steps.
     */
    public void testDelivery()
    {
        //TODO implementar este método
    }
}

