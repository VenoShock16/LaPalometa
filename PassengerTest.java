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
        private Location pickup1;
    private Location destination1;
        private Location pickup2;
    private Location destination2;
        private Location pickup3;
    private Location destination3;
    private String taxiName;
    private Passenger passenger;
    private int credit;
    private Reliable reliable;
    private Reliable reliable1;
    private Reliable reliable2;
    private Reliable reliable3;
    
    Passenger passengerVip1;
    Passenger passengerVip2;
    
    Passenger passengerNoVip1;
    Passenger passengerNoVip2;

  
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
        pickup= new Location(1,1);
        destination=new Location(2,2);
        reliable.setValor(8);
        passengerVip1 = new PassengerVip(pickup , destination, "Jose Pulido Pulido" , 5 , 5000,  reliable);

        
        pickup1 = new Location(0,0);
        destination1 =new Location(4,4);
        reliable1 .setValor(4);
        passengerVip2 = new PassengerVip(pickup1 , destination1 , "Fernando Palomo Civantos" , 10 , 2000,  reliable1);
        
        
        pickup2 = new Location(5,5);
        destination2 =new Location(5,4);
        reliable2 .setValor(1);
        passengerNoVip1 = new PassengerNoVip( pickup2,  destination2 , "José Hernandez" ,6 ,200 ,  reliable2 );
        
        pickup3 = new Location(2,2);
        destination3 =new Location(2,4);
        reliable3 .setValor(8);
        passengerNoVip2 = new PassengerNoVip( pickup3,  destination3 , "José Hernandez" ,6 ,500 ,  reliable3 );
        
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
     * Test the pay method of the passenger object.
     */
    @Test
    public void TestPay(){
        //Pay del pasajero vip
        passengerNoVip1.pay();
        assertEquals(passengerNoVip1.getcreditCard(),170);
        
        //Pay del pasajero no vip
        passengerVip1.pay();
        assertEquals(passengerVip1.getcreditCard(),4390);
        
    }


        /**
     * Test the pay method of the passenger object.
     */
    @Test
    public void calculateEvaluationValue(){
        // calculateEvaluationValue del pasajero vip
        assertEquals(passengerVip1.calculateEvaluationValue(),31); //8*2+15
        
        // calculateEvaluationValue del pasajero no vip
        assertEquals(passengerNoVip1.calculateEvaluationValue(),2); //1*2
        
    }
}