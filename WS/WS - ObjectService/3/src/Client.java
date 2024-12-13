
package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Order;

public class Client {

    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();
        List<Order> order = objectService.requestListOrder("B21DCCN407", "KE6riqz6");
        HashMap<String, Float> map = new HashMap<>();
        float max_cost = -999;
        String id = "";
        for (Order x : order) {

            if (!map.containsKey(x.getCustomerId())) {
                map.put(x.getCustomerId(), x.getAmount());
            } else {
                map.put(x.getCustomerId(), map.get(x.getCustomerId()) + x.getAmount());
            }
            if (max_cost < map.get(x.getCustomerId())) {
                System.out.println("ok");
                id = x.getCustomerId();
                max_cost = map.get(x.getCustomerId());
            }
        }
        List<Order> result = new ArrayList<>();
        for (Order x : order) {
            if (x.getCustomerId().equals(id)) {
                result.add(x);
            }
        }
        objectService.submitListOrder("B21DCCN407", "KE6riqz6", result);

    }
}
