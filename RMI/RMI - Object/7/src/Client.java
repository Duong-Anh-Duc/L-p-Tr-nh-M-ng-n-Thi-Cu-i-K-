package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService os = (ObjectService) registry.lookup("RMIObjectService");
        Ticket ticket = (Ticket) os.requestObject("B21DCCN319", "KxwBnSqq");
        System.out.println(ticket);
        String code = "";
        code += ticket.getEventName().toUpperCase().charAt(0);
        code += ticket.getEventName().toUpperCase().charAt(ticket.getEventName().length() - 1);
        code += ticket.getSaleDate().substring(3, 5);
        code += ticket.getSaleDate().substring(0, 2);
        int cnt[] = new int[10];
        for(char x : ticket.getSaleDate().toCharArray()){
            if(Character.isDigit(x)){
                cnt[x - '0'] = 1;
            }
        }
        for(int i = 9 ; i >= 0;i--){
            if(cnt[i] == 0){
                code += i;
                break;
            }
        }
        for(int i = 0 ; i <= 9;i++){
            if(cnt[i] == 0){
                code += i;
                break;
            }
        }
        ticket.setTicket(code);
        System.out.println(ticket);
        os.submitObject("B21DCCN319", "KxwBnSqq", ticket);
    }
}
