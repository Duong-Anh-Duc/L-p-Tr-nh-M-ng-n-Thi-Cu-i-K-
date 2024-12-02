package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    public static String sl(int n){
        if(n >= 1000) return "L";
        else if(n >= 500 && n < 1000) return "M";
        else return "S";
    }
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService os = (ObjectService) registry.lookup("RMIObjectService");
        Event event = (Event) os.requestObject("B21DCCN197", "EZqLmhnX");
        String eventCode = sl(event.getExpectedAttendance());
        eventCode += event.getEventName().toUpperCase().charAt(0);
        eventCode += event.getEventName().toUpperCase().charAt(event.getEventName().length() - 1);
        eventCode += event.getEventDate().substring(8) + event.getEventDate().substring(5, 7);
        event.setEventCode(eventCode);
        os.submitObject("B21DCCN197", "EZqLmhnX", event);
    }
}
