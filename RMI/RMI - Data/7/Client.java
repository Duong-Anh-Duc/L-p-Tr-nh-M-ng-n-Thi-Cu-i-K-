package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static boolean dx(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds = (DataService) registry.lookup("RMIDataService");
        String res[] = ((String)ds.requestData("B21DCCN166", "Ky3u2Nch")).split("; ");
        int n = Integer.parseInt(res[0]);
        int k = Integer.parseInt(res[1]);
        List<Integer> a = new ArrayList<>();
        for(int i = n ; i < k;i++){
            if(dx(Integer.toString(i))) a.add(i);
        }
        
        ds.submitData("B21DCCN166", "Ky3u2Nch", a);
    }
}
