import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Client {   
    public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String send1 = ";B21DCCN791;jSQOmpQe";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2207));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String res = new String(dp1.getData(), 0, dp1.getLength());
         String result = res.split(";")[0] + ";";
         int n = Integer.parseInt(res.split(";")[1]);
         String arr[] = res.split(";")[2].split(",");
         int cnt[] = new int[101];
         for(String x : arr){
             cnt[Integer.parseInt(x)] = 1;
         }
         for(int i = 1 ; i <= n;i++){
             if(cnt[i] == 0){
                 result += Integer.toString(i);
                 result += ",";
             }
             
         }
         result = result.substring(0, result.length() - 1);
         socket.send(new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2207));
    }
}