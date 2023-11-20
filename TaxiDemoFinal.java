/**
 * Provide a simple demonstration of running a stage-one
 * scenario. Three simulaions are create: 

 * DemoOnePassanger: A single passenger and taxi are created, and a pickup
 * requested. As the simulation is run, the passenger
 * should be picked up and then taken to their destination.
 * 
 * DemoInicial: Two passengers and three taxi sare created, two pickups
 * requested. As the simulation is run, the passengers
 * should be picked up and then taken to their destination.
 *
 * DemoAvanzada: Some passengers and taxis are created, so some pickup
 * are requested. As the simulation is run, all the passengers
 * should be picked up and then taken to their destination.
 * 
 * @author DP Clasess
 * @version 2023
 */
public class TaxiDemoFinal
{
    public static final int MAXX = 20; //Valor máximo de número de filas 
    public static final int MAXY = 20; //Valor máximo de número de columnas
    //Entrega Final   ----------------------
    //--------------------------------------
    public static final int CREDITCARDDECREMENTNOVIP = 30;
    public static final int CREDITCARDDECREMENTVIP = 600;
    public static final int LIMITTOBEPOPULAR = 20000;

    
    public static void main(String [] args) {
        //Comentar o descomentar cada demo para ser ejecutada

        //Demo con 2 personajes y 2 taxis
        DemoTwoPassengers demoOne = new DemoTwoPassengers();
        demoOne.run();

        //Demo con 3 personajes y 3 taxis
        //DemoInicialFinal demoIni = new DemoInicialFinal();
        //demoIni.run();

        //Demo con varios personajes y taxis
        //DemoAvanzadaFinal demoAvan = new DemoAvanzadaFinal();
        //demoAvan.run();
    }
}
