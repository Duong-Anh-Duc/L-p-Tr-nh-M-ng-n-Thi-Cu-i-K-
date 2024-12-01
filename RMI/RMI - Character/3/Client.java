package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");
        int n = Integer.parseInt(cs.requestCharacter("B21DCCN239", "DF8aJzvC")); 
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String result = "";
        String arr[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0 ; i < values.length;i++){
           while(n >= values[i]){
               n -= values[i];
               result += arr[i];
           }
           if(n == 0) break;
        }
        cs.submitCharacter("B21DCCN239", "DF8aJzvC", result);
    }
}
