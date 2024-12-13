import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        String send = "B21DCCN791;nbLdRpae";
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        os.write(send.getBytes());
        byte[] data = new byte[1024];
        int read = is.read(data);
        String res = new String(data, 0, read);
        int length = -1;
        String result = "";
        for (int i = 0; i < res.length() - 1; i++) {
            int cnt[] = new int[256];
            String ans = Character.toString(res.charAt(i));
            cnt[res.charAt(i)] = 1;
            for (int j = i + 1; j < res.length(); j++) {
                if (cnt[res.charAt(j)] == 1) {
                    break;
                } else {
                    cnt[res.charAt(j)] = 1;
                    ans += res.charAt(j);
                }
            }
            if (ans.length() > length) {
                result = ans;
                length = ans.length();
            }
        }
        os.write((result + ";" + Integer.toString(length)).getBytes());

    }
}