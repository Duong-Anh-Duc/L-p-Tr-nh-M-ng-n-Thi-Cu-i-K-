package src;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Client {   
    public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String send1 = ";B21DCCN407;gQ3gOHvz";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2208));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String arr[] = new String(dp1.getData(), 0, dp1.getLength()).split(";");
         String result = arr[0] + ";";
         int cnt[] = new int[256];
         for(char x : arr[2].toCharArray()){
             cnt[x] = 1;
         }
         for(char x : arr[1].toCharArray()){
             if(cnt[x] == 0){
                 result += x;
             }
         }
         socket.send(new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2208));
    }
}