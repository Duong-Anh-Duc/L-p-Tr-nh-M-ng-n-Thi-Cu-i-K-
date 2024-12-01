package src;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Client {   
    public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String send1 = ";B21DCCN407;h0F0ZkNh";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2208));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String arr[] = new String(dp1.getData(), 0, dp1.getLength()).split(";");
         String result = arr[0] + ";";
         char x = ' ';
         int max_pos = -999;
         int cnt[] = new int[256];
         for(char i : arr[1].toCharArray()){
             cnt[i]++;
             if(cnt[i] > max_pos){
             max_pos = cnt[i];
             x = i;
         }
         }
         result += x + ":";
         for(int i = 0 ; i < arr[1].length() ;i++){
             if(cnt[arr[1].charAt(i)] == max_pos){
                 result += (i + 1) + ",";
             }
         }
         socket.send(new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2208));
    }
}