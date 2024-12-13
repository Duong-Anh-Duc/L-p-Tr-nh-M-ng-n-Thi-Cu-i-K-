
package src;

import java.util.ArrayList;
import java.util.List;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class Client {
    public static String xuly(int n) {
        String result = "";
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                n /= i;
                result += i + ", ";
            }
        }
        if (n != 1)
            result += n;
        else
            result = result.substring(0, result.length() - 2);
        return result;
    }

    public static void main(String[] args) {
        DataService_Service dataService_Service = new DataService_Service();
        DataService dataService = dataService_Service.getDataServicePort();
        List<Integer> a = dataService.getData("B21DCCN001", "TwZpbqUg");
        List<String> result = new ArrayList<>();
        for (int x : a) {
            result.add(xuly(x));
        }
        dataService.submitDataStringArray("B21DCCN001", "TwZpbqUg", result);
    }
}
