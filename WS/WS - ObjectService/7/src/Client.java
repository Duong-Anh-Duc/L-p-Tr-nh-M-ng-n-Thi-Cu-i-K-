package src;

import java.util.ArrayList;
import java.util.List;

import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Student;

public class Client {
    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();
        List<Student> student = objectService.requestListStudent("B21DCCN003", "qNfIMvid");
        List<Student> result = new ArrayList<>();
        for (Student x : student) {
            if (x.getScore() >= 8 || x.getScore() < 5) {
                result.add(x);
            }
        }
        objectService.submitListStudent("B21DCCN003", "qNfIMvid", result);
    }
}
