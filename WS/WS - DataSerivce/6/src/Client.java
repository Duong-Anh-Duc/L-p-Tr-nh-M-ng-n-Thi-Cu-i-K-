
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
        List<Integer> a = dataService.getData("B21DCCN251", "0y52bTKB");
        int cnt[] = new int[256];
        for (int x : a) {
            cnt[x]++;
        }
        Collections.sort(a);
        List<String> result = new ArrayList<>();
        for (int x : a) {
            if (cnt[x] != 0) {
                String tmp = "";
                tmp += x + ", " + cnt[x];
                cnt[x] = 0;
                result.add(tmp);
            }
        }
        dataService.submitDataStringArray("B21DCCN251", "0y52bTKB", result);
    }
}
