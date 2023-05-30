package graph;

public class Edge {
    private final int destination;
    private final int weight;

    public Edge(int dest, int weight){
        this.weight = weight;
        this.destination = dest;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}
