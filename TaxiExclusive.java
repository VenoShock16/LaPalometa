
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
    private int popularidad;
    /**
     * Constructor for objects of class TaxiExclusive
     * 
     */
    public TaxiExclusive(TransportCompany company, Location location, String name, FuelConsumption fuelConsumption, int weight)
    {
        super(company,location,name,fuelConsumption);
        
        popularidad = 6;
        setOcMax(1);
        this.weight= weight;
    }
    
        public TaxiExclusive(TransportCompany company, Location location, String name)
    {
        super(company,location,name);
        
        popularidad = 6;
        setOcMax(1);
        this.weight= 0;
    }
    
    public int obtainComsumption()
    {
    return (weight/2) * enumFuelConspution.getValor() * distanciaRecorrida;
    }
    
    
    // @Override
    // public void act(){
        
    // }
    
    @Override
    public void adjustPopularity(Passenger passenger)
    {
        if(passenger.getcreditCard()>20000){ //Escribir logica: si el pasjero que se ha dejado tiene +20000 = +4 popularidad
            popularidad= popularidad+4;
        }
        else{
            popularidad= popularidad-1; //Si tiene - de 20000 = -1 popularidad
        }
    
    }
    
}
