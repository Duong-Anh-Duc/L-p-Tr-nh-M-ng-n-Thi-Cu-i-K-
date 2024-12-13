package src;

import java.util.Collections;
import java.util.List;

import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class Client {
    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService characterService = service.getCharacterServicePort();
        List<Integer> a = characterService.requestCharacter("B21DCCN467", "y0rzRpF7");
        Collections.sort(a);
        characterService.submitCharacterCharArray("B21DCCN467", "y0rzRpF7", a);
    }
}