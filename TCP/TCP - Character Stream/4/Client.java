import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("B21DCCN407;uomT1w2h");
        bw.newLine();
        bw.flush();
        String res = br.readLine();
        String svc = "", db = "";
        for(char x : res.toCharArray()){
            if(Character.isAlphabetic(x) || Character.isDigit(x)) svc += x;
            else db += x;
        }
        bw.write(svc);
        bw.newLine();
        bw.flush();
        bw.write(db);
        bw.newLine();
        bw.flush();
    }
}