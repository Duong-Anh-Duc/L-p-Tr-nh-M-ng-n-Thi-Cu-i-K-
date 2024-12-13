
package src;

import java.util.List;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class Client {
    public static void main(String[] args) {
        DataService_Service dataService_Service = new DataService_Service();
        DataService dataService = dataService_Service.getDataServicePort();
        List<Integer> a = dataService.getData("B21DCCN407", "qkzi3CZ7");
        int sum = 0;
        for (int x : a) {
            sum += x;
        }
        dataService.submitDataInt("B21DCCN407", "qkzi3CZ7", sum);
    }

}
