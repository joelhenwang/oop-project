package discretestochasticsimulation;

import java.util.Random;

public abstract class Event implements IEvent, Comparable<Event>{
    private double event_duration;

    private String event_type;

    private Random rand;
    public void setEventDuration(double mean){
        event_duration = expDistribution(mean);
    }
    public double getEventDuration(){
        return event_duration;
    }
    public String getEventType(){
        return event_type;
    }

    public void setEventType( String type){
        event_type = type;
    }

    private double expDistribution(double mean){
        double next = rand.nextDouble();
        return -mean * Math.log(1.0 - next);
    }

    @Override
    public int compareTo(Event o) {
        return Double.compare(this.event_duration, o.getEventDuration());
    }
}
