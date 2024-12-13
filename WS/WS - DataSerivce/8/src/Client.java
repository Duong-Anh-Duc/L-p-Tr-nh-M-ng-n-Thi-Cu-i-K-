
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
        List<Integer> a = dataService.getData("B21DCCN003", "WpaUTFMu");
        List<Integer> b = new ArrayList<>();
        for (int i = 1; i < a.size(); i++) {
            b.add(a.get(i));
        }
        Collections.sort(b);
        int k = a.get(0);
        List<Integer> result = new ArrayList<>();
        result.add(b.get(b.size() - k));
        result.add(b.get(k - 1));
        dataService.submitDataIntArray("B21DCCN003", "WpaUTFMu", result);
    }
}
