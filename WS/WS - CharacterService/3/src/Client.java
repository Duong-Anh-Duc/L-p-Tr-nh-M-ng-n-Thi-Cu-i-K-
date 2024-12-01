package src;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn.medianews.CharacterService_Service;
public class Client {
    public static void main(String[] args) {
      CharacterService_Service service = new CharacterService_Service();
      CharacterService characterService  = service.getCharacterServicePort();
      List<String> arr = characterService.requestStringArray("B21DCCN226", "V137Wpha");
      Collections.sort(arr, new Comparator<String>(){
    @Override
    public int compare(String a, String b){
        return a.length() - b.length();
    }
    });
    characterService.submitCharacterStringArray("B21DCCN226", "V137Wpha", arr);
    }
    
}
