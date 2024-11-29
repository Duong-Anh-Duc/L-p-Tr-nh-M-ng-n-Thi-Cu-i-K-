import java.rmi.registry.*;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService bs  = (ByteService) registry.lookup("RMIByteService");
        byte[] data = bs.requestData("B21DCCN791", "72APqvbO");
        int cnt[] = new int[256];
        int min_pos = 999999;
        for(byte x : data){
           cnt[x]++;
           min_pos = Math.min(min_pos, cnt[x]);
        }
        byte[] send = new byte[2];
        for(byte x : data){
            if(cnt[x] == min_pos){
                send[0] = x;
                send[1] = (byte) cnt[x];
                break;
            }
        }
        bs.submitData("B21DCCN239", "72APqvbO", send);
    }
}