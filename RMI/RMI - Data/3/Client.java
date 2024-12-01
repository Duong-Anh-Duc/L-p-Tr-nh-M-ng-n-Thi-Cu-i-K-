package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
public class Client {
    public static void Try(int i){
        for(int j = x[i - 1] + 1; j <= n - k + i;j++){
            x[i] = j;
            if(i == k){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                for(int q = 1 ; q <= k;q++){
                    tmp.add(a[x[q] - 1]);
                }
                result.add(tmp);
            }
            else Try(i + 1);
            
        }
    }
    public static ArrayList<ArrayList<Integer>> result;
    public static int n;
    public static int k;
    public static int x[];
    public static int a[];
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds  = (DataService) registry.lookup("RMIDataService");
        String res = (String) ds.requestData("B21DCCN239","m9BmFncT");
        String arr[] = res.split(";");
        ArrayList<Integer> so = new ArrayList<>();
        k = Integer.parseInt(arr[1].trim());
        String tmp[] = arr[0].split(", ");
        for(String x : tmp){
            so.add(Integer.parseInt(x));
        }
        n = so.size();
        a = new int[n];
        x = new int[100];
        x[0] = 0;
        for(int i = 0 ; i < n;i++){
            a[i] = so.get(i);
        }
        result = new ArrayList<ArrayList<Integer>>();
        Try(1);
        ds.submitData("B21DCCN239", "m9BmFncT", result);
    }
}