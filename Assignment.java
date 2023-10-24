
/**
 * Write a description of class assignments here.
 *
<<<<<<< HEAD
 * @author (your name)
 * @version (a version number or a date)
 */
public class Assignment
{
<<<<<<< HEAD
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class assignments
     */
    public Assignment()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
=======
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
>>>>>>> d9545d9bade08043cf62db58cd7f1d726d5eadf1
=======
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
>>>>>>> cb3497591d425bc224ef854c26cdaff1fe3d5585
    }
}
