import java.util.*;

/**
 * Provide a simple demonstration of running a stage-one
 * scenario. Two orders and three delivery persons are created. 
 * Two pickups are requested. As the simulation is run, the orders
 * should be picked up and then delivered to their destination.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes
 */
public class DemoInicial
{
    DeliveryCompany company;
    private List<DeliveryPerson> actors; //simulation's actors, they are the delivery persons
                                         //of the company

    /**
     * Constructor for objects of class DemoOneOrder
     */
    public DemoInicial()
    {
        company = new DeliveryCompany("Compañía DP Delivery Cáceres");
        actors = new ArrayList<>();
        reset();
    }

    /**
     * Run the demo for a fixed number of steps.
     */
    public void run()
    {        
        //Ejecutamos un número de pasos la simulación.
        //En cada paso, cada persona de reparto realiza su acción
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
        for(DeliveryPerson actor : actors) {
            actor.act();
        }
    }

    /**
     * Reset the demo to a starting point.
     * A single delivery person and order are created, and a pickup is
     * requested for a single order.
     * @throws IllegalStateException If a pickup cannot be found
     */
    public void reset()
    {
        actors.clear();

        createDeliveryPersons();
        createOrders(); 
        showInicialInfo();
        runSimulation();
    }

 /**
     * DeliveryPersons are created and added to the company
     */
    private void createDeliveryPersons() {
        DeliveryPerson dp1 = new DeliveryPerson(company, new Location(3, 3),"DP2");
        DeliveryPerson dp2 = new DeliveryPerson(company, new Location(10, 10),"DP1");
        DeliveryPerson dp3 = new DeliveryPerson(company, new Location(12, 14),"DP3");
        
        company.addDeliveryPerson(dp1);
        company.addDeliveryPerson(dp2);
        company.addDeliveryPerson(dp3);
        actors.addAll(company.getDeliveryPersons());
    }

    /**
     * Orders are created and added to the company
     */
    private void createOrders() {
        Location whLocation=company.getlocationWareHouse();
        Order order1 = new Order("Lucy", whLocation,
                new Location(2, 6),10, 1.2, "Decathon Cáceres");
        Order order2 = new Order("Gru", whLocation,
                new Location(5,2),10, 1.5, "Pintores");
        Order order3 = new Order("Kevin", whLocation,
                new Location(14,2),11, 2.2, "Ruta de la Plata");
        company.addOrder(order1);
        company.addOrder(order2);
        company.addOrder(order3);
    }

    /**
     * A pickup is requested for a single order.
     * @throws IllegalStateException If a pickup cannot be found
     */
    private void runSimulation() {
        List<Order> orders = company.getOrders();

        Collections.sort(orders,new ComparadorTimeAndDestinationNameOrder());
        
        for(Order order : orders) {
            if(!company.requestPickup(order)) {
                throw new IllegalStateException("Failed to find a pickup.");        
            }
        }

    }

    /**
     * Initial info is showed with the information about delivery persons and orders
     */
    private void showInicialInfo() {

        System.out.println("--->> Simulation of the company: "+company.getName()+" <<---");
        System.out.println("-->> Delivery persons of the company <<--");
        System.out.println("-->> ------------------------------- <<--");

        List<DeliveryPerson> actorsSort = new ArrayList<>(actors);
        Collections.sort(actorsSort, new ComparadorNombreDeliveryPerson());
        Iterator<DeliveryPerson> iteratorActors = actorsSort.iterator();
        while(iteratorActors.hasNext()){
            System.out.println(iteratorActors.next());
        }
        
        System.out.println("-->> Orders to be picked up <<--");
        System.out.println("-->> ---------------------- <<--");

        List<Order> orders = new ArrayList<>(company.getOrders());
        Collections.sort(orders, new ComparadorOrderDeliveryPersonName());
        
        Iterator<Order> iteratorOrders = orders.iterator();
        while(iteratorOrders.hasNext()){
            Order order = iteratorOrders.next();
            System.out.println(order);
        }

        System.out.println(" ");        
        System.out.println("-->> Simulation start <<--");
        System.out.println("-->> ---------------- <<--");
        System.out.println(" ");        
    }

    /**
     * Final info is showed with the information about delivery persons and orders
     */
    private void showFinalInfo() {

        System.out.println(" ");
        System.out.println("-->> ----------------- <<--");
        System.out.println("-->> End of simulation <<--");        
        System.out.println("-->> ----------------- <<--");
        System.out.println(" ");

        System.out.println("-->> Delivery persons final information <<--");
        System.out.println("-->> ---------------------------------- <<--");

        actors.stream()
        .sorted(new ComparadorDeliveryPersonOrdersDeliveredAndName())
        .forEach((actor)->System.out.println( actor.showFinalInfo() ));
        
        System.out.println("-->> Orders final information <<--");
        System.out.println("-->> ------------------------ <<--");
 
        List<Order> orders = company.getOrders();
        orders.stream()
        .sorted(new ComparadorTimeAndDestinationNameOrder())
        .forEach((order)-> System.out.println(order.showFinalInfo()) );
    }
}
