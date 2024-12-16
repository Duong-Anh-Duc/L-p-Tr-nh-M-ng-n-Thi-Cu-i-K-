package src;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.EmployeeY;
import vn.medianews.ObjectService;

public class Client {
    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();
        List<EmployeeY> employeeYs = objectService.requestListEmployeeY("B21DCCN004", "vewbvojZ");
        Collections.sort(employeeYs, new Comparator<EmployeeY>() {
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                OffsetDateTime time1 = o1.getStartDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
                OffsetDateTime time2 = o2.getStartDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
                return time1.compareTo(time2);
            }

        });
        objectService.submitListEmployeeY("B21DCCN004", "vewbvojZ", employeeYs);

    }
}
