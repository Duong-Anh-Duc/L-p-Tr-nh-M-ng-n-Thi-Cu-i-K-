package src;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class Client {
    public static int dem(String s) {
        String nguyenam = "ueoaiUEOAI";
        int cnt = 0;
        for (char x : s.toCharArray()) {
            if (nguyenam.contains(Character.toString(x))) {
                ++cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService characterService = service.getCharacterServicePort();
        List<String> arr = characterService.requestStringArray("B21DCCN001", "mDN1MFUJ");
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return dem(o1) - dem(o2);
            }
        });
        characterService.submitCharacterStringArray("B21DCCN001", "mDN1MFUJ", arr);
    }
}