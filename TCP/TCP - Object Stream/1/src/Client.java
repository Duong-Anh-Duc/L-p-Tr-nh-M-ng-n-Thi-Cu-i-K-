package src;

import TCP.Product;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        String send = "B21DCCN239;8CH3NIg3";
        oos.writeObject(send);
        oos.flush();
        Product product = (Product) ois.readObject();
        String tmp = Double.toString(product.getPrice()).split("\\.")[0];
        int discount = 0;
        for (char x : tmp.toCharArray()) {
            discount += x - '0';
        }
        product.setDiscount(discount);
        oos.writeObject(product);
        oos.flush();
    }
}