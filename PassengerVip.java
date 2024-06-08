
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
    public PassengerVip(Location pickup, Location destination, String name, Reliable reliable)
    {
       super(pickup,destination,name,reliable);
    }
    
    /**
     * Constructor for objects of class PassengerVip
     */
        public PassengerVip(Location pickup, Location destination, String name, int arrivalTime
        , int creditCard, Reliable reliable)
    {
       super(pickup,destination,name, arrivalTime, creditCard,reliable);
    }

    /**
     * Constructor for objects of class PassengerVip
     */
    public PassengerVip(Location pickup, Location destination, String name, String taxiName)
    {
       super(pickup,destination,name,taxiName);
    }

    /**
     * Carries out the action of paying regarding PassengerVip
     */
    @Override
    public void pay()
    {
        //A lo mejor esta mal porque hace falta darle una propina de 10 al conductor y
        //eso no se como se hace hasta que alguien haga taxi
    substractFromCreditCard(610);
    }
    
    /**
     * Carries out the action of calculating the Evaluation regarding PassengerVip
     */
    @Override    
        public int calculateEvaluationValue()
        {
        return super.calculateEvaluationValue() + 15;
    }
}
