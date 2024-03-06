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

    public TaxiShuttle(TransportCompany company, Location location, String name)
    {
        super(company,location,name);
        if (passengers== null){
            passengers= new TreeSet<Passenger>(new ComparadorLlegada());
        }
    }

    @Override
    public void act(){
       /*         if(targetLocation==null){
        idleCount=idleCount+1; //Si no tiene ningún destino asigando el idleCount del taxi aumenta
        }
        else{
            Location lAux;
            lAux= location.nextLocation(targetLocation);
            System.out.println("@@@ Taxi: "+name + " moving to: " + lAux.getX()+ " , " +lAux.getY());
        int i=0;
        while(company.assignments.get(this).size() <= i){
            Location PassgengerPickupAux;
            PassgengerPickupAux =company.assignments.getValue().get(i).getPickup();
        if(lAux.equals(targetLocation)){
            
        }
        }   */
    }
        
        

        // if(getTargetLocation() == null) {
            // idleCount=idleCount+1;
        // }
            // else{
                // this.setLocation(getLocation().nextLocation(getTargetLocation()));
                // System.out.println("@@@ Taxi: " + getName () +" moving to: " + getLocation().getX() + ", " + getLocation().getY());
                // if(getTargetLocation().equals(getLocation()) ){
                    // if (getPassenger() != null){
                        // if(getPassenger().getDestination().equals(getLocation()) ){
                            // notifyPassengerArrival(getPassenger());
                            // offloadPassenger();
                            // incrementPassengersTransported();
                            // if(getPassenger() != null){
                                // setTargetLocation(getPassenger().getPickup());
                            // }
                        // }
                        // else {
                            // notifyPickupArrival();
                        // }
                    // }

                // }
            
    //    }

    public int GastoCombustible()
    {
        return enumFuelConspution.getValor() * distanciaRecorrida;
    }

    public int obtainComsumption(){
        return enumFuelConspution.getValor() * distanciaRecorrida;
    }
    
}

            
