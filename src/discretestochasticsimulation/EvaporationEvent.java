package discretestochasticsimulation;

import graph.Edge;

public class EvaporationEvent extends Event{
    private final double p;
    private final double n;

    private final Edge edge;

    public EvaporationEvent(double p, double n, Edge edge){
        this.p = p;
        this.n = n;
        this.edge = edge;

        setEventDuration( n );
        setEventType("evaporation");
    }

    public Edge getEdge(){
        return edge;
    }

}
