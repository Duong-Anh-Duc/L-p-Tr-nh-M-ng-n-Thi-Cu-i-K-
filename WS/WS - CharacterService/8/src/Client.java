package src;

import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class Client {
    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService characterService = service.getCharacterServicePort();
        String res = characterService.requestString("B21DCCN008", "rT6Ql5GH");
        String result = "";
        for (char x : res.toCharArray()) {
            if (Character.isAlphabetic(x)) {
                result += x;
            }
        }
        StringBuilder sb = new StringBuilder(result);
        characterService.submitCharacterString("B21DCCN008", "rT6Ql5GH", sb.reverse().toString());
    }
}