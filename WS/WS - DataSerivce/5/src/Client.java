
package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class Client {

    public static void main(String[] args) {
        DataService_Service dataService_Service = new DataService_Service();
        DataService dataService = dataService_Service.getDataServicePort();
        List<Integer> a = dataService.getData("B21DCCN791", "FPv5UUKG");
        List<String> b = new ArrayList<>();
        for (int x : a) {
            b.add(Integer.toString(x));
        }
        Collections.sort(b);
        Collections.reverse(b);
        String result = "";
        for (String x : b) {
            result += x;
        }
        dataService.submitDataString("B21DCCN791", "FPv5UUKG", result);
    }
}
