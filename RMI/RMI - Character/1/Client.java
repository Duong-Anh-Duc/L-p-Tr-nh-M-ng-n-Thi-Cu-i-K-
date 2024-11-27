
package RMI;

import java.rmi.registry.*;
import RMI.CharacterService;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");
        String res = cs.requestCharacter("B21DCCN239", "aTnXjI8V");
        String key = res.split("\\;")[0];
        String word = res.split("\\;")[1];
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            result += (char) (word.charAt(i) ^ key.charAt(i % key.length()));
        }
        System.out.println(result);
        cs.submitCharacter("B21DCCN239", "aTnXjI8V", result);
    }
}