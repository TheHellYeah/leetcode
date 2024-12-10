
public class S27 {

    public static void main(String[] args) {
        new S27().removeElement(new int[] {0,1,2,2,3,0,4,2 }, 2);
    }

    public int removeElement(int[] nums, int val) {

        int[] buffer = new int[nums.length];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            if (num != val) {
                buffer[k++] = num;
            }
        }

        if (k >= 0) System.arraycopy(buffer, 0, nums, 0, k);
        return k;
    }
}
