package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class Client {
   

    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService characterService = service.getCharacterServicePort();
        List<String> arr = characterService.requestStringArray("B21DCCN440", "LGPkNHFP");
        int min_length = 99, max_length = -99;
        String wordMin = "", wordMax = "";
        for(String x : arr){
            if(min_length > x.length()){
                wordMin = x;
                min_length = x.length();
            }
            if(max_length < x.length()){
                wordMax = x;
                max_length = x.length();
            }
        }
       characterService.submitCharacterString("B21DCCN440", "LGPkNHFP", wordMax + ";" + wordMin);
    }

}
