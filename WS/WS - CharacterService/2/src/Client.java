package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class Client {
    public static int dem(String x) {
        String na = "ueoai";
        int cnt = 0;
        for (char i : x.toCharArray()) {
            i = Character.toLowerCase(i);
            if (i == 'u' || i == 'e' || i == 'o' || i == 'a' || i == 'i')
                ++cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService characterService = service.getCharacterServicePort();
        List<String> arr = characterService.requestStringArray("B21DCCN791", "DYeISPeq");
        List<String> result = new ArrayList<>();
        Collections.sort(arr);
        int cnt[] = new int[1001];
        cnt[0] = 1;
        for (String x : arr) {
            cnt[dem(x)] = 1;
        }

        for (int i = 0; i <= 1000; i++) {
            if (cnt[i] != 0) {
                String tmp = "";
                for (String x : arr) {
                    if (dem(x) == i) {
                        tmp += x + ", ";
                    }
                }
                tmp = tmp.substring(0, tmp.length() - 2);
                result.add(tmp);
            }
        }
        characterService.submitCharacterStringArray("B21DCCN791", "DYeISPeq", result);
    }

}
