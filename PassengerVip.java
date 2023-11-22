
/**
 * Write a description of class PassengerVip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PassengerVip extends Passenger
{

    /**
     * Constructor for objects of class PassengerVip
     */
    public PassengerVip(Location pickup, Location destination, String name)
    {
       super(pickup,destination,name);
    }
    
    public PassengerVip(Location pickup, Location destination, String name, String taxiName)
    {
       super(pickup,destination,name,taxiName);
    }
    /**
     *
     */
    @Override
    public void pay()
    {
        //A lo mejor esta mal porque hace falta darle una propina de 10 al conductor y
        //eso no se como se hace hasta que alguien haga taxi
    creditCard= creditCard -610;
    }
    
    @Override    
        public int calculateEvaluationValue(){
        super.calculateEvaluationValue();
        //Y además aumenta en 15 la valoración del vehiculo utilizado
        return 0;
    }
}
