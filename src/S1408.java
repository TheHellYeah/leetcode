import java.util.ArrayList;
import java.util.List;

public class S1408 {

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                String s1 = words[i];
                String s2 = words[j];
                if (s1.length() >= s2.length()) {
                    continue;
                }
                if (isSubstring(s1, s2)) {
                    res.add(s1);
                    break;
                }
            }
        }
        return res;
    }

    private boolean isSubstring(String s1, String s2) {
        return s2.contains(s1);
    }
}
