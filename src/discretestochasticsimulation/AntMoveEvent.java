package discretestochasticsimulation;

import java.util.Random;

public class AntMoveEvent implements IEvent, Comparable<IEvent> {
    private float weight;
    private float delta;

    private double event_time;

    private String event_type;

    private Random rand;

    private double expDistribution(double mean){
        double next = rand.nextDouble();
        return -mean * Math.log(1.0 - next);
    }
    @Override
    public void setEventTime() {

    }

    @Override
    public float getEventTime() {
        return 0;
    }

    @Override
    public String getEventType() {
        return "ant_move";
    }

    @Override
    public String setEventType() {
        return null;
    }


    @Override
    public int compareTo(IEvent o) {
        return Double.compare(this.event_time, o.getEventTime());
    }
}
