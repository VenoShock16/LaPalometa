import java.util.*;

/**
 * Provide a simple demonstration of running a stage-one
 * scenario. A single passenger and taxi are created, and a pickup
 * requested. As the simulation is run, the passenger
 * should be picked up and then taken to their destination.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023 DP Classes
 */
public class DemoTwoPassengers
{
    TransportCompany company;
    private List<Actor> actors;

    /**
     * Constructor for objects of class DemoOnePassanger
     */
    public DemoTwoPassengers()
    {
        company = new TransportCompany("Compañía Taxis Cáceres");
        actors = new ArrayList<>();
        reset();
    }

    /**
     * Run the demo for a fixed number of steps.
     */
    public void run()
    {        
        //Ejecutamos un número de pasos la simulación.
        //En cada paso, cada taxi realiza su acción
        for(int step = 0; step < 100; step++) {
            step();
        }
        showFinalInfo();
    }

    /**
     * Run the demo for one step by requesting
     * all actors to act.
     */
    public void step()
    {
        for(Actor actor : actors) {
            actor.act();
        }
    }

    /**
     * Reset the demo to a starting point.
     * A single taxi and passenger are created, and a pickup is
     * requested for a single passenger.
     * @throws IllegalStateException If a pickup cannot be found
     */
    public void reset()
    {
        actors.clear();

        createTaxis();
        createPassengers(); 
        showInicialInfo();
        runSimulation();
    }

    /**
     * Taxis are created and added to the company
     */
    private void createTaxis() {
        Taxi taxi = new TaxiExclusive(company, new Location(10, 10),"T1", FuelConsumption.MEDIUM, 7000);
        Taxi taxi2 = new TaxiShuttle(company, new Location(8,8),"T2", FuelConsumption.LOW, 2);

        company.addVehicle(taxi);
        company.addVehicle(taxi2);
        actors.addAll(company.getVehicles());
    }

    /**
     * Passengers are created and added to the company
     */
    private void createPassengers() {
        Passenger passenger = new PassengerVip(new Location(6, 6),
                new Location(5,2),"Lucy", 30, 30000, Reliable.HIGH);
        Passenger passenger2 = new PassengerNoVip(new Location(2,3),
                new Location(3,10),"Gru", 20, 2000, Reliable.LOW);
        company.addPassenger(passenger);        
        company.addPassenger(passenger2);
    }

    /**
     * A pickup is requested for a single passenger.
     * @throws IllegalStateException If a pickup cannot be found
     */
    private void runSimulation() {
        List<Passenger> passengers = company.getPassengers();

        for(Passenger passenger : passengers) {
            if(!company.requestPickup(passenger)) {
                throw new IllegalStateException("Failed to find a pickup.");        
            }
        }
    }

    /**
     * Initial info is showed with the information about taxis and passengers
     */
    private void showInicialInfo() {
        List<Taxi> vehicles = company.getVehicles();
        List<Passenger> passengers = company.getPassengers();
        Collections.sort(vehicles, new ComparadorNombreTaxi());
        Collections.sort(passengers, new ComparadorNombrePassenger());
        System.out.println("--->> Simulation of the company: "+company.getName()+" <<---");
        System.out.println("-->> Taxis of the company <<--");

        for(Taxi  taxi : vehicles) {
            System.out.println(taxi);
        }
        System.out.println("-->> Passengers requesting taxi <<--");
        Collections.sort(passengers, new ComparadorPasHoraLlegada());

        for(Passenger passenger : passengers) {
            System.out.println(passenger);
        }
        System.out.println("");
        System.out.println("-->> ---------------- <<--");
        System.out.println("-->> Simulation start <<--");
        System.out.println("-->> ---------------- <<--");
        System.out.println("");        
    }

    /**
     * Final info is showed with the information about taxis and passengers
     */
    private void showFinalInfo() {
        List<Taxi> vehicles = company.getVehicles();
        List<Passenger> passengers = company.getPassengers();
        Collections.sort(vehicles, new ComparadorPasTransportadosTaxi());
        Collections.sort(passengers, new ComparadorNombrePassenger());

        System.out.println("");
        System.out.println("-->> ----------------- <<--");
        System.out.println("-->> End of simulation <<--");        
        System.out.println("-->> ----------------- <<--");
        System.out.println("");

        System.out.println("-->> Taxis final information <<--");

        for(Taxi  taxi : vehicles) {
            System.out.println(((Taxi)taxi).showFinalInfo());
        }
        System.out.println("-->> Passengers final information <<--");
        for(Passenger passenger : passengers) {
            System.out.println(passenger.showFinalInfo());
        }
        //Muestra los Taxis con menos turnos inactivos y Taxis con más valoración
        company.showFinalInfo();

    }
}
