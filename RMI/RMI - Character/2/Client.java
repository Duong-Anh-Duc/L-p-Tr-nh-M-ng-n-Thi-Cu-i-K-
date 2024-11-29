package RMI;
import java.rmi.registry.*;
public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) registry.lookup("RMICharacterService");
        String res = cs.requestCharacter("B21DCCN467", "R3wG9kWP"); 
        res += "@";
        int cnt[] = new int[256];
        cnt['I'] = 1;
        cnt['V'] = 5;
        cnt['X'] = 10;
        cnt['L'] = 50;
        cnt['C'] = 100;
        cnt['D'] = 500;
        cnt['M'] = 1000;
        cnt['@'] = 0;
        int sum = 0;
        for(int i = 1 ; i < res.length();i++){
            if(cnt[res.charAt(i - 1)] >= cnt[res.charAt(i)]){
                sum += cnt[res.charAt(i - 1)];
            }
            else{
                sum -= cnt[res.charAt(i - 1)];
            }
        }
        cs.submitCharacter("B21DCCN467", "R3wG9kWP", Integer.toString(sum));
    }
}
