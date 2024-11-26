import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static boolean snt(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return n > 1;
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String send = ";B21DCCN239;pIptgvaW";
        socket.send(
                new DatagramPacket(send.getBytes(), 0, send.length(), InetAddress.getByName("203.162.10.109"), 2207));
        byte[] data = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(data, data.length);
        socket.receive(dp1);
        String res = new String(dp1.getData(), 0, dp1.getLength());
        String result = res.split("\\;")[0] + ";";
        int n = Integer.parseInt(res.split("\\;")[1]);
        int cnt = 0;
        for (int i = 2; i <= 1000; i++) {
            if (cnt >= n)
                break;
            if (snt(i)) {
                result += Integer.toString(i);
                result += ",";
                cnt++;
            }
        }
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
        socket.send(
                new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2207));
    }
}