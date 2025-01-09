
public class S1769 {

    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        int[] answer = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            int ops = 0;
            for (int j = 0; j < chars.length; j++) {
                if (i==j) continue;

                char c = chars[j];
                if (c == '1') {
                    ops += Math.abs(j - i);
                }
            }
            answer[i] = ops;
        }
        return answer;
    }
}
