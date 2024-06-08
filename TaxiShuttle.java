import java.util.*;
import java.util.Random;

/**
 * Write a description of class TaxiShuttle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TaxiShuttle extends Taxi

{
    //No se muy bien si es TreeSet y tmp se muy bien como usarlo
    private TreeSet<Passenger> passengers; 

    /**
     * Constructor for objects of class TaxiShuttle
     */
    public TaxiShuttle(TransportCompany company, Location location, String name,FuelConsumption fuelConsumption,int ocMax)
    {
        super(company,location,name,fuelConsumption);
        if (passengers== null){
            passengers= new TreeSet<Passenger>(new ComparadorLlegada());
        }
        setOcMax(ocMax);
    }
    
    /**
     * Constructor for objects of class TaxiShuttle
     */    
    public TaxiShuttle(TransportCompany company, Location location, String name)
    {
        super(company,location,name);
        if (passengers== null){
            passengers= new TreeSet<Passenger>(new ComparadorLlegada());
        }
    }
    /**
    * Calcula la popularidad del taxi TaxiShuttle
    */
        @Override
    public void adjustPopularity(Passenger passenger)
    {
    
    }
    
     
    /**
     * Carry out the taxiShuttle actions
     */
    @Override
    public void act(){
        boolean flagPickUp=false;
        boolean flagOffload=false;

        if(targetLocation==null){
        idleCount=idleCount+1; //Si no tiene ningún destino asigando el idleCount del taxi aumenta
        }
        else{
            distanciaRecorrida++;
            Location lAux;
            lAux= location.nextLocation(targetLocation);
            System.out.println("@@@ Taxi: "+name + " moving to: " + lAux.getX()+ " , " +lAux.getY());
            //Si la siguiente posicion es la misma que la a la que se dirgia y no está lleno
            //es decir, va recoger a un pasajero:
            if(lAux.equals(targetLocation)){ //&&getIsFree()
            flagPickUp=true;
            }
            //Si la siguiente posicion es la misma que la a la que se dirgia y está lleno
            //es decir, esta llevando a un destino a un pasajero:
            if(lAux.equals(taxiDestination)){ //&& (getIsFree() && passengers.isEmpty()) || (!getIsFree() && !passengers.isEmpty())
            flagOffload= true;
            }
        }    

        if(targetLocation!=null){
        //Efectua el movimiento
        location=location.nextLocation(targetLocation);  
        }

        if(flagPickUp){
        notifyPickupArrival(); //Notifica que ha recogido un pasajero
        //pickup(passenger.first());
        }

        if(flagOffload){
        notifyPassengerArrival(passenger.first()); //Notifica que el pasajero ha llegado a su destino
        offloadPassenger();
        incrementPassengersTransported();
        }  
    }

    /**
    * Calcula la consumción del taxiShuttle
    */
    public int obtainComsumption(){
        Location lAux = getInitialLocation();        
        return enumFuelConspution.getValor() * lAux.distance(getLocation());
    }
    
}

            
