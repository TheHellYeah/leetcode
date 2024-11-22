import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<Integer, Integer> occurs = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                occurs.merge(Arrays.hashCode(matrix[i]), 1, Integer::sum);
            } else {
                occurs.merge(Arrays.hashCode(reverse(matrix[i])), 1, Integer::sum);
            }
        }
        return occurs.values().stream().max(Integer::compareTo).orElse(0);
    }

    private int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            reversed[i] = val == 0 ? 1 : 0;
        }
        return reversed;
    }
}
