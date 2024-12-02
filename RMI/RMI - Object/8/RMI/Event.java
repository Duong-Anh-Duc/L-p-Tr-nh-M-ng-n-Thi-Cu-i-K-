package RMI;

import java.io.Serializable;

public class Event implements Serializable {
    private static final long serialVersionUID = 20241131L;
    private String id;
    private String eventName;
    private String eventDate;
    private int expectedAttendance;
    private String eventCode;
    public Event(){
        
    }

    public Event(String id, String eventName, String eventDate, int expectedAttendance) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.expectedAttendance = expectedAttendance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getExpectedAttendance() {
        return expectedAttendance;
    }

    public void setExpectedAttendance(int expectedAttendance) {
        this.expectedAttendance = expectedAttendance;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", expectedAttendance=" + expectedAttendance + ", eventCode=" + eventCode + '}';
    }
    
}