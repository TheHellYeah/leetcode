import java.util.HashMap;
import java.util.Map;

public class S2285 {

    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> connections = new HashMap<>();
        Map<Integer, Integer> values = new HashMap<>();

        for (int[] road : roads) {
            int firstCity = road[0];
            int secondCity = road[1];
            connections.merge(firstCity, 1, Integer::sum);
            connections.merge(secondCity, 1, Integer::sum);
        }

        int[] idx = { n };

        connections.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
            .forEach(city -> values.put(city.getKey(), idx[0]--));

        long importance = 0;
        for (int[] road : roads) {
            int firstCity = road[0];
            int secondCity = road[1];
            Integer firstVal = values.get(firstCity);
            Integer secondVal = values.get(secondCity);
            importance += firstVal + secondVal;
        }
        return importance;
    }
}
