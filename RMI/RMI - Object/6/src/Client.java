package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService os = (ObjectService) registry.lookup("RMIObjectService");
        ProductX productX = (ProductX) os.requestObject("B21DCCN167", "EuDELnFU");
        System.out.println(productX);
        String disCode = productX.getDiscountCode();
        int discount = 0;
        for(char x : disCode.toCharArray()){
            if(Character.isDigit(x)) discount += x - '0';
        }
        productX.setDiscount(discount);
        os.submitObject("B21DCCN167", "EuDELnFU", productX);
    }
}
