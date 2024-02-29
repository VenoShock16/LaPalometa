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
    
    public int GastoCombustible()
    {
    return enumFuelConspution.getValor() * distanciaRecorrida;
    }
    
    public int obtainComsumption(){
        return enumFuelConspution.getValor() * distanciaRecorrida;
    }

}
