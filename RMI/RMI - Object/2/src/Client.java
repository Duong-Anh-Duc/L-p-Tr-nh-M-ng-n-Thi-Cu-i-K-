package RMI;
import java.rmi.registry.*;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService cs = (ObjectService) registry.lookup("RMIObjectService");
        Order order = (Order) cs.requestObject("B21DCCN467", "v2cu2TWj");
        System.out.println(order);
        String orderCode = order.getShippingType().toUpperCase().substring(0, 2);
        orderCode += order.getCustomerCode().substring(order.getCustomerCode().length() - 3);
        orderCode += order.getOrderDate().substring(8) + order.getOrderDate().substring(5, 7);
        order.setOrderCode(orderCode);
        cs.submitObject("B21DCCN467", "v2cu2TWj", order);
    }
}
