package RMI;
import java.rmi.registry.*;
import java.util.ArrayList;
public class Client {
    public static boolean check(int n){
        for(int i = 2 ; i <= Math.sqrt(n);i++){
            if(n % i == 0) return false;
        }
        return n > 1;
    }
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds = (DataService) registry.lookup("RMIDataService");
        int n = (int) ds.requestData("B21DCCN239", "vuWrRTFO");
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 2 ; i <= n;i++){
            if(check(i)) a.add(i);
        }
        ds.submitData("B21DCCN239", "vuWrRTFO", a);
    }
}