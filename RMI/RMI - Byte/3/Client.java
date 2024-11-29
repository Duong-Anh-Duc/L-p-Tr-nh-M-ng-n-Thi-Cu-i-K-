import java.rmi.registry.*;
import java.util.ArrayList;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService bs  = (ByteService) registry.lookup("RMIByteService");
        byte[] data = bs.requestData("B21DCCN440", "yR15mxfg");
        ArrayList<Integer> a= new ArrayList<>();
        int cnt = 1;
        for(int i = 0 ; i < data.length - 1;i++){
            if(data[i] == data[i + 1]){
                cnt++;
            }
            else{
                a.add((int)data[i]);
                a.add(cnt);
                cnt = 1;
            }
        }
        if(data[data.length - 1] == data[data.length - 2]){
            a.add((int)data[data.length - 1]);
            a.add(cnt);
        }
        else{
            a.add((int)data[data.length - 1]);
            a.add(1);
        }
        byte[] sendData = new byte[a.size()];
        for(int i = 0 ; i < a.size();i++){
            sendData[i] = (byte) (int)a.get(i);
        }
        bs.submitData("B21DCCN440", "yR15mxfg", sendData);
    }
}
