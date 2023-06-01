package discretestochasticsimulation;

import java.util.Random;

public class AntMoveEvent extends Event implements IEvent, Comparable<Event> {
    private double weight;
    private double delta;

    public AntMoveEvent( double weight, double delta){
        this.weight = weight;
        this.delta = delta;

        setEventDuration( weight * delta );
        setEventType("ant_move");
    }

}
