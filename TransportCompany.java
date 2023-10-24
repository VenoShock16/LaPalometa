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
       while (i< assignments.size() || !enc ){ //como se hace para que retorne segun la posicion
           if(assignments.get(i).isFree()){
               enc=true;           
            }
           i++;
       }
       if (enc= true){
           return assignments.get(i);
       }
       else{
         return null;  
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
        taxiAux= scheduleVehicle(passenger.getPickup());
        if (taxiAux== null){
            return false;
        }
        else{
        taxiAux.setPickupLocation(passenger.getPickup());
        taxiAux.setTargetLocation(passenger.getDestination());
        assignment.passengerToTaxi(passenger, taxiAux);     // asignará el objeto Passenger al taxi (en assignments)
        return true;
        }
    }

    /**
     * A vehicle has arrived at a pickup point.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtPickup(Taxi taxi)
    {
        //TODO Obtener el pasajero asignado al taxi y eliminar la asignación correspondiente taxi/pasajero
        //TODO Descomentar siguiente línea cuando esté el método completamente implementado
        //System.out.println("<<<< "+taxi + " picks up " + passenger.getName());
        //TODO el pasajero debe guardar el nombre del taxi que le ha recogido
        //TODO el taxi debe recoger al pasajero
    }
}