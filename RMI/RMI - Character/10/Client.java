package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");
        String res = cs.requestCharacter("B21DCCN216", "LpB2xgRw");
        String result = "";
        for (char x : res.toCharArray()) {
            result += (char) ((x - 'a' - res.length() % 7 + 26) % 26 + 'a');
        }
        cs.submitCharacter("B21DCCN216", "LpB2xgRw", result);

    }
}