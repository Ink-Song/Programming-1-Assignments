import java.text.SimpleDateFormat;

public class Arrangement {
    private final int eventNumber;
    private final String name;
    private final String location;
    private final String host;
    private final String type;
    private final long timestamp;


    /**
     * @param eventNumber - Unique Number For the event. Should be checked against other events before being created.
     * @param name - String name of the event. Should be limited in length.
     * @param location - Location of the vent. Should be limited in length.
     * @param host - Name of the Arranger
     * @param type - What type of event it was
     * @param timestamp - The Date and Time that the event occurred.
     */
    public Arrangement(int eventNumber, String name, String location, String host, String type, long timestamp) {
        this.eventNumber = eventNumber; //Event number should be unique. This should be taken care of before constructing.
        this.name = name;
        this.location = location;
        this.host = host;
        this.type = type;
        this.timestamp = timestamp;
    }

    public int getEventNumber() {
        return eventNumber;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public String getHost() {
        return host;
    }
    public String getType() {
        return type;
    }
    public long getTimestamp() {
        return timestamp;
    }

    public String getTimeAsDate(){
        String date = String.valueOf(timestamp);
        return date.substring(0,4) + "-" + date.substring(4,6) + "-" + date.substring(6,8) + " Time: " + date.substring(8);
        //return new SimpleDateFormat("yyyy-MM-dd-HHHH").format(newDate);
    }

    public int getDateWithoutTime(){
        String date = String.valueOf(timestamp).substring(0,8);
        return Integer.parseInt(date);
    }

    @Override
    public String toString() {
        return "Arrangement: " + name + " ID: " + eventNumber + "\n" + " Timestamp: " + getTimeAsDate() + "\n" + " Location: " + location + "\n" + " Host: " + host + "\n" + " Type: " + type;
    }

}
