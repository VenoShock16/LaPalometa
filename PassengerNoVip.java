
/**
 * Write a description of class PassengerNoVip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PassengerNoVip extends Passenger
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class PassengerNoVip
     */
    public PassengerNoVip(Location pickup, Location destination, String name,Reliable reliable)
    {
       super(pickup,destination,name,reliable);
    }
 
    /**
     * Constructor for objects of class PassengerNoVip
     */
    public PassengerNoVip(Location pickup, Location destination, String name,int arrivalTime
        ,int creditCard , Reliable reliable)
    {
       super(pickup,destination,name, arrivalTime, creditCard,reliable);
    }

    /**
     * Constructor for objects of class PassengerNoVip
     */
    public PassengerNoVip(Location pickup, Location destination, String name, String taxiName)
    {
       super(pickup,destination,name,taxiName);
    }

    /**
     * Carry out the action of paying regarding PassengerNoVip
     */
    @Override
    public void pay()
    {
    substractFromCreditCard(30);
    }
}
