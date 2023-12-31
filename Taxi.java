import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Map;

/**
 * Model the common elements of taxis and shuttles.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */

// Esta clase guarda todos los elementos comunes de los taxis y reliza las acciones de recoger y dejar a sus pasajeros asigandos
public abstract class Taxi 
{
    // The Taxi Company of this Taxi.
    private TransportCompany company;  
    
    private Map<Taxi,TreeSet<Passenger>> TaxiAssignments;
    
    // Where the vehicle is.
    private Location location;     
    // Where the vehicle is headed.
    private  Location targetLocation; 
    // Record how often the vehicle has nothing to do.
    private int idleCount;       
    //name of the taxi
    private String name; 
    //passengers of the taxi
    //private ArrayList<Passenger>passenger;
    //Colección de pasageros (la ordenacion se le psa el comprador la instanciarlo)
    private TreeSet<Passenger> passenger;
    //number of passengers that are transported by the taxi (in the whole simulation)
    private int passengersTransported;
    //Si el taxi está libre o no
    private boolean IsFree;
    //Esta variable sirve al asignar los taxis a los pasajeros y no sobre escribirlos cuando ya tiene un pasajero asigando
    private boolean IsBooked;
    //enum del fuelconsption medio del taxi
    protected FuelConsumption enumFuelConspution;
    //Valoracion de los taxis, es publico por ue el único que lo cambia es passenger    
    public int valuation;
    //Ocupacion del taxi, min=1 max=4
    private int occupation;
    //Distancia recorrida en toda la simulación
    protected int distanciaRecorrida=0;
    //ocupación máxima del taxi
    private int ocMax;
    
    

    /**
     * Constructor of class Vehicle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    
    public Taxi(TransportCompany company, Location location, String name)
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
        if(passenger== null){
            passenger= new TreeSet<Passenger>(new ComparadorLlegada());
        }
        this.company = company;
        this.location = location;
        this.name= name;
        
        targetLocation = null;
        idleCount = 0;
        IsFree= true;
        IsBooked= false;
        occupation = 0;

        }
        
            /**
     * Constructor of class Vehicle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    
    public Taxi(TransportCompany company, Location location, String name, FuelConsumption enumFuelConspution)
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
        if(passenger== null){
            passenger= new TreeSet<Passenger>(new ComparadorLlegada());
        }
        this.company = company;
        this.location = location;
        this.name= name;
        this.enumFuelConspution= enumFuelConspution;
        
        targetLocation = null;
        idleCount = 0;
        IsFree= true;
        IsBooked= false;
        occupation = 0;

        }
        
    /**
     * Get the taxi ocupation
     * @return the ocupation of the taxi
     */
      public int getOccupation()
    {
        return occupation;
    }
    
    /**
     * Get the taxi name
     * @return the name of the taxi
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the taxi valuation
     * @return the valuation of the taxi
     */
        public int getValuation()
    {
        return valuation;
    }
    
    /**
     * Set the name of the taxi
     * @param the name of the taxi you want to set
     */
        public void setName(String name)
    {
        this.name=name;
    }
    
    /**
     * Set the name of the taxi
     * @param the name of the taxi you want to set
     */
        public void setOcMax(int ocMax)
    {
        this.ocMax=ocMax;
    }
    
    /**
     * Get the passenger of the taxi
     * @return the passenger of the taxi
     */
        public TreeSet<Passenger>getPassenger()
    {
        return passenger;
    }
    
    /**
     * Set the passenger of the taxi
     * @param the passenger you want to set
     */
    public void InsertarPasagero(Passenger p){
        passenger.add(p);
        targetLocation=p.getPickup();
    }

