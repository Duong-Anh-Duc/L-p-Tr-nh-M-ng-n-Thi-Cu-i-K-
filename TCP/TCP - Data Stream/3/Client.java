import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
public class Client {
    public static int ucln(int a, int b){
        if(b == 0) return a;
        return ucln(b, a % b);
    }
    public static int bcnn(int a, int b){
        return a / ucln(a, b) * b;
    }
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("B21DCCN467;WE4akGMM");
        dos.flush();
        int a = dis.readInt();
        int b = dis.readInt();
        dos.writeInt(ucln(a, b));
        dos.writeInt(bcnn(a, b));
        dos.writeInt(a + b);
        dos.writeInt(a * b);
        dos.flush();
    }
}