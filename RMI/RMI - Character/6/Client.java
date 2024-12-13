package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");
        String res = cs.requestCharacter("B21DCCN226", "4YB29RJh");
        res = res.replaceAll("[{}\"]", "");
        String arr[] = res.split(", ");
        ArrayList<String> chan = new ArrayList<>();
        ArrayList<String> le = new ArrayList<>();
        String result = "";
        for (String x : arr) {
            if ((x.charAt(3) - '0') % 2 == 0)
                chan.add(x);
            else
                le.add(x);
        }
        for (int i = 0; i < chan.size(); i++) {
            result += chan.get(i) + (i != chan.size() - 1 ? ", " : "");

        }
        result += "; ";
        for (int i = 0; i < le.size(); i++) {
            result += le.get(i) + (i != le.size() - 1 ? ", " : "");

        }
        cs.submitCharacter("B21DCCN226", "4YB29RJh", result);
    }
}