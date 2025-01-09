import java.util.Arrays;

public class S2185 {
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words)
            .filter(w -> w.startsWith(pref))
            .count();
    }
}
