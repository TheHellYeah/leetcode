
public class S3042 {

    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String s1 = words[i];
                String s2 = words[j];
                if (s1.length() > s2.length()) {
                    continue;
                }
                if (isPrefixAndSuffix(s1, s2)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean isPrefixAndSuffix(String s1, String s2) {
        return s2.startsWith(s1) && s2.endsWith(s1);
    }
}
