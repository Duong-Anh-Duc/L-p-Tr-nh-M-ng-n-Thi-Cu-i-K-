package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService bs = (ByteService) registry.lookup("RMIByteService");
        byte[] data = bs.requestData("B21DCCN105", "basdfDnt");
        byte[] result = Base64.getDecoder().decode(data);
        bs.submitData("B21DCCN105", "basdfDnt", result);     
    }
}
