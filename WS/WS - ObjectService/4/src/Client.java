package src;

import java.util.ArrayList;
import java.util.List;

import vn.medianews.Customer;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;

public class Client {
    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();
        List<Customer> customer = objectService.requestListCustomer("B21DCCN440", "4zcxNMzo");
        List<Customer> result = new ArrayList<>();
        for (Customer x : customer) {
            if (x.getTotalSpent() > 5000 && x.getPurchaseCount() > 5) {
                result.add(x);
            }
        }
        objectService.submitListCustomer("B21DCCN440", "4zcxNMzo", result);
    }
}
