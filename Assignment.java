
/**
 * Write a description of class assignments here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Assignment
{
    private Taxi taxi;
    private Passenger passenger;

    /**
     * Constructor for objects of class assignments
     */
    public void passengerToTaxi(Passenger passenger, Taxi taxi){
        taxi.asignarPasagero(passenger);    
    }
    public Assignment(){
        taxi= null;
        passenger= null;
    }
    public Assignment(Taxi taxi, Passenger passenger)
    {
        this.taxi= taxi;
        this.passenger= passenger;
    }
    public Taxi getTaxiAssignment(){
        return taxi;
    }
    public Passenger getPassengerAssignment(){
        return passenger;
    }
}