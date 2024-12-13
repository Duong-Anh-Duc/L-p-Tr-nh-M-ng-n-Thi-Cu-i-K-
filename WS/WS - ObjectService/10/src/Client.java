package src;

import java.time.DayOfWeek;
import java.time.OffsetDateTime;

import vn.medianews.Employee;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;

public class Client {
    public static int calc(OffsetDateTime start, OffsetDateTime end) {
        int workingdays = 0;
        for (OffsetDateTime i = start; !i.isAfter(end); i = i.plusDays(1)) {
            DayOfWeek day = i.getDayOfWeek();
            if (day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY) {
                workingdays++;
            }
        }
        return workingdays;
    }

    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();
        Employee employee = objectService.requestEmployee("B21DCCN084", "L8CainEX");
        employee.setWorkingDays(calc(employee.getStartDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime(),
                employee.getEndDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime()));
        objectService.submitEmployee("B21DCCN084", "L8CainEX", employee);
    }
}
