
/**
 * This class stores taxis and passengers.
 *
 * @author (Jorge)
 * @version 1
 */
public class Assignment
{
    private Taxi taxi;
    private Passenger passenger;

    /**
     * Constructor for objects of class assignments.
     */
    public Assignment(){
        taxi= null;
        passenger= null;
    }
    
    /**
     * Constructor with necessary parameters for objects of class assignments.
     */
    public Assignment(Taxi taxi, Passenger passenger)
    {
        this.taxi= taxi;
        this.passenger= passenger;
    }
    
     /**
     * Assign a taxi to a passenger.
     */
    public void passengerToTaxi(Passenger passenger, Taxi taxi){
        taxi.asignarPasagero(passenger);
    }
    
    /**
     * @return The name of the taxi.
     */
    public Taxi getTaxiAssignment(){
        return taxi;
    }
    
    /**
     * @return The name of the passenger.
     */
    public Passenger getPassengerAssignment(){
        return passenger;
    }
}