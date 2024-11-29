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
         String send1 = ";B21DCCN791;J2cCETyx";
         socket.send(new DatagramPacket(send1.getBytes(), send1.length(), InetAddress.getByName("203.162.10.109"), 2209));
         byte[] read = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(read, read.length);
         socket.receive(dp1);
         String id = new String(dp1.getData(), 0, 8);
         System.out.println(id);
         ByteArrayInputStream bais = new ByteArrayInputStream(dp1.getData(), 8, dp1.getLength() - 8);
         ObjectInputStream ois = new ObjectInputStream(bais);
         Student student = (Student) ois.readObject();
         System.out.println(student);
         String arr[] = student.getName().split(" ");
         String name = "";
         for(int i = 0 ; i < arr.length;i++){
             name += arr[i].toUpperCase().substring(0, 1) + arr[i].toLowerCase().substring(1);
             name += (i != arr.length - 1) ? " " : "";
         }
         student.setName(name);
         String email = arr[arr.length - 1].toLowerCase();
         for(int i = 0 ; i < arr.length - 1;i++){
             email += arr[i].toLowerCase().charAt(0);
         }
         email += "@ptit.edu.vn";
         student.setEmail(email);
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos);
         oos.writeObject(student);
         oos.flush();
         byte[] Id = id.getBytes();
         byte[] ObjectSend = baos.toByteArray();
         byte[] DataSend = new byte[Id.length + ObjectSend.length];
         System.arraycopy(Id, 0, DataSend, 0, Id.length);
         System.arraycopy(ObjectSend, 0, DataSend, Id.length, ObjectSend.length);
         socket.send(new DatagramPacket(DataSend, DataSend.length, InetAddress.getByName("203.162.10.109"), 2209));
    }
}