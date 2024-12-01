package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService bs = (ByteService) registry.lookup("RMIByteService");
        byte[] data = bs.requestData("B21DCCN161", "rDwNO7GG");
        byte[] send = new byte[data.length];
        byte[] PTIT = {80, 84 , 73, 84};
        for(int i = 0 ; i < data.length;i++){
            send[i] = (byte)((int)(data[i] ^ PTIT[i % PTIT.length]));
        }
        bs.submitData("B21DCCN161", "rDwNO7GG", send);
    }
}
