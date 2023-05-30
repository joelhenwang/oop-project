import graph.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.createRandomGraph(10);
        HamiltoneanCycle hamil = new HamiltoneanCycle( graph.getNodeList()[1], 5, graph.getNodeList());
        hamil.findCycle();

        for (Node node:graph.getNodeList()) {
            System.out.println(node.getId() + ":");
            for (Edge edge :
                    node.getEdges()) {
                System.out.print((edge.getDestination() + 1) + " ");
            }
            System.out.println();
        }
    }
}