package aco;

import graph.Edge;
import graph.Graph;
import graph.IGraph;
import graph.Node;

import javax.swing.*;
import java.util.*;

public class Ant {
    private Node current_node;
    private int nest_node;

    private double path_cost;
    private ArrayList<Integer> path;

    private LinkedList<Edge> path_edges;

    private ArrayList<Boolean> visited;

    public Ant(){
        path = new ArrayList<>();
        visited = new ArrayList<>();
    }

    public Ant(Node current_node){
        this.current_node = current_node;
        this.nest_node = current_node.getId();
        path = new ArrayList<>();
        path_edges = new LinkedList<>();
        visited = new ArrayList<>();

    }

    public int getNestNode() {
        return nest_node;
    }

    public LinkedList<Edge> getPathEdges() {
        return path_edges;
    }

    public void setCurrentNode(Node node){
        current_node = node;
    }

    public Node getCurrentNode() {
        return current_node;
    }

    public void addToPath(int node_id){
        path.add( node_id );
    }
    public void addToPathEdges(Edge edge) { path_edges.addLast(edge); }

    public ArrayList<Integer> getPath() {
        return path;
    }

    public boolean isVisited(int id){
        return visited.get( id );
    }


    // If there's one node that is not ( visited[node] = false )
    // return false -> means that not every node has been visited
    public boolean allVisited() {
        return !visited.contains(false);
    }

    // Return false is theres one neighbour node that has not been visited
    public boolean allNeighVisited(){
        for( Edge edge: current_node.getEdges()){
            if( !visited.get( edge.getId() ) ) return false;
        }
        return true;
    }

    public void chooseNextNode(IGraph graph, Pheromones pheromones){
        List<Edge> edges = current_node.getEdges();
        Random rand = new Random();
        int next_int = rand.nextInt( edges.size() );
        Edge next_edge = edges.get( next_int );
        current_node = graph.getNode( next_edge.getDestination() );
    }

    public List<Edge> getNeighEdges(){
        return current_node.getEdges();
    }

    public List<Edge> getNonVisitedNeighEdges(){
        List<Edge> non_visited_edges = new ArrayList<>();

        for ( Edge edge : getNeighEdges()){
            if (  !path.contains( edge.getDestination() ) ) {
                non_visited_edges.add(edge);
            }
        }

        return non_visited_edges;
    }

    public Edge getNextChosenEdge(Pheromones pheromones, double alpha, double beta){
        List<Edge> edges = getNonVisitedNeighEdges();

        if( edges.size() == 0) edges = getNeighEdges();

        Edge next_edge = null;
        double norm_const = 0.0;


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
                next_edge = edge;
            }
        }

        return next_edge;

    }

    public double edgeFavOutcome(double alpha, double beta, double pheromone, double weight){
        return  (alpha + pheromone) / (beta + weight);
    }

    public void removeCycle(int cycle_start_index){
        for (int i = cycle_start_index + 1; i < path.size(); i++){
            path.remove(i);
            path_edges.removeLast();
        }
    }

    public boolean pathIsHamiltonean(int tot_nodes){
        // Put all array elements in a HashSet
        Set<Integer> s =
                new HashSet<Integer>(path);

        // If all elements are distinct, size of
        // HashSet should be same array.
        return (s.size() == tot_nodes);
    }

}
