package discretestochasticsimulation;

public interface IEvent {
    public void setEventDuration(double mean);
    public double getEventDuration();
    public String getEventType();
    public void setEventType(String type);

}
