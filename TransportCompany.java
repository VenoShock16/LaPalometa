import java.util.*;
import javax.swing.Box;
import java.util.TreeSet;

/**
 * Model the operation of a taxi company, operating different
 * types of vehicle. This version operates a single taxi.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TransportCompany  
{
    private String name; 
    private List<Taxi> vehicles;
    private List<Passenger> passengers;
    //private List<Assignment> assignments;
    private Map<Taxi,Set<Passenger>> assignments;

    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name){
        this.name= name;
        vehicles = new ArrayList<>();
        passengers = new ArrayList<>();
        //assignments = new ArrayList<>();
        Map<Taxi,Passenger> assignments = new HashMap<>();
    }

    /**
     * Constructor with necessary parameters for objects of class TransportCompany
     */
    public TransportCompany(String name, List<Taxi> vehicles, List<Passenger> passengers)
    {
        this.name = name;
        vehicles = new ArrayList<>(vehicles);
        passengers = new ArrayList<>(passengers);
        //assignments = new ArrayList<>(assignments);
        assignments = new HashMap<>();
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
     * Add a new vehicle to the list of vehicles
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
       this.vehicles.sort(Comparator.comparingInt((Taxi taxi) -> taxi.getLocation().distance(location)).thenComparing(Taxi::getName));
       while (i< vehicles.size() && !enc ){ 
           tAux= vehicles.get(i);
           if(tAux.isFree()&& !tAux.isBooked()){
               enc=true;           
            }
           i++;
       }
       if (enc= true){
           return tAux;
       }
       else{
        //Si no encuentra o encuentra y esta lleno el taxi devuelve null.
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
        //cuadno me devuelven un taxi tengo q comprobar si tiene lista en assigments, si no tiene, hago un Set<Passenger> sAux= new treeSet<Passenger>();
        // al crearlo le meto un comparador que he creado anteriormente  new Comparator<Passenger>()
        //Assignment assignmentAux;
        //assignmentAux= null;
        taxiAux= scheduleVehicle(passenger.getPickup());
        passenger.setTaxiName(taxiAux.getName());
        taxiAux.setBookTaxi(true);
        
        if (taxiAux== null){
            return false;
        }
        else{
            Set<Passenger> sAux= assignments.get(taxiAux);
            if(sAux ==null){
               sAux= new TreeSet<Passenger>(new ComparadorPassenger());
            }
            else{
                assignments.remove(taxiAux);
            }
                sAux.add(passenger);
                assignments.put(taxiAux, sAux);
                taxiAux.setPickupLocation(passenger.getPickup());
                //assignmentAux=new Assignment(taxiAux,passenger);
                //assignments.add(assignmentAux);
                System.out.println("<<<< "+taxiAux + " go to pick up passenger " +passenger.getName()+ " at " +passenger.getPickup());
                //assignmentAux.passengerToTaxi(passenger, taxiAux); 
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
        if(taxi.getLocation()==pAux.getPickup()){ // Obtener el pasajero asignado al taxi y eliminar la asignación correspondiente taxi/pasajero
            
            assignments.put(taxi,pAux);  //las tres linias siguientes cambian por el map                           
            taxi.asignarPasagero(pAux);  //aAux.passengerToTaxi(pAux, taxi);
            assignments.remove(taxi);
            System.out.println("<<<< "+taxi + " picks up " + pAux.getName());
            pAux.setTaxiName(taxi.getName());   // el pasajero debe guardar el nombre del taxi que le ha recogido
            taxi.pickup(pAux);  // el taxi debe recoger al pasajero
        }        
    }
}