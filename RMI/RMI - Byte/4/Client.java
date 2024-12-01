package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService bs  = (ByteService) registry.lookup("RMIByteService");
        byte[] data = bs.requestData("B21DCCN239", "xfuCACxt");
        ArrayList<Byte> chan = new ArrayList<>();
        ArrayList<Byte> le = new ArrayList<>();
        for(byte x : data){
            if(x % 2 == 0) chan.add(x);
            else le.add(x);
        }
        byte[] send = new byte[data.length];
        for(int i = 0 ; i < chan.size();i++){
            send[i] = chan.get(i);
        }
        for(int i = 0 ; i < le.size();i++){
            send[i + chan.size()] = le.get(i);
        }
        bs.submitData("B21DCCN239", "xfuCACxt", send);
    }
}