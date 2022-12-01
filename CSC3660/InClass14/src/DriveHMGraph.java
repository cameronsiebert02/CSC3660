import java.util.ArrayList;

public class DriveHMGraph {
    public static void main(String[] args) {
        HMGraph g = createGraph();
        showtheConnections(g, "Mo");
    }

    private static void showtheConnections(HMGraph g, String node) {
        System.out.printf("\nThe connections for %s are:", node);
        ArrayList<String> connections = g.getConnections(node);
        for(String name: connections){
            System.out.printf("\nC: %s", name);
        }
    }

    private static HMGraph createGraph() {
        HMGraph g = new HMGraph();
        g.addVertex("Mo");
        g.addVertex("Larry");
        g.addVertex("Curly");
        g.addVertex("Shemp");
        // Now add connections
        g.addEdge("Larry", "Curly");
        g.addEdge("Larry", "Mo");
        g.addEdge("Curly", "Shemp");
        return g;
    }
}