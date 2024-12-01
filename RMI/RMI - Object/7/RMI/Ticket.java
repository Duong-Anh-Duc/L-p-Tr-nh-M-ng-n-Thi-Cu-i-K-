package RMI;

import java.io.Serializable;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 20241133L;
    private String id;
    private String eventName;
    private String saleDate;
    private String ticket;
    public Ticket() {
        this.id = "";
        this.eventName = "";
        this.saleDate = "";
        this.ticket = "";
    }

    public Ticket(String id, String eventName, String saleDate) {
        this.id = id;
        this.eventName = eventName;
        this.saleDate = saleDate;
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

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", eventName=" + eventName + ", saleDate=" + saleDate + ", ticket=" + ticket + '}';
    }
    
}