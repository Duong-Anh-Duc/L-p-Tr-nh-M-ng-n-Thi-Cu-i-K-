
package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService os = (ObjectService) registry.lookup("RMIObjectService");
        Employee employee = (Employee) os.requestObject("B21DCCN239", "9yhCu1jT");
        int sum = 0, n = employee.getExperienceYears();
        while(n != 0){
            sum += n % 10;
            n /= 10;
        }
        int uoc = 0, m = employee.getExperienceYears();
        for(int i = 1 ; i <= m;i++){
            if(m % i == 0) uoc++;
        }
        double factor =(double)(sum + uoc + employee.getExperienceYears()) / 100.0;
        double finalSalary = employee.getBaseSalary() * (1 + factor);
        employee.setFinalSalary(finalSalary);
        os.submitObject("B21DCCN239", "9yhCu1jT", employee);
    }
}