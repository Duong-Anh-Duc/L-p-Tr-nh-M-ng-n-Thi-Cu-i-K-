import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
public class Client {   
    public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String send1 = ";B21DCCN174;bjeYPwIQ";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2207));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String arr[] = new String(dp1.getData(), 0, dp1.getLength()).split(";");
         ArrayList<Integer> a = new ArrayList<>();
         String result = arr[0] + ";";
         for(String x : arr[1].split(",")){
             a.add(Integer.parseInt(x));
         }
         Collections.sort(a);
         result += a.get(a.size() - 1) + "," + a.get(0);
         socket.send(new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2207));
    }
}