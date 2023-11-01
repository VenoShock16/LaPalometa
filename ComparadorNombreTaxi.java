import java.util.*; 
/**
 * Write a description of class ComparadorNombreTaxi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ComparadorNombreTaxi implements Comparator<Taxi>
{
    /**
     * Compara 2 taxis segun el estado de cercania al pasajero, si son iguales se decide por el nombre
     * @param One Taxi type object
     * @param One Taxi type object
     * @return Cual es el taxi mas cercano
     */
    public int compare(Taxi t1, Taxi t2){  
        return (t1.getName().compareTo(t2.getName()));
    } 
}
