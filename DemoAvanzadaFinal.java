import java.util.*;

/**
 * Provide a simple demonstration of running a stage-one
 * scenario. Several passengers and taxis are created. Pickups are
 * requested. As the simulation is run, the passengers
 * should be picked up and then taken to their destination.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023 DP Classes
 */
public class DemoAvanzadaFinal
{
    TransportCompany company;
    private List<Taxi> actors;

    /**
     * Constructor for objects of class DemoOnePassanger
     */
    public DemoAvanzadaFinal()
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
        Taxi taxi1 = new TaxiExclusive(company, new Location(10, 13),"T2", FuelConsumption.MEDIUM, 7000);
        Taxi taxi2 = new TaxiShuttle(company, new Location(0,0),"T1", FuelConsumption.LOW, 2);
        Taxi taxi3 = new TaxiExclusive(company, new Location(16, 18),"T3", FuelConsumption.HIGH, 9000);
        Taxi taxi4 = new TaxiShuttle(company, new Location(8,19),"T4", FuelConsumption.LOW, 3);
        Taxi taxi5 = new TaxiShuttle(company, new Location(11,1),"T5", FuelConsumption.LOW, 3);
        Taxi taxi6 = new TaxiExclusive(company, new Location(2, 10),"T6", FuelConsumption.HIGH, 9000);

        company.addVehicle(taxi1);
        company.addVehicle(taxi2);
        company.addVehicle(taxi3);
        company.addVehicle(taxi4);
        company.addVehicle(taxi5);
        company.addVehicle(taxi6);

        actors.addAll(company.getVehicles());
    }

    /**
     * Passengers are created and added to the company
     */
    private void createPassengers() {
        Passenger passenger1 = new PassengerNoVip(new Location(2, 2),
                new Location(10, 10),"Kevin", 20, 2000, Reliable.LOW);
        Passenger passenger2 = new PassengerNoVip(new Location(4, 16),
                new Location(19,0),"Margo", 30, 5000, Reliable.HIGH);
        Passenger passenger3 = new PassengerNoVip(new Location(10, 10),
                new Location(2,2),"Edith", 20, 4000, Reliable.HIGH);
        Passenger passenger4 = new PassengerNoVip(new Location(15, 3),
                new Location(7,1),"Stuart", 15, 1000, Reliable.LOW);
        Passenger passenger5 = new PassengerNoVip(new Location(11, 6),
                new Location(19,19),"Agnes", 10, 6000, Reliable.LOW);
        Passenger passenger6 = new PassengerNoVip(new Location(13, 17),
                new Location(0,0),"Scarlet", 25, 6000, Reliable.LOW);
        Passenger passenger7 = new PassengerVip(new Location(0, 0),
                new Location(2, 6),"Lucy", 30, 30000, Reliable.HIGH);
        Passenger passenger8 = new PassengerNoVip(new Location(6, 6),
                new Location(5,2),"Gru", 20, 3000, Reliable.LOW);
        Passenger passenger9 = new PassengerVip(new Location(0, 7),
                new Location(2,1),"Hector", 15, 90000, Reliable.HIGH);
        Passenger passenger10 = new PassengerNoVip(new Location(8,5),
                new Location(1,4),"Dr Nefario", 20, 7000, Reliable.HIGH);

        company.addPassenger(passenger1);
        company.addPassenger(passenger2);
        company.addPassenger(passenger3);
        company.addPassenger(passenger4);
        company.addPassenger(passenger5);
        company.addPassenger(passenger6);
        company.addPassenger(passenger7);
        company.addPassenger(passenger8);
        company.addPassenger(passenger9);
        company.addPassenger(passenger10);
    }

    /**
     * A pickup is requested for a single passenger.
     * @throws IllegalStateException If a pickup cannot be found
     */
    private void runSimulation() {
        List<Passenger> passengers = company.getPassengers();
        for(Passenger passenger : passengers) {
            if(!company.requestPickup(passenger)) {
                throw new IllegalStateException("Failed to find a pickup for: "+ passenger.getName());        
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

        for(Taxi taxi : vehicles) {
            System.out.println(taxi);
        }
        System.out.println("-->> Passengers requesting taxi <<--");
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
        Collections.sort(vehicles, new ComparadorPasTransportadosTaxi()); // ComparadorPassenger?
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
