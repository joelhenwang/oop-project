package discretestochasticsimulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PEC {
    List<Event> event_list = new ArrayList<>();
    private int event_index = 0;
    private double current_time;

    public PEC(){
        current_time = 0;
    }

    public Event getNextEvent(){
        return event_list.get(event_index++);
    }

    public void addEvent(Event new_event){
        event_list.add(new_event);
        Collections.sort(event_list);
    }

}
