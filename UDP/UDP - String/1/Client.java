import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String send = ";B21DCCN239;a9ntJp7g";
        socket.send(
                new DatagramPacket(send.getBytes(), 0, send.length(), InetAddress.getByName("203.162.10.109"), 2208));
        byte[] data = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(data, data.length);
        socket.receive(dp1);
        String res = new String(dp1.getData(), 0, dp1.getLength());
        String result = res.split("\\;")[0] + ";";
        String xuly = res.split("\\;")[1];
        int cnt[] = new int[256];
        for (char x : xuly.toCharArray()) {
            cnt[x]++;
        }
        for (char x : xuly.toCharArray()) {
            if (cnt[x] != 0) {
                result += Integer.toString(cnt[x]) + x;
                cnt[x] = 0;
            }
        }
        System.out.println(result);
        socket.send(new DatagramPacket(result.getBytes(), 0, result.length(), InetAddress.getByName("203.162.10.109"),
                2208));
    }
}