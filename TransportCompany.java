import java.util.*;
import javax.swing.Box;

/**
 * Model the operation of a taxi company, operating different
 * types of vehicle. This version operates a single taxi.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TransportCompany  
{
    // TODO definir todos sus campos
    private String name;  //nombre de la compañía
    private List<Taxi> vehicles;
    private List<Passenger> passengers;
    private List<Assignment> assignments;

    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name){
        this.name= name;
        vehicles = new ArrayList<>();
        passengers = new ArrayList<>();
        assignments = new ArrayList<>();
    }
    public TransportCompany(String name, List<Taxi> vehicles, List<Passenger> passengers, List<Assignment> assignments)
    {
        this.name = name;
        vehicles = new ArrayList<>(vehicles);
        passengers = new ArrayList<>(passengers);
        assignments = new ArrayList<>(assignments);
    }

    /**
     * @return The name of the company.
     */
    public String getName()
    {
        return name;
    }

    /**
     * A vehicle has arrived at a passenger's destination.
     * @param vehicle The vehicle at the destination.
     * @param passenger The passenger being dropped off.
     */
    public void arrivedAtDestination(Taxi vehicle,
    Passenger passenger)
    {
        System.out.println(vehicle + " offloads " + passenger);
    }

    /**
     * @return The list of vehicles.
     */
    public List<Taxi> getVehicles()
    {       
        return vehicles;
    }

    /**
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers()
    {
        return passengers;
    }

    /**
     * @param Add the new Vehicle.
     */
    public void addVehicle(Taxi vehicle)
    {
        vehicles.add (vehicle);
    }

    /**
     * Add a new passenger in the company.
     * @param passenger The new passenger.
     */
    public void addPassenger(Passenger passenger)
    {
        passengers.add (passenger);

    }

    /**
     * Find a the most closed free vehicle to a location, if any.
     * @param location location to go
     * @return A free vehicle, or null if there is none.
     */
    private Taxi scheduleVehicle(Location location)
    {
       boolean enc;
       int i=0;
       enc= false;
       Taxi tAux;
       tAux= null;
       Assignment aAux;
       while (i< assignments.size() || !enc ){ //como se hace para que retorne segun la posicion
           aAux= assignments.get(i);
           tAux= aAux.getTaxiAssignment();
           if(tAux.isFree()){
               enc=true;           
            }
           i++;
       }
       if (enc= true){
           return tAux;
       }
       else{
<<<<<<< HEAD
         return null;  
         
=======
         return tAux;  
>>>>>>> 625e16615264ccaf605c1f5392ad84b8574ab939
       }
       
      
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(Passenger passenger)
    {
        Taxi taxiAux;
        Assignment assignment;
        assignment= null;
        taxiAux= scheduleVehicle(passenger.getPickup());
        if (taxiAux== null){
            return false;
        }
        else{
        taxiAux.setPickupLocation(passenger.getPickup());
        taxiAux.setTargetLocation(passenger.getDestination());
         assignment.passengerToTaxi(passenger, taxiAux); // asignará el objeto Passenger al taxi (en assignments)
         assignments.add(assignment);
        return true;
        }
    }

    /**
     * A vehicle has arrived at a pickup point.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtPickup(Taxi taxi)
    {   
        Assignment aAux;
        Passenger pAux;
        pAux= taxi.getPassenger();
        aAux= null;
        if(taxi.getLocation()==pAux.getPickup()){  // Obtener el pasajero asignado al taxi y eliminar la asignación correspondiente taxi/pasajero
           aAux.passengerToTaxi(pAux, taxi);
            assignments.remove(aAux);
            System.out.println("<<<< "+taxi + " picks up " + pAux.getName());
            pAux.setTaxiName(taxi.getName());   // el pasajero debe guardar el nombre del taxi que le ha recogido
            taxi.pickup(pAux);  // el taxi debe recoger al pasajero
        }        
    }
}