package src;

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
        bw.write("B21DCCN005;afvEER9o");
        bw.newLine();
        bw.flush();
        String res = br.readLine();
        String arr[] = res.split(" ");
        String word = "";
        int index = 0;
        int max = -99;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i].length()) {
                max = arr[i].length();
                word = arr[i];
            }
        }
        bw.write(word);
        bw.newLine();
        bw.write(Integer.toString(res.indexOf(word)));
        bw.newLine();
        bw.flush();
    }
}