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
        String send = "B21DCCN467;N8UDt0b7";
        os.write(send.getBytes());
        os.flush();
        byte[] data = new byte[1024];
        int read = is.read(data);
        String arr[] = new String(data, 0, read).split(",");
        ArrayList<Integer> a = new ArrayList<>();
        for(String x : arr){
            a.add(Integer.parseInt(x));
        }
        Collections.sort(a);
        int s1 = 0, s2 = 0, min_pos = 999999;
        for(int i = 1 ; i < a.size();i++){
            if(a.get(i) - a.get(i - 1) <= min_pos){
                min_pos = a.get(i) - a.get(i - 1);
                s1 = a.get(i - 1);
                s2 = a.get(i);
            }
        }
        os.write((Integer.toString(min_pos) + "," + Integer.toString(s1) + "," + Integer.toString(s2)).getBytes());
        os.flush();
    }
}