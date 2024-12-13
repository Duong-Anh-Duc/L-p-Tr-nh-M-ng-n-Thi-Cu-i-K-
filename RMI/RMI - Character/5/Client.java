package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");
        String res = cs.requestCharacter("B21DCCN407", "sbGzdqKV");
        int cnt[] = new int[256];
        String result = "{";
        int trang = 0;
        for (char x : res.toCharArray()) {
            if (x == ' ')
                trang++;
            else
                cnt[x]++;
        }
        for (char x : res.toCharArray()) {
            if (x == ' ' && trang != 0) {
                result += "\"" + Character.toString(x) + "\"" + ": " + Integer.toString(trang) + ", ";
                trang = 0;
            } else if (x != ' ' && cnt[x] != 0) {
                result += "\"" + Character.toString(x) + "\"" + ": " + Integer.toString(cnt[x]) + ", ";
                cnt[x] = 0;
            }
        }
        result = result.substring(0, result.length() - 2);
        result += "}";
        cs.submitCharacter("B21DCCN407", "sbGzdqKV", result);
    }
}
