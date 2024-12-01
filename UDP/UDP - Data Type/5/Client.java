import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Client {   
    public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String send1 = ";B21DCCN407;XEg4gPk4";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2207));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String arr[] = new String(dp1.getData(), 0, dp1.getLength()).split(";");
         String result = arr[0] + ";";
         int s = Integer.parseInt(arr[2]);
         String strDecode = "";
         for(char x : arr[1].toCharArray()){
             if(Character.isUpperCase(x)){
                 strDecode += (char)((x + s - 'A') % 26 + 'A');
             }
             else {
                 strDecode += (char)((x + s - 'a') % 26 + 'a');
             }
         }
        result += strDecode;
        socket.send(new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2207));
    }
}