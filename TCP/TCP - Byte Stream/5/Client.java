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
        String send = "B21DCCN407;pzOYhvEZ";
        os.write(send.getBytes());
        os.flush();
        byte[] data = new byte[1024];
        int read = is.read(data);
        String arr[] = new String(data, 0, read).split(",");
        ArrayList<Integer> a = new ArrayList<>();
        for(String x : arr){
            a.add(Integer.parseInt(x));
        }
        String result = "";
        Collections.sort(a);
        for(int i = 0 ; i < arr.length;i++){
            if(Integer.parseInt(arr[i]) == a.get(a.size() - 2)){
                result += a.get(a.size() - 2) + "," + i;
                break;
            }
        }
        os.write(result.getBytes());
    }
}