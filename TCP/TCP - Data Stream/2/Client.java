import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
public class Client {   
    public static void main(String[] args) throws Exception {
         Socket socket = new Socket("203.162.10.109", 2207);
         String send = "B21DCCN791;q9LgrHZy";
         DataInputStream dis = new DataInputStream(socket.getInputStream());
         DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
         dos.writeUTF(send);
         dos.flush();
         int n = dis.readInt();
         ArrayList<Integer> a = new ArrayList<>();
         int sum = 0;
         for(int i = 1 ; i <= n;i++){
             int m = dis.readInt();
             sum += m;
             a.add(m);
         }
         float tbc = (float) 1.0 * sum / a.size();
         float ps = 0;
         for(int x : a){
             ps += (x - tbc) * (x - tbc);
         }
         ps /= a.size();
         dos.writeInt(sum);
         dos.writeFloat(tbc);
         dos.writeFloat(ps);
         dos.flush();
        
         
    }
}