
package src;

import java.util.ArrayList;
import java.util.List;

import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class Client {

    public static void main(String[] args) {
        DataService_Service dataService_Service = new DataService_Service();
        DataService dataService = dataService_Service.getDataServicePort();
        List<Integer> a = dataService.getData("B21DCCN467", "4iyFyXaI");
        List<Integer> chan = new ArrayList<>();
        List<Integer> le = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int x : a) {
            if (x % 2 == 0)
                chan.add(x);
            else
                le.add(x);
        }
        int i = 0, j = 0;
        while (i < chan.size() && j < le.size()) {
            result.add(chan.get(i));
            ++i;
            result.add(le.get(j));
            ++j;
        }
        while (i < chan.size()) {
            result.add(chan.get(i));
            ++i;
        }
        while (j < le.size()) {
            result.add(le.get(i));
            ++j;
        }
        dataService.submitDataIntArray("B21DCCN467", "4iyFyXaI", result);
    }
}
