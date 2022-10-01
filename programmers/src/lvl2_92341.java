import java.util.*;

public class lvl2_92341 {
    public int[] solution(int[] fees, String[] records) {
        Set<String> carNumber = new HashSet<>();
        Map<String, Integer> usedSumCar = new HashMap<>();
        Map<String, Integer> parkedCar = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] parsed = records[i].split(" ");
            carNumber.add(parsed[1]);

            String[] times = parsed[0].split(":");
            int minutes = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

            if (parsed[2].equals("IN")) {
                parkedCar.put(parsed[1], minutes);
            } else {
                int inMinutes = parkedCar.getOrDefault(parsed[1], 0);
                usedSumCar.put(parsed[1], usedSumCar.getOrDefault(parsed[1], 0) + minutes - inMinutes);
                parkedCar.put(parsed[1], -1);
            }
        }

        int minutes = 23 * 60 + 59;
        for (String key: carNumber) {
            if (parkedCar.getOrDefault(key, -1) != -1) {
                usedSumCar.put(key, usedSumCar.getOrDefault(key, 0) + minutes - parkedCar.getOrDefault(key, 0));
            }
        }

        List<String> carNumberList = new ArrayList<>(carNumber);
        Collections.sort(carNumberList);
        int[] answer = new int[carNumberList.size()];
        for (int i = 0; i < carNumberList.size(); i++) {
            String carNum = carNumberList.get(i);

            int used = usedSumCar.get(carNum);

            if (used > fees[0]) {
                answer[i] = fees[1] + (int)Math.ceil((float)(used - fees[0]) / (float)fees[2]) * fees[3];
            } else {
                answer[i] = fees[1];
            }
        }

        return answer;
    }
}
