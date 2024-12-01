package RMI;
import java.net.URLEncoder;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");
        String result = cs.requestCharacter("B21DCCN167", "HWNyMwvx");
        result = URLEncoder.encode(result, "UTF-8");
        cs.submitCharacter("B21DCCN167", "HWNyMwvx", result);
    }
}