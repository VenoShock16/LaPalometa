/**
 * Model the common elements of taxis and shuttles.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class Taxi 
{
    // The Taxi Company of this Taxi.
    private TransportCompany company;  
    // Where the vehicle is.
    private Location location;     
    // Where the vehicle is headed.
    private  Location targetLocation; 
    // Record how often the vehicle has nothing to do.
    private int idleCount;       
    //name of the taxi
    private String name; 
    //passenger of the taxi
    private Passenger passenger;
    //number of passengers that are transported by the taxi (in the whole simulation)
    private int passengersTransported;

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
        this.company = company;
        this.location = location;
        targetLocation = null;
        idleCount = 0;
        }

    /**
     * @return the name of the taxi
     */
    public String getName()
    {
        return name;
    }
    
        public Passenger getPassenger()
    {
        return passenger;
    }
    public void asignarPasagero(Passenger p){
        this.passenger = p;
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
        boolean flag=false;  //bandera
        //El if checa si tiene por lo menos 1 pasajero,
        //Si lo tiene aunque tenga uno se considera que el taxi no está libre.
        //Si tiene 0 estará libre
        if(passengersTransported==0){
        flag=true;
        }
        return flag;
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
        setTargetLocation(passenger.getDestination());
    }

    /**
     * Offload the passenger.
     */
    public void offloadPassenger()
    {
        passenger=null; //Limpia la información de passenger para luego asignarle otro pasajero
        targetLocation=null; //Como el vehiculo ya ha llegado a su posición a la que se dirigía limpia ese campo.
    }

    /**
     * @return how many passengers this vehicle has transported.
     */
    public int getPassengersTransported()
    {
        return passengersTransported;
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

    /**
     * Carry out a taxi's actions.
     */
    public void act()
    {
        if(targetLocation==null){
           idleCount=idleCount+1; //Si no tiene ningún destino asigando el idleCount del taxi aumenta
        }
        else{
            //Si la siguiente posicion es la misma que la a la que se dirgia y no está lleno
            //es decir, va recoger a un pasajero:
            if(location.nextLocation(targetLocation)==targetLocation&&isFree()){
                notifyPickupArrival(); //Notifica que ha recogido un pasajero
            }
            //Si la siguiente posicion es la misma que la a la que se dirgia y está lleno
            //es decir, esta llevando a un destino a un pasajero:
            if(location.nextLocation(targetLocation)==targetLocation&&!isFree()){
                notifyPassengerArrival(passenger); //Notifica que el pasajero ha llegado a su destino
                offloadPassenger();
                incrementPassengersTransported();
            }
            
            //Efectua el movimiento
            setLocation(location.nextLocation(targetLocation));
        
        }
    }
    
     /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    public String showFinalInfo()
    {
        return "Final taxi information: " + getName() + " " + getLocation() + " " + passengersTransported +" "+ getIdleCount();

    }

}
