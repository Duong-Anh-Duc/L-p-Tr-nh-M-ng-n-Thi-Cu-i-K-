
package src;

import java.util.ArrayList;
import java.util.List;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class Client {
    public static void main(String[] args) {
        DataService_Service dataService_Service = new DataService_Service();
        DataService dataService = dataService_Service.getDataServicePort();
        double n = dataService.getDataDouble("B21DCCN004", "nhFjYg0F");
        int res = Integer.parseInt(Double.toString(n).split("[.]")[0]);
        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        for (int i = 1; i <= res; i++) {
            if (res % i == 0) {
                result.add(i);
                ++cnt;
            }
        }
        result.add(0, cnt);
        dataService.submitDataIntArray("B21DCCN004", "nhFjYg0F", result);
    }
}
