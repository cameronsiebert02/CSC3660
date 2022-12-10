package DirectedGraphHW;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class HWDriverPrep {
    public static void main(String[] args) {
        HWGraph g = createGraph();
        printGraph( g );
        Set<String> keys = g.getKeys();
        String startCity = "Chicago";
        String layOver = getLayOverCity( keys, startCity);
        Vertex v = g.getThisVertex( startCity, layOver);
        System.out.printf("\n The connections from Start:%s with layover N:%s are (%s):", startCity, v.label, v.weight);

        showConnections( g, v );
    }

    private static void printGraph(HWGraph g) {
        //ToDo: Write This Method
        // What: This method should accept a constructuted graph and output the complete graph
        //    It should show the node and each connection to the node.
        for(String key : g.graphMap.keySet()){
            System.out.printf("\n-----Showing connections for key: %s", key);
            for(Vertex v : g.graphMap.get(key)){
                System.out.printf("\nCity: %s Distance: %s", v.label, v.weight);
            }
        }
    }

    private static String getLayOverCity(Set<String> keys, String startCity) {
        //ToDo: Write This Method
        // What:  This method should show all the keys that are NOT the startCity
        //        and prompt the user for a layover city.
        // Returns: the city that the user input
        Scanner scan = new Scanner(System.in);
        String uInput = "";
        System.out.printf("\nSelect a layover city (");
        StringBuilder sb = new StringBuilder();
        String cma = "";
        for (String s : keys) {
            if(s.equalsIgnoreCase(startCity)){
                continue;
            }
            sb.append(cma).append(s);
            cma = ", ";
        }
        System.out.printf(sb.toString() + ") ");
        try {
            uInput = scan.nextLine();
        }catch (Exception e){
            System.out.printf("Please enter a city from the above list: ");
            uInput = scan.nextLine();
        }

        return uInput;
    }

    private static void showConnections(HWGraph g, Vertex layOverVertex) {
      // ToDo: Write this method
        // What: This method inputs the graph (g) and the layoverVertex.
        // Output: All of the cities connected to the layover vertex, their distance and total distance from Chicago
        // E.g.,
        // The connections from Start:Chicago with layover N:New York are (790):
        //      Name:Houston Distance:1647 Total Distance:2437
        //     Name:Orlando Distance:1080 Total Distance:1870
        if(g.graphMap.get(layOverVertex).size() == 0){
            System.out.printf("\nOThere are no connections from this city");
        }
        for(Vertex v : g.graphMap.get(layOverVertex.label)){
            System.out.printf("\nName: %s Distance: %s Total Distance: %s", v.label, v.weight, v.weight + layOverVertex.weight);
        }
    }

    private static HWGraph createGraph() {
        //Todo: Write this method
        // Create the directed graph shown in the problem. Properly construct it to connect all node
        // Returns: The properly connected HWGraph9
        HWGraph map = new HWGraph();
        map.addVertex("Chicago");
        map.addVertex("Dallas");
        map.addVertex("Atlanta");
        map.addVertex("New York");
        map.addVertex("Houston");
        map.addVertex("Orlando");
        Vertex cNewYork = new Vertex("New York", 790);
        Vertex cAtlanta = new Vertex("Atlanta", 718);
        Vertex cDallas = new Vertex("Dallas", 968);
        map.addEdge("Chicago", cNewYork);
        map.addEdge("Chicago", cAtlanta);
        map.addEdge("Chicago", cDallas);
        Vertex dOrlando = new Vertex("Orlando", 1120);
        Vertex dHouston = new Vertex("Houston", 239);
        map.addEdge("Dallas", dOrlando);
        map.addEdge("Dallas", dHouston);
        Vertex aDallas = new Vertex("Dallas", 781);
        Vertex aNewYork = new Vertex("New York", 870);
        Vertex aOrlando = new Vertex("Orlando", 438);
        map.addEdge("Atlanta", aDallas);
        map.addEdge("Atlanta", aNewYork);
        map.addEdge("Atlanta", aOrlando);
        Vertex nyHouston = new Vertex("Houston", 1647);
        Vertex nyOrlando = new Vertex("Orlando", 1080);
        map.addEdge("New York", nyHouston);
        map.addEdge("New York", nyOrlando);
        Vertex hOrlando = new Vertex("Orlando", 967);
        map.addEdge("Houston", hOrlando);

        return map;
    }
}