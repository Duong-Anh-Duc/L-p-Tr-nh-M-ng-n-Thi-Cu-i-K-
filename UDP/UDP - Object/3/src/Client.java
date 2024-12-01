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
         String send1 = ";B21DCCN407;OHNFXnln";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2209));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String id = new String(dp1.getData(), 0, 8);
         ByteArrayInputStream bais = new ByteArrayInputStream(dp1.getData(), 8, dp1.getLength() - 8);
         ObjectInputStream ois = new ObjectInputStream(bais);
         Product product = (Product) ois.readObject();
         String arr[] = product.getName().split(" ");
         String name = arr[arr.length - 1] + " ";
         for(int i = 1 ; i < arr.length - 1;i++){
             name += arr[i] + " ";
         }
         name += arr[0];
         product.setName(name);
         StringBuilder sb = new StringBuilder(Integer.toString(product.getQuantity()));
         product.setQuantity(Integer.parseInt(sb.reverse().toString()));
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos);
         oos.writeObject(product);
         oos.flush();
         byte Id[] = id.getBytes();
         byte ObjectSend[] = baos.toByteArray();
         byte sendData[] = new byte[Id.length + ObjectSend.length];
         System.arraycopy(Id, 0, sendData, 0, Id.length);
         System.arraycopy(ObjectSend, 0, sendData, Id.length, ObjectSend.length);
         socket.send(new DatagramPacket(sendData, sendData.length, InetAddress.getByName("203.162.10.109"), 2209));
    }
}