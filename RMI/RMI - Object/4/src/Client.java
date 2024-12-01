package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.Book;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService os = (ObjectService) registry.lookup("RMIObjectService");
        Book book = (Book) os.requestObject("B21DCCN791","U7H06W17");
        System.out.println(book);
        String result = Character.toString(book.getAuthor().split(" ")[0].toUpperCase().charAt(0));
        result += book.getAuthor().split(" ")[book.getAuthor().split(" ").length - 1].toUpperCase().charAt(0); 
        result += Integer.toString(book.getYearPublished()).substring(Integer.toString(book.getYearPublished()).length() - 2);
        result += String.join("", book.getTitle().split(" ")).length();
        String ans = Integer.toString(book.getPageCount());
        while(ans.length() < 3){
            ans = "0" + ans;
        }
        result += ans;
        book.setCode(result);
        os.submitObject("B21DCCN239", "U7H06W17", book);
    }
}
