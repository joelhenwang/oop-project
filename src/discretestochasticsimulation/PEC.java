package discretestochasticsimulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PEC {
    List<IEvent> event_list = new ArrayList<>();
    private int event_index = 0;
    private float current_time;

    public PEC(){
        current_time = 0;
    }

    public IEvent getNextEvent(){
        IEvent next_I_event = IEvents.get(event_index);
        event_index++;
        return next_I_event;
    }

    public void addEvent(IEvent new_I_event){
        event_list.add(new_I_event);
        Collections.sort(event_list);
    }

}
