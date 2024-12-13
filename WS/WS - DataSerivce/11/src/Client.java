
package src;

import java.util.ArrayList;
import java.util.List;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class Client {
    public static void main(String[] args) {
        DataService_Service dataService_Service = new DataService_Service();
        DataService dataService = dataService_Service.getDataServicePort();
        List<Integer> a = dataService.getData("B21DCCN033", "E2Axwwf3");
        int cnt[] = new int[256];
        List<Integer> result = new ArrayList<>();
        for (int x : a) {
            if (cnt[x] == 0) {
                result.add(x);
                cnt[x] = 1;
            }
        }
        dataService.submitDataIntArray("B21DCCN033", "E2Axwwf3", result);
    }
}
