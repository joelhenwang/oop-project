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
        int tot_nodes = 10;
        int max_weight = 10;
        WeightedGraph graph = new WeightedGraph(tot_nodes);
        graph.createRandomGraph(max_weight);


        double curr_time = 0.0;
        int colony_size = 3;
        int ants_simulated = 0;
        double sim_time = 100.0;
        double alpha = 1.5;
        double beta = 1.2;
        double delta = 1.5;
        Node node_1 = graph.getNode(0);

        Pheromones pheromones = new Pheromones( graph.getMaxEdges() );
        PEC pec = new PEC();

        for(int n_ant = 1; n_ant <= colony_size; n_ant++){
            Ant ant = new Ant(node_1);

            Edge next_edge = ant.getNextChosenEdge(pheromones, alpha, beta );

            pec.addEvent( new AntMoveEvent( curr_time, graph, ant, next_edge, delta ) );

            while (curr_time < sim_time && ants_simulated < colony_size){

                if(ant.getPathEdges().size() > tot_nodes){
                    if (ant.pathIsHamiltonean(tot_nodes)) {
                        // create evap events
                        System.out.println(ant.getPathEdges());
                        break;
                    }
                }



                next_edge = ant.getNextChosenEdge(pheromones, alpha, beta );

                pec.addEvent( new AntMoveEvent( curr_time, graph, ant, next_edge, delta ) );


                break;
            }
        }






    }
}