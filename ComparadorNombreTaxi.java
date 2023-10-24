import java.util.*; 
/**
 * Write a description of class ComparadorNombreTaxi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorNombreTaxi
{
    public int compare(Taxi t1, Taxi t2){  
        return (t1.getName().compareTo(t2.getName()));
    } 
}
