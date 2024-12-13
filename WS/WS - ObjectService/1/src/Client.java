
package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();

        List<StudentY> a = objectService.requestListStudentY("B21DCCN239", "fvo1S0sV");
        HashMap<String, Float> map = new HashMap<>();
        for (StudentY studentY : a) {
            if (!map.containsKey(studentY.getSubject())) {
                map.put(studentY.getSubject(), studentY.getScore());
            } else if (map.containsKey(studentY.getSubject()) && map.get(studentY.getSubject()) < studentY.getScore()) {
                map.put(studentY.getSubject(), studentY.getScore());
            }
        }
        List<StudentY> result = new ArrayList<>();
        for (StudentY studentY : a) {
            if (map.get(studentY.getSubject()) == studentY.getScore()) {
                result.add(studentY);
            }
        }
        objectService.submitListStudentY("B21DCCN239", "fvo1S0sV", result);
    }
}
