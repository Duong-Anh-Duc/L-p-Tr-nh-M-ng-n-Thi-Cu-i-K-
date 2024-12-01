import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("B21DCCN407;viSsFpPA");
        dos.flush();
        float[] xs = new float[7];
        int cnt[] = new int[7];
        int n = dis.readInt();
        for(int i = 1 ; i <= n;i++){
            int tmp = dis.readInt();
            cnt[tmp]++;
        }
        for(int i = 1 ; i <= 6;i++){
            xs[i] = (float) cnt[i] / n;
            dos.writeFloat(xs[i]);
        }    
    }
}