    /**
     * Get the location.
     * @return Where this taxi is currently located.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Get the number of passengers.
     * @return the number of passenger that the taxi contains
     */
    public int getPassengersTransported()
    {
        return passengersTransported;
    }

    
    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }
    
    /**
     * Cambia el estado de si un taxi ha sido reservsado por un pasajero o no
     * @param boolean flag
     */
        public void setBookTaxi(boolean flag)
    {
        this.IsBooked= flag;
    }
    

    /**
     * Get the target location.
     * @return Where this vehicle is currently headed, or null
     *         if it is idle.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }

    /**
     * Set the required target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }

     /**
     * Receive a pickup location. This becomes the
     * target location.
     * @param location The pickup location.
     */
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
    }

     /**
     * Get the TransportCompany
     * @return Transport Company of the taxi
     */
    public TransportCompany getTransportCompany()
    {
        return company;
    }
    
    /**
     * Recieve a company, Set the required company
     */
     public void setTransportCompany(TransportCompany company)
    {
        this.company = company;
    }
    
    /**
     * Has the vehicle a target Location?
     * @return Whether or not this vehicle has a target Location.
     */
    public boolean hasTargetLocation(){
        return getTargetLocation() != null;
    }
    
    /**
     * Clear the target location.
     */
    public void clearTargetLocation()
    {
        targetLocation = null;
    }

    /**
     * @return on how many steps this vehicle has been idle.
     */
    public int getIdleCount()
    {
        return idleCount;
    }
    
    /**
     * @return The max occupation of the taxi.
     */
    public int getOcMax()
    {
        return ocMax;
    }

    /**
     * Increment the number of steps on which this vehicle
     * has been idle.
     */
    public void incrementIdleCount()
    {
        idleCount++;
    }

    /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    public String toString()
    {
        return getClass().getName() + " " +getName()+" at " + getLocation();
    }

    /**
     * Is the taxi free?
     * @return Whether or not this taxi is free.
     */
    public boolean isFree()
    {
        return IsFree;
    }
    
    /**
     * Get del estado booked del taxi
     * @return Whether or not this taxi is booked.
     */
    public boolean isBooked()
    {
        return IsBooked;
    }


    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
         company.arrivedAtPickup(this); 
    }

    /**
     * Notify the company of our arrival at a passenger's destination.
     */
    public void notifyPassengerArrival(Passenger passenger)
    {
        company.arrivedAtDestination(this, passenger);
    }

    /**
     * Receive a passenger.
     * Set passenger's destination as its target location.
     * @param passenger The passenger.
     */
    public void pickup(Passenger passenger)
    {   
        InsertarPasagero(passenger);
        setTargetLocation(passenger.getDestination());
        targetLocation=passenger.getDestination();
        System.out.println("<<<< Taxi " + name + " at "+ location + " picks up " + passenger.getName());
        occupation= occupation +1;
            // IsFree=false;
    }

    /**
     * Offload the passenger.
     */
    public void offloadPassenger()
    {
        passenger=null; //Limpia la información de passenger para luego asignarle otro pasajero
        targetLocation=null; //Como el vehiculo ya ha llegado a su posición a la que se dirigía limpia ese campo.
        occupation= occupation -1;
        IsFree=true;
        setBookTaxi(false);
    }
    
    /**
     * Increment the number of passengers this vehicle has transported.
     */
    protected void incrementPassengersTransported()
    {
        passengersTransported =passengersTransported +1; //Lo incrementa 1
    }

    /**
     * Get the distance to the target location from the current location.
     * @return distance to target location.
     */
    public int distanceToTheTargetLocation()
    {
        return location.distance(targetLocation);

    }
    
    public boolean tieneSitio(){
        boolean enc;
        if(occupation< ocMax){
            enc= true;
        }
        else{
            enc= false;
        }
        return enc;
    }

    /**
     * Carry out a taxi's actions.
     */
    public void act()
    {
        boolean flagPickUp=false;
        boolean flagOffload=false;
        // Passenger p1;
        // p1= passenger.first();
        
        company.assignments.get(this);
        
        TreeSet<Passenger> pAux= company.assignments.get(this);
        Passenger p1;
        p1= pAux.first();
        
        
        
        
        if(targetLocation==null){
           idleCount=idleCount+1; //Si no tiene ningún destino asigando el idleCount del taxi aumenta
        }
        else{
            distanciaRecorrida++;
            Location lAux;
            lAux= location.nextLocation(targetLocation);
            System.out.println("@@@ Taxi: "+name + " moving to: " + lAux.getX()+ " - " +lAux.getY());
            //Si la siguiente posicion es la misma que la a la que se dirgia y no está lleno
            //es decir, va recoger a un pasajero:
            if(lAux.equals(targetLocation)&&isFree()){
                flagPickUp=true;
            }
            //Si la siguiente posicion es la misma que la a la que se dirgia y está lleno
            //es decir, esta llevando a un destino a un pasajero:
            if(lAux.equals(targetLocation)&&!isFree()){
                flagOffload= true;
            }
        }    
         
        
        if(targetLocation!=null){
        //Efectua el movimiento
        location=location.nextLocation(targetLocation);  
        }
        
        if(flagPickUp){
                notifyPickupArrival(); //Notifica que ha recogido un pasajero
                pickup(passenger.first());
            }
            
        if(flagOffload){
            notifyPassengerArrival(passenger.first()); //Notifica que el pasajero ha llegado a su destino
            offloadPassenger();
            incrementPassengersTransported();
        }
        
    }
    
    
    public abstract int obtainComsumption();
    
    
    public String showFinalInfo()
    {
        return "Final taxi information: " + getName() + " at location " + getLocation()+ " occupation "+getOccupation()+ "- passengers transported: " +
        passengersTransported +" - non active for: "+ getIdleCount()+ " times - valuation:" +getValuation() + " - consumption: " + obtainComsumption();

    }

}
