package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService os = (ObjectService) registry.lookup("RMIObjectService");
        Student student = (Student) os.requestObject("B21DCCN440", "Lp4fCVLj");
        String code = "B" + Integer.toString(student.getEnrollmentYear()).substring(Integer.toString(student.getEnrollmentYear()).length() - 2);
        String name[] = student.getName().split(" ");
        code += name[name.length - 1].toUpperCase() + "_";
        String setName = "";
        for(int i = 0 ; i < name.length - 1;i++){
            code += name[i].toUpperCase().charAt(0);
        }
        for(int i = 0 ; i < name.length;i++){
            setName += name[i].toUpperCase().substring(0, 1) + name[i].toLowerCase().substring(1);
            setName += " ";
        }
        setName = setName.substring(0, setName.length() - 1);
        student.setCode(code);
        student.setName(setName);
        os.submitObject("B21DCCN440", "Lp4fCVLj", student);
    }
}
