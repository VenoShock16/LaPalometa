
/**
 * Write a description of class assignments here.
 *
 * @author (leo chino)
 * @version (a version number or a date)
 */
public class Assignment
{
    private Taxi taxi;
    private Passenger passenger;

    /**
     * Constructor for objects of class assignments
     */
    public Assignment(){
        taxi= null;
        passenger= null;
    }
    public Assignment(Taxi taxi, Passenger passenger)
    {
        this.taxi= taxi;
        this.passenger= passenger;
    }
    public Taxi getTaxiAssignment(Taxi taxi){
        return taxi;
    }
    public Passenger getTaxiAssignment(Passenger passenger){
        return passenger;
    }
}
