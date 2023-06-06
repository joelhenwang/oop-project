import aco.Ant;
import aco.AntMoveEvent;
import aco.Pheromones;
import graph.*;
import pec.Event;
import pec.PEC;

import java.util.List;

public class Main {

    public static double edgeFavOutcome(double alpha, double beta, double pheromone, double weight){
        return  (alpha + pheromone) / (beta + weight);
    }
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(10);
        graph.createRandomGraph(10);
//        HamiltoneanCycle hamil = new HamiltoneanCycle( graph.getNodeList()[1], 5, graph.getNodeList());
//        hamil.findCycle();
//
//        for (Node node:graph.getNodeList()) {
//            System.out.println(node.getId() + ":");
//            for (Edge edge :
//                    node.getEdges()) {
//                System.out.print((edge.getDestination() + 1) + " ");
//            }
//            System.out.println();
//        }
        double curr_time = 0.0;
        int colony_size = 3;
        int ants_simulated = 0;
        double sim_time = 100.0;
        Node node_1 = graph.getNode(0);
        Ant ant = new Ant(node_1);
        Pheromones pheromones = new Pheromones( graph.getMaxEdges() );
        PEC pec = new PEC();

        while (curr_time < sim_time && ants_simulated < colony_size){
            break;
        }




    }
}