package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");
        String res = cs.requestCharacter("B21DCCN161", "PWSWBJQF");
        String result = Base64.getEncoder().encodeToString(res.getBytes());
        cs.submitCharacter("B21DCCN239", "PWSWBJQF", result);
    }
}