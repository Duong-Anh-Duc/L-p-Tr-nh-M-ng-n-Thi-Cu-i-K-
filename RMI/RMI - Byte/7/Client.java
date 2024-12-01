package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService bs = (ByteService) registry.lookup("RMIByteService");
        byte[] data = bs.requestData("B21DCCN174", "P0C43x5C");
        String result = "";
        for(byte x : data){
            result += Integer.toHexString((int)x);
        }
        bs.submitData("B21DCCN174", "P0C43x5C", result.getBytes());
    }
}
