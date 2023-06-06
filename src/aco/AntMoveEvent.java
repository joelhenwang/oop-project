package aco;

import graph.Edge;
import graph.Node;
import graph.WeightedGraph;
import pec.Event;

import java.util.List;

public class AntMoveEvent extends Event{

    private Ant ant;
    private double weight;
    private final double alpha;
    private final double beta;
    private final double delta;


    public AntMoveEvent( double time, double alpha, double beta, double delta, Ant ant, Pheromones pheromones){

        this.alpha = alpha;
        this.beta = beta;
        this.delta = delta;
        setEventType("ant_move");
    }

    public void executeEvent(Pheromones pheromones, WeightedGraph graph){
        int next_node_id = getNextChosenNodeId(pheromones);


        if(ant.isVisited( next_node_id ) || ant.getPath().contains(next_node_id)){
            if( !ant.allNeighVisited() ) executeEvent(pheromones, graph);
        }

        ant.setCurrentNode( graph.getNode(next_node_id) );
    }

    public int getNextChosenNodeId(Pheromones pheromones){
        int next_node_id = ant.getCurrentNode().getId();
        double norm_const = 0.0;
        List<Edge> edges = ant.getCurrentNode().getEdges();

        for (Edge edge : edges) {
            double edge_fav_outcome = edgeFavOutcome(
                    alpha,
                    beta,
                    pheromones.getPheromone(edge),
                    edge.getWeight()
            );
            norm_const += edge_fav_outcome;
        }



        double p = Math.random();
        double cumulativeProbability = 0.0;

        for (Edge edge : edges) {
            cumulativeProbability += edgeFavOutcome(
                                    alpha,
                                    beta,
                                    pheromones.getPheromone(edge),
                                    edge.getWeight()
                                ) / norm_const;

            if (p <= cumulativeProbability) {
                next_node_id = edge.getDestination();
            }
        }

        return next_node_id;

    }



    public double edgeFavOutcome(double alpha, double beta, double pheromone, double weight){
        return  (alpha + pheromone) / (beta + weight);
    }
}
