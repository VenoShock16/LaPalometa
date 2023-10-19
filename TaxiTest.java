import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import javax.swing.Box;

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
    private List<Passenger> passengerList;
    private List<Taxi> taxiList;
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
        //Crea 2 listas para declarar TransportCompany
        passengerList = new ArrayList<Passenger>();
        taxiList= new ArrayList<Taxi>();
        // Locations for the passenger.
        Location pickup1 = new Location(1, 2);
        Location destination1 = new Location(5, 6);
        Location pickup2 = new Location(1,5);
        Location destination2 = new Location(2,3);
        
        // Starting position for the taxi.
        Location taxiLocation = new Location(0, 0);
        
        // Para poder declarar el taxi sin necesitar una compañia he añadido un setCompany a taxi para añadirselo despues.
        taxi1 = new Taxi(null, taxiLocation,"T1");
        taxi2 = new Taxi(null, taxiLocation,"T2");
        
        // Create 2 new passengers
        Passenger passenger1 = new Passenger(pickup1,destination1,"Nombre1", "T1");
        Passenger passenger2 = new Passenger(pickup2,destination2,"Nombre2", "T2");
        // Add passengers and taxis to the taxiList and passengerList
        passengerList.add(passenger1);
        passengerList.add(passenger2);
        taxiList.add(taxi1);
        taxiList.add(taxi2);
        
        //Create the company
        TransportCompany company = new TransportCompany("Compañía Taxis Cáceres",taxi,passengerList,taxiList);
        //Quita el null al taxi y le añade la compañía.
        taxi.setTransportCompany(company);
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        //TODO
    }

    /**
     * Test creation and the initial state of a taxi.
     */
    @Test
    public void testCreation()
    {
        assertNotNull(passengerList); //La lista de pasajeros no debería estar vacia
        assertNotNull(taxiList); //La lista de taxis no debería estar vacia
        assertNotNull(taxi1.getCompany()); //El campo company debería ser nulo inicialmente
        assertEquals(new Location(0, 0), taxi1.getLocation()); //La localizacion icial del taxi es 0,0
        assertEquals("T1", taxi1.getName()); //Checa si el nombre es correcta
        assertNull(taxi.getTargetLocation()); //No deberia tener ningun taget location
        assertEquals(0, taxi1.getIdleCount()); //Checa el idle count
        assertEquals(passenger1,taxi1.getPassenger()); //Checa el passenger
        assertEquals(0, taxi1.getPassengersTransported()); //Checa los pasjeros transportados
        assertNotNull(taxi1.getTransportCompany()); // Comprobar que la compañía se ha asignado correctamente
    }

    /**
     * Test that a taxi is no longer free after it has
     * picked up a passenger.
     */
    @Test
    public void testPickup()
    {
        taxi.pickup(passenger1);
        taxi.pickup(passenger2);
        
        assertEquals(passenger1, taxi1.getPassenger()); //Mira si el passenger se ha asiganado correctamente
        assertEquals(passenger1.getDestination(), taxi1.getTargetLocation()); //Comapara el getDestination y el targetLocation
        
        assertEquals(passenger2, taxi2.getPassenger()); //Mira si el passenger se ha asiganado correctamente
        assertEquals(passenger2.getDestination(), taxi2.getTargetLocation()); //Mira si el passenger se ha asiganado correctamente
    }

    /**
     * Test that a taxi becomes free again after offloading
     * a passenger.
     */
    public void testOffload()
    {
            taxi1.pickup(passenger); // Realiza la recogida del pasajero.
            taxi1.act();
            taxi1.offloadPassenger();
            
            // Verifica que el pasajero se haya dejado en su destino y que el pasajero del taxi sea nulo.
            assertNull(taxi.getPassenger());
            assertNull(taxi.getTargetLocation());
    }

    /**
     * Test that a taxi picks up and delivers a passenger within
     * a reasonable number of steps.
     */
    public void testDelivery()
    {
        /*
         * No tengo ni idea como hacer esta clase, necesito una tutoria.
         
         taxi1.pickup(passenger); // Realiza la recogida del pasajero.
            taxi1.act();
            taxi1.offloadPassenger();
            
            // Verifica que el pasajero se haya dejado en su destino y que el pasajero del taxi sea nulo.
            assertNull(taxi.getPassenger());
            assertNull(taxi.getTargetLocation());
            
            */
    }
}

