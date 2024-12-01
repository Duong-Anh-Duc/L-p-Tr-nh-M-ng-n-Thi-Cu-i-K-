package src;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        String send = "B21DCCN036;kakMyZgv";
        os.write(send.getBytes());
        os.flush();
        byte[] data = new byte[1024];
        int read = is.read(data);
        String arr[] = new String(data, 0, read).split(",");
        ArrayList<Integer> chan = new ArrayList<>();
        ArrayList<Integer> le = new ArrayList<>();
        
        for(String x : arr){
            int tmp = Integer.parseInt(x);
            if(tmp % 2 == 0) chan.add(tmp);
            else le.add(tmp);
        }
        Collections.sort(chan);
        Collections.sort(le);
        String result = "[";
        for(int i = 0 ; i < chan.size();i++){
            result += chan.get(i) + (i != chan.size() - 1 ? ", " : "");
        }
        result += "];[";
        for(int i = 0 ; i < le.size();i++){
            result += le.get(i) + (i != le.size() - 1 ? ", " : "");
        }
        result += "]";
        os.write(result.getBytes());
        os.flush();
    }
}