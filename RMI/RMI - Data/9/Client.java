package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
   
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds = (DataService) registry.lookup("RMIDataService");
        int n = (int) ds.requestData("B21DCCN192", "WO3QmuEz");
        System.out.println(n);
        int cost[] = {10, 5, 2, 1};
        String result = "";
        String ans = "";
        int cnt = 0;
        for(int i = 0 ; i < cost.length;i++){
            while(n >= cost[i]){
                ++cnt;
                n -= cost[i];
                ans += cost[i] + ",";
            }
        }
        result += cnt + "; ";
        result += ans;
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
        ds.submitData("B21DCCN192", "WO3QmuEz", result);
    }
}
