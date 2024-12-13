import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2207);
        String send = "B21DCCN239;jK528d25";
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(send);
        dos.flush();
        String res = dis.readUTF();
        int s = dis.readInt();
        String result = "";
        for (char x : res.toCharArray()) {
            if (!Character.isLowerCase(x)) {
                result += (char) ((x + s - 'A') % 26 + 'A');
            } else {
                result += (char) ((x + s - 'a') % 26 + 'a');
            }
        }
        dos.writeUTF(result);
        dos.flush();
    }
}