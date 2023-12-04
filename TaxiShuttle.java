import java.util.*;
<<<<<<< HEAD
import java.util.Random
=======
import java.util.Random;
>>>>>>> c22eaaacca53bcd22b1e97e604134a074d80d1c6

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
    public TaxiShuttle(TransportCompany company, Location location, String name)
    {
        super(company,location,name);
        if (passengers== null){
            passengers= new TreeSet<Passenger>(new ComparadorLlegada());
        }
        occupation=  Math.random()*4; //poner q la ocupacion es >1 y <4, seguramente esté mal
    }
    
    
    
    public int GastoCombustible()
    {
    return enumFuelConspution.getValor() * distanciaRecorrida;
    }
    
    

}
