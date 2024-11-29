import TCP.Customer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject("B21DCCN467;T9VtrYv5");
        oos.flush();
        Customer customer = (Customer) ois.readObject();
        String arr[] = customer.getName().split(" ");
        String name = "";
        name += arr[arr.length - 1].toUpperCase() + ", ";
        for(int i = 0 ; i < arr.length - 1;i++){
            name += arr[i].toUpperCase().charAt(0) + arr[i].toLowerCase().substring(1) + (i != arr.length - 2  ? " " : "");
        }
        String birth = customer.getDayOfBirth();
        birth = birth.replace('-', '/');
        birth = birth.substring(3, 6) + birth.substring(0, 3) + birth.substring(6);
        String userName = "";
        for(int i = 0 ; i < arr.length - 1;i++){
            userName += arr[i].toLowerCase().charAt(0);
        }
        userName += arr[arr.length - 1].toLowerCase();
        customer.setName(name);
        customer.setDayOfBirth(birth);
        customer.setUserName(userName);
        oos.writeObject(customer);
        oos.flush();        
    }
}