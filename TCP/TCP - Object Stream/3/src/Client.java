package src;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject("B21DCCN440;RQF92k1q");
        oos.flush();
        String name = "";
        Laptop laptop = (Laptop) ois.readObject();
        String arr[] = laptop.getName().split(" ");
        name += arr[arr.length - 1] + " ";
        for(int i = 1 ; i < arr.length - 1 ;i++){
            name += arr[i];
            name += " ";
        }
        name += arr[0];
        laptop.setName(name);
        StringBuilder sb = new StringBuilder(Integer.toString(laptop.getQuantity()));
        laptop.setQuantity(Integer.parseInt(sb.reverse().toString()));
        oos.writeObject(laptop);
        oos.flush();
    }
}