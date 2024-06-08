
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
        Location lAux = getInitialLocation();        
        return (weight/2) * enumFuelConspution.getValor() * lAux.distance(getLocation());
    }
    
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
            if(lAux.equals(targetLocation)){//&&isFree
                flagPickUp=true;
            }
            //Si la siguiente posicion es la misma que la a la que se dirgia y está lleno
            //es decir, esta llevando a un destino a un pasajero:
            if(lAux.equals(taxiDestination)){ //&&!isFree
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
    
    //
        
    @Override
        public String showFinalInfo()
    {
        return getClass().getName() +" " +getName()+ " at location " + getLocation()+ " occupation "+getOcMax()+ "- passengers transported: " +
        getPassengersTransported() +" - non active for: "+ getIdleCount()+ " times - valuation:" +getValuation() + " - consumption: " + obtainComsumption()
        + " - popularity: "+ popularidad;

    }
        
    
}
