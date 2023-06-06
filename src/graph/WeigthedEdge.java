package graph;

public class WeigthedEdge extends Edge{

    private final double weight;
    public WeigthedEdge(int dest, double weight) {
        super(dest);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}
