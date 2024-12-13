
package src;

import java.util.ArrayList;
import java.util.List;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class Client {
    public static int ucln(int a, int b) {
        if (b == 0)
            return a;
        return ucln(b, a % b);
    }

    public static void main(String[] args) {
        DataService_Service dataService_Service = new DataService_Service();
        DataService dataService = dataService_Service.getDataServicePort();
        double n = dataService.getDataDouble("B21DCCN440", "o8hcMOUc");
        String arr[] = Double.toString(n).split("[.]");
        int nhan = arr[1].length();
        int tu = (int) (Math.ceil(n * Math.pow(10, nhan)));
        int mau = (int) (Math.pow(10, nhan));
        List<Integer> result = new ArrayList<>();
        result.add(tu / ucln(tu, mau));
        result.add(mau / ucln(tu, mau));
        dataService.submitDataIntArray("B21DCCN440", "o8hcMOUc", result);
    }
}
