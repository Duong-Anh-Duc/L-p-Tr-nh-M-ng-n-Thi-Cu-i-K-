
package RMI;
import java.rmi.registry.*;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService ds = (ByteService) registry.lookup("RMIByteService");
        byte[] data = ds.requestData("B21DCCN239", "06W1XKWV");
        byte[] send = new byte[data.length];
        for(int i = 0 ; i < data.length;i++){
            data[i] += data.length;
            send[i] = data[i];
        }
        ds.submitData("B21DCCN239", "06W1XKWV", send);
    }
}