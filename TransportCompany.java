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
    private Map<Taxi,TreeSet<Passenger>> assignments;

    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name){
        this.name= name;
        vehicles = new ArrayList<>();
        passengers = new ArrayList<>();
        //assignments = new ArrayList<>();
       assignments = new HashMap<>();
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
        System.out.println(vehicle.toStringSimple() + " offloads " + passenger);
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
    private Taxi scheduleVehicle(Passenger passenger, Location location)
    {
       boolean enc;
       int i=0;
       enc= false;
       Taxi tAux;
       tAux= null;
       this.vehicles.sort(Comparator.comparingInt((Taxi taxi) -> taxi.getLocation().distance(location)).thenComparing(Taxi::getName));// Ordena la lista de taxis según la ubicación.
       while (i< vehicles.size() && !enc ){ 
           tAux= vehicles.get(i);
           if (passenger.getcreditCard() >= 20000){//Mira si es rico
               if(hayHuecoTaxiExclusive(tAux)){
                enc=true; 
                }
            }
            else{
                if(hayHuecoTaxiShuttle(tAux)){
                    enc=true;
                }
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
     * Checks if there are any space left for the passenger in the taxi
     * @retuns true if it does @return false if it doesn't
     */
    public boolean hayHuecoTaxiExclusive(Taxi taxi){
        boolean flag= false;
        if(!assignments.containsKey(taxi)&& taxi.getOcMax()==1){
            flag= true;
        }
        return flag;
    }
    
    /**
     * Checks if there are any space left for the passenger in the taxi
     * @retuns true if it does @return false if it doesn't
     */
    public boolean hayHuecoTaxiShuttle(Taxi taxi){
        boolean flag = false;
        if(taxi.tieneSitio()&& taxi.getOcMax()>1){
            flag= true;
        }
        return flag;
        
        
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
public boolean requestPickup(Passenger passenger)
    {
        Taxi taxiAux = null;
        //cuadno me devuelven un taxi tengo q comprobar si tiene lista en assigments, si no tiene, hago un Set<Passenger> sAux= new treeSet<Passenger>();
        // al crearlo le meto un comparador que he creado anteriormente  new Comparator<Passenger>()
        //Assignment assignmentAux;
        //assignmentAux= null;
        taxiAux= scheduleVehicle(passenger, passenger.getPickup());
        passenger.setTaxiName(taxiAux.getName());
        //taxiAux.setBookTaxi(true);
        Passenger pAux;
        TreeSet<Passenger> sAux;
        
        if (taxiAux== null){
            return false;
        }
        else{
            if(assignments.containsKey(taxiAux)){
                sAux= assignments.get(taxiAux);
                assignments.remove(taxiAux);
            }
            else {
               sAux= new TreeSet<Passenger>(new ComparadorLlegada());
            }
                taxiAux.InsertarPasagero(passenger);
                sAux.add(passenger);
                assignments.put(taxiAux, sAux);
                pAux= sAux.first();
                taxiAux.setPickupLocation(pAux.getPickup());
                 int ocupacion =taxiAux.getOccupation();
                 ocupacion=ocupacion+1;
                 taxiAux.setOcupacion(ocupacion);
                 
        
                //assignmentAux=new Assignment(taxiAux,passenger);
                //assignments.add(assignmentAux);
                System.out.println("<<<< "+taxiAux.toStringSimple() + " go to pick up passenger " +passenger.getName()+ " at " +passenger.getPickup());
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
        TreeSet<Passenger> pAux= assignments.get(taxi);
        Passenger p1;
        if (pAux!= null){  
            p1= pAux.first();
        
            if(taxi.getLocation().equals(p1.getPickup())){ // Obtener el pasajero asignado al taxi y eliminar la asignación correspondiente taxi
                assignments.remove(taxi);
                pAux.remove(p1);
                if (pAux.size()!=0){
                assignments.put(taxi,pAux);                
                }
                System.out.println("<<<< "+taxi.toStringSimple() + " picks up " + p1.getName());
                p1.setTaxiName(taxi.getName());   // el pasajero debe guardar el nombre del taxi que le ha recogido
                taxi.pickup(p1);  // el taxi debe recoger al pasajero
            }
        }
    }
    
    /**
     * Renews the location where the taxi is headed to.
     */
    public void RennewTargetLocation(Taxi taxi){
        TreeSet<Passenger> PtreeAux;
        PtreeAux=assignments.get(taxi);
        taxi.setTargetLocation(PtreeAux.first().getDestination());
        taxi.setTaxiDestination(PtreeAux.first().getDestination());
    }
    
    /**
     * A vehicle has arrived at the passenger destination.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtDestination(Taxi taxi){
        TreeSet<Passenger> pAux= assignments.get(taxi);
        Passenger p1;
        p1= pAux.first();
        if(taxi.getLocation().equals(p1.getDestination())){
            System.out.println("<<<< "+taxi.toStringSimple() + " at " + taxi.getLocation()+ " offloads "+ p1.getName()+ " travelling from  "+ p1.getPickup() + " to "
            + p1.getDestination());
                taxi.decOccupation();
            // assignments.remove(taxi);
            // pAux.remove(p1);
            if (assignments.containsKey(taxi)&&passengers.size()>0){
                assignments.put(taxi,pAux);                
            }
        }
    }
    
    /**
     * Shows final info of the company
     */
    public void showFinalInfo(){
        Taxi tAux;
       System.out.println("-->> Taxi(s) with less time not active <<--"); 
       Collections.sort(vehicles, new ComparadorIdleCountTaxi());
       
       tAux= vehicles.get(0);
       
       System.out.println("Final taxi information: " + tAux.getName() + " at " + tAux.getLocation()+ " occupation "+
       tAux.getOccupation()+ " - passengers transported: " +
       tAux.getPassengersTransported() +" - non active for: "+ tAux.getIdleCount()+ " times - valuation:" + tAux.getValuation() + " - consumption: " +
       tAux.obtainComsumption());
       
       System.out.println("-->> Taxi(s) with highest evaluation <<--"); 
       Collections.sort(vehicles, new ComparadorEvaluationTaxi());
       tAux= vehicles.get(0);
       
       System.out.println("Final taxi information: " + tAux.getName() + " at " + tAux.getLocation()+ "occupation "+
       tAux.getOccupation()+ " - passengers transported: " +
       tAux.getPassengersTransported() +" - non active for: "+ tAux.getIdleCount()+ " times - valuation: " + tAux.getValuation() + " - consumption: " +
       tAux.obtainComsumption());
    }
}