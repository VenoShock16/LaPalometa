import java.util.*; 
/**
 * Write a description of class ComparadorPassenger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComparadorPassenger implements Comparator<Passenger>
{
    /**
     * Compara 2 pasajeros por orden de distancia
     * @param One Passenger type object
     * @param One Passenger type object
     * @return Cual es el pasajero con orden alfabetico mas cercano
     */
    public int compare(Passenger p1, Passenger p2){  
        if(p1.getDistance()==p2.getDistance()){
            return new ComparadorNombrePassenger().compare(p1,p2);
        }
        else{
            if(p1.getDistance()>p2.getDistance()){
                return 1;
            }
            if(p1.getDistance()<p2.getDistance()){
                return -1;
            }
        }
        
    }
}
