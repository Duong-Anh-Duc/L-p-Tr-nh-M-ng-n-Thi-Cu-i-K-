package src;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class Client {
    public static String cd(float n){
        if(n >= 3.7) return "A";
        else if(n >= 3.0 && n < 3.7) return "B";
        else if(n >= 2.0 && n < 3.0) return "C";
        else if(n >= 1.0 && n < 2.0) return "D";
        return "F";
    }
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject("B21DCCN407;eZIASWfO");
        oos.flush();
        Student student = (Student) ois.readObject();
        student.setGpaLetter(cd(student.getGpa()));
        oos.writeObject(student);
        oos.flush();
    }
}