package FinalProblems;

import DirectedGraphHW.Vertex;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphWeightedFE {
    HashMap<String, ArrayList<Node>> graph = new HashMap<>();
    public boolean addNode( String nName ) {
        // ToDo: Write this method that adds the String nName to this.graph
        //     Returns True when added successfully
        //             False is String already exists in the graph as a key
        ArrayList<Node> nodes = new ArrayList<>();
        if(graph.isEmpty()){
            graph.put(nName, nodes);
        } else {
            for(String key : graph.keySet()){
                if (nName.equalsIgnoreCase(key)) {
                    return false;
                }
            }
            graph.put(nName, nodes);
        }
        return true;
    }
    public boolean  addEdge(String source, String destName, int weight){
        Node destNode = new Node(destName, weight);
        // ToDo: Complete this method that adds the node to the vertix with String Source
        //          Returns: True if added successfully
        //          Returns False if the vertex source does not exist in the graph
        for(String key : graph.keySet()){
            if (source.equalsIgnoreCase(key)){
                graph.get(source).add(destNode);
            }
        }
        return true;
    }
    public void printGraph(){
        // 'ToDo: Write this method that outputs the graph
        //          in the format shown in the ppt slids
        for(String key : graph.keySet()){
            System.out.printf("\nVertex: %s", key);
            for(Node cur : graph.get(key)){
                System.out.printf("\n--- Node: %s Distance: %s", cur.Name, cur.weight);
            }
        }
    }

    public boolean gotRoute( String startCity, String endCity ){
        // ToDo: Starts at startCity and determine if there is a path from
        //      startCity to endCity
        // ToDo: Returns True if there is a path from startCity to endCity
        //         false if there is not a path
        for (Node n : graph.get(startCity)){
            if(n.Name.equalsIgnoreCase(endCity)) {
                return true;
            } else if (!n.Name.equalsIgnoreCase(endCity)) {
                for(Node o : graph.get(n.Name)){
                    if(o.Name.equalsIgnoreCase(endCity)){
                        return true;
                    } else if (!o.Name.equalsIgnoreCase(endCity)) {
                        for(Node p : graph.get(o.Name)){
                            if(p.Name.equalsIgnoreCase(endCity)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
    class Node {
        String Name;
        int weight;
        public Node(String name, int weight) {
            this.Name =  name;
            this.weight = weight;
        }
    }