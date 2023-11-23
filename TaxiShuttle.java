
/**
 * Write a description of class TaxiShuttle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TaxiShuttle extends Taxi

{
    //No se muy bien si es TreeSet y tmp se muy bien como usarlo
    private Passengers TreeSet<Passenger>; 
    /**
     * Constructor for objects of class TaxiShuttle
     */
    public TaxiShuttle(TransportCompany company, Location location, String name)
    {
        super(company,location,name);
    }
    
    
    public int GastoCombustible()
    {
    return enumFuelConspution.getValor() * distanciaRecorrida;
    }
    
    

}
