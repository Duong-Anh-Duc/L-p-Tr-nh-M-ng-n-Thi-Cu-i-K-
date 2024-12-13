package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds = (DataService) registry.lookup("RMIDataService");
        String res = (String) ds.requestData("B21DCCN368", "xeiuJVhC");
        String arr[] = res.split(", ");
        ArrayList<Double> a = new ArrayList<>();
        for(String x : arr){
            a.add(Double.parseDouble(x));
        }
        double sum = 0.0;
        for(int i = 0 ; i < a.size();i++ ){
            sum += a.get(i);
        }
        double tbc = sum / a.size();
        double phuongsai = 0.0;
        for(int i = 0 ; i < a.size();i++){
            phuongsai += (a.get(i) - tbc) * (a.get(i) - tbc);
        }
        phuongsai /= a.size();
        double dolechchuan = Math.sqrt(phuongsai);
        String result = "";
        result += String.format( "%.2f", phuongsai) + " : " + String.format( "%.2f", dolechchuan);
        result = result.replace(",", ".");
        ds.submitData("B21DCCN368", "xeiuJVhC",result);
    }
}
