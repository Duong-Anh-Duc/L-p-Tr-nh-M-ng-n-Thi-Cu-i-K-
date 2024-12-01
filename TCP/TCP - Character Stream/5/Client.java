package src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("B21DCCN791;DAP6oEfx");
        bw.newLine();
        bw.flush();
        String arr[] = br.readLine().split(" ");
        ArrayList<String> a = new ArrayList<String>();
        for(String x : arr){
            a.add(x);
        }
        String result = "";
        Collections.sort(a);
        for(String x : a){
            result += x + " ";
        }
        result = result.substring(0, result.length() - 1);
        bw.write(result);
        bw.newLine();
        bw.flush();
    }
}