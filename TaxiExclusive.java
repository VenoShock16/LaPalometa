
/**
 * Write a description of class TaxiExclusive here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TaxiExclusive extends Taxi implements SerPopularEnRedes

{
    //peso del taxiExclusivo
    private int weight;
    //popularidadEnRedes del taxi asociada al interface
    private int popularidad =6;
    /**
     * Constructor for objects of class TaxiExclusive
     */
    public TaxiExclusive(TransportCompany company, Location location, String name)
    {
        super(company,location,name);
    }
    
    @Override
    public int obtainComsumption()
    {
    return weight * enumFuelConspution.getValor() * distanciaRecorrida;
    }
    
    @Override
    public void OffloadOperation(){
        adjustPopularity();
        super.OffloadOperation();
    }
    
    @Override
    public void adjustPopularity()
    {
    
    
    }
    
}
