import java.util.*;
/**
 * Write a description of class ComparadorLlegada here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComparadorLlegada implements Comparator<Passenger>
{
    /**
     * Compara 2 pasajeros por orden de llegada al taxi
     * @param One Passenger type object
     * @param One Passenger type object
     * @return Cual es el pasajero con orden alfabetico mas cercano
     */
    public int compare(Passenger p1, Passenger p2){  
        if(p1.getArrivalTime()==p2.getArrivalTime()){
            return new ComparadorNombrePassenger().compare(p1,p2);
        }
        else if(p1.getArrivalTime()>p2.getArrivalTime()){
                return 1;
            }
            else return -1;
     }
}
