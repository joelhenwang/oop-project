package graph;

import java.util.ArrayList;

public class Ant {
    private Node current_node;

    private double path_cost;
    private ArrayList<Node> path;

    private ArrayList<Integer> visited;

    public Ant(){
        path = new ArrayList<>();
        visited = new ArrayList<>();
    }

    public Ant(Node current_node){
        this.current_node = current_node;
        path = new ArrayList<>();
        visited = new ArrayList<>();

    }

    public void setCurrent_node(Node node){
        current_node = node;
    }

    public Node getCurrent_node() {
        return current_node;
    }

    public void addToPath(Node node){
        path.add(node);
    }

    public ArrayList<Node> getPath() {
        return path;
    }
}
