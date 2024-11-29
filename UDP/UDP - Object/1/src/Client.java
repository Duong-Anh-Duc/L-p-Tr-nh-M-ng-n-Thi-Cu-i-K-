package src;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Client {   
    public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String send1 = ";B21DCCN239;bc5mHCpX";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2209));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String id = new String(dp1.getData(), 0, 8);
         ByteArrayInputStream bais = new ByteArrayInputStream(dp1.getData(), 8, dp1.getLength() - 8);
         ObjectInputStream ois = new ObjectInputStream(bais);
         Customer customer = (Customer) ois.readObject();
         String arr[] = customer.getName().split(" ");
         String name = "";
         name += arr[arr.length - 1].toUpperCase() + ", ";
         String username = "";
         for(int i = 0 ; i < arr.length - 1;i++){
             name += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1).toLowerCase();
             name += (i != arr.length - 2) ? " " : "";
             username += arr[i].toLowerCase().charAt(0);
         }
         username += arr[arr.length - 1].toLowerCase();
         String birth = customer.getDayOfBirth();
         birth = birth.replace('-', '/');
         birth = birth.substring(3, 6) + birth.substring(0, 3) + birth.substring(6);
         customer.setName(name);   
         customer.setUserName(username);
         customer.setDayOfBirth(birth);
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos);
         oos.writeObject(customer);
         oos.flush();
         byte[] idsend = id.getBytes();
         byte[] Objectsend = baos.toByteArray();
         byte[] sendData = new byte[idsend.length + Objectsend.length];
         System.arraycopy(idsend, 0, sendData, 0, idsend.length);
         System.arraycopy(Objectsend, 0, sendData, idsend.length, Objectsend.length);
         socket.send(new DatagramPacket(sendData, sendData.length, InetAddress.getByName("203.162.10.109"), 2209));
         socket.close();
    }
}