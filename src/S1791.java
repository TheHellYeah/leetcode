
public class S1791 {

    public int findCenter(int[][] edges) {
        int[] node1 = edges[0];
        int[] node2 = edges[1];

        int first = node1[0];
        int second = node1[1];

        int first2 = node2[0];
        int second2 = node2[1];

        if (first == first2) {
            return first;
        }
        else if (second == first2)  {
            return second;
        } else return second2;
    }
}
