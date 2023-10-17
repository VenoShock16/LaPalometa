import java.util.*;

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
    private Taxi vehicles;
    private Passenger passengers;
    private Passenger assignments;
    private ArrayList<Passenger> lPassengers;
    private ArrayList<Taxi> lVehicles;

    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name, Taxi vehicles, Passenger passengers, Passenger assignments)
    {
        this.name = name;
        this.vehicles = vehicles;
        this.passengers = passengers;
        this.assignments = assignments;
        lPassengers = new ArrayList<Passenger>();
        lVehicles = new ArrayList<Taxi>();
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
        return lVehicles;
    }

    /**
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers()
    {
        return lPassengers;
    }

    /**
     * @param Add the new Vehicle.
     */
    public void addVehicle(Taxi vehicle)
    {
        lVehicles.add (vehicle);
    }

    /**
     * Add a new passenger in the company.
     * @param passenger The new passenger.
     */
    public void addPassenger(Passenger passenger)
    {
        lPassengers.add (passenger);

    }

    /**
     * Find a the most closed free vehicle to a location, if any.
     * @param location location to go
     * @return A free vehicle, or null if there is none.
     */
    private Taxi scheduleVehicle(Location location)
    {
    //    int i;
    //    for (i=0; i<; i++){ // cómo se cual es el valor máximo de la lista?
    //        if(lVehicles(i).isFree()){
    //            return lVehicles(i);
    //        }
    //    }
        return null;
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(Passenger passenger)
    {
        Taxi taxiAux;
        taxiAux= scheduleVehicle(passenger.getPickup());
        if (taxiAux== null){
            return false;
        }
        else{
        taxiAux.setPickupLocation(passenger.getPickup());
        taxiAux.setTargetLocation(passenger.getDestination());
        // asignará el objeto Passenger al taxi (en assignments)
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