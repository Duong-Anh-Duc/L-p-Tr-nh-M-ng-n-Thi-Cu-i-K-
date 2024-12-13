
package src;

import java.util.ArrayList;
import java.util.List;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class Client {

    public static void main(String[] args) {
        DataService_Service dataService_Service = new DataService_Service();
        DataService dataService = dataService_Service.getDataServicePort();
        List<Integer> a = dataService.getData("B21DCCN239", "mYuaqugS");
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            result.add(Integer.toBinaryString(a.get(i)));
        }
        dataService.submitDataStringArray("B21DCCN239", "mYuaqugS", result);

    }

}
