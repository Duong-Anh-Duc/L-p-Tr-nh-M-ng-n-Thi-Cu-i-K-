
package src;

import java.util.ArrayList;
import java.util.List;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class Client {
    public static void main(String[] args) {
        DataService_Service dataService_Service = new DataService_Service();
        DataService dataService = dataService_Service.getDataServicePort();
        List<Integer> a = dataService.getData("B21DCCN025", "QBDJ1GGL");
        List<String> result = new ArrayList<>();
        for (int x : a) {
            result.add(Integer.toOctalString(x) + "|" + Integer.toHexString(x).toUpperCase());
        }
        dataService.submitDataStringArray("B21DCCN025", "QBDJ1GGL", result);
    }
}
