package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;

public class Client {
    public static void Try(int i){
        for(int j = 1 ; j <= n;j++){
            if(vs[j] == false){
                x[i] = j;
                vs[j] = true;
                if(i == n){
                    String tmp = "";
                    for(int q = 1 ; q <= n;q++){
                        tmp += a[x[q] - 1];
                    }
                    result.add(tmp);
                }
                else Try(i + 1);
                vs[j] = false;
            }
        }
    }
    public static int a[];
    public static int x[];
    public static boolean vs[];
    public static int n;
    public static ArrayList<String> result;
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds = (DataService) registry.lookup("RMIDataService");
        String res = (String) ds.requestData("B21DCCN303", "SLzGRAGX");
        String arr[] = res.split(", ");
        n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        String pass = "";
        for(String i : arr){
            pass += i;
            ans.add(Integer.parseInt(i));
        }
        Collections.sort(ans);
        a = new int[n];
        x = new int[100];
        vs = new boolean[100];
        result = new ArrayList<>();
        for(int i = 0 ; i < a.length;i++){
            a[i] = ans.get(i);
        }
        Try(1);
        System.out.println(pass);
        int index = 0;
        for(int i = 0 ; i < result.size();i++){
            if(pass.equals(result.get(i))){
                if(i == result.size() - 1){
                    index = 0;
                }
                else{
                    index = i + 1;
                }
            }
        }
        String send = "";
        for(int i = 0 ; i < result.get(index).length();i++){
            send += result.get(index).charAt(i) + (i != result.get(index).length() - 1 ? "," : "");
        }
        ds.submitData("B21DCCN303", "SLzGRAGX", send);
    }
}
