package RMI;

import java.net.URLEncoder;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");
        String arr[] = cs.requestCharacter("B21DCCN282", "VMZktsn1").split(";");
        String result = "";
        for (int i = 0; i < arr[1].length(); i++) {
            result += (char) ((int) (arr[1].charAt(i) - 'a' + arr[0].charAt(i % arr[0].length()) - 'a') % 26 + 'a');
        }
        cs.submitCharacter("B21DCCN282", "VMZktsn1", result);

    }
}