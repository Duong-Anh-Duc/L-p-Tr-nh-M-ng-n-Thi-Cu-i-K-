
package RMI;

import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService os = (ObjectService) registry.lookup("RMIObjectService");
        BookX book = (BookX) os.requestObject("B21DCCN791", "P8fODAJc");
        String ten = book.getAuthor();
        String code = Character.toString(ten.split(" ")[0].charAt(0))
                + Character.toString(ten.split(" ")[ten.split(" ").length - 1]
                        .charAt(ten.split(" ")[ten.split(" ").length - 1].length() - 1));
        code += Integer.toString(book.getYearPublished())
                .substring(Integer.toString(book.getYearPublished()).length() - 2);
        code += book.getGenre().length();
        code += book.getTitle().length() % 10;
        book.setCode(code);
        os.submitObject("B21DCCN791", "P8fODAJc", book);
    }
}