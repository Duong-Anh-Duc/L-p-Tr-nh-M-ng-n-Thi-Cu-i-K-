package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds = (DataService) registry.lookup("RMIDataService");
        int n = (int) ds.requestData("B21DCCN440", "DWeGte4n");
        System.out.println(n);
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        for(int i = 1 ; i <= n;i++){
            for(int j = i + 1 ; j <= n ;j++){
                for(int k = j + 1 ; k <= n ;k++){
                    if(i * i + j * j == k * k){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(j);
                        tmp.add(k);
                        a.add(tmp);
                    }
                }
            }
        }
        System.out.println(a);
        ds.submitData("B21DCCN440","DWeGte4n", a);
    }
}
