import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        String send = "B21DCCN239;Gi9V4mHo";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw.write(send);
        bw.newLine();
        bw.flush();
        String res1 = br.readLine();
        String res2 = br.readLine();
        String result = "";
        for (char x : res1.toCharArray()) {
            boolean check = false;
            for (char y : res2.toCharArray()) {
                if (x == y)
                    check = true;
            }
            if (!check)
                result += x;
        }
        bw.write(result);
        bw.newLine();
        bw.flush();
    }
}