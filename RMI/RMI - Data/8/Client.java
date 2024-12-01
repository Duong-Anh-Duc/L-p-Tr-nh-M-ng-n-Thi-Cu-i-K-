package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;

public class Client {
   
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds = (DataService) registry.lookup("RMIDataService");
        String res[] = ((String)ds.requestData("B21DCCN167", "vZWSdf4G")).split("; ");
        ArrayList<Integer> a = new ArrayList<>();
        int k = Integer.parseInt(res[1]);
        for(String x : res[0].split(", ")){
            a.add(Integer.parseInt(x));
        }
        Collections.sort(a);
        ds.submitData("B21DCCN167", "vZWSdf4G", a.get(a.size() - k));
    }
}
