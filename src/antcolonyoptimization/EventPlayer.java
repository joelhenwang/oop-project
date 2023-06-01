package antcolonyoptimization;

import discretestochasticsimulation.IEvent;
import discretestochasticsimulation.PEC;

public class EventPlayer {

    IEvent current_I_event;
    ExecuteEventStrategy eventStrategy;

    public void setCurrent_event(IEvent IEvent){
        current_I_event = IEvent;
    }

    public void setEventStrategy(ExecuteEventStrategy eventStrategy) {
        this.eventStrategy = eventStrategy;
    }
}
