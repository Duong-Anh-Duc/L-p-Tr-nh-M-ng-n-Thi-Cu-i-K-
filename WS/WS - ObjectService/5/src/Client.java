package src;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import vn.medianews.*;
public class Client {
 
    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();
        List<CustomerY> customerYs = objectService.requestListCustomerY("B21DCCN005", "aYiLQ3wo");
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime ago = now.minusMonths(6);
        List<CustomerY> result = new ArrayList<>();
        for(CustomerY x : customerYs){
            if(x.getLastTransactionDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime().isAfter(ago) && x.getLastTransactionDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime().isBefore(now)) continue;
            result.add(x);  
        }
        objectService.submitListCustomerY("B21DCCN005", "aYiLQ3wo", result);
    }
}
