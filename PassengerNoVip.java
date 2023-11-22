
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
     * Constructor for objects of class PassengerVip
     */
    public PassengerNoVip(Location pickup, Location destination, String name)
    {
       super(pickup,destination,name);
    }
    
    public PassengerNoVip(Location pickup, Location destination, String name, String taxiName)
    {
       super(pickup,destination,name,taxiName);
    }

    @Override
    public void pay()
    {
    creditCard= creditCard -30;
    }
}
