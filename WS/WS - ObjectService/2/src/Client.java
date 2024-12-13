
package src;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.OrderY;

public class Client {

    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();
        List<OrderY> ordery = objectService.requestListOrderY("B21DCCN467", "N0JXSMJu");
        List<OrderY> result = new ArrayList<>();
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime ago = now.minusDays(30);
        for (OrderY x : ordery) {
            OffsetDateTime orderDate = x.getOrderDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
            if (orderDate.isBefore(now) && orderDate.isAfter(ago)
                    && (x.getStatus().equals("pending") || x.getStatus().equals("processing"))) {
                result.add(x);

            }

        }
        objectService.submitListOrderY("B21DCCN467", "N0JXSMJu", result);

    }
}
