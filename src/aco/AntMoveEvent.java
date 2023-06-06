package aco;

import pec.Event;

public class AntMoveEvent extends Event{
    private final double weight;
    private final double delta;

    public AntMoveEvent( double time, double weight, double delta){
        this.weight = weight;
        this.delta = delta;

        setEventTime( time ,weight * delta );
        setEventType("ant_move");
    }

}
