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
    private Taxi taxi1;
    private Taxi taxi2;
    private Passenger passenger1;
    private Passenger passenger2;
    private List<Passenger> passengerList;
    private List<Taxi> taxiList;
    private List<Assignment> assignments;
    private Location taxiLocation1;
    private Location taxiLocation2;
    private Location pickup1;
    private Location pickup2;
    private Location destination1;
    private Location destination2;
    private Assignment assigment1;
    private Assignment assigment2;
    
    private TransportCompany company;
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
        //Crea 3 listas para declarar TransportCompany
        passengerList = new ArrayList<Passenger>();
        taxiList= new ArrayList<Taxi>();
        assignments= new ArrayList<Assignment>();
        

        
 

        // Locations for the passenger.
        pickup1 = new Location(1, 2);
        destination1 = new Location(5, 4);
        pickup2 = new Location(1,5);
        destination2 = new Location(2,3);
        
        // Starting position for the taxi.
        taxiLocation1 = new Location(0, 0);
        taxiLocation2 = new Location(0, 0);

        
        
        // Create 2 new passengers
        passenger1 = new Passenger(pickup1,destination1,"Nombre1", "T1");
        passenger2 = new Passenger(pickup2,destination2,"Nombre2", "T2");
    
        
        //Create 2 assigments
        assigment1 = new Assignment( taxi1,passenger1);
        assigment2 = new Assignment( taxi2,passenger2);
        
        // Add passengers and taxis to the taxiList and passengerList
        passengerList.add(passenger1);
        passengerList.add(passenger2);
        taxiList.add(taxi1);
        taxiList.add(taxi2);
        assignments.add(assigment1);
        assignments.add(assigment2);
        
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        company= null;
        taxiList.remove(taxi1);
        taxiList.remove(taxi2);
        taxi1= null;
        taxi2= null;
        taxiLocation1= null;
        taxiLocation2= null;
        passengerList.remove(passenger1);
        passengerList.remove(passenger2);
        pickup1= null;
        destination1= null;
        pickup2= null;
        destination2= null;

        
    }

    /**
     * Test creation and the initial state of a taxi.
     */
    @Test
    public void testCreation()
    {
        
        //Create the company
        TransportCompany defaultcompany = new TransportCompany("Compañía Taxis Cáceres",taxiList,passengerList,assignments);
            
        //Create 2 taxis
        taxi1 = new Taxi(defaultcompany, taxiLocation1,"T1");
        taxi2 = new Taxi(defaultcompany, taxiLocation2,"T2");
        
        //Asigna los pasajeros al taxi
        taxi1.asignarPasagero(passenger1);
        taxi2.asignarPasagero(passenger2);
        
        //Asserts
        assertNotNull(passengerList); //La lista de pasajeros no debería estar vacia
        assertNotNull(taxiList); //La lista de taxis no debería estar vacia
        assertNotNull(taxi1.getTransportCompany()); //El campo company debería ser nulo inicialmente
        assertEquals(new Location(0, 0), taxi1.getLocation()); //La localizacion inicial del taxi es 0,0
        //No se porque da mal vvv
        assertEquals(taxi1.getName(),"T1"); //Checa si el nombre es correcto
        assertNull(taxi1.getTargetLocation()); //No deberia tener ningun taget location
        assertEquals(0, taxi1.getIdleCount()); //Checa el idle count
        assertEquals(taxi1.getPassenger(),passenger1); //Checa si no tiene un passenger asigando
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
        
        
        //Create the company
        TransportCompany defaultcompany = new TransportCompany("Compañía Taxis Cáceres",taxiList,passengerList,assignments);
            
        //Create 2 taxis
        taxi1 = new Taxi(defaultcompany, taxiLocation1,"T1");
        taxi2 = new Taxi(defaultcompany, taxiLocation2,"T2");
        
        //Asigna los pasajeros al taxi
        taxi1.asignarPasagero(passenger1);
        taxi2.asignarPasagero(passenger2);
        
        taxi1.pickup(passenger1);
        taxi2.pickup(passenger2);
        
        //Asserts taxi1
        assertEquals(passenger1, taxi1.getPassenger()); //Mira si el passenger se ha asiganado correctamente
        assertEquals(passenger1.getDestination(), taxi1.getTargetLocation()); //Comapara el getDestination y el targetLocation
        assertEquals(false, taxi1.isFree()); //Mira si no esta libre el taxi
        
        //Asserts taxi2
        assertEquals(passenger2, taxi2.getPassenger()); //Mira si el passenger se ha asiganado correctamente
        assertEquals(passenger2.getDestination(), taxi2.getTargetLocation()); //Mira si el passenger se ha asiganado correctamente
        assertEquals(false, taxi2.isFree()); //Mira si no esta libre el taxi
    }

    /**
     * Test that a taxi becomes free again after offloading
     * a passenger.
     */
    @Test
    public void testOffload()
    {

   
    
        //Create the company
        TransportCompany defaultcompany = new TransportCompany("Compañía Taxis Cáceres",taxiList,passengerList,assignments);
            
        //Create 2 taxis
        taxi1 = new Taxi(defaultcompany, taxiLocation1,"T1");
        taxi2 = new Taxi(defaultcompany, taxiLocation2,"T2");
        
        //Asigna los pasajeros al taxi
        taxi1.asignarPasagero(passenger1);
        taxi2.asignarPasagero(passenger2);
        
            taxi1.act(); //Se mueve hacia el punto de recogida
            taxi1.act(); //Se mueve y Realiza la recogida del pasajero.
            
            taxi1.act(); //Se mueve hacia el destino del pasajero
            taxi1.act(); //Se mueve hacia el destino del pasajero
            taxi1.act(); //Se mueve hacia el destino del pasajero
            //assertEquals( taxiLocation1.nextLocation(taxi1.getTargetLocation()),passenger1.getDestination()); //Mira si la siguiente posicion es el target location y la destination del pasajero coinciden
            taxi1.act(); //Se mueve y Hace offload pasajero.
            
            //Este asser equals da mal es decir no hace el load por alguna razon del psajero
            assertEquals(true, taxi1.isFree()); //Mira si esta libre el taxi
            assertNull(taxi1.getPassenger()); //El offload limpia el pasajero, entonces deberia estar en null
            assertNull(taxi1.getTargetLocation()); //El offload limpia el TargetLocation, entonces deberia estar en null
            
            
            taxi2.act(); //Se mueve hacia el punto de recogida
            taxi2.act(); //Se mueve hacia el punto de recogida
            taxi2.act(); //Se mueve hacia el punto de recogida
            taxi2.act(); //Se mueve hacia el punto de recogida
            taxi2.act(); //Se mueve y Realiza la recogida del pasajero.
            
            taxi2.act(); //Se mueve hacia el destino del pasajero
            assertEquals( taxiLocation2.nextLocation(taxi2.getTargetLocation()),passenger2.getDestination()); //Mira si la siguiente posicion es el target location y la destination del pasajero coinciden
            taxi2.act(); //Se mueve y Hace offload pasajero.
            
            assertEquals(true, taxi2.isFree()); //Mira si esta libre el taxi
            assertNull(taxi2.getPassenger()); //El offload limpia el pasajero, entonces deberia estar en null
            assertNull(taxi2.getTargetLocation()); //El offload limpia el TargetLocation, entonces deberia estar en null
            
    }

    /**
     * Test that a taxi picks up and delivers a passenger within
     * a reasonable number of steps.
     */
    @Test
    public void testDelivery()
    {
        

        
        //Create the company
        TransportCompany defaultcompany = new TransportCompany("Compañía Taxis Cáceres",taxiList,passengerList,assignments);
            
        //Create 2 taxis
        taxi1 = new Taxi(defaultcompany, taxiLocation1,"T1");
        
        //Asigna los pasajeros al taxi
        taxi1.asignarPasagero(passenger1);
    
            taxi1.act(); //Se mueve hacia el punto de recogida
            assertEquals(taxiLocation1.nextLocation(taxi1.getTargetLocation()),passenger1.getPickup()); //Mira si la siguiente posicion es el target location y la pickup del pasajero coinciden
            taxi1.act(); //Se mueve y Realiza la recogida del pasajero.
            
            assertEquals(passenger1, taxi1.getPassenger()); //Mira si el passenger se ha asiganado correctamente
         //   assertEquals(passenger1.getDestination(), taxi1.getTargetLocation()); //Comapara el getDestination y el targetLocation
            assertEquals(false, taxi1.isFree()); //Mira si no esta libre el taxi
            
            taxi1.act(); //Se mueve hacia el destino del pasajero
            taxi1.act(); //Se mueve hacia el destino del pasajero
            taxi1.act(); //Se mueve hacia el destino del pasajero
            assertEquals( taxiLocation1.nextLocation(taxi1.getTargetLocation()),passenger1.getDestination()); //Mira si la siguiente posicion es el target location y la destination del pasajero coinciden
            taxi1.act(); //Se mueve y Hace offload pasajero.
            
            assertEquals(true, taxi1.isFree()); //Mira si esta libre el taxi
            assertNull(taxi1.getPassenger()); //El offload limpia el pasajero, entonces deberia estar en null
            assertNull(taxi1.getTargetLocation()); //El offload limpia el TargetLocation, entonces deberia estar en null
        
    }
}

