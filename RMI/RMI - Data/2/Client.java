
import java.rmi.registry.*;
import java.util.ArrayList;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds  = (DataService) registry.lookup("RMIDataService");
        int n = (int) ds.requestData("B21DCCN791", "elzG9DKp");
        int m = n;
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 2 ; i <= Math.sqrt(m);i++){
            if(n % i == 0){
                while(n % i == 0){
                    a.add(i );
                    n /= i;
                }
            }
        }
        if(n != 1) a.add(n);     
        ds.submitData("B21DCCN239", "elzG9DKp", a);
    }
}