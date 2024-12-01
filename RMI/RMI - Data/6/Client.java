package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds = (DataService) registry.lookup("RMIDataService");
        int n = (int) ds.requestData("B21DCCN407", "macOADNQ");
        System.out.println(n);
        List<Integer> a = new ArrayList<>();
        for(int i = 1 ; i <= Math.sqrt(n);i++){
            if(i * i <= n){
                a.add(i * i);
            }
        }
        ds.submitData("B21DCCN440", "macOADNQ", a);
    }
}
