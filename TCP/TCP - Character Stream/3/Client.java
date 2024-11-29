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
        bw.write("B21DCCN467;fl5dtfu3");
        bw.newLine();
        bw.flush();
        String res = br.readLine();
        int cnt[] = new int[256];
        String result = "";
        for(char x : res.toCharArray()){
            if(Character.isAlphabetic(x) && cnt[x] == 0){
                result += x;
                cnt[x] = 1;
            }
        }
        bw.write(result);
        bw.newLine();
        bw.flush();
    }
}