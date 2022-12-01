import java.util.Arrays;
import java.util.Scanner;

public class InClass_adjMatrix {
    public static void main(String[] args) {
        int[][] aMatrix = getAdMatrix();
        String[] nodes = setNodeNames();
        String startNode = getStartNode(nodes);
        int index = findThisNode(startNode, nodes);
        System.out.printf("Index: %s", index);
        if(index == -1){
            System.out.printf("\nSorry node is not found: %s", startNode);
        }else{
            System.out.printf("\nShowing connections from start: %s", startNode);
            int[] theRow = aMatrix[index];
            showWhatConnections(theRow, nodes);
        }
    }

    private static void showWhatConnections(int[] row, String[] nodes) {
        int position = 0;
        for(int nodeIndex : row){
            if(nodeIndex == 1){
                String theNode = nodes[position];
                System.out.printf("\nPlace: %s", theNode);
            }
            position++;
        }
    }

    private static int findThisNode(String startNode, String[] nodes) {
        int index = -1;
        int ct = 0;
        for(String node : nodes){
            if (node.equalsIgnoreCase(startNode)){
                return ct;
            }
            ct++;
        }
        return index;
    }

    private static String getStartNode(String[] nodes) {
        Scanner scan = new Scanner(System.in);
        String startNode = "";
//        Arrays.sort(nodes);
        String oStr = "";
        String cm = "";
        for(String node : nodes){
            oStr += cm + node;
            cm = ", ";
        }
        System.out.printf("\nEnter a start node %s:", oStr);
        startNode = scan.nextLine();
        return startNode;
    }

    private static String[] setNodeNames() {
        String[] nodes = {"Seattle", "San Francisco", "Los Angeles", "Denver", "Kansas City",
                "Chicago", "Boston", "New York", "Atlanta", "Miami", "Dallas", "Houston"};
        return nodes;
    }

    private static int[][] getAdMatrix() {
        int[][] adjacencyMatrix = {
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, // Seattle
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // San Francisco
                {0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, // Los Angeles
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0}, // Denver
                {0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0}, // Kansas City
                {1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0}, // Chicago
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, // Boston
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0}, // New York
                {0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1}, // Atlanta
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, // Miami
                {0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1}, // Dallas
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0}  // Houston
        };
        return adjacencyMatrix;
    }
}
