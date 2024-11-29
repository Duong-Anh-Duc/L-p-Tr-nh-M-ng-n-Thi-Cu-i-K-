import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Client {   
    public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String send1 = ";B21DCCN440;xaylN7xW";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2208));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String res = new String(dp1.getData(), 0, dp1.getLength());
         String result = res.split(";")[0] + ";";
         String arr[] = res.split(";")[1].split(" ");
         String name = "";
         for(int i = 0 ; i < arr.length;i++){
             name += arr[i].toUpperCase().substring(0, 1) + arr[i].toLowerCase().substring(1);
             name += (i != arr.length - 1 ? " " : "");
         }
         result += name;
        socket.send(new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2208));
    }
}