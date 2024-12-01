package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService bs = (ByteService) registry.lookup("RMIByteService");
        byte[] data = bs.requestData("B21DCCN467", "jBi1oXgV");
        byte[] send = new byte[data.length];
        String result = "";
        for(int i = 0 ; i < data.length;i++){
            result += Integer.toOctalString(data[i]);
        }
       bs.submitData("B21DCCN467", "jBi1oXgV", result.getBytes());
    }
}
