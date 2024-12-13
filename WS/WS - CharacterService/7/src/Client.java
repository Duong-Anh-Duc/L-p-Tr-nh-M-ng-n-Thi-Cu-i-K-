package src;

import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class Client {
    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService characterService = service.getCharacterServicePort();
        String arr[] = characterService.requestString("B21DCCN005", "9n2rfqST").split(" ");
        int max_length = -99, min_length = 99;
        String dai = "", ngan = "";
        for (String x : arr) {
            if (max_length < x.length()) {
                max_length = x.length();
                dai = x;
            }
            if (min_length > x.length()) {
                min_length = x.length();
                ngan = x;
            }
        }
        String result = dai + "; " + ngan;
        characterService.submitCharacterString("B21DCCN005", "9n2rfqST", result);
    }
}