import java.util.ArrayList;

public class GraphInClassAdjacencyList_11_17 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = buildAdList(5);
        showGraph(adj);
    }

    private static void showGraph(ArrayList<ArrayList<Integer>> adj) {
        for(int r = 0; r < adj.size(); r++){
            System.out.printf("\n Showing row: %s", r);
            for(int n = 0; n < adj.get(r).size(); n++){
                System.out.printf(" -> %s", adj.get(r).get(n));
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> buildAdList(int v) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        // One way to initialize if we knew v
        for(int i = 0;i < v;i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        return adj;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int n1, int n2) {
        adj.get(n1).add(n2);
        adj.get(n2).add(n1);
    }
}