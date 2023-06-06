package aco;

import graph.Edge;
import graph.Graph;
import graph.IGraph;
import graph.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ant {
    private Node current_node;

    private double path_cost;
    private ArrayList<Integer> path;

    private ArrayList<Boolean> visited;

    public Ant(){
        path = new ArrayList<>();
        visited = new ArrayList<>();
    }

    public Ant(Node current_node){
        this.current_node = current_node;
        path = new ArrayList<>();
        visited = new ArrayList<>();

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

    public ArrayList<Integer> getPath() {
        return path;
    }

    public boolean isVisited(int id){
        return visited.get( id );
    }

    public boolean allVisited() {
        return !visited.contains(false);
    }

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
}
