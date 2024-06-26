/**
 * Model a passenger wishing to get from one
 * location to another.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public abstract class Passenger {
    private String name;
    private Location pickup;
    private Location destination;
    private String taxiName;
    private int arrivalTime;
    protected int creditCard;
    private Reliable enumReliable; //Tipo enum

    /**
     * Constructor for objects of class Passenger
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param name The passenger's name
     * @throws NullPointerException If either location is null.
     */

    public Passenger(Location pickup, Location destination, String name, Reliable enumReliable    ){
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;
        this.name = name;
        this.taxiName = "";
        this.enumReliable =enumReliable;
    }
    
    /**
     * Constructor for objects of class Passenger
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param name The passenger's name
     * @throws NullPointerException If either location is null.
     */
        public Passenger(Location pickup, Location destination, String name,    
        int arrivalTime,int creditCard, Reliable enumReliable){
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;
        this.name = name;
        this.taxiName = "";
        this.enumReliable =enumReliable;
        this.arrivalTime =arrivalTime;
        this.creditCard =creditCard;
    }

    /**
     * Constructor for objects of class Passenger
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param name The passenger's name
     * @throws NullPointerException If either location is null.
     */
    public Passenger(Location pickup, Location destination, String name, String taxiName)
    {
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;
        this.name = name;
        this.taxiName = taxiName;
    }

    /**
     * @return The name of the passenger.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return The creditCard money of the passenger.
     */
    public int getcreditCard(){
        return this.creditCard;
    }  
    
    /**
     * @return The destination location.
     */
    public Location getDestination()
    {
        return destination;
    }

    /**
     * Return details of the passenger, such as where it is.
     * @return A string representation of the passenger.
     */
    public String toString()
    {
        return getClass().getName()+" "+getName()+" travelling from " +
        pickup + " to " + destination + " arrival time: " + getArrivalTime() +" money in the credit card: "+
        getcreditCard()+ " <realiable: " + enumReliable.getNombre()+" (value: " + enumReliable.getValor()
        +")>";
    }

    /**
     * @return The pickup location of the passenger.
     */
    public Location getPickup()
    {
        return pickup;
    }
    
    /**
     * @return The pickup location of the passenger.
     */
    public int getDistance()
    {
        return pickup.distance(destination);
    }
    
    /**
     * @return The arrival time of the passenger.
     */
    public int getArrivalTime(){
        return arrivalTime;
    }

    /**
     * @modify The name of the taxi used.
     */
    public void setTaxiName(String tName)
    {
        this.taxiName= tName;
    }

    /**
     * @return The name of the taxi used.
     */
    public String getTaxiName()
    {
        return taxiName;
    }

    /**
     * Show the final information about the passenger, including the name of the taxi that used.
     */
    public String showFinalInfo()
    {
        return getClass().getName()+" "+getName()+" in " + destination + " transported by: " + getTaxiName() + " with "+
        getcreditCard() + " money in the credit card";
    }
    
    /**
     * Se ejecuta despues de que el vehiculo haga offload y llamra ha algunos modulos
     */
    public int act()
    {
        pay();
        return calculateEvaluationValue();
    }
    
    /**
     * Clase abstracta, diferentes formas de pagar para diferentes pasajeros
     */
    public abstract void pay();
    
    public void substractFromCreditCard(int i){
        this.creditCard=this.creditCard- i;
    }
    
    /**
     * Debe ser llamado con la valoracion del taxi
     */
    public int calculateEvaluationValue(){
        return (enumReliable.getValor() * 2);
    }
}