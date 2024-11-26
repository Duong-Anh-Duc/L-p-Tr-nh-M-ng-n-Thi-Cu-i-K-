
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        String send = "B21DCCN239;1yovwF9y";
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        os.write(send.getBytes());
        byte[] data = new byte[1024];
        int byteRead = is.read(data);
        String res = new String(data, 0, byteRead);
        int sum = 0;
        String arr[] = res.split("\\|");
        for (String x : arr) {
            sum += Integer.parseInt(x);
        }
        os.write(Integer.toString(sum).getBytes());
    }
}