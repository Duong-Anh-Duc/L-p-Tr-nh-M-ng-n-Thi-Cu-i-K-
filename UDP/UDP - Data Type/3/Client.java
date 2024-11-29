import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Client {   
    public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String send1 = ";B21DCCN440;JLPIokkS";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2207));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String res = new String(dp1.getData(), 0, dp1.getLength());
         String result = res.split(";")[0] + ";";
         int sum = 0;
         String arr = res.split(";")[1];
         for(char x : arr.toCharArray()){
             sum += x - '0';
         }
         result += sum;
         socket.send(new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2207));
        
    }
}