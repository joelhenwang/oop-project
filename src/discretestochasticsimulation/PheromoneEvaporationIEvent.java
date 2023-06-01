package discretestochasticsimulation;

public class PheromoneEvaporationIEvent implements IEvent {
    private float weight;
    private float gama;

    private double event_time;

    @Override
    public void setEventTime(){

    }

    @Override
    public float getEventTime() {
        return 0;
    }

    @Override
    public String getEventType(){
        return "pheromone_evaporation";
    }

}
