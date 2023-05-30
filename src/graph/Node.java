package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final int id;
    List<Edge> edges = new ArrayList<>();
    List<Integer> linked = new ArrayList<>();

    public Node(int id){
        this.id = id;
    }

    public void addEdgeToNode(int dest, int weight){
        if( linked.contains(dest ) ){
            throw new RuntimeException("Edge with node " + dest + " already exists");
        }
        linked.add(dest);
        this.edges.add( new Edge( dest, weight) );
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return Integer.toString(id);
    }
}


