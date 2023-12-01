
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
     */
    public TaxiExclusive(TransportCompany company, Location location, String name)
    {
        super(company,location,name);
        popularidad = 6;
    }
    
    public int obtainComsumption()
    {
    return weight * enumFuelConspution.getValor() * distanciaRecorrida;
    }
    
    //metodo act, me da pereza hacerlo
    @Override
    public void act(){
        
    }
    
    //@Override lo he comentado pq daba error
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
