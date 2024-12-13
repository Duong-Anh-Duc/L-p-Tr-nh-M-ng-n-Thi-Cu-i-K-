package src;
import java.util.ArrayList;
import java.util.List;
import vn.medianews.CharacterService_Service;
public class Client {
    public static void main(String[] args) {
      CharacterService_Service service = new CharacterService_Service();
      CharacterService characterService  = service.getCharacterServicePort();
      String arr[] = characterService.requestString("B21DCCN007", "sBQjqANT").split(" ");
      String result1 = "", result2 = "", result3 = "";
      for(int i = 0  ; i < arr.length;i++){
          result1 += arr[i].toUpperCase().substring(0, 1) + arr[i].toLowerCase().substring(1);
      }
      result2 += arr[0].toLowerCase();
      for(int i = 1 ; i < arr.length;i++){
          result2 += arr[i].toUpperCase().substring(0, 1) + arr[i].toLowerCase().substring(1);
      }
      for(int i = 0 ; i < arr.length;i++){
          result3 += arr[i].toLowerCase() + (i != arr.length - 1 ? "_" : "");
      }
     
      List<String> a = new ArrayList<>();
      a.add(result1);
      a.add(result2);
      a.add(result3);
      characterService.submitCharacterStringArray("B21DCCN007", "sBQjqANT", a);
}
}