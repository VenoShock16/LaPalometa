import java.util.*;
/**
 * Write a description of class ComparadorPasTransportadosTaxi here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComparadorEvaluationTaxi implements Comparator<Taxi>
{
   /**
     * Compara 2 taxis por número de pasageros
     * @param One Passenger type object
     * @param One Passenger type object
     * @return Cual es el pasajero con orden alfabetico mas cercano
     */
    public int compare(Taxi t1, Taxi t2){  
        if(t1.getValuation()==t2.getValuation()){
            return new ComparadorNombreTaxi().compare(t1,t2);
        }
        else
            if(t1.getValuation()<t2.getValuation()){
                return 1;
            }
            else return -1;
            
    }
}
