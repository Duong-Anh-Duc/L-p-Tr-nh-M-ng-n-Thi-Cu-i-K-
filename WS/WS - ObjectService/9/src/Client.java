package src;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Project;

public class Client {
    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();
        List<Project> projects = objectService.requestListProject("B21DCCN010", "R6UOuyyE");
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime future = now.plusDays(15);
        List<Project> result = new ArrayList<>();
        for (Project x : projects) {
            OffsetDateTime time = x.getDueDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
            if (x.getCompletionPercentage() > 80 && time.isAfter(now) && time.isBefore(future)) {
                result.add(x);
            }
        }
        objectService.submitListProject("B21DCCN010", "R6UOuyyE", result);
    }
}
